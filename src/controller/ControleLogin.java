package controller;

import dao.UsuarioDAO;
import dao.Conexao;
import model.Usuario;
import view.Login;
import view.home;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControleLogin{
    private Login tela1;
    
    public ControleLogin(Login tela1){
        this.tela1 = tela1;
    }
    
    public void loginUsuario(){
        Usuario usuario = new Usuario(null, tela1.getTxtUsuario().getText(), tela1.getTxtSenha().getText());
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            ResultSet res = dao.consultar(usuario);
            if(res.next()){
                JOptionPane.showMessageDialog(tela1, "Login efetuado", "Aviso", 
                                                JOptionPane.INFORMATION_MESSAGE);
                String nome = res.getString("nome");
                String usuarioLogado = res.getString("usuario");
                String senha = res.getString("senha");
                int id = res.getInt("id");
                
                Usuario usuarioCompleto = new Usuario(id, nome, usuarioLogado, senha);
                
                home telaHome = new home(usuarioCompleto);
                telaHome.setVisible(true);
                tela1.dispose();
            } else{
                JOptionPane.showMessageDialog(tela1, "Login não efetuado", "Erro", 
                                                JOptionPane.ERROR_MESSAGE);
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(tela1, "Erro: " + e.getMessage(), "Erro de Conexão", 
                                            JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}