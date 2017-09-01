package atividades;

import usuarios.UsuarioStrategy;

import java.util.List;

public class AtividadeReal implements Atividade {
    private String titulo;
    private String descricao;
    private String material;
    private List<UsuarioStrategy> participantes;
    private Atividades atividade;



    public AtividadeReal(String titulo, String descricao, String material, List<UsuarioStrategy> participantes, Atividades atividade){
        this.titulo = titulo;
        this.descricao = descricao;
        this.material = material;
        this.participantes = participantes;
    }


    public AtividadeReal criarAtividade(String titulo, String descricao, String material, List<UsuarioStrategy> participantes, Atividades atividade){
        return new AtividadeReal(titulo, descricao, material, participantes, atividade);
    }


}
