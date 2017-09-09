package alocacoes;

public class ConcluidoState implements AlocacaoState{

    @Override
    public AlocacaoState mudarEstado() {
        return this;
    }

    @Override
    public String getProximoEstado() {
        return "Estado Final: concluido";
    }

    @Override
    public String toString() {
        return "Concluido";
    }
    
    
}
