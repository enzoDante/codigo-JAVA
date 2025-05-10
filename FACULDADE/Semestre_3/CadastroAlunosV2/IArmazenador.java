import DadosAlunoPac.Aluno;
/**
 * IArmazenador interface para armazenadores.
 * 
 * @author Julio Arakaki 
 * @version 12/04/2023
 */

public interface IArmazenador { 
    public void adicionar(Aluno a);
    public Aluno remover(int i);
    public boolean estaVazia();
    public Aluno buscar (int i);
    public Aluno buscarPorRA(String ra);
    public int getQtd();
}

