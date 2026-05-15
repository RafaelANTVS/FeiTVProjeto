package controller;

import dao.UsuarioDAO;
import dao.Conexao;
import model.Usuario;
import view.Cadastro;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControleCadastro {
    private Cadastro telaCadastro;
    
    public ControleCadastro(Cadastro telaCadastro) {
        this.telaCadastro = telaCadastro;
    }
    
    public void salvarUsuario() {
        String nome = telaCadastro.getTxtNome().getText();
        String usuario = telaCadastro.getTxtUsuario().getText();
        String senha = telaCadastro.getTxtSenha().getText();
        
        // Validação 
        if (nome.isEmpty() || usuario.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(telaCadastro, 
                "Preencha todos os campos!", 
                "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        Usuario novoUsuario = new Usuario( nome, usuario, senha);
        
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            UsuarioDAO dao = new UsuarioDAO(conn);
            dao.inserir(novoUsuario);
            
            JOptionPane.showMessageDialog(telaCadastro, 
                "Usuário cadastrado com sucesso!", 
                "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            

            telaCadastro.getTxtNome().setText("");
            telaCadastro.getTxtUsuario().setText("");
            telaCadastro.getTxtSenha().setText("");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(telaCadastro, 
                "Erro ao cadastrar: " + e.getMessage(), 
                "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}