/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Rafael
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.videos;

public class PlaylistDAO {
    private final Connection conn;

    public PlaylistDAO(Connection conn) {
        this.conn = conn;
    }

    /**
     * Adiciona um vídeo à playlist de um aluno específico.
     */
    public void adicionarVideo(int idAluno, int idVideo) throws SQLException {
        String sql = "INSERT INTO tbplaylist (id_aluno, id_video) VALUES (?, ?)";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idAluno);
            stmt.setInt(2, idVideo);
            stmt.execute();
        }
    }

    /**
     * Remove um vídeo específico da playlist do aluno.
     */
    public void removerVideo(int idAluno, int idVideo) throws SQLException {
        String sql = "DELETE FROM tbplaylist WHERE id_aluno = ? AND id_video = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idAluno);
            stmt.setInt(2, idVideo);
            stmt.execute();
        }
    }

    /**
     * Retorna a lista completa de vídeos de um aluno, buscando os detalhes na tabela de vídeos.
     */
    public List<videos> listarPorAluno(int idAluno) throws SQLException {
        List<videos> playlist = new ArrayList<>();
        
        String sql = "SELECT v.* FROM tbvideos v " +
                     "JOIN tbplaylist p ON v.id = p.id_video " +
                     "WHERE p.id_aluno = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idAluno);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    videos video = new videos();
                    video.setId(rs.getInt("id"));
                    video.setTitulo(rs.getString("titulo"));
                    video.setDescricao(rs.getString("descricao"));
                    video.setUrl(rs.getString("url"));
                    
                    playlist.add(video);
                }
            }
        }
        return playlist;
    }
}
