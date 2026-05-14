package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.videos;

public class VideoDAO {
    private Connection conn;
    
    public VideoDAO(Connection conn) {
        this.conn = conn;
    }
    
    // Inserir vídeo na playlist
    public void inserir(videos video, int usuarioId) throws SQLException {
        String sql = "INSERT INTO playlist (usuario_id, titulo, url, descricao) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, usuarioId);
        statement.setString(2, video.getTitulo());
        statement.setString(3, video.getUrl());
        statement.setString(4, video.getDescricao());
        statement.execute();
    }
    
    // Remover vídeo da playlist
    public void remover(int videoId) throws SQLException {
        String sql = "DELETE FROM playlist WHERE id = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, videoId);
        statement.execute();
    }
    
    // Consultar todos os vídeos de um usuário
    public ResultSet consultarPorUsuario(int usuarioId) throws SQLException {
        String sql = "SELECT * FROM playlist WHERE usuario_id = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, usuarioId);
        statement.execute();
        return statement.getResultSet();
    }
    
    // Listar vídeos como lista (melhor para usar no programa)
    public List<videos> listarVideos(int usuarioId) throws SQLException {
        List<videos> videos = new ArrayList<>();
        String sql = "SELECT * FROM playlist WHERE usuario_id = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, usuarioId);
        ResultSet rs = statement.executeQuery();
        
        while (rs.next()) {
            videos video = new videos(
                rs.getInt("id"),
                rs.getString("url"),
                rs.getString("descricao"),
                false
            );
            video.setTitulo(rs.getString("titulo"));
            videos.add(video);
        }
        return videos;
    }
}