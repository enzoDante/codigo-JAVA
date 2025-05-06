import java.util.ArrayList;
import java.util.List;

public class CRDAluno {
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

    public String Select(){
        String msg = "";
        if(!Alunos.isEmpty())
            for (Aluno aluno : Alunos) {
                msg += "[Nome: ["+aluno.getNome()+"] RA: ["+aluno.getRa()+"]  Curso: ["+aluno.getCurso()+"]\n Idade: ["+aluno.getIdade()+"] ID: ["+aluno.getId()+"] Periodo: ["+aluno.getPeriodo()+"] ]\n\n";
            }
            
        return msg;
    }





}
