package usuarios;

import atividades.Atividades;

public class PesquisadorStrategy extends UsuarioStrategy {
    public PesquisadorStrategy(int id, String cpf, String nome, String email) {
        super(id, cpf, nome, email);
    }

    @Override
    public boolean podeCriarAtividade(Atividades atividade) {
        return atividade.equals(Atividades.APRESENTACAO);
    }

    @Override
    public String toString() {
        return "Pesquisador";
    }
    
    
}
