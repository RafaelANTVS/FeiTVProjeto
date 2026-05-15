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
    
    // metodos para as playlists
    public void criar(String nome, int idUsuario) throws SQLException {
        String sql = "INSERT INTO playlists (nome, id_usuario) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome);
        stmt.setInt(2, idUsuario);
        stmt.execute();
    }
    
    public void editar(int idPlaylist, String novoNome) throws SQLException {
        String sql = "UPDATE playlists SET nome = ? WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, novoNome);
        stmt.setInt(2, idPlaylist);
        stmt.execute();
    }
    
    public void excluir(int idPlaylist) throws SQLException {
        String sql = "DELETE FROM playlists WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idPlaylist);
        stmt.execute();
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
        return lista;
    }
    //manipular os videos
    public void adicionarVideo(int idPlaylist, int idVideo) throws SQLException {
        String sql = "INSERT INTO playlist_videos (playlist_id, video_id) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idPlaylist);
        stmt.setInt(2, idVideo);
        stmt.execute();
    }
    
    public void removerVideo(int idPlaylist, int idVideo) throws SQLException {
        String sql = "DELETE FROM playlist_videos WHERE playlist_id = ? AND video_id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idPlaylist);
        stmt.setInt(2, idVideo);
        stmt.execute();
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
            VideoModel video = new VideoModel(
                rs.getInt("id"),
                rs.getString("url_video"),
                rs.getString("descricao"),
                rs.getInt("curtidas")
            );
            video.setTitulo(rs.getString("titulo"));
            lista.add(video);
        }
        return lista;
    }
}