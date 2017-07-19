
package sistemadegestaoderecursos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */
public class SistemaDeGestaoDeRecursos {
    /*Globais*/
    static Scanner leitor = new Scanner(System.in);
    static int max = 100;
    static void limpaTela() {//colocar isso onde não tem ainda
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
    
    /*Usuario:*/
    static String[] nomeUsuario = new String[max];
    static String[] emailUsuario = new String[max];
    static int[] tipoUsuario = new int[max];
    static int qtdUsuarios = 0;
    
    public static int cadUsuario(){
        if(qtdUsuarios == max){
            System.out.println("Quantidade máxima permitida atingida!");
            return 1;
        }
        System.out.println("Digite o nome do Usuario:");
        nomeUsuario[qtdUsuarios] = leitor.nextLine();
        System.out.println("Digite o email do Usuario:");
        emailUsuario[qtdUsuarios] = leitor.nextLine();
        System.out.println("Digite o numero relativo ao tipo de usuario:");
        System.out.println("1-Aluno de Graduação");
        System.out.println("2-Aluno de Mestrado");
        System.out.println("3-Aluno de Doutorado");
        System.out.println("4-Professor");
        System.out.println("5-Pesquisador");
        tipoUsuario[qtdUsuarios] = leitor.nextInt();
        leitor.nextLine();
        qtdUsuarios++;
        return 0; 
    }
    
    public static int consulUsuario(){
        System.out.println("Digite o id do Usuário a ser consultado:");
        int id = leitor.nextInt();
        leitor.nextLine();
        System.out.println("Nome do usuario: "+nomeUsuario[id]);
        System.out.println("Email do usuario: "+emailUsuario[id]);
        String tipo;
        switch(tipoUsuario[id]){
            case 1:
                tipo = "Aluno de Graduação";
                break;
            case 2:
                tipo = "Aluno de Mestrado";
                break;
            case 3:
                tipo = "Aluno de Doutorado";
                break;
            case 4:
                tipo = "Professor";
                break;
            case 5:
                tipo = "Pesquisador";
                break;
            default:
                tipo = "Admin";
                break;
        }
        System.out.println("Tipo do usuario: "+tipo);
        System.out.println("Atividades iniciadas e recursos alocados:");
        for(int i = 0; i<qtdAlocacao; i++){
            if(usuarioAlocacao[i] == id){
                System.out.println("Recurso: "+nomeRecurso[recursoAlocacao[i]]);
                System.out.println("Atividade: "+tituloAtividade[atividAlocacao[i]]);
            }
        }
        System.out.println("\n\nDigite uma tecla para continuar...");
        leitor.nextLine();
        limpaTela(); 
        return 0;
    }
    
    public static void listarUsuarios(){
        for(int i = 0; i<qtdUsuarios; i++){
            System.out.println("Usuario de id "+i+": "+nomeUsuario[i]);
        }
        System.out.println("\n\nDigite uma tecla para continuar...");
        leitor.nextLine();
        limpaTela();
    }
    /*Recurso:*/
    static String[] nomeRecurso = new String[max];
    static int[] respRecurso = new int[max];
    static int qtdRecursos = 0;
    
    public static int cadRecurso(){
        if(qtdRecursos == max){
            System.out.println("Quantidade máxima permitida atingida!");
            return 1;
        }
        if(qtdUsuarios == 0){
            System.out.println("Impossível cadastrar recurso sem haver um usuário para ser responsável por ele, cadastre um usuario!");
            return 1;
        }
        System.out.println("Digite o nome do recurso:");
        nomeRecurso[qtdRecursos] = leitor.nextLine();
        System.out.println("Digite o id do responsável pelo recurso:");
        int id = leitor.nextInt();
        leitor.nextLine();
        if(tipoUsuario[id] != 4 && tipoUsuario[id] != 5){
            System.out.println("Responsável inválido!\nInforme um usuário que seja professor ou pesquisador para ser responsável pelo recurso!");
            return 1;
        }
        respRecurso[qtdRecursos] = id;
        qtdRecursos++;
        return 0;
    }
    
    public static int consulRecurso(){
        System.out.println("Digite o id do recurso a ser consultado:");
        int id = leitor.nextInt();
        leitor.nextLine();
        System.out.println("Nome do recurso: "+nomeRecurso[id]);
        System.out.println("Responsável pelo recurso "+respRecurso[id]);
        for(int i = 0; i<qtdAlocacao; i++){
            if(recursoAlocacao[i] == id){
                System.out.println("Atividade "+tituloAtividade[atividAlocacao[i]]+" está associada a esse recurso");
                System.out.println("Usuario "+nomeUsuario[usuarioAlocacao[i]]+" está associado a essse recurso");
            }
        }
        System.out.println("\n\nDigite uma tecla para continuar...");
        leitor.nextLine();
        limpaTela();
        return 0;
    }
    
    public static void listarRecursos() {
        for(int i = 0; i<qtdRecursos; i++){
            System.out.println("Nome do recurso de id "+i+": "+nomeRecurso[i]);
        }
        System.out.println("\n\nDigite uma tecla para continuar...");
        leitor.nextLine();
        limpaTela();
    }
    
    /*Inicio de uma atividade*/
    static String[] tituloAtividade = new String[max];
    static String[] descriAtividade = new String[max];
    static int[][] participAtividade = new int[max][max];
    static int[] qtdParticipAtividade = new int[max];
    static String[] materialAtividade = new String[max];
    static int[] tipoAtividade = new int[max];
    static int qtdAtividades = 0;
    
    public static int iniciarAtividade(){
        if(qtdAtividades == max){
            System.out.println("Quantidade máxima permitida atingida!");
            return 1;
        }
        if(qtdUsuarios == 0){
            System.out.println("Impossível iniciar atividade sem haver usuários, cadastre um usuario!");
        }
        System.out.println("Digite o nome da Atividade:");
        tituloAtividade[qtdAtividades] = leitor.nextLine();
        System.out.println("Digite uma descrição para a atividade:");
        descriAtividade[qtdAtividades] = leitor.nextLine();
        System.out.println("Digite quais materiais serão usados:");
        materialAtividade[qtdAtividades] = leitor.nextLine();
        System.out.println("Digite o tipo de Atividade:");
        System.out.println("1-Aula tradicional");
        System.out.println("2-Apresentações");
        System.out.println("3-Laboratório");
        tipoAtividade[qtdAtividades] = leitor.nextInt();
        leitor.nextLine();
        int temp = 0, aux = 0; 
        System.out.println("Paticipantes possíveis para a atividade:");
        for(int i = 0; i<qtdUsuarios; i++){
                System.out.println("Usuario:"+nomeUsuario[i]+", id:"+i);
        }
        System.out.println("Quantos usuarios participarão da atividade?");
        qtdParticipAtividade[qtdAtividades] = leitor.nextInt();
        leitor.nextLine();
        for(int i = 0; i<qtdParticipAtividade[qtdAtividades]; i++){
            participAtividade[qtdAtividades][i] = leitor.nextInt();
            leitor.nextLine();
        }
        qtdAtividades++;
        return 0;
    }
    
    public static void consulAtividade(){
        System.out.println("Digite o id da atividade a ser exibida:");
        int id = leitor.nextInt();
        leitor.nextLine();
        System.out.println("Titulo da atividade: "+tituloAtividade[id]);
        System.out.println("Descrição da atividade: "+descriAtividade[id]);
        System.out.println("Participantes da atividade: ");
        for(int i = 0; i<qtdParticipAtividade[id]; i++){
            System.out.println(nomeUsuario[participAtividade[id][i]]);
        }
        System.out.println("Material da atividade: "+materialAtividade[id]);
        String tipo;
        if(tipoAtividade[id] == 1) tipo = "Aula Tradicional";
        else if(tipoAtividade[id] == 2) tipo = "Apresentações";
        else tipo = "Laboratório";
        System.out.println("Tipo de atividade: "+tipo);
        System.out.println("\n\nDigite uma tecla para continuar...");
        leitor.nextLine();
        limpaTela();
    }
    
    /*Alocação de recursos*/
    static String[] statusAlocacao = new String[max];
    static Date[] inicioAlocacao = new Date[max];//new SimpleDateFormat("dd/mm/yyyy HH:mm:ss"); 
    static Date[] terminoAlocacao = new Date[max];
    static SimpleDateFormat conversor = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    static int[] atividAlocacao = new int[max];
    static int[] recursoAlocacao = new int[max];
    static int[] usuarioAlocacao = new int[max];
    static int qtdAlocacao = 0;
    public static int alocarRecurso(){
        if(qtdAtividades == 0){
            System.out.println("Nenhuma atividade foi criada!");
            return 1;
        }
        if(qtdRecursos == 0){
            System.out.println("Não há recursos para serem alocados!");
            return 1;
        }
        if(qtdUsuarios == 0){
            System.out.println("Não há usuários para alocar recursos!");
        }
        System.out.println("Digite o id da atividade para o qual será alocado o recurso:");
        int escolha, temp = 0;
        for(int i = 0; i<qtdAtividades; i++)
                System.out.println("Atividade:"+tituloAtividade[i]+", id:"+i);
        escolha = leitor.nextInt();
        leitor.nextLine();
        System.out.println("Usuarios disponíveis para alocar recurso para esta atividade:");
        for(int i = 0; i<qtdUsuarios; i++){
            if(tipoAtividade[escolha] == 1 || tipoAtividade[escolha] == 3){
                if(tipoUsuario[i] == 4){
                    System.out.println("Usuario:"+nomeUsuario[i]+", id:"+i);
                    temp = 1;
                }
            }else{
                System.out.println("Usuario:"+nomeUsuario[i]+", id:"+i);
                temp = 1;
            }
        }
        if(temp != 1){
            System.out.println("Nenhum!");
            return 1;
        }
        System.out.println("Digite o id do usuario que esta alocando esse recurso:");
        usuarioAlocacao[qtdAlocacao] = leitor.nextInt();
        leitor.nextLine();
        System.out.println("Escolha o id do recurso a ser alocado:");
        for(int i = 0; i<qtdRecursos; i++)
            System.out.println("Recurso:"+nomeRecurso[i]+", id:"+i);
        recursoAlocacao[qtdAlocacao] = leitor.nextInt();
        leitor.nextLine();
        Date inicioD;
        Date terminoD;
        
        while (true){
            break;
        }
        while(true){
            System.out.println("Data de inicio da alocação: (DD/MM/AAAA HH:MM)");
            String inicio = leitor.nextLine();
            try {
                inicioD = conversor.parse(inicio);
            } catch (ParseException ex) {
                Logger.getLogger(SistemaDeGestaoDeRecursos.class.getName()).log(Level.SEVERE, null, ex);
                continue;
            }
            System.out.println("Data de termino da alocação: (DD/MM/AAAA HH:MM)");
            String termino = leitor.nextLine();
            try {
                terminoD = conversor.parse(termino);
            } catch (ParseException ex) {
                Logger.getLogger(SistemaDeGestaoDeRecursos.class.getName()).log(Level.SEVERE, null, ex);
                continue;
            }
            if (!inicioD.before(terminoD)) {
                System.out.println("Datas inválidas, insira as datas corretamente!");
                continue;
            }
            int aux = 0;
            for(int i = 0; i<qtdAlocacao; i++){
                if(recursoAlocacao[i] == recursoAlocacao[qtdAlocacao] || usuarioAlocacao[i] == usuarioAlocacao[qtdAlocacao]){
                    if (!inicioD.after(terminoAlocacao[i]) && !terminoD.before(inicioAlocacao[i])) {
                        System.out.println("Recurso já alocado para este horario");
                        System.out.println("Deseja tentar novamente? 1-Sim; 2-Não");
                        int confirmacao = leitor.nextInt();
                        leitor.nextLine();
                        if(confirmacao == 1){
                            aux = 1;
                            break;
                        }
                        else return 1;
                    }
                }
            }
            if(aux == 0) break;           
        }
        inicioAlocacao[qtdAlocacao] = inicioD;
        terminoAlocacao[qtdAlocacao] = terminoD;
        statusAlocacao[qtdAlocacao] = "Em processo de alocação";
        qtdAlocacao++;
        return 0;
    }
    
    public static int gerenciarAlocacao(){
        System.out.println("Digite o id da Alocação a ser gerenciada:");
        for(int i = 0; i<qtdAlocacao; i++){
            System.out.println("Recurso: "+nomeRecurso[recursoAlocacao[i]]+", Atividade: "+tipoAtividade[atividAlocacao[i]]);
        }
        int idAloc = leitor.nextInt();
        leitor.nextLine();
        String proxStatus;
        if(statusAlocacao[idAloc].startsWith("Em proc")) proxStatus = "Alocado";
        else if(statusAlocacao[idAloc].startsWith("Aloc")) proxStatus = "Em andamento";
        else proxStatus = "Concluído";
        System.out.println("Deseja alterar o status da alocacao para: "+proxStatus+"1-Sim; 2-Não");
        int escolha = leitor.nextInt();
        leitor.nextLine();
        if(escolha == 1) statusAlocacao[idAloc] = proxStatus;
        return 0;
    }
    
    public static void consulAlocacao(){
        System.out.println("Digite o id da alocação a ser exibida:");
        int id = leitor.nextInt();
        leitor.nextLine();
        System.out.println("Recurso Alocado: "+nomeRecurso[recursoAlocacao[id]]);
        System.out.println("\nStatus da alocação: "+statusAlocacao[id]);
        System.out.println("Data de inicio: "+inicioAlocacao[id]+"\nData de fim: "+terminoAlocacao[id]);
        System.out.println("Atividade da alocação: "+tituloAtividade[atividAlocacao[id]]);
        System.out.println("Usuario responsável pela alocação: "+nomeUsuario[usuarioAlocacao[id]]);
        System.out.println("\n\nDigite uma tecla para continuar...");
        leitor.nextLine();
        limpaTela();
    }
    
    /*Relatorio*/
    
    public static void relatorio(){
        System.out.println("Numero de usuarios: "+qtdUsuarios);
        
        int emProc = 0;
        int alocad = 0;
        int emAnda = 0;
        int conclu = 0;
        
        for(int i = 0; i<qtdAlocacao; i++){
            if(statusAlocacao[i].startsWith("Em proc")) emProc++;
            else if(statusAlocacao[i].startsWith("Aloc")) alocad++;
            else if(statusAlocacao[i].startsWith("Em anda")) emAnda++;
            else if(statusAlocacao[i].startsWith("conclu")) conclu++;
        }
        System.out.println("Numero total de recursos: "+qtdRecursos);
        System.out.println("Numero de recursos em processo de alocação: "+emProc);
        System.out.println("Numero de recursos alocados: "+alocad);
        System.out.println("Numero de recursos em andamento: "+emAnda);
        System.out.println("Numero de recursos com status concluido: "+conclu);
        System.out.println("Numero total de alocações: "+qtdAlocacao);
        System.out.println("Numero total de atividades: "+qtdAtividades);
        int aulaT = 0;
        int apres = 0;
        int labor = 0;
        for(int i = 0;i<qtdAtividades; i++){
            if(tipoAtividade[i] == 1) aulaT++;
            else if(tipoAtividade[i] == 2) apres++;
            else if(tipoAtividade[i] == 3) labor++;
        }
        System.out.println("Atividades \"Aula tradicional\": "+aulaT);
        System.out.println("Atividades \"Apresentações\": "+apres);
        System.out.println("Atividades \"Laboratório\": "+labor);
        System.out.println("\n\nDigite uma tecla para continuar...");
        leitor.nextLine();
        limpaTela();
    }
    
    
    public static void menu(){
        System.out.println("Digite o numero da operação a ser feita:");
        System.out.println("1-Cadastrar usuario");
        System.out.println("2-Cadastrar recurso");
        System.out.println("3-Iniciar uma atividade");
        System.out.println("4-Alocar recurso");
        System.out.println("5-Gerenciar Alocações");
        System.out.println("6-Consultar usuario");
        System.out.println("7-Listar usuarios");
        System.out.println("8-Consultar recurso");
        System.out.println("9-Listar recursos");
        System.out.println("10-Consultar atividade");
        System.out.println("11-Consultar alocação");
        System.out.println("12-Emitir relatorio");
        System.out.println("0-Exit");
        int resp = leitor.nextInt();
        leitor.nextLine();
        switch (resp) {
            case 0:
                System.exit(0);
            case 1:
                limpaTela();
                if(cadUsuario() == 0)
                    System.out.println("Cadastrado com Sucesso!");
                else
                    System.out.println("Houve algum erro!");
                menu();
                break;
            case 2:
                limpaTela();
                if(cadRecurso() == 0)
                    System.out.println("Cadastrado com Sucesso!");
                else
                    System.out.println("Houve algum erro!");
                menu();
                break;
            case 3:
                limpaTela();
                if(iniciarAtividade() == 0)
                    System.out.println("Iniciada com Sucesso!");
                else
                    System.out.println("Houve algum erro!");
                menu();
                break;
            case 4:
                limpaTela();
                if(alocarRecurso()== 0)
                    System.out.println("Alocado com Sucesso!");
                else
                    System.out.println("Houve algum erro!");
                menu();
                break;
            case 5:
                limpaTela();
                 if(gerenciarAlocacao()== 0)
                    System.out.println("Gerenciado com Sucesso!");
                else
                    System.out.println("Houve algum erro!");
                 menu();
                break;
            case 6:
                limpaTela();
                consulUsuario();
                menu();
                break;
            case 7:
                limpaTela();
                listarUsuarios();
                menu();
                break;
            case 8:
                limpaTela();
                consulRecurso();
                menu();
                break;
            case 9:
                limpaTela();
                listarRecursos();
                menu();
                break;
            case 10:
                limpaTela();
                consulAtividade();
                menu();
                break;        
            case 11:
                limpaTela();
                consulAlocacao();
                menu();
                break;
            case 12:
                limpaTela();
                relatorio();
                menu();
                break;
            default:
                limpaTela();
                System.out.println("Escolha uma opção válida!");
                menu();
                break;
        }
    }
    
    public static void main(String[] args) {
        menu();
    }
    
}
