package activerecord;

public class FalsoNegativo {
    
    private String trechoSelecionado;
    private int posIncial = -1;
    private int posFinal = -1;

    public FalsoNegativo(String trechoSelecionado, int posInicial, int posFinal) {
        this.trechoSelecionado = trechoSelecionado;
        this.posIncial = posInicial;
        this.posFinal = posFinal;
    }

    public String getTrechoSelecionado() {
        return trechoSelecionado;
    }

    public void setTrechoSelecionado(String trechoSelecionado) {
        this.trechoSelecionado = trechoSelecionado;
    }

    public int getPosIncial() {
        return posIncial;
    }

    public void setPosIncial(int posIncial) {
        this.posIncial = posIncial;
    }

    public int getPosFinal() {
        return posFinal;
    }

    public void setPosFinal(int posFinal) {
        this.posFinal = posFinal;
    }
    
}
