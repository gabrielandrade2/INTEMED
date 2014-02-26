package br.gpri.controle;

import activerecord.Elemento;
import activerecord.FalsoNegativo;
import activerecord.Regra;
import activerecord.Resultados;
import activerecord.Subregra;
import activerecord.TrechoEncontrado;
import br.gpri.janelas.JanelaCadastroRegra;
import br.gpri.janelas.JanelaResultados;
import br.gpri.nlp.Tagger;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.StyledDocument;

public class ControleResultados extends Variaveis{
	
	Integer linha;
	int idResult;
	int idResultSR;
	int idExecucao;
	int idTexto;
        String original;
	private JanelaResultados Janela;
        
	private List<Resultados> listaResultados;
	private List<Resultados> listaResultadosSelecionados;
	private List<Elemento> elementos;
	private List<Regra> regras;
	List<Subregra> subregras;
        
	private List<TrechoEncontrado> trechosTextoSelecionadoRegras = new ArrayList<TrechoEncontrado>();
	private List<TrechoEncontrado> trechosTextoSelecionadoSubregras = new ArrayList<TrechoEncontrado>();
        
        public ControleResultados(List<Resultados> listaResultados, int idExecucao){
		linha = 0;
		this.listaResultados = listaResultados;
		this.idExecucao = idExecucao;
		
                //Pre-Processa o texto para mostrar na janela
                preProcessaTexto();
                
		Janela = new JanelaResultados();
		Janela.setLocationRelativeTo(null);
		
		//ActionListener dos Botões
		Janela.BotaoOk.addActionListener(this.Ok);
		Janela.BotaoRegra.addActionListener(this.Cadastra);
		Janela.BotaoFalsoNegativo.addActionListener(this.FalsoNegativo);
			
		//Caixa de Texto Regra
		Janela.TextoRegra.setEditable(false);
		Janela.TextoRegra.setLineWrap(true);
		Janela.TextoRegra.setWrapStyleWord(true);
		
		//Caixa de Texto Trecho Regra
		Janela.RegraTextoTrecho.setEditable(false);
		Janela.RegraTextoTrecho.setLineWrap(true);
		Janela.RegraTextoTrecho.setWrapStyleWord(true);
		
		//Caixa de Texto Subregra
		Janela.TextoSubRegra.setEditable(false);
		Janela.TextoSubRegra.setLineWrap(false);
		Janela.TextoSubRegra.setWrapStyleWord(true);
		
		//Caixa de Texto Trecho Subregra
		Janela.SubRegraTextoTrecho.setEditable(false);
		Janela.SubRegraTextoTrecho.setLineWrap(true);
		Janela.SubRegraTextoTrecho.setWrapStyleWord(true);
		
		//Referente aos Textos
		Janela.NumeroTexto.setText(linha.toString());
		Janela.AreaTexto.setEditable(false);
                Janela.AreaTexto.setContentType("text/html");
//		Janela.AreaTexto.setLineWrap(true);
//		Janela.AreaTexto.setWrapStyleWord(true);
		Janela.NumeroTexto.setEditable(false);
		
		//DropDownListBox filtro de textos
		Janela.DropDownTexto.setSelectedIndex(0);
		Janela.DropDownTexto.addActionListener(this.DropDownListBox);

		//Botões de Comentário
		Janela.BotaoComRegra.addActionListener(this.Comment);
		Janela.BotaoComSubRegra.addActionListener(this.CommentSubRegra);
		
		//Gera Lista dos textos
		inicializaListas();
		
	}
	
	private void inicializaListas(){
		
		Janela.ListaTextos.setSelectedIndex(linha);
		Janela.ListaTextos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Janela.ListaTextos.setLayoutOrientation(JList.VERTICAL);
		Janela.ListaTextos.addListSelectionListener(this.Textos);
	
		Janela.ListaRegra.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Janela.ListaRegra.setLayoutOrientation(JList.VERTICAL);
		Janela.ListaRegra.addListSelectionListener(this.Regras);
		
		Janela.ListaSubRegra.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Janela.ListaSubRegra.setLayoutOrientation(JList.VERTICAL);
		Janela.ListaSubRegra.addListSelectionListener(this.Subregras);
                
                geraListaResultados();
	}
	
	public void abreJanela(){
		Janela.setVisible(true);
	}
	
	public void fechaJanela(){
		Janela.setVisible(false);
		Janela.dispose();
	}
	
	private void limpaCaixasTexto(){
		Janela.TextoRegra.setText("");
		Janela.RegraTextoTrecho.setText("");
		Janela.TextoSubRegra.setText("");
		Janela.SubRegraTextoTrecho.setText("");
        }
        
        private void limpaAreaTexto(){
            	Janela.AreaTexto.setText("");
        }
        
        private void preProcessaTexto(){
            Tagger Tagger = new Tagger(BD);
            for(int i=0; i<listaResultados.size(); i++){
                String texto = listaResultados.get(i).getTexto();
                texto = Tagger.preProccessText(texto);
                texto = Tagger.expandePreposicoes(texto);
                listaResultados.get(i).setTexto(texto);
            }
        }
	
	private void geraListaResultados(){
		int filtro = Janela.DropDownTexto.getSelectedIndex(); //Pega a seleção do DropDown
		listaResultadosSelecionados = new ArrayList<Resultados>();
		List<String> textos = new ArrayList<String>();
		
		//Compara e gera a lista para cada caso
		if(filtro == 0){ //Todos
			listaResultadosSelecionados = listaResultados;
			for(int i=0; i<listaResultados.size(); i++){
				textos.add(listaResultados.get(i).getTexto());
			}
		}
		else if(filtro == 1){ //Encontrados
			for(int i=0; i<listaResultados.size(); i++){
				Resultados r = listaResultados.get(i);
				if(r.isEncontrado()){
					listaResultadosSelecionados.add(r);
					textos.add(r.getTexto());
				}
			}
		}
		else if(filtro == 2){ //Não encontrados
			for(int i=0; i<listaResultados.size(); i++){
				Resultados r = listaResultados.get(i);
				if(!r.isEncontrado()){
					listaResultadosSelecionados.add(r);
					textos.add(r.getTexto());
				}
			}
		}
		else
			System.out.println("Problema com o DropDownListBox do filtro de textos");
		
                            
		//Atualiza lista na Janela
	
		DefaultListModel listaTexto = new DefaultListModel();
		for(int i=0; i<textos.size(); i++){
				listaTexto.addElement(textos.get(i));
		}
		
		Janela.ListaTextos.setModel(listaTexto);
		
		Janela.ListaTextos.updateUI();
		limpaCaixasTexto();
		Janela.ListaTextos.setSelectedIndex(0);
	}
	
		
	private void separaTrechos(List<TrechoEncontrado> trechosTextoSelecionado){
		trechosTextoSelecionadoRegras = new ArrayList<TrechoEncontrado>();
		trechosTextoSelecionadoSubregras = new ArrayList<TrechoEncontrado>();
		
		for(int i=0;i<trechosTextoSelecionado.size();i++){
			if(trechosTextoSelecionado.get(i).isSubregra())
				trechosTextoSelecionadoSubregras.add(trechosTextoSelecionado.get(i));
			else
				trechosTextoSelecionadoRegras.add(trechosTextoSelecionado.get(i));
		}
	}

/*	protected void geraListaTexto(List<String> textos){
		int item=Janela.DropDownTexto.getSelectedIndex();
		DefaultListModel listaTexto = new DefaultListModel();
		Janela.DropDownTexto.setSelectedIndex(0);
		for(int i=0; i<textos.size(); i++){
				
				listaTexto.addElement(textos.get(i));
				
			}
		Janela.ListaTextos.setModel(listaTexto);
		Janela.ListaTextos.updateUI();
		Janela.ListaTextos.setSelectedIndex(0);
	}*/
	
	protected void geraListaRegras(){
		DefaultListModel listaRegrasEncontrados = new DefaultListModel();
		for(int i=0;i<trechosTextoSelecionadoRegras.size();i++){
			listaRegrasEncontrados.addElement(trechosTextoSelecionadoRegras.get(i).getRegra().getPrevia());				
		}
		Janela.ListaRegra.setModel(listaRegrasEncontrados);
		Janela.ListaRegra.updateUI();
		Janela.ListaRegra.setSelectedIndex(0);
	}
	
	private void geraListaSubregras(int idRegra){
		DefaultListModel listaSubregrasEncontrados = new DefaultListModel();
		for(int i=0;i<trechosTextoSelecionadoSubregras.size();i++){
			if(trechosTextoSelecionadoSubregras.get(i).getSubregra().getIdRegra() == idRegra)
				listaSubregrasEncontrados.addElement(trechosTextoSelecionadoSubregras.get(i).getSubregra().getPrevia());				
		}
		Janela.ListaSubRegra.setModel(listaSubregrasEncontrados);
		Janela.ListaSubRegra.updateUI();
		Janela.ListaSubRegra.setSelectedIndex(0);
	}
	
        private String marcaFalsosNegativos(String texto){
            if(!(texto == null)){
                String[] texto_separado = texto.split(" ");
		List<FalsoNegativo> falsosNegativos = BD.selectFalsoNegativo(idExecucao, idTexto);
		
                for(FalsoNegativo fn:falsosNegativos){
                   int posInicial = fn.getPosIncial();
                   int posFinal = fn.getPosFinal();
                   
                   //texto_separado[posInicial] = "<font color=\"red\">" + texto_separado[posInicial];
                  // texto_separado[posFinal] = texto_separado[posFinal] + "</font color=\"red\">";
                   //texto_separado[posInicial] = "<mark style=\"background-color:DarkSalmon\">" + texto_separado[posInicial];
                  // texto_separado[posFinal] = texto_separado[posFinal] + "</mark>";
                  //texto_separado[posInicial] = "<span style=\"background-color:DarkSalmon\">" + texto_separado[posInicial];
                  // texto_separado[posFinal] = texto_separado[posFinal] + "</span>";
                   
                   texto_separado[posInicial] = "<font style=\"background-color:#ffc0a0 \">" + texto_separado[posInicial];
                   texto_separado[posFinal] = texto_separado[posFinal] + "</font>";
               }
                //texto_separado[0] = "<html>" + texto_separado[0];
               //texto_separado[texto_separado.length-1] +=  "</html>";
                
               texto = new String();
               for (String token : texto_separado) 
                   texto += " " + token;
               
               texto = texto.substring(1, texto.length());
             }
	    
            System.out.println(texto);
            return texto;
	}
        
        
	/*private String marcaFalsosNegativosold(String texto){
            if(!(texto == null)){
		List<FalsoNegativo> falsosNegativos = BD.selectFalsoNegativo(idExecucao, idTexto);
		for(FalsoNegativo fn:falsosNegativos){
                                String falsoNegativo = fn.getTrechoSelecionado();
                                String textoComparacao = texto;
                                falsoNegativo = falsoNegativo.toLowerCase();
                          	if(original.contains(falsoNegativo)){
                                    String falsoNegativoREGEX = corrigeREGEX(falsoNegativo);
                                    
                                    Pattern pattern = Pattern.compile(falsoNegativoREGEX);
                                    Matcher matcher = pattern.matcher(textoComparacao);
                                    boolean encontrou=matcher.find();
                                    
                                    String[] dividido = textoComparacao.split(falsoNegativoREGEX);
                                    texto = new String();
                                    
                                     if(dividido.length == 1){
                                             texto += dividido[0];
                                             if(encontrou)
                                             {
                                                texto += "<font color=\"red\">" + matcher.group(0) + " </font>";
                                             }

                                         }
                                         else{
                                            for(int j=0; j<dividido.length - 1; j++){
                                                texto += dividido[j] + "<font color=\"red\">";
                                                if (j<matcher.groupCount())
                                                {        
                                                    texto += matcher.group(j) + " </font>";
                                                }
                                                else 
                                                {
                                                    texto += falsoNegativo + " </font>";
                                                }
                                            }
                                            texto += dividido[dividido.length-1];
                                         }   
				}
			}
		}
              
		return texto;
	}*/
	
        private String negritaTexto(String texto){
           if(!(texto == null)){
                              
               original = texto;     
               String[] texto_separado = texto.split(" ");
               
               //Marca trechos sobrepostos
               for(int i=0; i<trechosTextoSelecionadoRegras.size(); i++){
                   //Pega o primero trecho para comparar
                   String a = trechosTextoSelecionadoRegras.get(i).getTrechoEncontrado(); //Para debug
                   int posInicial = trechosTextoSelecionadoRegras.get(i).getPosInicial();
                   int posFinal = trechosTextoSelecionadoRegras.get(i).getPosFinal();
                   
                   //Para caso seja Nada Encontrado ou tenha tido algum problema com a posição, ele fica com -1 e não marca
                   if(posInicial < 0 || posFinal < 0)
                       break;
                                      
                   //Pega todos os outros, um por um, pra ver se tem algum que começa (e termina ou não) dentro de outro
                   for(int j=0; j<trechosTextoSelecionadoRegras.size(); j++){
                       //Não compara iguais
                       if(i==j)
                           break;
                       String b = trechosTextoSelecionadoRegras.get(i).getTrechoEncontrado(); //Para debug
                       int posInicial2 = trechosTextoSelecionadoRegras.get(j).getPosInicial();
                       int posFinal2 = trechosTextoSelecionadoRegras.get(j).getPosFinal();
                       
                       //Pega um trecho e compara se outro abre dentro
                       if(posInicial2 > posInicial && posInicial2 < posFinal){
                           //Coloca a tag de cor de sobreposicão no lugar onde começa o trecho dentro do outro
                           texto_separado[posInicial2] = "<font color=\"yellow\">" + texto_separado[posInicial2];
                           
                           //Vê se esse trecho também, termina dentro do outro
                           if(posFinal2 > posInicial && posFinal2 < posFinal)
                               //Se sim coloca o fehcamento de tag no trecho de dentro
                               texto_separado[posFinal2] = texto_separado[posFinal2] + "</font color=\"yellow\">";
                           else
                               //Se não coloca o fechamento no trecho que contém o outro
                               texto_separado[posFinal] = texto_separado[posFinal] + "</font color=\"yellow\">";
                       }
                   }
               }
               
               
               //Marca trechos encontrados
               for(int i=0; i<trechosTextoSelecionadoRegras.size(); i++){
                   int posInicial = trechosTextoSelecionadoRegras.get(i).getPosInicial();
                   int posFinal = trechosTextoSelecionadoRegras.get(i).getPosFinal();
                   
                   //Para caso seja Nada Encontrado ou tenha tido algum problema com a posição, ele fica com -1 e não marca
                   if(posInicial < 0 || posFinal < 0)
                       break;
                   
                   String color = new String();
                   if(trechosTextoSelecionadoRegras.get(i).getRegra().corElementoIsNull())
                       color = BD.selectCorElemento(trechosTextoSelecionadoRegras.get(i).getRegra().getElemento());
                   else
                    color = trechosTextoSelecionadoRegras.get(i).getRegra().getCorElemento();
                   
                   texto_separado[posInicial] = "<font color=\""+color+"\"><b>" + texto_separado[posInicial];
                   texto_separado[posFinal] = texto_separado[posFinal] + "</b></font color=\""+color+"\">";
                   
               }
             
               texto = new String();
               for (String token : texto_separado) 
                   texto += " " + token;
               
               texto = texto.substring(1, texto.length());
        }
        return texto;
   }
        

        
        /*private String negritaTextoold(String texto){
           if(!(texto == null)){
               original = texto;     
               for(int i=0; i<trechosTextoSelecionadoRegras.size(); i++){
                          String trecho = trechosTextoSelecionadoRegras.get(i).getTrechoEncontrado();
                          trecho = trecho.toLowerCase();
                          
	                          //Isso aqui e para caso no BD não esteja inserido o texto já pre-processado
	                          String textoComparacao = texto.toLowerCase();
                                  if(original.contains(trecho)){
                                          
                                         String trechoREGEX = corrigeREGEX(trecho);
                   
                                         Pattern pattern = Pattern.compile(trechoREGEX);
                                         Matcher matcher = pattern.matcher(textoComparacao);
                                         boolean encontrou=matcher.find();
                                                 
                                         String[] dividido = textoComparacao.split(trechoREGEX);
                                         texto = new String();
                                         
                                         if(dividido.length == 1){
                                             texto += dividido[0];
                                             if(encontrou)
                                             {
                                                texto += "<b>" + matcher.group(0) + "</b>";
                                             }
                                         }
                                         else{
                                            for(int j=0; j<dividido.length-1; j++){
                                                if (j==0){
                                                    texto += dividido[j];
                                                }
                                                String st0 = matcher.group(0);
                                                if (j>0&&!trecho.contentEquals(st0))
                                                {
                                                   st0=trecho; 
                                                }
                                                int posInicio=st0.indexOf("<b>");
                                                int posFim=st0.indexOf("</b>");
                                                if (posInicio > -1 && posFim>posInicio)
                                                {
                                                    st0=st0.replace("<b>", "");
                                                    st0=st0.replace("</b>", "");
                                                    st0="<b>"+st0+"</b>";
                                                }
                                                if (posFim > -1 && posInicio>posFim)
                                                {
                                                    st0=st0.replace("<b>", "");
                                                    st0=st0.replace("</b>", "");                                                    
                                                }
                                                if (posInicio > -1 && posFim==-1)
                                                {
                                                    st0=st0.replace("<b>", "");
                                                    st0="<b>"+st0;
                                                }
                                                if (posFim > -1 && posInicio==-1)
                                                {
                                                    st0=st0.replace("</b>", "");
                                                    st0=st0+"</b>";
                                                }
                                                if (posFim == -1 && posInicio==-1)
                                                {
                                                    st0="<b>"+st0+"</b>";
                                                }
                                                texto +=  st0;
//                                                texto += "<b>" + trecho + "</b>";
                                                texto += dividido[j+1];
                                                }
                                            }                             
                          }
                     }
        }
        return texto;
   }*/

        private String corrigeREGEX(String trecho){
       
            if(trecho.contains("("))
                trecho = trecho.replaceAll("\\(", "\\\\(");
            if(trecho.contains(")"))
                trecho = trecho.replaceAll("\\)", "\\\\)");
            if(trecho.contains(" "))
                trecho = trecho.replaceAll(" ", " ( |<b>|</b>|<font color=\"red\">|</font>|)*");

                
            return trecho;
        }
        
	 ActionListener Ok = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fechaJanela();
				JanelaArquivo = new ControleArquivo();
				JanelaArquivo.abreJanela();
				
			}
		};
		
		 ActionListener Cadastra = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JanelaCadRegra= new ControleCadastroRegra(false, linha-1);
					JanelaCadRegra.abreJanela();
					
				}
			};
		

		ActionListener DropDownListBox = new ActionListener() {
			public void actionPerformed(ActionEvent DropDownListBox) {
				geraListaResultados();
			}
		};
		
		 ActionListener Comment = new ActionListener() {
				
                            	@Override
				public void actionPerformed(ActionEvent e) {
					JanelaComentario = new ControleComentario(idResult);
					JanelaComentario.abreJanela();
					
				}
			};
			ActionListener CommentSubRegra = new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						JanelaComentario = new ControleComentario(idResultSR);
						JanelaComentario.abreJanela();
						
					}
				};
				
			ActionListener FalsoNegativo = new ActionListener() {
					public void actionPerformed(ActionEvent FalsoNegativo) {
						String trechoSelecionado = Janela.AreaTexto.getSelectedText();
                                                
                                                //Identifica a posição no padrão utilizado, por número de palavra
                                                int charInicial = Janela.AreaTexto.getSelectionStart();
                                                int charFinal = Janela.AreaTexto.getSelectionEnd();
                                                
                                                
                                                
                                                String texto =  (String) Janela.ListaTextos.getSelectedValue();
                                                        
                                                //Conta o número de palavras até a palavra de início
                                                int posInicial = 0;
                                                for(int i=0; i<charInicial; i++)
                                                    if(texto.charAt(i) == ' ')
                                                        posInicial++;
                                                                                                
                                                //Conta o número de palvras entre o início e o fim do trecho marcado
                                                int posFinal = posInicial;
                                                for(int i=charInicial; i<charFinal; i++)
                                                    if(texto.charAt(i) == ' ')
                                                        posFinal++;
                                                posFinal--; //Pegava sempre uma palavra a mais
                                                
                                                //Para garantir que não foi selecionado só parte de uma palavra e ele marque de vermelho até o final
                                                if(posInicial > posFinal)                                                
                                                    posFinal = posInicial;
                                                
                                                
                                                //Cria objeto Falson Negativo
                                                FalsoNegativo fn = new FalsoNegativo(trechoSelecionado, posInicial, posFinal);
                                                
						BD.insertFalsoNegativo(idTexto, idExecucao, fn);
                                      
                                                //Identifica logo apos marcar
                                                
                                                //Pegar texto daqui, se pegar da área texto vem com html e os acentos zuados
//                                                String texto =  (String) Janela.ListaTextos.getSelectedValue();
                                                texto = negritaTexto(texto);
                                                texto = marcaFalsosNegativos(texto);
                                                Janela.AreaTexto.setText(texto);
                                                Janela.AreaTexto.updateUI();
                            		}
				};
				
                 
                         
		ListSelectionListener Textos = new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent Regras) {
                            
				limpaCaixasTexto();
                                limpaAreaTexto();
                
				int textoSelecionado=Janela.ListaTextos.getSelectedIndex();
				if(textoSelecionado >= 0)
                                    
					idTexto = listaResultadosSelecionados.get(textoSelecionado).getIdTexto();
				
                                //Pegar texto daqui, se pegar da área texto vem com html e os acentos zuados
                                String texto =  (String) Janela.ListaTextos.getSelectedValue();
	                                
				
				if(textoSelecionado == -1){
					textoSelecionado = 0;
				}	
				if(listaResultadosSelecionados.isEmpty()){
                                    DefaultListModel nenhumaEntrada = new DefaultListModel();
                                    nenhumaEntrada.addElement("Nenhuma entrada");
                                    Janela.ListaTextos.setModel(nenhumaEntrada);
                                    limpaCaixasTexto();
                                    limpaAreaTexto();
                                    DefaultListModel listaVazia = new DefaultListModel();
                                    Janela.ListaRegra.setModel(listaVazia);
                                    Janela.ListaSubRegra.setModel(listaVazia);
                                }
                                
                                else{
				List<TrechoEncontrado> trechosTextoSelecionado = listaResultadosSelecionados.get(textoSelecionado).getTrechos();
				//List<TrechoEncontrado> trechosTextoSelecionado = listaEncontrados.get(textoSelecionado);
                               
				separaTrechos(trechosTextoSelecionado);
                                linha = Janela.ListaTextos.getSelectedIndex();
				Integer l = linha + 1;
				Janela.NumeroTexto.setText(l.toString());
				geraListaRegras();
                                
                                if(trechosTextoSelecionadoRegras.get(0).hasRegra())
                                    texto = negritaTexto(texto);
                                
                                texto = marcaFalsosNegativos(texto);
                                
                                
                                Janela.AreaTexto.setText(texto);
                                
                                }
			}	
		};
		
		ListSelectionListener Regras = new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent Regras) {
                    int regraSelecionada=Janela.ListaRegra.getSelectedIndex();      
                    if(regraSelecionada>=0){
                            limpaCaixasTexto();
                            TrechoEncontrado t = trechosTextoSelecionadoRegras.get(regraSelecionada);
                            idResult=t.getidResultado();
                            int idRegra = t.getRegra().getId();
                            String textoTrecho = t.getRegra().getTexto();
                            String textoRegra = t.getTrechoEncontrado();
                            Janela.TextoRegra.setText(textoRegra);
                            Janela.RegraTextoTrecho.setText(textoTrecho);
                            
                            geraListaSubregras(idRegra);
                    }
            }
    };
    
    ListSelectionListener Subregras = new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent Subregras) {
                    int subregraSelecionada=Janela.ListaSubRegra.getSelectedIndex();        
                    if(subregraSelecionada>=0){
                    		
                    		TrechoEncontrado t = trechosTextoSelecionadoSubregras.get(subregraSelecionada);
                            String textoTrecho= t.getSubregra().getTexto();
                            String textoSubregra = t.getTrechoEncontrado();
                            idResultSR=t.getidResultado();
                            Janela.TextoSubRegra.setText(textoSubregra);
                            Janela.SubRegraTextoTrecho.setText(textoTrecho);
                    }

                    
                    	
            }
    };
		
	

}
