package controller;

import model.Usuario;
import view.Pesquisar;
import view.Playlist;

public class HomeVideo {
    private Usuario usuarioLogado;
    
    public HomeVideo(Usuario usuario) {
        this.usuarioLogado = usuario;
    }
    
    public void chamarPesquisar() {
        Pesquisar telaPesquisa = new Pesquisar(usuarioLogado);
        telaPesquisa.setVisible(true);
    }
    
    public void chamarPlaylist() {
        Playlist telaPlaylist = new Playlist(usuarioLogado);
        telaPlaylist.setVisible(true);
    }
    
    public Usuario getUsuario() {
        return usuarioLogado;
    }
}