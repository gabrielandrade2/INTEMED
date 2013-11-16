package activerecord;

public class Execucao {
	private int id;
        private int idArquivo;
	private String data;
	private String arquivo;
        private String descricao = "";	

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if(descricao != null)
            this.descricao = descricao;
        else
            this.descricao = "";
    }
	public int getIdArquivo() {
		return idArquivo;
	}
	public void setIdArquivo(int idArquivo) {
		this.idArquivo = idArquivo;
	}
	public String getArquivo() {
		return arquivo;
	}
	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
}
