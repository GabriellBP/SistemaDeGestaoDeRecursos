package usuarios;

import atividades.Atividades;

public class ProfessorStrategy  extends UsuarioStrategy {
    public ProfessorStrategy(int id, String cpf, String nome, String email) {
        super(id, cpf, nome, email);
    }

    @Override
    public boolean podeCriarAtividade(Atividades atividade) {
        return true;
    }

    @Override
    public String toString() {
        return "Professor"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
