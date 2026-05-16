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
        carregarPlaylists();
    }
    
    public void carregarPlaylists() {
        try {
            Conexao conexao = new Conexao();
            PlaylistDAO dao = new PlaylistDAO(conexao.getConnection());
            List<PlaylistModel> playlists = dao.listarPorUsuario(usuario.getId());
            
            DefaultListModel<String> model = new DefaultListModel<>();
            for (PlaylistModel p : playlists) {
                model.addElement(p.getId() + " - " + p.getNome());
            }
            tela.getListaPlaylists().setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(tela, "Erro: " + e.getMessage());
        }
    }
    
    public void criar() {
        String nome = JOptionPane.showInputDialog(tela, "Nome da playlist:");
        if (nome != null && !nome.isEmpty()) {
            try {
                Conexao conexao = new Conexao();
                PlaylistDAO dao = new PlaylistDAO(conexao.getConnection());
                dao.criar(nome, usuario.getId());
                JOptionPane.showMessageDialog(tela, "Playlist criada!");
                carregarPlaylists();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(tela, "Erro: " + e.getMessage());
            }
        }
    }
    
    public void editar() {
        int id = tela.getPlaylistSelecionada();
        if (id == -1) {
            JOptionPane.showMessageDialog(tela, "Selecione uma playlist!");
            return;
        }
        String novoNome = JOptionPane.showInputDialog(tela, "Novo nome:");
        if (novoNome != null && !novoNome.isEmpty()) {
            try {
                Conexao conexao = new Conexao();
                PlaylistDAO dao = new PlaylistDAO(conexao.getConnection());
                dao.editar(id, novoNome);
                JOptionPane.showMessageDialog(tela, "Playlist editada!");
                carregarPlaylists();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(tela, "Erro: " + e.getMessage());
            }
        }
    }
    
    public void excluir() {
        int id = tela.getPlaylistSelecionada();
        if (id == -1) {
            JOptionPane.showMessageDialog(tela, "Selecione uma playlist!");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(tela, "Excluir playlist?");
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                Conexao conexao = new Conexao();
                PlaylistDAO dao = new PlaylistDAO(conexao.getConnection());
                dao.excluir(id);
                JOptionPane.showMessageDialog(tela, "Playlist excluída!");
                carregarPlaylists();
                tela.limparVideos();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(tela, "Erro: " + e.getMessage());
            }
        }
    }
    
    public void buscar() {
        String termo = tela.getBuscaPlaylists().getText();
        if (termo.isEmpty()) {
            carregarPlaylists();
            return;
        }
        
        try {
            Conexao conexao = new Conexao();
            PlaylistDAO dao = new PlaylistDAO(conexao.getConnection());
            List<PlaylistModel> playlists = dao.buscarPorNome(termo, usuario.getId());
            
            DefaultListModel<String> model = new DefaultListModel<>();
            for (PlaylistModel p : playlists) {
                model.addElement(p.getId() + " - " + p.getNome());
            }
            tela.getListaPlaylists().setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(tela, "Erro: " + e.getMessage());
        }
    }
    
    public void adicionarFavorito() {
        int playlistId = tela.getPlaylistSelecionada();
        int videoId = tela.getVideoSelecionado();
        if (playlistId == -1) {
            JOptionPane.showMessageDialog(tela, "Selecione uma playlist!");
            return;
        }
        if (videoId == -1) {
            JOptionPane.showMessageDialog(tela, "Selecione um vídeo!");
            return;
        }
        
        try {
            Conexao conexao = new Conexao();
            PlaylistDAO dao = new PlaylistDAO(conexao.getConnection());
            dao.adicionarVideo(playlistId, videoId);
            JOptionPane.showMessageDialog(tela, "Vídeo adicionado!");
            carregarVideosPlaylist();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(tela, "Erro: " + e.getMessage());
        }
    }
    
    public void removerVideo() {
        int playlistId = tela.getPlaylistSelecionada();
        int videoId = tela.getVideoSelecionado();
        
        if (playlistId == -1 || videoId == -1) {
            JOptionPane.showMessageDialog(tela, "Selecione playlist e vídeo!");
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(tela, "Remover vídeo da playlist?");
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                Conexao conexao = new Conexao();
                PlaylistDAO dao = new PlaylistDAO(conexao.getConnection());
                dao.removerVideo(playlistId, videoId);
                JOptionPane.showMessageDialog(tela, "Vídeo removido!");
                carregarVideosPlaylist();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(tela, "Erro: " + e.getMessage());
            }
        }
    }
    
    public void carregarVideosPlaylist() {
        int id = tela.getPlaylistSelecionada();
        if (id == -1) {
            tela.limparVideos();
            return;
        }
        
        try {
            Conexao conexao = new Conexao();
            PlaylistDAO dao = new PlaylistDAO(conexao.getConnection());
            List<model.VideoModel> videos = dao.listarVideos(id);
            
            DefaultListModel<String> model = new DefaultListModel<>();
            for (model.VideoModel v : videos) {
                model.addElement(v.getId() + " - " + v.getTitulo());
            }
            tela.getListaVideoPlaylist().setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(tela, "Erro: " + e.getMessage());
        }
    }
    
}