package atividades;

import usuarios.UsuarioStrategy;

import java.util.List;

public class AtividadeRealProxy{
    
    public AtividadeReal criarAtividade(int id, UsuarioStrategy responsavel, String titulo, String descricao, String material, List<UsuarioStrategy> participantes, Atividades atividade) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(responsavel.podeCriarAtividade(atividade)){
            return new AtividadeReal(id, responsavel, titulo, descricao, material, participantes, atividade);
        }else{
            return null;
        }
    }

}
