package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.VideoModel;

public class VideoDAO {
    private Connection conn;

    public VideoDAO(Connection conn) {
        this.conn = conn;
    }

    public List<VideoModel> buscarPorNome(String termo) throws SQLException {
        List<VideoModel> lista = new ArrayList<>();
        String sql = "SELECT id, titulo, descricao, url_video, curtidas FROM videos WHERE titulo ILIKE ?";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, "%" + termo + "%");
        statement.execute();
        
        ResultSet res = statement.getResultSet();
        while (res.next()) {
            VideoModel video = new VideoModel();
            video.setId(res.getInt("id"));
            video.setTitulo(res.getString("titulo"));
            video.setDescricao(res.getString("descricao"));
            video.setUrlVideo(res.getString("url_video"));
            video.setCurtidas(res.getInt("curtidas"));
            lista.add(video);
        }
        res.close();
        statement.close();
        return lista;
    }

    public void registrarReacao(int usuarioId, int videoId, String tipo) throws SQLException {
        String sql = "INSERT INTO curtidas (id_usuario, id_video, tipo) VALUES (?, ?, ?) " +
                     "ON CONFLICT (id_usuario, id_video) DO UPDATE SET tipo = EXCLUDED.tipo";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, usuarioId);
        statement.setInt(2, videoId);
        statement.setString(3, tipo);
        
        statement.execute();
        statement.close();
        conn.close(); 
    }
    public int contarReacoes(int idVideo, String tipo) throws SQLException {
        int total = 0;
        String sql = "SELECT COUNT(*) AS total FROM curtidas WHERE id_video = ? AND tipo = ?";
        
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, idVideo);
        statement.setString(2, tipo);
        ResultSet res = statement.executeQuery();
        
        if (res.next()) {
            total = res.getInt("total");
        }
        
        res.close();
        statement.close();
        conn.close();
        return total;
    }
}