package alocacoes;

public class EmProcessoAlocacaoState implements AlocacaoState{

    @Override
    public AlocacaoState mudarEstado() {
        return new AlocadoState();
    }

    @Override
    public String getProximoEstado() {
        return "Alocado";
    }

    @Override
    public String toString() {
        return "Em Processo de Alocacao";
    }
    
    
}
