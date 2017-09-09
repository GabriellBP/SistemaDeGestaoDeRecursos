package alocacoes;

import recursos.RecursoPrototype;

public interface AlocacaoState {

    AlocacaoState mudarEstado();
    
    String getProximoEstado();

}
