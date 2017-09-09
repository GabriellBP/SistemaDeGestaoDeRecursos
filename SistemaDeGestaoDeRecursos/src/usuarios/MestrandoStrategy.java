package usuarios;

import atividades.Atividades;

public class MestrandoStrategy extends UsuarioStrategy {
    public MestrandoStrategy(int id, String cpf, String nome, String email) {
        super(id, cpf, nome, email);
    }

    @Override
    public boolean podeCriarAtividade(Atividades atividade) {
        return atividade.equals(Atividades.APRESENTACAO);
    }

    @Override
    public String toString() {
        return "Aluno de Mestrado";
    }
    
    
}
