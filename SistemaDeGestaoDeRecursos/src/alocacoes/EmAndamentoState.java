package alocacoes;

public class EmAndamentoState implements AlocacaoState{

    @Override
    public AlocacaoState mudarEstado() {
        return new ConcluidoState();
    }

    @Override
    public String getProximoEstado() {
        return "Concluido";
    }

    @Override
    public String toString() {
        return "Em Andamento";
    }
    
    
    
}
