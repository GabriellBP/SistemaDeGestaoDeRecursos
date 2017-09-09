package recursos;

public class ProjetorPrototype extends RecursoPrototype {
    public ProjetorPrototype() {
        super(0);
    }

    protected ProjetorPrototype(ProjetorPrototype projetorPrototype){
        super(projetorPrototype.getIdentificacao());
    }
    
    @Override
    public RecursoPrototype clonar() {
        return new ProjetorPrototype(this);
    }

    @Override
    public String toString() {
        return "Projetor";
    }
    
}
