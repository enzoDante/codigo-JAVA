import DadosAlunoPac.Aluno;
import java.util.ArrayList;
import java.util.List;

public class CRDAluno extends ValidarDados {
    //public List<Aluno> Alunos = new ArrayList<>();
    //
    // public IArmazenador Alunos = new ListaArray();
    public IArmazenador Alunos;

    public CRDAluno(IArmazenador armazenador){
        this.Alunos = armazenador;
    }

    public boolean Inserir(Aluno value){
        if(!VerificarRADuplicatas(value.getRa())){
            Alunos.adicionar(value);
            return true; // sucesso
        }

        return false; // aluno com ra ja existente
    }

    public boolean VerificarRADuplicatas(String value){
        return Alunos.buscarPorRA(value) != null;

        // for (Aluno aluno : Alunos) {
        //     if(aluno.getRa().equals(value)) return true; // existe aluno com esse ra
        // }
        // return false; // não existe aluno com esse ra, logo pode cadastrar
    }
    public boolean VerificarID(String value){
        for(int i = 0; i < Alunos.getQtd(); i++){
            Aluno a = Alunos.buscar(i);
            if(a != null && a.getId().equals(value))
                return true;
        }
        return false;
        
        // for (Aluno aluno : Alunos) {
        //     if(aluno.getId().equals(value)) return true; // existe aluno com esse id
        // }
        // return false;
    }

    public boolean Delete(String value){
        for(int i = 0; i < Alunos.getQtd(); i++){
            Aluno a = Alunos.buscar(i);
            if(a != null && a.getRa().equals(value)){
                Alunos.remover(i);
                return true;
            }
        }
        return false;
        
        // for (Aluno aluno : Alunos) {
        //     if(aluno.getRa().equals(value)){
        //         Alunos.remove(aluno);
        //         return true; //sucesso
        //     } 
        // }
        // return false; // não existe aluno com esse ra
    }

    public Object[][] Select(){
        int qtd = Alunos.getQtd();
        Object[][] dados = new Object[qtd][6];
        for(int i = 0; i < qtd; i++){
            Aluno aluno = Alunos.buscar(i);
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
