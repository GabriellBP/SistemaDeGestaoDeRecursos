package alocacoes;

import recursos.RecursoPrototype;
import usuarios.UsuarioStrategy;

import java.util.Date;

public abstract class AlocacaoState {
    private String status;
    private UsuarioStrategy responsavel;
    private Date dataInicio;
    private Date dataFim;



    abstract void mudarEstado(RecursoPrototype recurso, int idAlocacao);


}
