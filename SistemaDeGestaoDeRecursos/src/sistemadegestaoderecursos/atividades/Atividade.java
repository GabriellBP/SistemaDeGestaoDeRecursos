package atividades;

import usuarios.Doutorando;
import usuarios.Graduando;
import usuarios.UsuarioStrategy;

import java.util.List;

public interface Atividade {
    public AtividadeReal criarAtividade(Doutorando responsavel, String titulo, String descricao, String material, List<UsuarioStrategy> participantes, Atividades atividade);
    public AtividadeReal criarAtividade(Graduando responsavel, String titulo, String descricao, String material, List<UsuarioStrategy> participantes, Atividades atividade);

}
