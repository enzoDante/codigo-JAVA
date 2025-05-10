
import java.awt.*;
import java.io.IOException;

import javax.swing.*;

public class ComponentesSWING {
    JLabel JTitulo;
    JLabel JNome;
    JLabel JIdade;
    JLabel JID;
    JLabel JRA;
    JLabel JCurso;
    JLabel JPeriodo;

    JTextField Nome;
    JTextField Idade;
    JTextField ID;
    JTextField RA;
    JTextField Curso;
    JTextField Periodo;

    JButton BtnVoltar;
    JButton BtnAvancar;
    
    CRDAluno ALUNO = new CRDAluno(new ListaArray());
    PermanenciaArquivo persistencia = new PermanenciaArquivo();
    String caminho = "D:\\Document\\vsCode\\codigo-JAVA\\FACULDADE\\arquivoAlunos.bin"; //C:\\Users\\ra00347608\\Documents\\arquivoAlunos.bin

    public void inicializarArquivo(){
        try {
            ALUNO.Alunos = persistencia.ler(caminho);
            
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }

    public void renderizar(Container tela, JPanel novoPainel){
        tela.removeAll();
        tela.setLayout(null);
        tela.add(novoPainel);
        novoPainel.setBounds(0, 0, 400, 300);
        tela.revalidate();
        tela.repaint();
    }

}
