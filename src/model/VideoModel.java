package model;

public class VideoModel {
    private int id, curtidas;
    private String url, descricao, titulo;
    
    public VideoModel(int id, String url, String descricao, int curtidas) {
        this.id = id;
        this.url = url;
        this.descricao = descricao;
        this.curtidas = curtidas;
    }
    
    public VideoModel(String titulo, String url, String descricao) {
        this.titulo = titulo;
        this.url = url;
        this.descricao = descricao;
        this.curtidas = 0; 
    }
    
    public VideoModel() {
    }
    
    public int getId() { 
        return id; 
    }
    public void setId(int id) {
        this.id = id; 
    }
   
    public String getUrl() {
        return url; 
    }
    public void setUrl(String url) {
        this.url = url; 
    }
    
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    
    public int getCurtidas() { return curtidas; }  
    public void setCurtidas(int curtidas) { this.curtidas = curtidas; }
    
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
}