package recursos;

import alocacoes.AlocacaoState;

import java.util.ArrayList;
import java.util.List;

//(identificação, data e hora de inicio, data e hora de termino, responsavel pelo recurso - professor, pesquisador ou administrador)
public abstract class RecursoPrototype {
    private int identificacao;
    private List<AlocacaoState> estadoAlocacao= new ArrayList<>();

}
