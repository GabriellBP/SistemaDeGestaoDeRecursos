package sistemadegestaoderecursos;

import java.text.ParseException;
import recursos.AuditorioPrototype;
import recursos.LaboratorioPrototype;
import recursos.ProjetorPrototype;
import recursos.SalaDeAulaPrototype;

interface SistemaDeGestaoDeRecursos{
    /*recursos estaticos e finais de um sistema de gestao de recursos*/
    AuditorioPrototype AUDITORIO = new AuditorioPrototype();
    LaboratorioPrototype LABORATORIO = new LaboratorioPrototype();
    ProjetorPrototype PROJETOR = new ProjetorPrototype();
    SalaDeAulaPrototype SALADEAULA = new SalaDeAulaPrototype();
    
    /*funcoes de um sistema de gestao de recursos*/
    void menu(SistemaDeGestaoDeRecursos sistema);//Menu principal
    
    void cadastrarUsuario(); 
    
    void cadastrarRecurso();
    
    void iniciarAtividade();
    
    void alocarRecurso();
    
    void gerenciarAlocacoes();
    
    void consultarUsuario();
    
    void listarUsuarios();
    
    void consultarRecurso();
    
    void listarRecursos();

    void listarAtividades();

    void listarAlocacoes();
    
    void emitirRelatorio();
}
