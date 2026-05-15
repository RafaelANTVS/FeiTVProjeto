package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.PlaylistModel;
import model.VideoModel;

public class PlaylistDAO {
    private Connection conn;
    
    public PlaylistDAO(Connection conn) {
        this.conn = conn;
    }
    
    // Metodos para as playlists
    public void criar(String nome, int idUsuario) throws SQLException {
        String sql = "INSERT INTO playlists (nome, id_usuario) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome);
        stmt.setInt(2, idUsuario);
        stmt.execute();
        
        stmt.close();
        conn.close(); 
    }
    
    public void editar(int idPlaylist, String novoNome) throws SQLException {
        String sql = "UPDATE playlists SET nome = ? WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, novoNome);
        stmt.setInt(2, idPlaylist);
        stmt.execute();
        
        stmt.close();
        conn.close();
    }
    
    public void excluir(int idPlaylist) throws SQLException {
        String sql = "DELETE FROM playlists WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idPlaylist);
        stmt.execute();
        
        stmt.close();
        conn.close();
    }
    
    // Lista
    public List<PlaylistModel> listarPorUsuario(int idUsuario) throws SQLException {
        List<PlaylistModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM playlists WHERE id_usuario = ? ORDER BY nome";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idUsuario);
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            PlaylistModel p = new PlaylistModel();
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setIdUsuario(rs.getInt("id_usuario"));
            lista.add(p);
        }
        rs.close();
        stmt.close();
        conn.close();
        return lista;
    }
    
    // Buscar playlist por nome
    public List<PlaylistModel> buscarPorNome(String nome, int idUsuario) throws SQLException {
        List<PlaylistModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM playlists WHERE nome ILIKE ? AND id_usuario = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, "%" + nome + "%");
        stmt.setInt(2, idUsuario);
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            PlaylistModel p = new PlaylistModel();
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setIdUsuario(rs.getInt("id_usuario"));
            lista.add(p);
        }
        rs.close();
        stmt.close();
        conn.close();
        return lista;
    }

    // Manipular os videos
    public void adicionarVideo(int idPlaylist, int idVideo) throws SQLException {
        String sql = "INSERT INTO playlist_videos (playlist_id, video_id) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idPlaylist);
        stmt.setInt(2, idVideo);
        stmt.execute();
        
        stmt.close();
        conn.close();
    }
    
    public void removerVideo(int idPlaylist, int idVideo) throws SQLException {
        String sql = "DELETE FROM playlist_videos WHERE playlist_id = ? AND video_id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idPlaylist);
        stmt.setInt(2, idVideo);
        stmt.execute();
        
        stmt.close();
        conn.close();
    }
    
    public List<VideoModel> listarVideos(int idPlaylist) throws SQLException {
        List<VideoModel> lista = new ArrayList<>();
        String sql = "SELECT v.* FROM videos v " +
                     "JOIN playlist_videos pv ON v.id = pv.video_id " +
                     "WHERE pv.playlist_id = ? ORDER BY v.titulo";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idPlaylist);
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            VideoModel video = new VideoModel();
            video.setId(rs.getInt("id"));
            video.setTitulo(rs.getString("titulo"));
            video.setDescricao(rs.getString("descricao"));
            video.setUrlVideo(rs.getString("url_video"));
            video.setCurtidas(rs.getInt("curtidas"));
            
            lista.add(video);
        }
        rs.close();
        stmt.close();
        conn.close();
        return lista;
    }
}