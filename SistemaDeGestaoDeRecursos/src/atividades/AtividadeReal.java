package atividades;

import usuarios.UsuarioStrategy;

import java.util.List;

public class AtividadeReal {
    private int id;
    private UsuarioStrategy responsavel;
    private String titulo;
    private String descricao;
    private String material;
    private List<UsuarioStrategy> participantes;
    private Atividades atividade;



    public AtividadeReal(int id, UsuarioStrategy responsavel, String titulo, String descricao, String material, List<UsuarioStrategy> participantes, Atividades atividade){        
        this.id = id;
        this.responsavel = responsavel;
        this.titulo = titulo;
        this.descricao = descricao;
        this.material = material;
        this.participantes = participantes;
        this.atividade = atividade;
    }

    public UsuarioStrategy getResponsavel() {
        return responsavel;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getMaterial() {
        return material;
    }

    public List<UsuarioStrategy> getParticipantes() {
        return participantes;
    }

    public Atividades getAtividade() {
        return atividade;
    }

    public int getId() {
        return id;
    }
    
    
}
