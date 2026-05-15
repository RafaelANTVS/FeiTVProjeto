package controller;

import dao.VideoDAO;
import dao.Conexao;
import model.VideoModel;
import model.Usuario;
import view.video;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Video {
    private video tela6;
    private VideoModel video;
    private Usuario usuario;

    public Video(video tela6, VideoModel video, Usuario usuario) {
        this.tela6 = tela6;
        this.video = video;
        this.usuario = usuario;
        
        atualizarContadores();
    }

    public void registrarLike() {
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            VideoDAO dao = new VideoDAO(conn);
            dao.registrarReacao(usuario.getId(), this.video.getId(), "like");
            
            JOptionPane.showMessageDialog(tela6, "Você curtiu o vídeo!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            
            atualizarContadores(); 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(tela6, "Erro no banco: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void registrarDislike() {
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            VideoDAO dao = new VideoDAO(conn);
            dao.registrarReacao(usuario.getId(), this.video.getId(), "dislike");
            
            JOptionPane.showMessageDialog(tela6, "Você descurtiu o vídeo!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            
            // Recalcula os números na interface
            atualizarContadores(); 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(tela6, "Erro no banco: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void favoritar() {
        view.Playlist telaPlaylist = new view.Playlist(usuario);
        telaPlaylist.setVisible(true);
    }

    public void atualizarContadores() {
        try {
            // ler os likes
            Conexao conexao1 = new Conexao();
            VideoDAO daoLike = new VideoDAO(conexao1.getConnection());
            int likes = daoLike.contarReacoes(this.video.getId(), "like");
            tela6.getMostraLike().setText(String.valueOf(likes));
            
            //  ler os dislikes
            Conexao conexao2 = new Conexao();
            VideoDAO daoDislike = new VideoDAO(conexao2.getConnection());
            int dislikes = daoDislike.contarReacoes(this.video.getId(), "dislike");
            tela6.getMostraDislike().setText(String.valueOf(dislikes));
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}