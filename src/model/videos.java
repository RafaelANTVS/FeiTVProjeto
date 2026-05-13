package model;

public class videos{

    private int id, url;
    private String descricao;
    private boolean reacao;

    public videos(int id, int url, String descricao, boolean reacao) {
        this.id = id;
        this.url = url;
        this.descricao = descricao;
        this.reacao = reacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUrl() {
        return url;
    }

    public void setUrl(int url) {
        this.url = url;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isReacao() {
        return reacao;
    }

    public void setReacao(boolean reacao) {
        this.reacao = reacao;
    }



    



}