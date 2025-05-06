import java.util.ArrayList;
import java.util.List;

public class CRDAluno extends ValidarDados {
    public List<Aluno> Alunos = new ArrayList<>();

    public boolean Inserir(Aluno value){
        if(!VerificarRADuplicatas(value.getRa())){
            Alunos.add(value);
            return true; // sucesso
        }

        return false; // aluno com ra ja existente
    }

    public boolean VerificarRADuplicatas(String value){

        for (Aluno aluno : Alunos) {
            if(aluno.ra.equals(value)) return true; // existe aluno com esse ra
        }
        return false; // não existe aluno com esse ra, logo pode cadastrar
    }
    public boolean VerificarID(String value){
        for (Aluno aluno : Alunos) {
            if(aluno.getId().equals(value)) return true; // existe aluno com esse id
        }
        return false;
    }

    public boolean Delete(String value){
        for (Aluno aluno : Alunos) {
            if(aluno.getRa().equals(value)){
                Alunos.remove(aluno);
                return true; //sucesso
            } 
        }
        return false; // não existe aluno com esse ra
    }

    public Object[][] Select(){
        
        Object[][] dados = new Object[Alunos.size()][6];
        if(!Alunos.isEmpty())
            for(int i = 0; i < Alunos.size(); i++){
                Aluno aluno = Alunos.get(i);
                dados[i][0] = aluno.getNome();
                dados[i][1] = aluno.getIdade();
                dados[i][2] = aluno.getRa();
                dados[i][3] = aluno.getId();
                dados[i][4] = aluno.getCurso();
                dados[i][5] = aluno.getPeriodo();
            }

        return dados;
    }


}
