package model;

import model.GerenciadorPlaylist;

public class Usuario {
    // atributos
    private String nome, usuario, senha;
    private GerenciadorPlaylist Playlist;
    
    // construtores
    public Usuario() {
    }

    public Usuario(String nome, String usuario, String senha) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.Playlist = new GerenciadorPlaylist();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public GerenciadorPlaylist getPlaylist() {
        return Playlist;
    }

    public void setPlaylist(GerenciadorPlaylist Playlist) {
        this.Playlist = Playlist;
    }

}
