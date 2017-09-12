package sistemadegestaoderecursos;

import alocacoes.Alocacao;
import alocacoes.AlocadoState;
import alocacoes.ConcluidoState;
import alocacoes.EmAndamentoState;
import alocacoes.EmProcessoAlocacaoState;
import atividades.AtividadeReal;
import atividades.AtividadeRealProxy;
import atividades.Atividades;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import recursos.AuditorioPrototype;
import recursos.LaboratorioPrototype;
import recursos.ProjetorPrototype;
import recursos.RecursoPrototype;
import recursos.SalaDeAulaPrototype;
import usuarios.DoutorandoStrategy;
import usuarios.GraduandoStrategy;
import usuarios.MestrandoStrategy;
import usuarios.PesquisadorStrategy;
import usuarios.ProfessorStrategy;
import usuarios.UsuarioStrategy;

public class SistemaDeGestaoG implements SistemaDeGestaoDeRecursos{
    /*Atributos do Sistema*/
    Scanner leitor = new Scanner(System.in);
    private List<UsuarioStrategy> usuarios = new ArrayList<>();
    private List<RecursoPrototype> recursos = new ArrayList<>();
    private List<AtividadeReal> atividades = new ArrayList<>();
    private List<Alocacao> alocacoes = new ArrayList<>();
    
    public static void main(String[] args) {
        SistemaDeGestaoDeRecursos sistema = new SistemaDeGestaoG();
        try{
            sistema.menu(sistema);
        }catch(Exception e){
            System.out.println("\n\n*****Houve algum erro!*****");
            System.out.println("Possíveis causas:");
            System.out.println("    Dados inseridos incorretamente(texto no lugar de inteiros)");
            System.out.println("    Ids colocadas que não estão armazenadas");
            System.out.println("TENHA ATENÇÃO!");
            sistema.menu(sistema);
        }
        
    }
    
    @Override
    public void menu(SistemaDeGestaoDeRecursos sistema) throws InputMismatchException, NullPointerException{
        System.out.println(" ------------------------------------------------");
        System.out.println(" |********-Sistema de Gestao de Recursos-********|");
        System.out.println(" ------------------------------------------------\n");
        while (true) {
            System.out.println("");
            System.out.println("1. Cadastrar usuario");
            System.out.println("2. Cadastrar recurso");
            System.out.println("3. Iniciar uma atividade");
            System.out.println("4. Alocar recurso");
            System.out.println("5. Gerenciar Alocações");
            System.out.println("6. Consultar usuario");
            System.out.println("7. Listar usuarios");
            System.out.println("8. Consultar recurso");
            System.out.println("9. Listar recursos");
            System.out.println("10. Listar atividades");
            System.out.println("11. listar alocações");
            System.out.println("12. Emitir relatorio");
            System.out.println("0. Sair");
            System.out.print("Digite a opção: ");

            String opcao = leitor.nextLine();
            
            System.out.println();

            switch (opcao) {
                case "0":
                    System.exit(0);
                case "1":
                    sistema.cadastrarUsuario();
                    break;
                case "2":
                    sistema.cadastrarRecurso();
                    break;
                case "3":
                    sistema.iniciarAtividade();
                    break;
                case "4":
                    sistema.alocarRecurso();
                    break;
                case "5":
                    sistema.gerenciarAlocacoes();
                    break;
                case "6":
                    sistema.consultarUsuario();
                    break;
                case "7":
                    sistema.listarUsuarios();
                    break;
                case "8":                 
                    sistema.consultarRecurso();
                    break;
                case "9":
                    sistema.listarRecursos();
                    break;
                case "10":
                    sistema.listarAtividades();
                    break;        
                case "11":
                    sistema.listarAlocacoes();
                    break;
                case "12":
                    sistema.emitirRelatorio();
                    break;
                default:
                    System.out.println("**Escolha uma opção válida!**\n");
                    break;
            }
            continuar();
	}
    }

    @Override
    public void cadastrarUsuario() throws InputMismatchException, NullPointerException{
        System.out.println("Digite o cpf do Usuario (apenas numeros):");
        String cpf = leitor.nextLine();        
        System.out.println("Digite o nome do Usuario:");
        String nome = leitor.nextLine();
        System.out.println("Digite o email do Usuario:");
        String email = leitor.nextLine();
        System.out.println("Informe o tipo de usuario:");
        System.out.println("1. Aluno de Graduação");
        System.out.println("2. Aluno de Mestrado");
        System.out.println("3. Aluno de Doutorado");
        System.out.println("4. Professor");
        System.out.println("5. Pesquisador");
        String tipo = leitor.nextLine();
        switch(tipo){
            case "1":
                usuarios.add(new GraduandoStrategy(usuarios.size(), cpf, nome, email));
                break;
            case "2":
                usuarios.add(new MestrandoStrategy(usuarios.size(), cpf, nome, email));
                break;
            case "3":
                usuarios.add(new DoutorandoStrategy(usuarios.size(), cpf, nome, email));
                break;
            case "4":
                usuarios.add(new ProfessorStrategy(usuarios.size(), cpf, nome, email));
                break;
            case "5":
                usuarios.add(new PesquisadorStrategy(usuarios.size(), cpf, nome, email));
                break;
            default:
                System.out.println("**Tipo invalido!**\nOperação cancelada!\n");
                break;
        }
    }

    @Override
    public void cadastrarRecurso() throws InputMismatchException, NullPointerException{
        int continuar = 0;
        do{
            System.out.println("Informe o tipo de recurso que desejas cadastrar:");
            System.out.println("1. Auditorio");
            System.out.println("2. Laboratorio");
            System.out.println("3. Projetor");
            System.out.println("4. Sala de aula");
            String tipo = leitor.nextLine();
            switch(tipo){
                case "1":
                    AuditorioPrototype auditorio = (AuditorioPrototype) AUDITORIO.clonar();
                    auditorio.setIdentificacao(recursos.size());
                    recursos.add(auditorio);
                    break;
                case "2":
                    LaboratorioPrototype laboratorio = (LaboratorioPrototype) LABORATORIO.clonar();
                    laboratorio.setIdentificacao(recursos.size());
                    recursos.add(laboratorio);
                    break;
                case "3":
                    ProjetorPrototype projetor = (ProjetorPrototype) PROJETOR.clonar();
                    projetor.setIdentificacao(recursos.size());
                    recursos.add(projetor);
                    break;
                case "4":
                    SalaDeAulaPrototype salaDeAula = (SalaDeAulaPrototype) SALADEAULA.clonar();
                    salaDeAula.setIdentificacao(recursos.size());
                    recursos.add(salaDeAula);
                    break;
                default:
                    System.out.println("**Tipo invalido!**");
                    
            }
            System.out.println("\nDesejas cadastrar outro recurso?\n1. Sim\n2. Nâo");
            continuar = leitor.nextInt();
            leitor.nextLine();
        }while(continuar == 1);
    }

    @Override
    public void iniciarAtividade() throws InputMismatchException, NullPointerException{
        if(usuarios.size() < 2){
            System.out.println("**Não é possível iniciar atividades!**\nPara iniciar uma atividade deve haver pelo menos 2 usuários cadastradas!");
            return;
        }
        AtividadeRealProxy atividadeProxy = new AtividadeRealProxy();//pensar em colocar na interface Sistema
        AtividadeReal atividade;
        int confirmacao = 0;
        do{
            System.out.println("Informe o titulo da atividade:");
            String titulo = leitor.nextLine();
            System.out.println("Informe uma breve descrição sobre a atividade:");
            String descricao = leitor.nextLine();
            System.out.println("Informe os materiais (separados por virgula) que serão usados na atividade:");
            String materiais = leitor.nextLine();
            listarUsuarios();
            System.out.print("Informe o ID do usuario responsável pela atividade: ");
            int idResp = leitor.nextInt();
            leitor.nextLine();
            List<UsuarioStrategy> participantes = new ArrayList<>();
            int idPart, continuar = 0;
            do{
                listarUsuarios();
                System.out.print("Informe o id de um participante da atividade: ");
                idPart = leitor.nextInt();
                leitor.nextLine();
                if((idPart == idResp) || (participantes.contains(usuarios.get(idPart))))
                    System.out.println("Usuario Inválido ou já cadastrado como participante");
                else
                    participantes.add(usuarios.get(idPart));
                System.out.println("\nDesejas cadastrar outro participante?\n1. Sim\n2. Nâo");
                continuar = leitor.nextInt();
                leitor.nextLine();    
            }while(continuar == 1);
            System.out.println("Atividades disponíveis:");
            for(Atividades atv : Atividades.values()){
                System.out.println("ID: "+atv.getIdAtividade()+" Atividade: "+atv);
            }
            int idAtiv = 0;
            do{
                System.out.print("Digite o id da atividade: ");
                idAtiv = leitor.nextInt();
                leitor.nextLine();
                if(idAtiv < 1 && idAtiv > 3) System.out.println("**ID invalido!**");
            }while(idAtiv < 1 && idAtiv > 3);
            atividade = atividadeProxy.criarAtividade(atividades.size(), usuarios.get(idResp), titulo, descricao, materiais, participantes, Atividades.getAtividade(idAtiv));            
            if(atividade == null)
                System.out.println("\n**Responsável não pode cadastrar esse tipo de atividade!**\n");
            else{
                atividades.add(atividade);
                System.out.println("Atividade cadastrada com sucesso!");
                usuarios.get(idResp).addHistoricoAtividades(atividade);
            }
            System.out.println("\nDesejas cadastrar outra atividade?\n1. Sim\n2. Nâo");
            confirmacao = leitor.nextInt();
            leitor.nextLine();
        }while(confirmacao == 1);
    }

    @Override
    public void alocarRecurso() throws InputMismatchException, NullPointerException{
        if(recursos.isEmpty() || atividades.isEmpty()){
            System.out.println("**Não é possível alocar recursos!**\nPara alocar recursos devem haver recursos e atividades cadastradas!");
            return;
        }
        listarRecursos();
        System.out.print("Informe o id do recurso a ser alocado: ");
        int idRec = leitor.nextInt();
        leitor.nextLine();
        listarAtividades();
        System.out.print("Informe o id da atividade para o qual o recurso será alocado: ");
        int idAti = leitor.nextInt();
        leitor.nextLine();
        Date inicioDate, fimDate;
        String inicio, fim;
        SimpleDateFormat conversor = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        first:
        while(true){
            System.out.println("Informe a data de inicio da alocação: (DD/MM/AAAA HH:MM)");
            inicio = leitor.nextLine();
            try {
                inicioDate = conversor.parse(inicio);
            } catch (ParseException ex) {
                System.out.println("**Formato de data inválido!**\n");
                continue;
            }
            System.out.println("Informe a data de fim da alocação: (DD/MM/AAAA HH:MM)");
            fim = leitor.nextLine();
            try {
                fimDate = conversor.parse(fim);
            } catch (ParseException ex) {
                System.out.println("**Formato de data inválido!**\n");
                continue;
            }
            if(!inicioDate.before(fimDate)){
                System.out.println("**Datas inválidas, insira as datas corretamente!**");
                continue;
            }
            for(Alocacao a : alocacoes){
                if(a.getRecurso().equals(recursos.get(idRec))){
                    if (!inicioDate.after(a.getDataFim()) && !fimDate.before(a.getDataInicio())) {
                        System.out.println("**Recurso já alocado para este horario!**");
                        System.out.println("Deseja tentar novamente?\n1. Sim\n2. Não");
                        int confirmacao = leitor.nextInt();
                        leitor.nextLine();
                        if(confirmacao == 1){
                            continue first;
                        }else{
                            break first;
                        }
                    }
                }
            }
            break;
        }
        alocacoes.add(new Alocacao(alocacoes.size(), atividades.get(idAti).getResponsavel(), atividades.get(idAti), recursos.get(idRec), inicioDate, fimDate));
        System.out.println("Recurso Alocado com sucesso!");
        atividades.get(idAti).getResponsavel().addHistoricoAlocacoes(alocacoes.get(alocacoes.size()-1));
    }

    @Override
    public void gerenciarAlocacoes() throws InputMismatchException, NullPointerException{
        if(alocacoes.isEmpty()){
            System.out.println("**Não há alocações para se gerenciar!**");
            return;
        }
        listarAlocacoes();
        System.out.print("Informe o id da Alocação a ser gerenciada: ");
        int idLoc = leitor.nextInt();
        leitor.nextLine();
        String proxStatus = alocacoes.get(idLoc).getEstadoAlocacao().getProximoEstado();
        System.out.println("Deseja mudar o status da alocação para: "+proxStatus+"\n1. Sim\n2. Não");
        int opcao = leitor.nextInt();
        leitor.nextLine();
        if(opcao == 1){
            alocacoes.get(idLoc).setEstadoAlocacao(alocacoes.get(idLoc).getEstadoAlocacao().mudarEstado());
            System.out.println("\n\nStatus alterado com sucesso!\n");
        }
    }

    @Override
    public void consultarUsuario()throws InputMismatchException, NullPointerException {
        int continuar = 0, idUser;
        UsuarioStrategy usuario;
        do{
            System.out.print("Informe o Id do Usuário a ser consultado: ");
            idUser = leitor.nextInt();
            leitor.nextLine();
            if(idUser<0 || idUser>=usuarios.size()){
                System.out.println("**ID não cadastrado, tente novamente.**\n\n");
            }else{
                usuario = usuarios.get(idUser);
                System.out.println("CPF: "+usuario.getCpf());
                System.out.println("Nome: "+usuario.getNome());
                System.out.println("Email: "+usuario.getEmail());
                System.out.println("Tipo: "+usuario.toString());
                usuario.listarHistoricoAlocacoes();
                usuario.listarHistoricoAtividades();
            }
            System.out.println("\nDesejas consultar outro Usuario?\n1. Sim\n2. Nâo");
            continuar = leitor.nextInt();
            leitor.nextLine();
        }while(continuar == 1);
    }

    @Override
    public void listarUsuarios() throws InputMismatchException, NullPointerException{
        System.out.println("Usuários cadastrados:");
        for(UsuarioStrategy a : usuarios){
            System.out.println("ID: "+a.getId());
            System.out.println("CPF: "+a.getCpf());
            System.out.println("Nome: "+a.getNome());
            System.out.println("Tipo: "+a.toString());
            System.out.println("");
        }
    }

    @Override
    public void consultarRecurso()throws InputMismatchException, NullPointerException {
        int continuar = 0, idRec;
        RecursoPrototype recurso;
        do{
            System.out.print("Informe o Id do Recurso a ser consultado: ");
            idRec = leitor.nextInt();
            leitor.nextLine();
            if(idRec<0 || idRec>=recursos.size()){
                System.out.println("**ID não cadastrado, tente novamente.**\n\n");
            }else{
                recurso = recursos.get(idRec);
                System.out.println("Tipo: "+recurso.toString());
                if(alocacoes.contains(recurso)){
                    System.out.println("O recurso esta nas seguintes alocações: ");
                    for(Alocacao a : alocacoes){
                        if(a.getRecurso().equals(recurso)){
                            System.out.println("Responsavel:");
                            System.out.println("ID: "+a.getResponsavel().getId()+", Nome: "+a.getResponsavel().getNome()+ ", Tipo: "+a.getResponsavel().toString());
                            System.out.println("Atividade: ");
                            System.out.println("Titulo: "+a.getAtividade().getTitulo()+", Tipo: "+a.getAtividade().toString()+", Inicio: "+a.getDataInicio()+", Fim: "+a.getDataFim());
			    System.out.println("Participantes:");
                            for(UsuarioStrategy u : a.getAtividade().getParticipantes()){
                                System.out.println("    ID: "+u.getId()+", Nome: "+u.getNome()+", CPF: "+u.getCpf());
                            }
                            System.out.println("");
                        }
                    }
                }
            }
            System.out.println("\nDesejas consultar outro Usuario?\n1. Sim\n2. Nâo");
            continuar = leitor.nextInt();
            leitor.nextLine();
        }while(continuar == 1);
    }

    @Override
    public void listarRecursos() throws InputMismatchException, NullPointerException{
        System.out.println("Recursos cadastrados:");
        for(RecursoPrototype a : recursos){
            System.out.println("ID: "+a.getIdentificacao());
            System.out.println("Tipo: "+a.toString());
            System.out.println("");
        }
    }

    @Override
    public void listarAtividades() throws InputMismatchException, NullPointerException{
        System.out.println("Atividades cadastrados:");
        for(AtividadeReal a : atividades){
            System.out.println("ID: "+a.getId());
            System.out.println("Titulo: "+a.getTitulo());
            System.out.println("Atividade: "+a.getAtividade());
            System.out.println("Responsavel: "+a.getResponsavel().getNome()+", ID: "+a.getResponsavel().getId()+", CPF: "+a.getResponsavel().getCpf());
            System.out.println("Participantes:");
            for(UsuarioStrategy u : a.getParticipantes()){
                System.out.println("    ID: "+u.getId()+", Nome: "+u.getNome());
            }
            System.out.println("");
        }
    }

    @Override
    public void listarAlocacoes() throws InputMismatchException, NullPointerException{
        System.out.println("Alocações cadastrados:");
        for(Alocacao a : alocacoes){
            System.out.println("ID: "+a.getIdAlocacao());
            System.out.println("Atividade: "+a.getAtividade().getTitulo());
            System.out.println("Recurso: "+a.getRecurso().toString());
            System.out.println("Responsavel: "+a.getResponsavel().getNome()+", ID: "+a.getResponsavel().getId()+", CPF: "+a.getResponsavel().getCpf());
            System.out.println("Status da Alocação: "+a.getEstadoAlocacao().toString());
            System.out.println("");
        }
    }
    
    @Override
    public void emitirRelatorio() throws InputMismatchException, NullPointerException{
        System.out.println("\n*--RELATORIO--*\n");
        System.out.println("Numero de Usuarios: "+usuarios.size());
        int emProc = 0, alocad = 0, emAnda = 0, conclu = 0;
        for(Alocacao a : alocacoes){
            if(a.getEstadoAlocacao() instanceof EmProcessoAlocacaoState) emProc++;
            else if(a.getEstadoAlocacao() instanceof AlocadoState) alocad++;
            else if(a.getEstadoAlocacao() instanceof EmAndamentoState) emAnda++;
            else if(a.getEstadoAlocacao() instanceof ConcluidoState) conclu++;
        }
        System.out.println("Numero de Alocações: "+alocacoes.size());
        System.out.println("Numero de Alocações com status 'Em Processo de Alocacao': "+emProc);
        System.out.println("Numero de Alocações com status 'Alocado': "+alocad);
        System.out.println("Numero de Alocações com status 'Em Andamento': "+emAnda);
        System.out.println("Numero de Alocações com status 'Concluido': "+conclu);
        System.out.println("Numero de Atividades: "+atividades.size());
        int aulaT = 0, apres = 0, labor = 0;
        for(AtividadeReal a : atividades){
            if(a.getAtividade().equals(Atividades.AULATRADICIONAL)) aulaT++;
            else if(a.getAtividade().equals(Atividades.APRESENTACAO)) apres++;
            else if(a.getAtividade().equals(Atividades.LABORATORIO)) labor++;
        }
        System.out.println("Numero de Atividades 'Aula Tradicional': "+aulaT);
        System.out.println("Numero de Atividades 'Apresentação': "+apres);
        System.out.println("Numero de Atividades 'Laboratório': "+labor);
        System.out.println("");
    }
    
    public void continuar(){
        System.out.println("\n\nTecle enter para continuar...");
        leitor.nextLine();
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }    
}
