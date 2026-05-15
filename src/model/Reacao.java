/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Rafael
 */

public class Reacao {
    
    public enum TipoReacao {
        like, dislike
    }

    private int usuarioId;
    private int videoId;
    private TipoReacao tipo;

    public Reacao(int usuarioId, int videoId, TipoReacao tipo) {
        this.usuarioId = usuarioId;
        this.videoId = videoId;
        this.tipo = tipo;
    }

    // Getters e Setters
    public int getUsuarioId() { return usuarioId; }
    public int getVideoId() { return videoId; }
    public String getTipoString() { return tipo.name(); }
}
