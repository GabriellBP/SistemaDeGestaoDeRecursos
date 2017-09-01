package usuarios;

import atividades.AtividadeReal;
import recursos.RecursoPrototype;

import java.util.ArrayList;
import java.util.List;

public abstract class UsuarioStrategy {
    private int cpf;
    private String nome;
    private String email;
    private List<RecursoPrototype> historicoRecursos;
    private List<AtividadeReal> historicoAtividades;

    public UsuarioStrategy(int cpf, String nome, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.historicoRecursos = new ArrayList<>();
        this.historicoAtividades = new ArrayList<>();
    }

    public void addHistoricoRecursos(RecursoPrototype recurso){
        historicoRecursos.add(recurso);
    }

    public void addHistoricoAtividades(AtividadeReal atividade){
        historicoAtividades.add(atividade);
    }

    public void listarRecursos(){
        //for each
    }

    public void listarAtividades(){
        //for each
    }

    public abstract boolean podeCriarAtividade();
}
