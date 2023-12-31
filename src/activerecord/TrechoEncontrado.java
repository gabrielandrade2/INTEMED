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
        private int posInicial = -1;
        private int posFinal = -1;
        private int indSentenca;
        private int indToken;
        private String comentario;
        
    public int getPosInicial() {
        return posInicial;
    }

    public void setPosInicial(int posInicial) {
        this.posInicial = posInicial;
    }

    public int getPosFinal() {
        return posFinal;
    }

    public void setPosFinal(int posFinal) {
        this.posFinal = posFinal;
    }
        
        public void setIndSentenca(int indSentenca) {
            this.indSentenca = indSentenca;
           
        }
        public void setIndToken(int indToken) {
            this.indToken = indToken;
           
        }
        public int getIndSentenca(){
            return indSentenca;
        }
        public int getIndToken(){
            return indToken;
        }
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

        public String getComentario() {
            return comentario;
        }

        public void setComentario(String comentario) {
            this.comentario = comentario;
        }


        
}
