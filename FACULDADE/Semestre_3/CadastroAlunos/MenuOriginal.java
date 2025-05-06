import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Classe para representar opções de menu do usuário.
 * 
 * @author Enzo Dante Mícoli ra00347608, Gabriel Azevedo Cruz ra00345943, Nícolas Okamoto Celestrino ra00345719, Pedro Bizzari ra00346785
 * @version 03/04/2025
 */
//MENU DO USUARIO
public class MenuOriginal {
    
    public List<Aluno> lista = new ArrayList<>();
    public boolean grafico = false;
    Scanner scanner = new Scanner(System.in);
    public String[] ALFABeto = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","ã","í","ú"};

    /**
     * Menu com opções
     *
     */
    public void menu()
    {
        String opcao = "";
        
        while(opcao.equals(""))
        {
            while(!opcao.equals("1") && !opcao.equals("2"))
            {    System.out.println("Escolha por onde voce gostaria de inserir seus dados");
                System.out.println("1- Via janela grafica");
                System.out.println("2- Via console");
                opcao = scanner.nextLine().trim();
            }

            switch(opcao)
            {
                case "1":
                    grafico = true;
                    try {
                        while (!opcao.equals("4")) { 
                            opcao = JOptionPane.showInputDialog("O que voce deseja fazer?\n1- Inserir\n2- Remover\n3- Listar\n4- Sair");
                            opcoes(opcao, true);
                        }
                    } catch( NullPointerException e){
                        System.out.println("O programa foi encerrado!\n");
                    } 
                    catch (Exception e) {
                        System.out.println("O programa foi encerrado!\n");
                    }
                    opcao = "4";
                    break;
                case "2":
                    //console
                    while (!opcao.equals("4")) { 
                        System.out.println("O que voce deseja fazer?\n" + //
                                "1- Inserir\n" + //
                                "2- Remover\n" + //
                                "3- Listar\n" + //
                                "4- Sair");
                        opcao = scanner.nextLine();
                        opcoes(opcao, false); 
                    }
                    break;
                    
                    
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
        
        
    }
    /**
     * opcoes de cadastro do aluno
     *
     * @param op (String) opcao selecionada
     * @param graf (boolean) escolha entre gráfico ou console
     * 
     */
    public void opcoes(String op, boolean graf){
        if(graf)
            switch(op)
            {
                case "1":
                    try {
                        Inserir();
                    } catch (Exception e) {
                      JOptionPane.showMessageDialog(null, "Aluno não inserido por erro de digitação.");
                    }
                    break;
                case "2":
                    try {
                        remover();
                    } catch (Exception e) {
                      JOptionPane.showMessageDialog(null, "Aluno não removido por erro de digitação.");
                    }
                    break;
                case "3":
                    listar();
                    break;
                case "4":
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
            }
        else
            switch(op)
            {
                case "1":
                    try {
                        Inserir();
                    } catch (Exception e) {
                      System.out.println("Aluno não inserido por erro de digitação.");
                    }
                    break;
                case "2":
                    try {
                        remover();
                    } catch (Exception e) {
                      System.out.println("Aluno não removido por erro de digitação.");
                    }
                    break;
                case "3":
                    listar();
                    break;
                case "4":
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            } 
    }
    /**
     * Inserir representa o cadastro de aluno
     *
     */
    public void Inserir(){
        String nome="", rg="", ra="", curso="";
        int idade=0, periodo=0;

        try {
            if(grafico){
                
                // Entrada de um nome do aluno (atraves do teclado)
                nome = inputPainel("Forneca o nome do aluno: ", false, false).trim();
            
                
                // Entrada da idade do aluno (atraves do teclado)
                idade = Integer.parseInt(inputPainel("Forneca a idade do aluno: ", true, true).trim());
        
                // Entrada de uma identificacao do aluno (atraves do teclado)
                rg = Identidade("Forneca o ID do aluno : ", true).trim();
        
                // Entrada da ra do aluno (atraves do teclado)
                ra = validarRA("Forneca o RA do aluno:", true).trim();
        
                // Entrada do curso do aluno (atraves do teclado)
                curso = inputPainel("Forneca o curso do aluno:", false, false).trim();
        
                // Entrada da idade do aluno (atraves do teclado)
                periodo = Integer.parseInt(inputPainel("Forneca o periodo do aluno:", true, false).trim());
            }else{
                // Entrada de um nome do aluno (atraves do teclado)
                nome = inputConsole("Forneca o nome do aluno: ", false, false).trim();
                
                // Entrada da idade do aluno (atraves do teclado)
                idade = Integer.parseInt(inputConsole("Forneca a idade do aluno: ", true, true).trim());
        
                // Entrada de uma identificacao do aluno (atraves do teclado)
                rg = Identidade("Forneca o ID do aluno : ", true).trim();
        
                // Entrada da ra do aluno (atraves do teclado)
                ra = validarRA("Forneca o RA do aluno:", true).trim();
        
                // Entrada do curso do aluno (atraves do teclado)
                curso = inputConsole("Forneca o curso do aluno:", false, false).trim();
        
                // Entrada da idade do aluno (atraves do teclado)
                periodo = Integer.parseInt(inputConsole("Forneca o periodo do aluno:", true, false).trim());
            }
    
            // Criacao de uma instancia da classe Aluno
            Aluno a = new Aluno(nome, idade, rg, ra, curso, periodo);
            lista.add(a);
            
        } catch (Exception e) {
            
            //System.out.println("Retornado para o menu\n");

        }
    }
    /**
     * remover representa remover um aluno da lista de alunos
     *
     */
    public void remover(){
        // String ra = JOptionPane.showInputDialog("Forneca o ra do aluno: ");
        String ra = "";
        boolean validar = false;
        if(grafico){
            if(lista.isEmpty()){
                JOptionPane.showMessageDialog(null, "Não possui alunos cadastrados!");
            }else{
                ra = validarRA("Forneca o ra do aluno: ", false);
            
                for (Aluno aluno : lista) {
                    if(aluno.getRa().equals(ra)){
                        JOptionPane.showMessageDialog(null, "Aluno: "+aluno.getNome()+" foi removido com sucesso!");
                        lista.remove(aluno);
                        validar = true;
                        break;
                    }
                
                }
                if(!validar)
                    JOptionPane.showMessageDialog(null, "RA não encontrado!");

            }

        }else{
            if(lista.isEmpty()){
                System.out.println("\nNão possui alunos cadastrados!\n");
            }else{
                ra = validarRA("Forneca o ra do aluno: ", false);
            
                for (Aluno aluno : lista) {
                    if(aluno.getRa().equals(ra)){
                        System.out.println("Aluno: "+aluno.getNome()+" foi removido com sucesso!\n");
                        lista.remove(aluno);
                        validar = true;
                        break;
                    }
                
                }
                if(!validar)
                    System.out.println("RA não encontrado!\n");
            }
            
        }
        
    }

    /**
     * listar permite listar todos os alunos da lista
     *
     */
    public void listar(){
        String val = "";
        if(grafico){
            if(lista.isEmpty()){
                val = "Não tem alunos cadastrados!";
            }else
                for (Aluno aluno : lista) {
                    val += "[Nome: ["+aluno.getNome()+"] RA: ["+aluno.getRa()+"]  Curso: ["+aluno.getCurso()+"]\n Idade: ["+aluno.getIdade()+"] ID: ["+aluno.getId()+"] Periodo: ["+aluno.getPeriodo()+"] ]\n\n";
                }
            JOptionPane.showMessageDialog(null, val); 
        }
        else
            if(lista.isEmpty()){
                System.out.println("Não tem alunos cadastrados!");
            }else
                for(Aluno aluno : lista){
                    System.out.println("[Nome: ["+aluno.getNome()+"] RA: ["+aluno.getRa()+"]  Curso: ["+aluno.getCurso()+"]\n Idade: ["+aluno.getIdade()+"] ID: ["+aluno.getId()+"] Periodo: ["+aluno.getPeriodo()+"] ]\n\n");
                }
    }

    /**
     * inputPainel função para inserção de valores via teclado por gráfico
     *
     * @param msg (String) mensagem para ser mostrada ao usuário
     * @param numerico (boolean) entrada numérica ou caractere
     * @return (String) valor digitado pelo usuário
     */
    public String inputPainel(String msg, boolean numerico, boolean isidade){

        String valor = "";
        int idadeperiodo = 0;
        if(numerico){
            while (true) { 
                valor = JOptionPane.showInputDialog(msg).trim();
                if(isNumeric(valor)){
                    idadeperiodo = Integer.parseInt(valor);
                    if(isidade)
                    {
                        if (idadeperiodo < 1 || idadeperiodo > 100)
                            JOptionPane.showMessageDialog(null, "idade nao compativel (minimo 1 e maximo 100)");
                        else
                            break;
                    }
                    else
                    {
                        if (idadeperiodo < 1 || idadeperiodo > 14)
                            JOptionPane.showMessageDialog(null, "periodo nao compativel (minimo 1 e maximo 14)");
                        else
                            break;
                    }
                }
                else
                    JOptionPane.showMessageDialog(null, "Insira um valor corretamente!");
            }
        }
        else{
            boolean validar = false;
            while (valor.equals("") || !validar) { 
                valor = JOptionPane.showInputDialog(msg).trim();
                for (int i = 0; i < valor.length(); i++) {
                    if(isNumeric(valor.charAt(i)+"") || !isAlfabeta(valor.charAt(i)+"")){
                        validar = false;
                        JOptionPane.showMessageDialog(null, "Preencha o campo corretamente!");
                        break;
                    }else validar = true;
                }
            }
        }

        return valor.trim();
    }
    /**
     * inputConsole função para inserção de valores via teclado por console
     *
     * @param msg (String) mensagem para ser mostrada ao usuário
     * @param numerico (boolean) entrada numérica ou caractere
     * @return (String) valor digitado pelo usuário
     */
    public String inputConsole(String msg, boolean numerico, boolean isidade){
        String valor = "";
        int idadeperiodo = 0;
        if(numerico){
            while (true) { 
                System.out.println(msg);
                valor = scanner.nextLine().trim();
                if(isNumeric(valor)){
                    idadeperiodo = Integer.parseInt(valor);
                    if(isidade){
                        if (idadeperiodo < 1 || idadeperiodo > 100)
                            System.out.println("idade nao compativel (minimo 1 maximo 100)");
                        else
                            break;
                    }
                    else
                    {
                        if(idadeperiodo < 1 || idadeperiodo > 14)
                            System.out.println("periodo nao compativel (minimo 1 maximo 14)");
                        else
                            break;
                    }
                }
                else
                    System.out.println("Insira um valor corretamente!");
            }
        }
        else{
            boolean validar = false;
            while (valor.equals("") || !validar) { 
                System.out.println(msg);
                valor = scanner.nextLine().trim();
                for (int i = 0; i < valor.length(); i++) {
                    if(isNumeric(valor.charAt(i)+"")){
                        validar = false;
                        System.out.println("Preencha o campo corretamente!");
                        break;
                    }else validar = true;
                }
            }
        }
        
        return valor.trim();
    }
    /**
     * validarRA função para inserção de RA com sua validação via teclado por gráfico ou console
     *
     * @param msg (String) mensagem para ser mostrada ao usuário
     * @param cadastro (boolean) entrada para cadastro ou validação do valor digitado
     * @return (String) valor digitado pelo usuário
     */
    public String validarRA(String msg, boolean cadastro){
        String valor = "";
        boolean validar = false;
        while (!validar) { 
            if(grafico){
                valor = JOptionPane.showInputDialog(msg).trim();
    
            }else{
                System.out.println(msg);
                valor = scanner.nextLine().trim();
            }
            if(valor.length() > 2 && valor.toUpperCase().startsWith("RA") && isNumeric(valor.substring(2, valor.length()))){
                validar = true;
                if(cadastro)
                    for(Aluno alun : lista){
                        if(alun.getRa().equals(valor)){
                            validar = false;
                            if(grafico)
                                JOptionPane.showMessageDialog(null, "RA ja existente!\nPreencha o campo corretamente!");
                            else
                                System.out.println("RA ja existente!\nPreencha o campo corretamente!");
    
                            break;
                        }
                    }
            }else{
                validar = false;
                if(grafico)
                    JOptionPane.showMessageDialog(null, "RA inválido!\nPreencha o campo corretamente!");
                else
                    System.out.println("RA inválido!\nPreencha o campo corretamente!");
    
            }
            
        }

        return valor.trim();
    }
    /**
     * Identidade função para inserção de ID via teclado por gráfico ou console e sua validação
     *
     * @param msg (String) mensagem para ser mostrada ao usuário
     * @param numerico (boolean) entrada para cadastro ou validação
     * @return (String) valor digitado pelo usuário
     */
    public String Identidade(String msg, boolean cadastro){
        String valor = "";
        boolean validar = false;
        while (!validar) { 
            if(grafico){
                valor = JOptionPane.showInputDialog(msg);
    
            }else{
                System.out.println(msg);
                valor = scanner.nextLine();
            }
            validar = true;
            if(cadastro)
                for(Aluno alun : lista){
                    if(alun.getId().equals(valor)){
                        validar = false;
                        if(grafico)
                            JOptionPane.showMessageDialog(null, "ID ja existente!\nPreencha o campo corretamente!");
                        else
                            System.out.println("ID ja existente!\nPreencha o campo corretamente!");

                        break;
                    }
                }
            
        }

        return valor;
    }

    /**
     * isNumeric função para verificar se valor de entrada é número ou não
     *
     * @param str (String) valor de entrada via teclado
     * @return (boolean) validação se é número ou não
     */
    public boolean isNumeric(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
 
        boolean foundDecimal = false;
        for (char c : str.toCharArray()) { // percorre a string
            if (!Character.isDigit(c)) { // verifica se eh digito
                if (c == '.' && !foundDecimal) { // verifica se existe um unico ponto
                    foundDecimal = true;
                } else {
                    return false;
                }
            }
        }            
        return true;
    }

   public boolean isAlfabeta(String str) {
        // Verifica se o caractere é alfabético (A-Z ou a-z) ou numérico (0-9)
        return (str.matches("[a-zA-ZàáâãäåéèêëíìîïóòôõöúùûüÿçÇ ]") || isNumeric(str));   

    }
}
