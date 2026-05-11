package controller;

import dao.AlunoDAO;
import dao.Conexao;
import model.Aluno;
import view.Cadastro;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControleCadastro {
    private Cadastro tela3;
    
    public ControleCadastro(Cadastro tela3){
        this.tela3 = tela3;
    }
    
    public void salvarAluno(){
        String nome = tela3.getTxtNome().getText();
        String usuario = tela3.getTxtUsuario().getText();
        String senha = tela3.getTxtSenha().getText();
        Aluno aluno = new Aluno(nome, usuario,senha);
        
        Conexao conexao = new Conexao();
        try {
            Connection conn = conexao.getConnection();
            AlunoDAO dao = new AlunoDAO(conn);
            dao.inserir(aluno);
            JOptionPane.showMessageDialog(tela3, "Usuario Cadastrado!","Aviso", 
                                        JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(tela3, "Usuário não cadastrado!","Erro", 
                                        JOptionPane.ERROR_MESSAGE);
        }
    }
}
