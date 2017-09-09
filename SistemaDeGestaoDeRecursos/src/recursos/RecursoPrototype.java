package recursos;

import alocacoes.AlocacaoState;

import java.util.ArrayList;
import java.util.List;

public abstract class RecursoPrototype {
    private int identificacao;
    
    public RecursoPrototype(int identificacao) {
        this.identificacao = identificacao;
    }
    
    //Prototype
    public abstract RecursoPrototype clonar();

    public int getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(int identificacao) {
        this.identificacao = identificacao;
    }

}
