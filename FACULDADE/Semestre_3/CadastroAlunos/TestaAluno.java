import javax.swing.JOptionPane;

/**
 * Testa a classe Aluno.
 * 
 * @author Enzo Dante Mícoli ra00347608, Gabriel Azevedo Cruz ra00345943, Nícolas Okamoto Celestrino ra00345719, Pedro Bizzari ra00346785
 * @version 03/04/2025
 */
public class TestaAluno {
    public static void main(String[] args) {
        // Entrada de um nome do aluno (atraves do teclado)
        String nome= JOptionPane.showInputDialog("Forneca o nome do aluno: ");
        
        // Entrada da idade do aluno (atraves do teclado)
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Forneca a idade do aluno: "));

        // Entrada de uma identificacao do aluno (atraves do teclado)
        String rg = JOptionPane.showInputDialog("Forneca o rg do aluno : ");

        // Entrada da ra do aluno (atraves do teclado)
        String ra = JOptionPane.showInputDialog("Forneca o ra do aluno: ");

        // Entrada do curso do aluno (atraves do teclado)
        String curso = JOptionPane.showInputDialog("Forneca o curso do aluno: ");

        // Entrada da idade do aluno (atraves do teclado)
        int periodo = Integer.parseInt(JOptionPane.showInputDialog("Forneca o periodo do aluno: "));

        // Criacao de uma instancia da classe Aluno
        Aluno a = new Aluno(nome, idade, rg, ra, curso, periodo);
        
        // Mostra os dados
        System.out.println("Dados do aluno: \n" + a);
        System.out.println("Nome invertido do aluno: " + a.getNomeInvertido());
        System.out.println("Nome bibliografico do aluno: " + a.getNomeBiblio());
    }
}
