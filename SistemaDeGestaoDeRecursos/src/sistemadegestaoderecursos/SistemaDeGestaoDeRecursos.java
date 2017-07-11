
package sistemadegestaoderecursos;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

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
        qtdUsuarios++;
        return 0; 
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
        if(tipoUsuario[id] != 4 && tipoUsuario[id] != 5){
            System.out.println("Responsável inválido!\nInforme um usuário que seja professor ou pesquisador para ser responsável pelo recurso!");
            return 1;
        }
        respRecurso[qtdRecursos] = id;
        qtdRecursos++;
        return 0;
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
        int temp = 0; 
        if(tipoAtividade[qtdAtividades] == 1 || tipoAtividade[qtdAtividades] == 3)
            temp = 4;
        System.out.println("Paticipantes possíveis para a atividade:");
        for(int i = 0; i<qtdUsuarios; i++){
            if(temp == 4){
                if(tipoUsuario[i] == temp){
                    System.out.println("Usuario:"+nomeUsuario+", id:"+i);
                    qtdParticipAtividade++;
                }
            }else{
                System.out.println("Usuario:"+nomeUsuario+", id:"+i);
                qtdParticipAtividade++;
            }
        }
        if(qtdParticipAtividade == 0){
            System.out.println("Nenhum!");
            return 1;
        }
        System.out.println("Quantos usuarios participarão da atividade?");
        qtdParticipAtividade = leitor.nextInt();
        for(int i = 0; i<qtdParticipAtividade; i++){
          participAtividade[qtdAtividades][i]
        }
        
        qtdAtividades++;
        return 0;
    }
    
    /*Alocação de recursos*/
    static Date[] inicioRecurso = new Date[max];//new SimpleDateFormat("dd/mm/yyyy HH:mm:ss"); 
    static Date[] terminoRecurso = new Date[max];
    
    
    
    public static void menu(){
        leitor.nextLine();//limpar o buff
        System.out.println("Digite o numero da operação a ser feita:");
        System.out.println("1-Cadastrar usuario");
        System.out.println("2-Cadastrar recurso");
        System.out.println("3-Iniciar uma atividade");
        System.out.println("4-Alocar recurso");
        System.out.println("5-Consultar usuario");
        System.out.println("6-Listar usuarios");
        System.out.println("7-Consultar recurso");
        System.out.println("8-Listar recursos");
        System.out.println("0-Exit");
        int resp = leitor.nextInt();
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
                
                break;
            case 4:
                limpaTela();
                break;
            case 5:
                limpaTela();
                break;
            default:
                System.out.println("Escolha uma opção válida!");
                menu();
                break;
        }
    }
    
    public static void main(String[] args) {
        menu();
    }
    
}
