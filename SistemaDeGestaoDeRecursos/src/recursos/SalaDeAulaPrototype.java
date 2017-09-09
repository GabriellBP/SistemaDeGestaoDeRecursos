package recursos;

public class SalaDeAulaPrototype extends RecursoPrototype {

    public SalaDeAulaPrototype() {
        super(0);
    }

    @Override
    public RecursoPrototype clonar() {
        return new SalaDeAulaPrototype(this);
    }
    
    protected SalaDeAulaPrototype(SalaDeAulaPrototype salaDeAulaPrototype){
        super(salaDeAulaPrototype.getIdentificacao());
    }

    @Override
    public String toString() {
        return "Sala de Aula";
    }
    
    
}
