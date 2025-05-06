
/**
 * Classe para representar (criar) objetos Aluno. 
 * Utiliza heranca com a classe Pessoa (pai)
 * 
 * @author Enzo Dante Mícoli ra00347608, Gabriel Azevedo Cruz ra00345943, Nícolas Okamoto Celestrino ra00345719, Pedro Bizzari ra00346785
 * @version 03/04/2025
 */
public class CadAlunos {
    public static void main(String args[]){
        int qtde = 3;

        // Cria array de alunos
        Aluno cad[] = new Aluno[qtde];

        cad[0] = new Aluno("nome1", 21, "id1", "ra1", "Ccomputacao", 1);
        cad[1] = new Aluno("nome2", 23, "id2", "ra2", "Engenharia", 5);
        cad[2] = new Aluno("nome3", 22, "id3", "ra3", "Jogos", 3);
        
        for (int i = 0; i < cad.length; i++){
            System.out.println("--------");
            System.out.println(cad[i]);
        }
    }
}
