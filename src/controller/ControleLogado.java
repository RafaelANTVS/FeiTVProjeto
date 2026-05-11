
package controller;

import model.Aluno;
import view.Logado;

public class ControleLogado {
    private Logado tela4;
    private Aluno aluno;
    
    public ControleLogado(Logado tela4, Aluno aluno){
        this.tela4 = tela4;
        this.aluno = aluno;
    }
    
    public Aluno chamarAlteracao(){
        return aluno;
    }
    
    public Aluno chamarExclusao(){
        return aluno;
    }
}
