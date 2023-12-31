package br.gpri.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;

import activerecord.Conjunto;
import activerecord.Elemento;
import activerecord.Execucao;
import activerecord.Regra;
import activerecord.Resultados;
import activerecord.Subregra;
import activerecord.TrechoEncontrado;
import static br.gpri.controle.Variaveis.BD;
import br.gpri.janelas.JanelaExecucao;
import br.gpri.nlp.Tagger;
import javax.swing.JTable;

public class ControleExecucao extends Variaveis{

	private JanelaExecucao Janela; 
	private List<Elemento> elementos = new ArrayList<Elemento>();
	private List<Conjunto> conjuntos = new ArrayList<Conjunto>();
        private List<Execucao> execucoes = new ArrayList<Execucao>();
	private List<Regra> regras;
	private JCheckBox[] checkbox;
	
	public ControleExecucao(){
		
		Janela = new JanelaExecucao();
		Janela.BotaoOk.addActionListener(this.Ok);
		Janela.BOTAOVOLTAR.addActionListener(this.Voltar);
		Janela.BotaoTrocar.addActionListener(this.Trocar);
		Janela.setLocationRelativeTo(null);
		
		buscaDropDownElementos();
		buscaDropDownConjuntos();
                buscaDropDownExecucoes();
		
		criaTabela();
	}
	
	private void criaTabela(){
            	int indexConjunto = Janela.DropDownlistboxConjunto.getSelectedIndex();
		int indexElemento = Janela.DropDownlistboxElementos.getSelectedIndex();
                int indexExecucao = Janela.DropDownlistboxExecucao.getSelectedIndex();
		
		int idConjunto = 0;
		int idElemento = 0;
                int idExecucao = 0;
		if(indexConjunto != 0)
			idConjunto = conjuntos.get(indexConjunto).getId();
		if(indexElemento != 0)
			idElemento = elementos.get(indexElemento).getId();
                if(indexExecucao != 0)
                       idExecucao = execucoes.get(indexExecucao).getId();
		
		regras = BD.selectRegras(idUsuario,idConjunto,idElemento,idExecucao);
		DefaultTableModel tabela = new DefaultTableModel() {  
                        public boolean isCellEditable(int row, int column) {
                            if(column == 0) 
                                return true;
                            else
                                return false;
                        }  
                        //Deixa a Tabela n�o edit�vel
                        
                        public Class<?> getColumnClass(int column) {  
                            if (column == 0)  
                                return Boolean.class;  
                            return super.getColumnClass(column);  
                        }  };
                    checkbox = new JCheckBox[regras.size()];
                    for(int i=0; i<checkbox.length;i++){
                            checkbox[i]=new JCheckBox();

                    }
	
	tabela.addColumn("Sele��o");
	tabela.addColumn("Texto");
	tabela.addColumn("Regra");
	tabela.addColumn("Conjunto");
	tabela.addColumn("Elemento");
	 
	for(int i=0; i<regras.size();i++){
		Regra r = regras.get(i);
		String elemento = "";
		String conjunto = " ";
		for(int j=0; j<elementos.size(); j++)
			if(r.getElemento() == elementos.get(j).getId()){
				elemento = elementos.get(j).getNome();
				break;
			}
		for(int k=0; k<conjuntos.size(); k++)
			if(r.getConjunto() == conjuntos.get(k).getId()){
				conjunto = conjuntos.get(k).getNome();
				break;
			}
		
		Object[] o={true,r.getTexto(), r.getPrevia(), conjunto, elemento};
		tabela.addRow(o);
		
	}
	Janela.TabelaExecucao.setModel(tabela);
		
		
	}
	
	private void buscaDropDownElementos(){
		elementos = BD.selectElemento();
		Elemento todos = new Elemento();
		todos.setId(0);
		todos.setNome("TODOS");
		todos.setDescricao("Todos os elementos");
		elementos.add(0, todos);
		
		DefaultComboBoxModel lista = new DefaultComboBoxModel();
		for(int i=0; i<elementos.size(); i++){
			lista.addElement(elementos.get(i).getNome());
		}
		Janela.DropDownlistboxElementos.setModel(lista); 
		Janela.DropDownlistboxElementos.addActionListener(this.DropDownListBoxElem);
		if(!elementos.isEmpty())
			Janela.DropDownlistboxElementos.setSelectedIndex(0);
	}
	
	private void buscaDropDownConjuntos(){
		conjuntos = BD.selectConjunto();
		Conjunto todos = new Conjunto();
		todos.setId(0);
		todos.setNome("TODOS");
		conjuntos.add(0, todos);
		
		DefaultComboBoxModel lista = new DefaultComboBoxModel();
		for(int i=0; i<conjuntos.size(); i++){
			lista.addElement(conjuntos.get(i).getNome());
		}
		
		Janela.DropDownlistboxConjunto.setModel(lista); 
		Janela.DropDownlistboxConjunto.addActionListener(this.DropDownListBoxConj);
		if(!conjuntos.isEmpty())
			Janela.DropDownlistboxConjunto.setSelectedIndex(0);
	}
	
        private void buscaDropDownExecucoes(){
            execucoes = BD.selectExecucoes(idUsuario); //Separar as execu��es por arquivo????
            //execucoes = BD.selectExecucoes(idUsuario, idArquivo);
            Execucao nenhuma = new Execucao();
            nenhuma.setId(0);
            nenhuma.setData("Nenhuma");
            nenhuma.setDescricao("Nenhuma");
            nenhuma.setArquivo("Nenhuma");
            execucoes.add(0,nenhuma);
            
            DefaultComboBoxModel lista = new DefaultComboBoxModel();
            for(int i=0; i<execucoes.size(); i++){
			lista.addElement(execucoes.get(i).getData());
		}
            
            Janela.DropDownlistboxExecucao.setModel(lista);
            Janela.DropDownlistboxExecucao.addActionListener(this.DropDownListBoxExec);
            if(!execucoes.isEmpty())
                Janela.DropDownlistboxExecucao.setSelectedIndex(0);
        }
        
	public void abreJanela(){
		Janela.setVisible(true);
	}
	
	public void fechaJanela(){
		Janela.setVisible(false);
		Janela.dispose();
	}
	
	
	//if(checkbox[i].isSelected())
	
	private List<Integer> pegaSelecaoRegras(){
		List<Integer> indiceRegras = new ArrayList<Integer>();
		for(int i=0; i<Janela.TabelaExecucao.getModel().getRowCount(); i++){
			boolean a = (Boolean) Janela.TabelaExecucao.getModel().getValueAt(i,0);
			if(a)			
				indiceRegras.add(i);
		}
		return indiceRegras;
	}
	

	private List<Regra> buscaRegrasSelecionadas(List<Integer> indiceRegras){
		
		List<Regra> regrasSelecionadas = new ArrayList<Regra>();
		
		for(int i=0; i<indiceRegras.size(); i++){
			Regra r = regras.get(indiceRegras.get(i)); //Pega cada uma das regras
			r = BD.selectTermoRegra(r); //Busca os termos dessa regra
			
			List<Subregra> subregras = new ArrayList<Subregra>();  
			subregras = BD.selectSubRegras(r); //Busca suas subregras
			if(!(subregras.isEmpty()))
				for(int j=0; j<subregras.size(); j++){
					Subregra s = subregras.get(j);	//Busca os termos da subregra e atualiza na lista
					s = BD.selectTermoSubregra(s);
					subregras.set(j,s);			
				}
			r.setSubregras(subregras);
			regrasSelecionadas.add(r);
		}
		return regrasSelecionadas;		
	}
        
        //Organiza os resultados para deixar na ordem da posi��o, igual quando � buscado no BD;
 /*       private List<Resultados> organizaResultados(List<Resultados> listaDesordenada){
            List<Resultados> listaOrdenada = new ArrayList<Resultados>();
            List<TrechoEncontrado> listaTrechoOrdenada = new ArrayList<TrechoEncontrado>();
            
            //Para cada um dos conjuntos de resultados (cada texto)
            for(Resultados r : listaDesordenada){
               List<TrechoEncontrado> listaTrechoDesordenada = r.getTrechos();
               
               for(TrechoEncontrado t : listaTrechoDesordenada){
                   //Como a lista de trechos ordenada est� vazia, insere o primeiro item para poder comparar
                   if(listaTrechoOrdenada.isEmpty()){
                       listaTrechoOrdenada.add(t);
                       continue;
                   }
                   
                   //Compara os elementos, se for menor insere na posi��o imediatamente interior, se for maior vai comparando at� o final
                   //Compara a posi��o incial, se for igual compara pela final
                   for(int i=0; i<listaTrechoOrdenada.size(); i++){
                       //Se for menor insere na posi��o e sai do loop
                       //Se for maior continua comparando    
                       if(t.getPosInicial() < listaTrechoOrdenada.get(i).getPosInicial()){
                           listaTrechoOrdenada.add(i, t);
                           break;
                       }
                       
                       //Se for igual compara pela posi��o final
                       else if(t.getPosInicial() == listaTrechoOrdenada.get(i).getPosInicial()){
                           for(int j=i; j<listaTrechoOrdenada.size(); j++){
                               //Se for menor ou igual insere na posi��o
                               if(t.getPosFinal() <= listaTrechoOrdenada.get(i).getPosFinal()){
                                 listaTrechoOrdenada.add(j, t);
                                 break;
                               }
                              //Sen�o contiuna comparando
                           } 
                       }
                       //Se estiver comparando com o �ltimo item e for maior insere no final da lista
                       else if(i == listaTrechoOrdenada.size()-1){
                           listaTrechoOrdenada.add(t);
                           break;
                       }
                   }
               }
              r.setTrechos(listaTrechoOrdenada);
              listaOrdenada.add(r);
              listaTrechoOrdenada = new ArrayList<TrechoEncontrado>();
            }
            
            return listaOrdenada;
        }*/
	
	 ActionListener Voltar = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fechaJanela();
				JanelaArquivo.abreJanela();
				
			}
		};
	
		 ActionListener Ok = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Tagger Tagger = new Tagger(BD);
					
                                        //N�mero para controle da classe ControleResultados
                                        int numResultado = 0;
					String descricao = Janela.descricaoExec.getText();
					List<Integer> indiceRegras = pegaSelecaoRegras(); //Verifica os checkbox
					List<Regra> regrasSelecionadas = buscaRegrasSelecionadas(indiceRegras); //Busca as regras selecionadas
					int numTextos = BD.getNumTextos(idUsuario, idArquivo);
					
					List<String> textos = new ArrayList<String>();
					
					List<Resultados> listaResultados = new ArrayList<Resultados>();
					//List<List<TrechoEncontrado>> listaEncontrados = new ArrayList<List<TrechoEncontrado>>();
					
					int idExecucao = BD.insertExecucao(idUsuario,idArquivo, descricao); //Cria a inst�ncia da Execucao
					BD.insertRegrasExecucao(idExecucao, regrasSelecionadas); //Armazena regras usadas na execucao
					
					for(int i=0; i<numTextos; i++){ //Pra cada texto, executa
						String texto = BD.selectTexto(idUsuario, idArquivo, i);
						boolean isEncontrado;

                                                System.out.println("Texto "+(i+1));
						
						List<TrechoEncontrado> encontrados = Tagger.executaRegra(texto, regrasSelecionadas);
						System.out.println("");
						
						//Console
//						System.out.println(texto);
//						System.out.println();
						for(int j=0; j<encontrados.size(); j++){
//							System.out.println("Trecho Encontrado: "+encontrados.get(j).getTrechoEncontrado());
//                                                        System.out.println("PosInicial= "+ encontrados.get(j).getPosInicial());
//                                                        System.out.println("PosFinal= "+encontrados.get(j).getPosFinal());
							if(encontrados.get(j).isSubregra()){
//								System.out.println("subRegra: "+encontrados.get(j).getSubregra().getPrevia());
							}
							else{
//								System.out.println("Regra: "+encontrados.get(j).getRegra().getPrevia());								
							}
							
//							System.out.println();
						}
						
						Resultados ResultadoTexto = new Resultados();
						
						//Caso n�o tenha encontrado nenhum trecho adiciona "Nada encontrado"
						if(encontrados.isEmpty()){
							TrechoEncontrado t = new TrechoEncontrado();
							Regra r = new Regra();
							r.setPrevia("Nada Encontrado");
							r.setTexto("Nada Encontrado");
							t.setRegra(r);
							t.setTrechoEncontrado("Nada Encontrado");
							t.setHasRegra(false); //Verificar pra tirar isso aqui
							ResultadoTexto.addTrecho(t);
							ResultadoTexto.setIsEncontrado(false);
						}
						
						else{
							ResultadoTexto.setTrechos(encontrados);
							ResultadoTexto.setIsEncontrado(true);
						}
						
						ResultadoTexto.setIdTexto(i);
						ResultadoTexto.setTexto(texto);
                                                ResultadoTexto.setNumResultado(numResultado);
                                                numResultado++;
                                                        
						listaResultados.add(ResultadoTexto);
						
						//textos.add(texto);
						//listaEncontrados.add(encontrados);
						
						//Insere no Banco de Dados - Insere regra seguido de suas subregras
						BD.insertResultados(ResultadoTexto, i, idExecucao);
					}
					
					
					fechaJanela();
                                       // listaResultados = organizaResultados(listaResultados);
					JanelaResultados = new ControleResultados(listaResultados,idExecucao);
					JanelaResultados.abreJanela();
					
				}
		 };
		
		 ActionListener Trocar = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
				List<Integer> indiceRegras = pegaSelecaoRegras(); //Verifica os checkbox	
				JanelaTrocaConj = new ControleTrocaConj(indiceRegras, idUsuario);
                               
                                JanelaTrocaConj.abreJanela();
				}
			};
			
	
		ActionListener DropDownListBoxElem = new ActionListener() {
			public void actionPerformed(ActionEvent DropDownListBox) {
				int item = Janela.DropDownlistboxElementos.getSelectedIndex();
				String tooltip = elementos.get(item).getDescricao();
				Janela.DropDownlistboxElementos.setToolTipText(tooltip);
				
				criaTabela();
			}
		};

		ActionListener DropDownListBoxConj = new ActionListener() {
			public void actionPerformed(ActionEvent DropDownListBox) {
				criaTabela();
			}
		};
                
                ActionListener DropDownListBoxExec = new ActionListener() {
			public void actionPerformed(ActionEvent DropDownListBox) {
				int item = Janela.DropDownlistboxExecucao.getSelectedIndex();
				String tooltip = execucoes.get(item).getDescricao();
				Janela.DropDownlistboxExecucao.setToolTipText(tooltip);
				                                                               
				criaTabela();
			}
		};

}
