package controller;

import dao.AlunoDAO;
import dao.Conexao;
import model.Aluno;
import view.Alteracao;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;

public class ControleAlteracao {
    private Alteracao tela6;
    private Aluno aluno;
    
    public ControleAlteracao(Alteracao tela6, Aluno aluno){
        this.tela6 = tela6;
        this.aluno = aluno;
    }
    
    public void atualizar(){
        String usuario = aluno.getUsuario();
        String novaSenha = tela6.getTxtNovaSenha().getText();
        Aluno aluno = new Aluno("", usuario, novaSenha);
        Conexao conexao = new Conexao();
        try{
            Connection conn = conexao.getConnection();
            AlunoDAO dao = new AlunoDAO(conn);
            dao.atualizar(aluno);
            JOptionPane.showMessageDialog(tela6, "Senha de Usuário atualizada com Sucesso!", 
                                        "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(tela6, "Falha de conexão!", 
                                        "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
