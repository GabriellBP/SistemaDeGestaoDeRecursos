package usuarios;

import atividades.Atividades;

public class DoutorandoStrategy extends UsuarioStrategy {
    public DoutorandoStrategy(int id, String cpf, String nome, String email) {
        super(id, cpf, nome, email);
    }

    @Override
    public boolean podeCriarAtividade(Atividades atividade) {
        return atividade.equals(Atividades.APRESENTACAO);
    }

    @Override
    public String toString() {
        return "Aluno de Doutorado";
    }
    
    

}
