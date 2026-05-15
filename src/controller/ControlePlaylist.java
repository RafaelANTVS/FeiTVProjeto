package model;

public class VideoModel {
    private int id;
    private String titulo;
    private String descricao;
    private String urlVideo; 
    private int curtidas;

    public VideoModel() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getUrlVideo() { return urlVideo; }
    public void setUrlVideo(String urlVideo) { this.urlVideo = urlVideo; }

    public int getCurtidas() { return curtidas; }
    public void setCurtidas(int curtidas) { this.curtidas = curtidas; }
}