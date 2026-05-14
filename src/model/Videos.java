package model;

public class videos {
    private int id;
    private String url;
    private String descricao;
    private boolean reacao;
    private String titulo; 
    
    public videos(int id, String url, String descricao, boolean reacao) {
        this.id = id;
        this.url = url;
        this.descricao = descricao;
        this.reacao = reacao;
    }
    
    public videos(String titulo, String url, String descricao) {
        this.titulo = titulo;
        this.url = url;
        this.descricao = descricao;
        this.reacao = false;
    }
    
        public videos() {
    }
    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    
    public boolean isReacao() { return reacao; }
    public void setReacao(boolean reacao) { this.reacao = reacao; }
    
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
}