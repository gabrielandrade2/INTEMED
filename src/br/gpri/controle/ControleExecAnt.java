package br.gpri.controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import activerecord.Execucao;
import activerecord.Regra;
import activerecord.Resultados;
import activerecord.TrechoEncontrado;
import static br.gpri.controle.Variaveis.BD;
import br.gpri.janelas.JanelaExecAnt;
import br.gpri.janelas.JanelaRegras;
import java.beans.PropertyChangeListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class ControleExecAnt extends Variaveis{
	
	private JanelaExecAnt Janela;
	private List<Execucao> execucoes;
        private JCheckBox[] checkbox;
        private int idArquivo = -1;
        
	public ControleExecAnt(){
		Janela = new JanelaExecAnt();
		geraListaExecucoes();
		
		Janela.ABotaoOk.addActionListener(this.OK);
		Janela.ABotaoVoltar.addActionListener(this.Volta);
		Janela.setLocationRelativeTo(null);
	}
	
	public ControleExecAnt(int idArquivo){
                this.idArquivo = idArquivo;
		Janela = new JanelaExecAnt();
		geraListaExecucoes();
		
		Janela.ABotaoOk.addActionListener(this.OK);
		Janela.ABotaoVoltar.addActionListener(this.Volta);
		Janela.setLocationRelativeTo(null);
	}
	
	
	private void geraListaExecucoes(){
            if(this.idArquivo < 0)
                execucoes = BD.selectExecucoes(idUsuario);
            else
                execucoes = BD.selectExecucoes(idUsuario,this.idArquivo);
            
                       
            DefaultTableModel tabela = new DefaultTableModel() { 
                
                  public boolean isCellEditable(int row, int column) {
                        if(column == 0 || column == 4)
                            return true;
                        else
                            return false;
                   }
                  //Deixa a Tabela não editável
                  
                  public Class<?> getColumnClass(int column) {  
                            if (column == 0)  
                                return Boolean.class;  
                            return super.getColumnClass(column);  
                        }  };
                    checkbox = new JCheckBox[execucoes.size()];
                    for(int i=0; i<checkbox.length;i++){
                            checkbox[i]=new JCheckBox();
                 }	
                
                  
		tabela.addColumn("Excluir");
                tabela.addColumn("Data / Hora");
		tabela.addColumn("Arquivo");
                tabela.addColumn("Descrição"); //Inserir no BD alter table execucoes add column descricao text;
                tabela.addColumn("Regras");
        
                if(execucoes.isEmpty()){
			Object[] o = {"Nenhuma Execução",""};
			tabela.addRow(o);
			}
		else{
			for(Execucao e:execucoes){
				Object[] o = {"X",e.getData(),e.getArquivo(),e.getDescricao(),"Regras"};
				tabela.addRow(o);
			}
		}
		
		Janela.tabelaExec.setModel(tabela);
		Janela.tabelaExec.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                ButtonColumn buttonColumn = new ButtonColumn(Janela.tabelaExec, Regras, 4);
                ButtonColumn buttonColumn2 = new ButtonColumn(Janela.tabelaExec, Excluir, 0);
	}
	
	public void abreJanela(){
		Janela.setVisible(true);
	}
	
	public void fechaJanela(){
		Janela.setVisible(false);
		Janela.dispose();
	}
	
	ActionListener Volta = new ActionListener() {
        public void actionPerformed(ActionEvent Volta) {
        	fechaJanela();
        	JanelaArquivo = new ControleArquivo();
        	JanelaArquivo.abreJanela();
		}
    };
    
	ActionListener OK = new ActionListener() {
        public void actionPerformed(ActionEvent OK) {
        	int index = Janela.tabelaExec.getSelectedRow();
    		if(index < 0)
    			System.out.println("Selecione uma execução");
    		else{
    			Execucao execucao = execucoes.get(index);
    			int idExecucao = execucao.getId();
    			int idArquivo = execucao.getIdArquivo();
    			List<String> textos = BD.selectTextos(idUsuario, idArquivo);
    			List<Resultados> listaResultados = BD.selectResultados(idExecucao, idArquivo, idUsuario);
    			
    			fechaJanela();
    			JanelaResultados = new ControleResultados(listaResultados,idExecucao);
    			JanelaResultados.abreJanela();
    		}
        }
	};
        
       
  Action Regras = new AbstractAction()
{
    public void actionPerformed(ActionEvent e)
    {
        JTable table = (JTable)e.getSource();
        JanelaRegras JanelaRegras = new JanelaRegras();
        
        //int linhaModelo = Integer.valueOf( e.getActionCommand() ); //Linha selecionada na
        int linhaModelo = Janela.tabelaExec.getSelectedRow();
        Execucao a = execucoes.get(linhaModelo);
        List<Regra> listaRegras = BD.selectRegrasExecucao(a.getId());
        
        DefaultTableModel tabela = new DefaultTableModel();
        tabela.addColumn("Prévia");
        tabela.addColumn("Texto Original");
        for(Regra r : listaRegras){
            Object[] o = {r.getPrevia(),r.getTexto()};
            tabela.addRow(o);
        }
        JanelaRegras.TabelaRegras.setModel(tabela);
        JanelaRegras.TabelaRegras.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JanelaRegras.LabelExecucao.setText("Execução: "+a.getData());
        JanelaRegras.LabelDescricao.setText("Descrição: "+a.getDescricao());
        
        JanelaRegras.setLocationRelativeTo(null);
        JanelaRegras.setVisible(true);
    }
};

Action Excluir = new AbstractAction(){
    public void actionPerformed(ActionEvent e)
    {
        JTable table = (JTable)e.getSource();
        int linha = Integer.valueOf( e.getActionCommand() );
        ((DefaultTableModel)table.getModel()).removeRow(linha);
         int idExecucao = execucoes.get(linha).getId();
         BD.removeExecucao(idExecucao);
         geraListaExecucoes();
    }
};
	
	
}
