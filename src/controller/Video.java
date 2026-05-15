package controller;
import controller.Video;
import model.Aluno;
import model.videos;


public class video {
        private Video tela;
        private Video video;
        private Usuario usuario;
        
        public Video(Video tela, Video video, Usuario usuario) {
            this.tela = tela;
            this.video = video;
            this.usuario = usuario;
        }
        public void like() {}
        public void dislike() {}
        public void favoritar() {
            // Abre tela de playlists para escolher onde adicionar
            // Ou usa a última playlist
        }
}