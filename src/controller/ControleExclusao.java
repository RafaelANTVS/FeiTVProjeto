package controller;

import dao.AlunoDAO;
import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Aluno;
import view.Exclusao;

public class ControleExclusao {
    private Exclusao tela5;
    private Aluno aluno;
    
    public ControleExclusao(Exclusao tela5, Aluno aluno){
        this.tela5 = tela5;
        this.aluno = aluno;
    }
    
    public void remover(){
        int option = JOptionPane.showConfirmDialog(tela5, "Deseja realmente excluir o cadastro?",
                "Aviso", JOptionPane.YES_NO_OPTION);
        if(option != 1){
            Conexao conexao = new Conexao();
            try{
                Connection conn = conexao.getConnection();
                AlunoDAO dao = new AlunoDAO(conn);
                dao.remover(aluno);
                JOptionPane.showMessageDialog(tela5, "Usuario removido com Sucesso!", 
                                            "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }catch(SQLException e){
                JOptionPane.showMessageDialog(tela5, "Falha de conexão!", 
                                            "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
