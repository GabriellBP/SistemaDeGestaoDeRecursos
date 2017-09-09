package usuarios;

import alocacoes.Alocacao;
import atividades.AtividadeReal;
import atividades.Atividades;
import recursos.RecursoPrototype;

import java.util.ArrayList;
import java.util.List;

public abstract class UsuarioStrategy {
    private int id;
    private String cpf;
    private String nome;
    private String email;
    private List<Alocacao> historicoAlocacoes;//mudar para alocaçãox
    private List<AtividadeReal> historicoAtividades;

    public UsuarioStrategy(int id, String cpf, String nome, String email) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.historicoAlocacoes = new ArrayList<>();
        this.historicoAtividades = new ArrayList<>();
    }

    public void addHistoricoAlocacoes(Alocacao alocacao){
        historicoAlocacoes.add(alocacao);
    }

    public void addHistoricoAtividades(AtividadeReal atividade){
        historicoAtividades.add(atividade);
    }

    public void listarHistoricoAlocacoes(){
        System.out.println("Alocações realizadas:");
        for(Alocacao a : historicoAlocacoes){
            System.out.println("Recurso: "+a.getRecurso().toString());
            System.out.println("Atividade: "+a.getAtividade().toString());
            System.out.println("Data de inicio: "+a.getDataInicio());//toString?
            System.out.println("Data de fim: "+a.getDataFim());
            System.out.println("\n");
        }
    }

    public void listarHistoricoAtividades(){
        System.out.println("Atividades realizadas:");
        for(AtividadeReal a : historicoAtividades){
            System.out.println("Titulo: "+a.getTitulo());
            System.out.println("Descricao: "+a.getDescricao());
            System.out.println("Material utilizado: "+a.getMaterial());
            System.out.println("Participantes:");
            for(UsuarioStrategy u : a.getParticipantes()){
                System.out.println("Cpf: "+u.getCpf()+", Nome: "+u.getNome()+", Tipo: "+u.toString());
            }
            System.out.println("\n");
        }
    }

    public abstract boolean podeCriarAtividade(Atividades atividade);

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }
    
    
    
}
