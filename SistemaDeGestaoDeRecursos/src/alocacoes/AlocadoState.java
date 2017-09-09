package alocacoes;

public class AlocadoState implements AlocacaoState{

    @Override
    public AlocacaoState mudarEstado() {
        return new EmAndamentoState();
    }

    @Override
    public String getProximoEstado() {
        return "Em andamento";
    }

    @Override
    public String toString() {
        return "Alocado";
    }
    
    
    
}
