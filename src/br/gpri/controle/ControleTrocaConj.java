/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gpri.controle;

import activerecord.Conjunto;
import static br.gpri.controle.Variaveis.BD;
import br.gpri.janelas.JanelaExecucao;
import br.gpri.janelas.JanelaTrocaConj;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author sikeira
 */
public class ControleTrocaConj {
    
    private JanelaTrocaConj Janela;
    private List<Conjunto> conjuntos = new ArrayList<Conjunto>();
    private List<Integer> indiceRegra = new ArrayList<Integer>();
    private int idUsuario;
    
    public ControleTrocaConj(){
       Janela = new JanelaTrocaConj();
       Janela.setLocationRelativeTo(null);
       Janela.BotaoOk.addActionListener(Ok);
       Janela.BotaoVoltar.addActionListener(Voltar);
       Janela.BotaoCriar.addActionListener(Criar);
       buscaDropDownConjuntos();

    }
    
    public ControleTrocaConj(List<Integer>indicesRegras, int idUser){
       Janela = new JanelaTrocaConj();
       Janela.setLocationRelativeTo(null);
       Janela.BotaoOk.addActionListener(Ok);
       Janela.BotaoVoltar.addActionListener(Voltar);
       Janela.BotaoCriar.addActionListener(Criar);
       buscaDropDownConjuntos();
       indiceRegra = indicesRegras;
       idUsuario=idUser;
      
    }
    
    public void abreJanela(){
		Janela.setVisible(true);
	}
	
	public void fechaJanela(){
		Janela.setVisible(false);
		Janela.dispose();
	}
	
    ActionListener Ok = new ActionListener() {
        public void actionPerformed(ActionEvent Login) {
        	if(Janela.DropDownConjuntos.getSelectedIndex()!=0){
                    
                for(int i=0; i<indiceRegra.size();i++){
                    BD.trocaConjunto(indiceRegra.get(i), idUsuario, Janela.DropDownConjuntos.getSelectedIndex());
                }
                
                }  
                fechaJanela();
        }
	};
    
    ActionListener Voltar = new ActionListener() {
        public void actionPerformed(ActionEvent Login) {
        	fechaJanela();
        }
	};
    ActionListener Criar = new ActionListener() {
        public void actionPerformed(ActionEvent Login) {
        	String conjunto = Janela.textoNovoConjunto.getText();
                BD.insertConjunto(conjunto);
                buscaDropDownConjuntos();
        }
	};
    private void buscaDropDownConjuntos(){
		conjuntos = BD.selectConjunto();
		Conjunto todos = new Conjunto();
		todos.setId(0);
		todos.setNome("Selecione o Conjunto");
		conjuntos.add(0, todos);
		
		DefaultComboBoxModel lista = new DefaultComboBoxModel();
		for(int i=0; i<conjuntos.size(); i++){
			lista.addElement(conjuntos.get(i).getNome());
		}
		
		Janela.DropDownConjuntos.setModel(lista); 
		//Janela.DropDownConjuntos.addActionListener(this.DropDownConjuntos);
		if(!conjuntos.isEmpty())
			Janela.DropDownConjuntos.setSelectedIndex(0);
	}
	
//    ActionListener DropDownListBoxConj = new ActionListener() {
//			public void actionPerformed(ActionEvent DropDownListBox) {
//				
//			}
//		};
}
