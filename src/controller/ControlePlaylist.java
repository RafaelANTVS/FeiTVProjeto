package controller;

import dao.Conexao;
import dao.PlaylistDAO;
import model.Usuario;
import model.PlaylistModel;
import view.Playlist;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import java.util.List;

public class ControlePlaylist {
    private Playlist tela;
    private Usuario usuario;
    
    public ControlePlaylist(Playlist tela, Usuario usuario) {
        this.tela = tela;
        this.usuario = usuario;
    }
    public void carregarPlaylists() {}
    public void criar() {}
    public void editar() {}
    public void excluir() {}
    public void buscar() {}
    public void adicionarFavorito() {}
    public void removerVideo() {}
    public void carregarVideosPlaylist() {}
    