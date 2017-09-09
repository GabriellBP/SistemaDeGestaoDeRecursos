package recursos;

public class AuditorioPrototype extends RecursoPrototype {
    public AuditorioPrototype() {
        super(0);
    }

    @Override
    public RecursoPrototype clonar() {
        return new AuditorioPrototype(this);
    }
    
    protected AuditorioPrototype(AuditorioPrototype auditorioPrototype){
        super(auditorioPrototype.getIdentificacao());
    }

    @Override
    public String toString() {
        return "Auditorio";
    }
    
}
