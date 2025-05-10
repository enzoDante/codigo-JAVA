import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import DadosAlunoPac.Aluno;

public class PermanenciaArquivo implements IPermanencia {
    @Override
    public void salvarAlunos(IArmazenador armazenador, String caminho) throws IOException{
        List<Aluno> lista = new ArrayList<>();
        for(int i = 0; i < armazenador.getQtd(); i++){
            Aluno a = armazenador.buscar(i);
            if(a != null)
                lista.add(a);
        }
        
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminho))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public IArmazenador ler(String caminho) throws IOException, ClassNotFoundException{
        File arquivo = new File(caminho);
        if(!arquivo.exists() || arquivo.length() == 0){
            return new ListaArray(); // ou VetDin se preferir
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminho))) {
            List<Aluno> lista = (List<Aluno>) ois.readObject();
            IArmazenador armazenador = new ListaArray(); // ou VetDin()

            for (Aluno aluno : lista) {
                armazenador.adicionar(aluno);
            }
            return armazenador;

        }
    }

}