package recursos;

public class LaboratorioPrototype extends RecursoPrototype{
    public LaboratorioPrototype() {
        super(0);
    }

    @Override
    public RecursoPrototype clonar() {
        return new LaboratorioPrototype(this);
    }
    
    protected LaboratorioPrototype(LaboratorioPrototype laboratorioPrototype){
        super(laboratorioPrototype.getIdentificacao());
    }

    @Override
    public String toString() {
        return "Laboratório";
    }
    
    
}
