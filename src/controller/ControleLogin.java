package controller;

import dao.AlunoDAO;
import dao.Conexao;
import model.Aluno;
import view.Login;
import view.Logado;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControleLogin{
    private Login tela1;
    
    public ControleLogin(Login tela1){
        this.tela1 = tela1;
    }
    
     public void loginAluno(){
        Aluno aluno = new Aluno(null,tela1.getTxtUsuario().getText(),tela1.getTxtSenha().getText());
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            AlunoDAO dao = new AlunoDAO(conn);
            ResultSet res = dao.consultar(aluno);
            if(res.next()){
                JOptionPane.showMessageDialog(tela1, "Login efetuado", "Aviso", 
                                                JOptionPane.INFORMATION_MESSAGE);
                String nome = res.getString("nome");
                String usuario = res.getString("usuario");
                String senha = res.getString("senha");
                Logado tela2 = new Logado(new Aluno(nome, usuario, senha));
                tela2.setVisible(true);
                tela1.setVisible(false);
            } else{
                JOptionPane.showMessageDialog(tela1, "Login não efetuado", "Erro", 
                                                JOptionPane.ERROR_MESSAGE);
                
            }
        } catch(SQLException e) {
    // 1. Mostra a mensagem detalhada na janela de erro
    JOptionPane.showMessageDialog(tela1, "Erro: " + e.getMessage(), "Erro de Conexão", 
                                    JOptionPane.ERROR_MESSAGE);
    
    // 2. Imprime o rastro do erro no console do NetBeans (muito importante para debug)
    e.printStackTrace();
}
    }
}
