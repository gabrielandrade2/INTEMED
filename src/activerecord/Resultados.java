package activerecord;

import java.util.ArrayList;
import java.util.List;

public class Resultados {

	private List<TrechoEncontrado> trechos = new ArrayList<TrechoEncontrado>();
	private boolean isEncontrado;
	private String texto;
	private int idTexto;
	private int numResultado;

    public int getNumResultado() {
        return numResultado;
    }

    public void setNumResultado(int numResultado) {
        this.numResultado = numResultado;
    }
        
	public void setTexto(String texto){
		this.texto = texto;
	}
	
	public int getIdTexto() {
		return idTexto;
	}

	public void setIdTexto(int idTexto) {
		this.idTexto = idTexto;
	}

	public String getTexto(){
		return this.texto;
	}
	
	public List<TrechoEncontrado> getTrechos() {
		return trechos;
	}
	
	public TrechoEncontrado getTrecho(int index){
		return trechos.get(index);
	}
	
	public int sizeOfTrechos(){
		return trechos.size();
	}
	
	public void setTrechos(List<TrechoEncontrado> trechos) {
		this.trechos = trechos;
	}
	
	public void addTrecho(TrechoEncontrado trecho){
		trechos.add(trecho);
	}
	
	public boolean isEncontrado() {
		return isEncontrado;
	}
	
	public void setIsEncontrado(boolean isEncontrado) {
		this.isEncontrado = isEncontrado;
	}
}
