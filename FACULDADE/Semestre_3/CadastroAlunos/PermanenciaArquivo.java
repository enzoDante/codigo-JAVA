import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class PermanenciaArquivo {
    public static void salvarAlunos(List<Aluno> alunos, String caminhoArquivo){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminhoArquivo))) {
            oos.writeObject(alunos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Aluno> lerAlunos(String caminhoArquivo){
        File arquivo = new File(caminhoArquivo);
        if(!arquivo.exists() || arquivo.length() == 0){
            return new ArrayList<>();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminhoArquivo))) {
            return (List<Aluno>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
            // TODO: handle exception
        }
    }

}
