package br.gpri.nlp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import activerecord.Acronimo;
import activerecord.Dicionario;
import activerecord.BD;
import activerecord.Regra;
import activerecord.Subregra;
import activerecord.Termo;
import activerecord.TrechoEncontrado;
import br.usp.pcs.lta.cogroo.entity.Token;
import br.usp.pcs.lta.cogroo.entity.impl.runtime.SentenceCogroo;
import br.usp.pcs.lta.cogroo.util.viewer.CogrooWrapper;
import br.usp.pcs.lta.cogroo.entity.impl.runtime.MorphologicalTag;

public class Tagger{
	
	public CogrooWrapper cogroo;
	public final int conjuntoTeste = 1;

	private List<Acronimo> acronimos;
        private Dicionario tabelamt;
	public List <String> frasesNegativas;
        public static MorphologicalTag mtADJ_F_S=null;
        
        private int contadorPosi��esPassadas = 0; //Para manter registro de quantos tokens j� passaram nas frases anteriores, j� que ele s� manda frase por frase e o i pra localizar a posi��o come�a de novo.
                                                  //Por isso deu problema e ele localizava s� na primeira frase.
	
	public Tagger(BD BD){

		cogroo = new CogrooWrapper();

		acronimos =  BD.selectAcronimos();
		frasesNegativas = BD.selectFrasesNegativas();
                tabelamt=BD.selectTabelaMT();
	}


	public String preProccessText(String text){
            //coloca um espa�o entre um ponto seguido de letra
                text = retiraPontoLetra(text);
            //Adiciona espaço para acronimos no começo/final frase
		text = espacaTexto(text);
		//Expande as datas	
		text = expandirData(text);
		//Retira erros recorrentes nos sumários
		text = retiraErrosRecorrentes(text);
		//Retira pontuação e caracteres especiais
		text = retiraPontuacao(text);
		//Espaça ponto
		text = espacaPontuacao(text);
		//Expande Acrônimos
		text = expandirAcronimos(text);
		//Coloca em minúsculas
		text = text.toLowerCase();
		//Retira Stopwords - m�todo retirado para identificar melhor a diferen�a entre
                //achado radiol�gico e termo morfol�gico, pois os termos morfol�gicos em algumas regras, s�o precedidos por artigos
//		text = retiraStopWords(text);
		//Remove espaco ponto
		text = removeEspacaPontuacao(text);
		//Retira espaco comeco/final frase
		text= removeEspacaTexto(text);
                //Remove espaco inicio texto
                text= removeEspacoInicio(text);
		
		return text;
	}

        public String expandePreposicoes(String texto){
                String[] sentencas = cogroo.sentDetect(texto);
                String textoExpandido = new String();
		for (String sentenca : sentencas) {
                    SentenceCogroo sc = new SentenceCogroo(sentenca);
                    List<Token> tokens = null;
                    cogroo.tokenizer(sc);

                    //Aplica o NAMEFINDER
                    // retirado porque estava tirando a "base" do trecho "n�cleos da base"		
                    //cogroo.nameFinder(sc);

                    //Expans�o de Preposi��es
                    cogroo.preTagger(sc);
                    tokens = sc.getTokens();
                    for(Token token: tokens){
                        textoExpandido += token.getLexeme() + " ";
                    }
                }
                
                return textoExpandido;
        }
        
	public String sentencaRapidMiner (String sentencaEntrada)
	{
		String[] sentencas = cogroo.sentDetect(sentencaEntrada);
		String sentenca="";
                for (String sentencaSFN : sentencas) {
//			List<Token> tokens = processCogroo(sentencaSFN);
                        if(!temFraseNegativa(sentencaSFN))
                        {
                            sentenca=sentenca+sentencaSFN;
                
                        }
                }
                sentenca=preProccessText(sentenca);
		//Tokeniza sentença
		SentenceCogroo sc = new SentenceCogroo(sentenca);
		cogroo.tokenizer(sc);

		//Aplica o NAMEFINDER
// retirado porque estava tirando a "base" do trecho "n�cleos da base"		cogroo.nameFinder(sc);
		
		//Expansão de preposições
		cogroo.preTagger(sc);
		List<Token> tokens = null;
		tokens = sc.getTokens();
		String textoRepomposto = "";
		for (int i=0;i<sc.getTokens().size();i++)
			textoRepomposto = textoRepomposto+" "+tokens.get(i);
		return textoRepomposto;
		
		
	}
	public List<Token> processCogroo(String sentenca){
		//Tokeniza sentença
		SentenceCogroo sc = new SentenceCogroo(sentenca);
		List<Token> tokens = null;
		cogroo.tokenizer(sc);

		//Aplica o NAMEFINDER
// retirado porque estava tirando a "base" do trecho "n�cleos da base"		cogroo.nameFinder(sc);
		
		//Expansão de preposições
		cogroo.preTagger(sc);
	
		
		//Realiza POS_tagging
		cogroo.tagger(sc);
		tokens = sc.getTokens();
                //flair - est� como PRP_ e devia ser ADJ_F_S
                //peritoneal - est� como PRP_ e devia ser ADJ_F_S
                 MorphologicalTag mt=null;
                for (int i=0;i<tokens.size();i++)
                {
                    Token tk = tokens.get(i);
                    if (tk.getMorphologicalTag().toString().equals("ADJ_F_S_"))
                    {
                        mtADJ_F_S=tk.getMorphologicalTag();
                    }
                }
                
                for (int i=0;i<tokens.size();i++)
                {
                    Token tk = tokens.get(i);
                    if(tk.getLexeme().equals("flair")||tk.getLexeme().equals("peritoneal"))
                    {
                        tk.setMorphologicalTag(mtADJ_F_S);
                    }
                }
                for (int i=0;i<tokens.size();i++)
                {
                    Token tk = tokens.get(i);
                    for(int j=0;j<tabelamt.tamanhoLista();j++){
                        if(tk.getLexeme().equals(tabelamt.getpalavra(j))){
                            MorphologicalTag m = new MorphologicalTag(tabelamt.getMT(j));
                            tk.setMorphologicalTag(m); 
                        }
                    
                    }
                }
                return tokens;
	}
	public boolean temFraseNegativa(String s)
	{
		for(int i=0; i<frasesNegativas.size(); i++)
		{
			if (s.contains(frasesNegativas.get(i)))
				return true;
		}
		return false;
	}
	//Tagger para Interface gráfica
	public Regra geraRegra(String text_sumario, String text_selecionado,int idElemento, int idRegra){
		
		List <Termo> termosregras = new ArrayList<Termo>();
		
		//Executa operações de PRÉ-PROCESSAMENTO
                
                
		text_sumario = preProccessText(text_sumario);
		text_selecionado = preProccessText(text_selecionado);
		
		//Separa texto selecionado em palavras
		SentenceCogroo selecionado = new SentenceCogroo(text_selecionado);
		cogroo.tokenizer(selecionado);
// retirado porque estava tirando a "base" do trecho "n�cleos da base"		cogroo.nameFinder(selecionado);
		cogroo.preTagger(selecionado);
		List<Token> text_selecionado_separado = selecionado.getTokens();
						
		String previa = "";
                String texto_expandido = "";
		
		//Separa texto em sentenças
		String[] sentencas = cogroo.sentDetect(text_sumario);
		for (String sentenca : sentencas) {
			List<Token> tokens = processCogroo(sentenca);

			//Procura onde estão os termos seleciontexto_expandido = text_selecionado_separado.get(k).getLexeme();ados
			//Compara um termo com o primeiro do vetor separado, caso encontre, ve se os termos
			//seguintes também são os esperados
			boolean igual = false;
			
			for(int i=0; i < tokens.size(); i++){
				for(int j=0; j < text_selecionado_separado.size(); j++){
					try{
					if(text_selecionado_separado.get(j).getLexeme().equals(tokens.get(i+j).getLexeme()))
						igual = true;
					else{
						igual = false;
						break;
					}
					}
					catch(IndexOutOfBoundsException e){
						System.out.println("Erro por texto selecionado estar em duas frases diferentes");
						e.printStackTrace();
						igual = false;
					
					}
				}
				
				//Cria a string a ser retornada,
				//a partir do indice do primeiro termo esperado encontrado. 
				if(igual){
					for(int k=0; k < text_selecionado_separado.size(); k++){
						texto_expandido += text_selecionado_separado.get(k).getLexeme() + " "; //Para deixar o texto da regra expandido quando guardar no bd, ao inv�s do selecionado.
                                                Token token = tokens.get(k+i);
						if(token.getLexeme().toString().equals("."));
						else{
							previa += "[" + token.getMorphologicalTag() + "]";
							Termo t = new Termo();
							t.setIdRegra(idRegra);
							t.setIdTermo(k);
							t.setTermo(token.getMorphologicalTag().toString());
							t.setTexto(token.getLexeme().toString());
							termosregras.add(t);
						}
					}
				}
                                if (igual) break;
			}
                        if (igual) break;
		}
                texto_expandido = texto_expandido.substring(0, texto_expandido.length()-1);
                
		Regra r = new Regra();
		r.setId(idRegra);
		r.setPrevia(previa);
		r.setTexto(texto_expandido);
		r.setConjunto(conjuntoTeste);
		r.setElemento(idElemento);
		r.setTermos(termosregras);
		
		return r; 
	}
	
	public Subregra geraSubRegra(String text_sumario, String text_selecionado,int idRegra, int idSubRegra){
		
		List <Termo> termosregras = new ArrayList<Termo>();
		
		//Executa operações de PRÉ-PROCESSAMENTO
		
                
                text_sumario = preProccessText(text_sumario);
		text_selecionado = preProccessText(text_selecionado);
		
		//Separa texto selecionado em palavras
		SentenceCogroo selecionado = new SentenceCogroo(text_selecionado);
		cogroo.tokenizer(selecionado);
// retirado porque estava tirando a "base" do trecho "n�cleos da base"		cogroo.nameFinder(selecionado);
		cogroo.preTagger(selecionado);
		List<Token> text_selecionado_separado = selecionado.getTokens();
						
		String previa = "";
                String texto_expandido = "";
		
		//Separa texto em sentenças
		String[] sentencas = cogroo.sentDetect(text_sumario);
		for (String sentenca : sentencas) {
			List<Token> tokens = processCogroo(sentenca);
			
			//Procura onde estão os termos selecionados
			//Compara um termo com o primeiro do vetor separado, caso encontre, ve se os termos
			//seguintes também são os esperados
			boolean igual = false;
			
			for(int i=0; i < tokens.size(); i++){
				for(int j=0; j < text_selecionado_separado.size(); j++){
					if(text_selecionado_separado.get(j).getLexeme().equals(tokens.get(i+j).getLexeme()))
						igual = true;
					else{
						igual = false;
						break;
					}
				}
				
				//Cria a string a ser retornada,
				//a partir do indice do primeiro termo esperado encontrado. 
				if(igual){
					for(int k=0; k < text_selecionado_separado.size(); k++){
						texto_expandido += text_selecionado_separado.get(k).getLexeme() + " ";
                                                Token token = tokens.get(k+i);
						if(token.getLexeme().toString().equals("."));
						else{
							previa += "[" + token.getMorphologicalTag() + "]";
							Termo t = new Termo();
							t.setIdRegra(idRegra);
							t.setIdSubregra(idSubRegra);
							t.setIdTermo(k);
							t.setTermo(token.getMorphologicalTag().toString());
							t.setTexto(token.getLexeme().toString());
							termosregras.add(t);
						}
					}
				}
                                if (igual) break;
                        }
                        if (igual) break;
		}
		texto_expandido = texto_expandido.substring(0, texto_expandido.length()-1);
                
		Subregra s = new Subregra();
		s.setId(idSubRegra);
		s.setIdRegra(idRegra);
		s.setPrevia(previa);
		s.setTexto(texto_expandido);
		s.setTermos(termosregras);
		
		return s; 
	}
	
        	public List<TrechoEncontrado> executaRegra(String texto_medico, List<Regra> regras){
		
		List<TrechoEncontrado> encontrados = new ArrayList<TrechoEncontrado>();
		String trechosEncontradosConcatenados="";
                int indSentenca=0;
                int posicaoToken=0;//Executa operações de PRÉ-PROCESSAMENTO
		texto_medico = preProccessText(texto_medico);
		
                //Separa texto em sentenças
		String[] sentencas = cogroo.sentDetect(texto_medico);
		for (String sentenca : sentencas) {
                    indSentenca++;
                    List<Token> tokens = processCogroo(sentenca);
                    System.out.print(";"+tokens.size());
                    for (int i=0;i < tokens.size(); i++)
                    {
                        posicaoToken++;
//                        System.out.print("["+posicaoToken+"]"+tokens.get(i).getLexeme());
//                         System.out.print("|"+tokens.get(i).getMorphologicalTag().toString()+" ");
                                                                
                    }
                    
                    if (temFraseNegativa(sentenca)){
			//Aqui ele passava pra pr�xima senten�a sem incrementar o contador de posi��es das frases anteriores, por isos n�o marcava as frases de baixo.
                        contadorPosi��esPassadas += tokens.size();
                        continue;
                    }
			//Executa cada uma das regras
                    for (Regra r : regras){
				
				boolean igual = false;
				
				//Procura por incidencia da regra
				for(int i=0; i < tokens.size(); i++){
					String trecho = "";
                            		for(int j=0; j < r.getNumTermos(); j++){
                                   
						String c;
						try{
							c = tokens.get(i+j).getMorphologicalTag().toString();
						}
						catch(IndexOutOfBoundsException e){
							c = "";
						}
						String d = r.getTermo(j).getTermo();
						if(c.contentEquals(d)){
							igual = true;
							trecho += tokens.get(i+j).getLexeme() + " ";
						//Se toda a comparação for igual, se tiver subregras testa
						}
						else{
							igual = false;
							break;
						}
					}
						//
						//Se tudo der certo, adiona na lista de encontrados e limpa a string trecho

//este teste foi tirado para que todas as ocorr�ncias de um termo possam fazer parte do laudo estruturado, sen�o o laudo estruturado
//ficava com "lacunas"                                       
//						if (trechosEncontradosConcatenados.contains(trecho))
//                                                        {igual=false;}      

//O teste abaixo foi colocado para identificar termos de nega��o, por enquando somente com "sem"

                                        if (i>0)
                                                {
                                                    String lexemeMenosUm=tokens.get(i-1).getLexeme();
                                                    if(lexemeMenosUm.contentEquals("sem"))
                                                    {
                                                        igual=false;
                                                    }
                                                }
                                                if(igual){
                                                       
//							boolean testeSubregra = true;
							List<TrechoEncontrado> subregrasEncontrados = new ArrayList<TrechoEncontrado>();
                                                        if(r.hasSubregra())
							{
								List<Subregra> subregras = r.getSubregras();
								executaSubRegra(subregras, tokens, trecho, subregrasEncontrados,i);
							}
//							if(testeSubregra){ trocado pela linha de baixo para manter os loops de regra e subregra parecidos
								TrechoEncontrado t = new TrechoEncontrado();
								t.setRegra(r);
								t.setIsSubregra(false);
								t.setHasRegra(true);
                                                                
                                                                //Texto do trecho encontrado
								t.setTrechoEncontrado(trecho);
                                                                
                                                                //Posi��o dos termos
                                                                t.setPosInicial(i+contadorPosi��esPassadas);
                                                                t.setPosFinal(i+contadorPosi��esPassadas+r.getNumTermos()-1);
                                                                
                                                                
                                                                if(i>0)
                                                                {
                                                                    t.setTermoAnterior(tokens.get(i-1).getMorphologicalTag().toString());
                                                                    t.setPalavraAnterior(tokens.get(i-1).getLexeme());
                                                                }
                                                                if((i+r.getNumTermos())<(tokens.size()))
                                                                {
                                                                    t.setTermoPosterior(tokens.get(i+r.getNumTermos()).getMorphologicalTag().toString());
                                                                    t.setPalavraPosterior(tokens.get(i+r.getNumTermos()).getLexeme());
                                                                }
                                                                
								trechosEncontradosConcatenados = trechosEncontradosConcatenados+trecho+"|";
                                                                trecho="";
                                                                t.setIndSentenca (indSentenca);
                                                                t.setIndToken(i);
								encontrados.add(t);
								igual = false;
								
								//Adiciona trechos das subregras na lista
								if(!subregrasEncontrados.isEmpty())
									for(int k=0; k<subregrasEncontrados.size(); k++)
										encontrados.add(subregrasEncontrados.get(k));
							
					}
                                        
				}		
				
			}
                    
                        //Incrementa contador das posi��es das frases passadas
                        contadorPosi��esPassadas += tokens.size();
		}
                
                //Reinicia o contador para o pr�ximo texto
                contadorPosi��esPassadas = 0;
		return encontrados;	
	}
	
	private boolean executaSubRegra(List<Subregra> subregras, List<Token> tokens, String trecho, List<TrechoEncontrado> subregraEncontrados,int i_token_regra){
		//inicio alteração Fernando.
		//	testeSubregra = executaSubRegra(r.getSubregras()); //Testa as subregras, retorna true se ela validarem a regra
		boolean igual_sr = true;
		//Executa cada uma das subregras
		boolean encontrou_algum_sr = false;
		for (Subregra sr : subregras){
                        boolean encontrou_esta_sr=false;
                        TrechoEncontrado t = new TrechoEncontrado();
        		int diferencaPosicaoTokenRegraTokenSubRegra=99999;
			igual_sr = false;
			
			
			//Procura por incidencia da subregra
			String trecho_sr = "";
			for(int i_sr=0; i_sr < tokens.size(); i_sr++){
				for(int j_sr=0; j_sr < sr.getNumTermos(); j_sr++){
					String c;
					try{
						c = tokens.get(i_sr+j_sr).getMorphologicalTag().toString();
					}
					catch(IndexOutOfBoundsException e){
						c = "";
					}
					String d = sr.getTermo(j_sr).getTermo();    
//                                        System.out.println("i_sr->"+i_sr+" j_sr->"+j_sr+" c->"+c+" d->"+d+" trecho->"+trecho+" tokens.get(i_sr+j_sr).getLexeme()->"+tokens.get(i_sr+j_sr).getLexeme());
					if(c.contentEquals(d) && !trecho.contains((tokens.get(i_sr+j_sr).getLexeme()))){
						 
						igual_sr = true;
						trecho_sr += tokens.get(i_sr+j_sr).getLexeme() + " ";
					}
					else{
						igual_sr = false;
						trecho_sr="";
						break;
					}
				}
					//
				if(igual_sr)
                                {
                                        if(diferencaPosicaoTokenRegraTokenSubRegra>(i_sr-i_token_regra)*(i_sr-i_token_regra))
                                        {
                                            diferencaPosicaoTokenRegraTokenSubRegra=(i_sr-i_token_regra)*(i_sr-i_token_regra);
                                        
//                                            System.out.println("trecho_sr->"+trecho_sr+" diferencaPosicaoTokenRegraTokenSubRegra->"+diferencaPosicaoTokenRegraTokenSubRegra);
	
                                            t.setSubregra(sr);
                                            t.setIsSubregra(true);
                                            t.setTrechoEncontrado(trecho_sr);
                                            trecho_sr = "";
                                            encontrou_algum_sr=true;
                                            encontrou_esta_sr=true;
                                        }
						
                                }
			}
                        if(encontrou_esta_sr)
                        {
                            subregraEncontrados.add(t);
                        }
		}
		return encontrou_algum_sr;
	}

	
	
	private String retiraErrosRecorrentes(String text){
		
		text = text.replaceFirst("#", "Paciente");

		return text;

		
	}
	
	private String retiraPontoLetra(String text){
		String aux="";
                aux=text.replaceAll("\\.",". ");
                String pattern="(\\.)( )([0-9])";
                text=aux.replaceAll(pattern,"$1$3");
//                System.out.println("retiraPontoLetra");
//                System.out.println(text);
//                System.out.println("<><><><><><><><><><><><><><<><><>< ");
                return text;
//		return text.replaceAll("[.][a-z]", "$1").replaceAll("[.][A-Z]", "$1");
		
	}
	private String retiraPontuacao(String text){
		
//		return text.replaceAll("[-!?><=%;/#,@*]", " ");
		return text.replaceAll("[-!?><=%;/#@*]", " ");
		
	}
	
	private String espacaPontuacao(String text){
		
		return text.replace(".", " .");
	}
	
	private String removeEspacaPontuacao(String text){
		
		return text.replace(" .", ".");
	}
	
	private String espacaTexto(String text){
		
		return (" "+text+" ");
	}
	
	private String removeEspacaTexto(String text){
		
		return text.substring(1, (text.length()-1));
	}
        
        private String removeEspacoInicio(String text){
                while(text.startsWith(" "))
                    text = text.substring(1, text.length());
                
                return text;
        }
	
	private String expandirData(String text){
		
		
		 if (Pattern.compile("[\\d]+[\\d]+[/]+[\\d]+[\\d]+[/]+[\\d]+[\\d]").matcher(text).find()
			    	|| Pattern.compile("[\\d]+[\\d]+[/]+[\\d]+[\\d]+[/]+[\\d]+[\\d]+[\\d]+[\\d]").matcher(text).find()
			    	|| Pattern.compile("[\\d]+[\\d]+[/]+[a-zA-Z]+[a-zA-Z]+[a-zA-Z][/]+[\\d]+[\\d]+[\\d]+[\\d]").matcher(text).find()
			    	|| Pattern.compile("[\\d]+[\\d]+[/]+[a-zA-Z]+[a-zA-Z]+[a-zA-Z][/]+[\\d]+[\\d]").matcher(text).find()){
			
			text = text.replace("01/","1/");
			text = text.replace("02/","2/");
			text = text.replace("03/","3/");
			text = text.replace("04/","4/");
			text = text.replace("05/","5/");
			text = text.replace("06/","6/");
			text = text.replace("07/","7/");
			text = text.replace("08/","8/");
			text = text.replace("09/","9/");
			 
			text = text.replace("/jan/"," de janeiro de ");
	    	text = text.replace("/fev/"," de fevereiro de ");
	    	text = text.replace("/mar/"," de março de ");
	    	text = text.replace("/abr/"," de abril de ");
	    	text = text.replace("/mai/"," de maio de ");
	    	text = text.replace("/jun/"," de junho de ");
	    	text = text.replace("/jul/"," de julho de ");
	    	text = text.replace("/ago/"," de agosto de ");
	    	text = text.replace("/set/"," de setembro de ");
	    	text = text.replace("/out/"," de outubro de ");
	    	text = text.replace("/nov/"," de novembro de ");
	    	text = text.replace("/dez/"," de dezembro de ");
			  
	    	text = text.replace("/01/"," de janeiro de ");
	    	text = text.replace("/02/"," de fevereiro de ");
	    	text = text.replace("/03/"," de março de ");
	    	text = text.replace("/04/"," de abril de ");
	    	text = text.replace("/05/"," de maio de ");
	    	text = text.replace("/06/"," de junho de ");
	    	text = text.replace("/07/"," de julho de ");
	    	text = text.replace("/08/"," de agosto de ");
	    	text = text.replace("/09/"," de setembro de ");
	    	text = text.replace("/10/"," de outubro de ");
	    	text = text.replace("/11/"," de novembro de ");
	    	text = text.replace("/12/"," de dezembro de ");
	    	
	    }
		
	    if (Pattern.compile("[\\d]+[\\d]+[/]+[\\d]+[\\d]").matcher(text).find()
	    	|| Pattern.compile("[\\d]+[\\d]+[/]+[a-zA-Z]+[a-zA-Z]+[a-zA-Z]").matcher(text).find()){
	    	
	    	text = text.replace("01/","1/");
			text = text.replace("02/","2/");
			text = text.replace("03/","3/");
			text = text.replace("04/","4/");
			text = text.replace("05/","5/");
			text = text.replace("06/","6/");
			text = text.replace("07/","7/");
			text = text.replace("08/","8/");
			text = text.replace("09/","9/");
	    	
	    	text = text.replace("/jan"," de janeiro");
	    	text = text.replace("/fev"," de fevereiro");
	    	text = text.replace("/mar"," de março");
	    	text = text.replace("/abr"," de abril");
	    	text = text.replace("/mai"," de maio");
	    	text = text.replace("/jun"," de junho");
	    	text = text.replace("/jul"," de julho");
	    	text = text.replace("/ago"," de agosto");
	    	text = text.replace("/set"," de setembro");
	    	text = text.replace("/out"," de outubro");
	    	text = text.replace("/nov"," de novembro");
	    	text = text.replace("/dez"," de dezembro");
	    	
	        text = text.replace("/01"," de janeiro");
	    	text = text.replace("/02"," de fevereiro");
	    	text = text.replace("/03"," de março");
	    	text = text.replace("/04"," de abril");
	    	text = text.replace("/05"," de maio");
	    	text = text.replace("/06"," de junho");
	    	text = text.replace("/07"," de julho");
	    	text = text.replace("/08"," de agosto");
	    	text = text.replace("/09"," de setembro");
	    	text = text.replace("/10"," de outubro");
	    	text = text.replace("/11"," de novembro");
	    	text = text.replace("/12"," de dezembro");}
	    
	       
	    return text;
	}
	
	private String retiraStopWords(String text){
		
		text = text.replace(" o ", " ");
		text = text.replace(" a ", " ");
		text = text.replace(" os ", " ");
		text = text.replace(" as ", " ");
		text = text.replace(" um ", " ");
		text = text.replace(" uma ", " ");
		text = text.replace(" uns ", " ");
		text = text.replace(" umas ", " ");
		
		
		return text;
		
	}
	
	private String expandirAcronimos(String text){
		
		 for(int i=0; i<acronimos.size(); i++){
			 Acronimo a = acronimos.get(i);
			 text = text.replace(a.getAcronimo() , a.getExpansao());
		 }
				
		return text;
		
	}
	
}
