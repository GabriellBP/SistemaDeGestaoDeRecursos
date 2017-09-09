package atividades;

public enum Atividades {
    AULATRADICIONAL(1),
    APRESENTACAO(2),
    LABORATORIO(3);
    
    public int idAtividade;

    Atividades(int id){
        idAtividade = id;
    }
    
    public int getIdAtividade() {
        return idAtividade;
    }
    
    public static Atividades getAtividade(int idAtividade){
        for(Atividades a : Atividades.values()){
            if(a.getIdAtividade() == idAtividade)
                return a;
        }
        return null;
    }
}
