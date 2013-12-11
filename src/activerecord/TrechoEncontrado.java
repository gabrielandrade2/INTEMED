package activerecord;

public class TrechoEncontrado {

	private String trechoEncontrado;
	private Regra regra;
	private Subregra subregra;
	private boolean isSubregra = false;
	private boolean hasRegra = false;
	private int idResultado;
	private String termoAnterior;
	private String palavraAnterior;
	private String termoPosterior;
	private String palavraPosterior;
        
	public Subregra getSubregra() {
		return subregra;
	}
	public void setSubregra(Subregra subregra) {
		this.subregra = subregra;
	}
	public boolean isSubregra() {
		return isSubregra;
	}
	public void setIsSubregra(boolean isSubregra) {
		this.isSubregra = isSubregra;
	}
	public void setHasRegra(boolean hasRegra) {
		this.hasRegra = hasRegra;
	}
	public String getTrechoEncontrado() {
		return trechoEncontrado;
	}
	public void setTrechoEncontrado(String trechoEncontrado) {
		this.trechoEncontrado = trechoEncontrado;
	}
	public String getTermoAnterior() {
		return termoAnterior;
	}
	public void setTermoAnterior(String termoAnterior) {
		this.termoAnterior = termoAnterior;
	}
	public String getPalavraAnterior() {
		return palavraAnterior;
	}
	public void setPalavraAnterior(String palavraAnterior) {
		this.palavraAnterior = palavraAnterior;
	}
	public String getTermoPosterior() {
		return termoPosterior;
	}
	public void setTermoPosterior(String termoPosterior) {
		this.termoPosterior = termoPosterior;
	}
	public String getPalavraPosterior() {
		return palavraAnterior;
	}
	public void setPalavraPosterior(String palavraPosterior) {
		this.palavraPosterior = palavraPosterior;
	}
	public Regra getRegra() {
		return regra;
	}
	public void setRegra(Regra regra) {
		this.regra = regra;
		this.hasRegra = true;
	}
	
	public boolean hasRegra(){
		return hasRegra;
	}
	
	public int getidResultado(){
		return idResultado;
		
	}
	
	public void setidResultado(int idResultado){
		this.idResultado = idResultado;
		
	}
	
}
