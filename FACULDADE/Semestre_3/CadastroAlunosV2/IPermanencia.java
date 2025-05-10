import java.io.IOException;

public interface IPermanencia {
    public void salvarAlunos(IArmazenador armazenador, String caminho) throws IOException;
    public IArmazenador ler(String caminho) throws IOException, ClassNotFoundException;
}
