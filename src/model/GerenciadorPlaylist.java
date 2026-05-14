/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;  
import java.util.ArrayList; 

/**
 *
 * @author Rafael
 */

public class GerenciadorPlaylist {
    
    private List<String> playlists;

    public GerenciadorPlaylist() {
        this.playlists = new ArrayList<>();
    }

    public List<String> getPlaylists() {
        return playlists;
    }

    public void adicionar(String nomePlaylist) {
        playlists.add(nomePlaylist);
    }

    public void remover(String nomePlaylist) {
        playlists.remove(nomePlaylist);
    }
}
