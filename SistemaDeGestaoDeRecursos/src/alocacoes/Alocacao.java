package alocacoes;

import atividades.AtividadeReal;
import java.util.Date;
import recursos.RecursoPrototype;
import usuarios.UsuarioStrategy;

public class Alocacao {
    private final int idAlocacao;
    private final UsuarioStrategy responsavel;
    private final AtividadeReal atividade;
    private final RecursoPrototype recurso;
    private final Date dataInicio;
    private final Date dataFim;
    private AlocacaoState estadoAlocacao;

    public Alocacao(int idAlocacao, UsuarioStrategy responsavel, AtividadeReal atividade, RecursoPrototype recurso, Date dataInicio, Date dataFim) {
        this.idAlocacao = idAlocacao;
        this.responsavel = responsavel;
        this.atividade = atividade;
        this.recurso = recurso;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.estadoAlocacao = new EmProcessoAlocacaoState();
    }

    public int getIdAlocacao() {
        return idAlocacao;
    }
    
    public UsuarioStrategy getResponsavel() {
        return responsavel;
    }

    public AtividadeReal getAtividade() {
        return atividade;
    }

    public RecursoPrototype getRecurso() {
        return recurso;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public AlocacaoState getEstadoAlocacao() {
        return estadoAlocacao;
    } 
    
    public void setEstadoAlocacao(AlocacaoState alocacaoState){
        this.estadoAlocacao = alocacaoState;
    }
}
