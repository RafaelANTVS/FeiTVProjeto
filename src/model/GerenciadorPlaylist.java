/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rafael
 */
public class GerenciadorPlaylist {
        private String[] videos = {"Aula de Java", "Tutorial MVC", "Demo NetBeans", "Projeto Swing"};

    public List<String> buscar(String termo) {
        List<String> resultados = new ArrayList<>();
        for (String v : videos) {
            if (v.toLowerCase().contains(termo.toLowerCase())) {
                resultados.add(v);
            }
        }
        return resultados;
    }
}
