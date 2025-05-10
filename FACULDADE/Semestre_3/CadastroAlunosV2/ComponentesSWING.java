
import DadosAlunoPac.Aluno;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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
    
    CRDAluno ALUNO = new CRDAluno();
    public void inicializarArquivo(){
        ALUNO.Alunos = PermanenciaArquivo.lerAlunos("C:\\Users\\ra00347608\\Documents\\arquivoAlunos.bin");
    }

    public void formMenu(Container tela){
        JTitulo = new JLabel("MENU");
        tela.add(JTitulo);
        JTitulo.setBounds(90, 5, 200, 20);
        JTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        JButton BtnCadastro = new JButton("CADASTRAR");
        tela.add(BtnCadastro);
        BtnCadastro.setBounds(115, 35, 150, 20);

        JButton BtnRemover = new JButton("REMOVER");
        tela.add(BtnRemover);
        BtnRemover.setBounds(115, 65, 150, 20);

        JButton BtnListar = new JButton("LISTAR");
        tela.add(BtnListar);
        BtnListar.setBounds(115, 95, 150, 20);

        BtnVoltar = new JButton("SAIR");
        tela.add(BtnVoltar);
        BtnVoltar.setBounds(115, 125, 150, 20);

        BtnCadastro.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evento){
                tela.removeAll();
                tela.revalidate();
                tela.repaint();

                formCadastro(tela);
            }
        });
        BtnRemover.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evento){
                if(!ALUNO.Alunos.isEmpty()){
                    tela.removeAll();
                    tela.revalidate();
                    tela.repaint();
    
                    formDelete(tela);

                }else{
                    JOptionPane.showMessageDialog(null, "Não existe aluno para remover");
                }
            }
        });
        BtnListar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evento){
                tela.removeAll();
                tela.revalidate();
                tela.repaint();

                viewAll(tela);
            }
        });

        BtnVoltar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evento){
                System.exit(0); // Encerra a aplicação completamente
            }
        });
    }

    public void formCadastro(Container tela){
        JTitulo = new JLabel("CADASTRO");
        tela.add(JTitulo);
        JTitulo.setBounds(150, 5, 200, 20);
        
        JNome = new JLabel("Digite o Nome");
        tela.add(JNome);
        JNome.setBounds(10, 20, 200, 20);

        Nome = new JTextField();
        tela.add(Nome);
        Nome.setBounds(10, 40, 200, 20);

        JIdade = new JLabel("Digite a Idade");
        tela.add(JIdade);
        JIdade.setBounds(10, 60, 100, 20);

        Idade = new JTextField();
        tela.add(Idade);
        Idade.setBounds(10, 80, 100, 20);

        JID = new JLabel("Digite o ID");
        tela.add(JID);
        JID.setBounds(250, 20, 100, 20);

        ID = new JTextField();
        tela.add(ID);
        ID.setBounds(250, 40, 100, 20);

        JRA = new JLabel("Digite o RA");
        tela.add(JRA);
        JRA.setBounds(250, 60, 100, 20);

        RA = new JTextField();
        tela.add(RA);
        RA.setBounds(250, 80, 100, 20);

        JCurso = new JLabel("Digite o Curso");
        tela.add(JCurso);
        JCurso.setBounds(10, 100, 100, 20);

        Curso = new JTextField();
        tela.add(Curso);
        Curso.setBounds(10, 120, 200, 20);

        JPeriodo = new JLabel("Digite o Periodo");
        tela.add(JPeriodo);
        JPeriodo.setBounds(250, 100, 100, 20);

        Periodo = new JTextField();
        tela.add(Periodo);
        Periodo.setBounds(250, 120, 100, 20);

        BtnAvancar = new JButton("Cadastrar");
        tela.add(BtnAvancar);
        BtnAvancar.setBounds(200, 160, 100, 25);
        BtnAvancar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evento){
                boolean validar = true;
                String msg = "Insira ";
                if(!ALUNO.ValidStrAlfa(Nome.getText())){
                    validar = false;
                    msg += " um Nome\n";
                }
                if(!ALUNO.ValidIdade(Idade.getText())){
                    validar = false;
                    msg += " uma idade\n";
                }

                if(!ALUNO.ValidStrAlfa(Curso.getText())){
                    validar = false;
                    msg += " um curso\n";
                }

                if(!ALUNO.ValidPerid(Periodo.getText())){
                    validar = false;
                    msg += "um periodo corretamente\n\n";
                }

                if(!ALUNO.validarRA(RA.getText())){
                    validar = false;
                    if(ALUNO.VerificarRADuplicatas(RA.getText())){
                        msg += " RA ja existente!\n";
                    }else{
                        msg += " RA inválido!\n";
                    }
                }
                
                // se sucesso, mostrar sucesso e voltar tela anterior
                if(validar){
                    
                    
                    Aluno obj = new Aluno(Nome.getText(), Integer.parseInt(Idade.getText()), ID.getText(), RA.getText(), Curso.getText(), Integer.parseInt(Periodo.getText()));
                    
                    if(ALUNO.Inserir(obj)){
                        tela.removeAll();
                        tela.revalidate();
                        tela.repaint();

                        PermanenciaArquivo.salvarAlunos(ALUNO.Alunos, "C:\\Users\\ra00347608\\Documents\\arquivoAlunos.bin");
                        formMenu(tela);
                        JOptionPane.showMessageDialog(null, "Aluno Cadastrado com sucesso!");
                    }else{
                        JOptionPane.showMessageDialog(null, "RA ja existente para outro Aluno!");
                    }

                }else{
                    
                    JOptionPane.showMessageDialog(null, msg);
                }


            }
        });

        BtnVoltar = new JButton("Cancelar");
        tela.add(BtnVoltar);
        BtnVoltar.setBounds(40, 160, 100, 25);
        voltarMenu(tela);

    }

    public void formDelete(Container tela){
        JTitulo = new JLabel("REMOVER ALUNO");
        tela.add(JTitulo);
        JTitulo.setBounds(145, 5, 200, 20);
        
        JRA = new JLabel("Digite o RA");
        tela.add(JRA);
        JRA.setBounds(145, 30, 100, 20);

        RA = new JTextField();
        tela.add(RA);
        RA.setBounds(145, 50, 100, 20);

        BtnVoltar = new JButton("Cancelar");
        tela.add(BtnVoltar);
        BtnVoltar.setBounds(85, 85, 100, 25);
        voltarMenu(tela);

        JButton delete = new JButton("Remover");
        tela.add(delete);
        delete.setBounds(195, 85, 100, 25);
        delete.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evento){
                
                if(!ALUNO.validarRA(RA.getText())){
                    JOptionPane.showMessageDialog(null, "RA inválido!");
                }else{
                    // remover da lista
                    if(ALUNO.Delete(RA.getText())){
                        tela.removeAll();
                        tela.revalidate();
                        tela.repaint();
                        
                        formMenu(tela);
                        PermanenciaArquivo.salvarAlunos(ALUNO.Alunos, "C:\\Users\\ra00347608\\Documents\\arquivoAlunos.bin");
                        JOptionPane.showMessageDialog(null, "Aluno removido com sucesso!");
                    }else{
                        JOptionPane.showMessageDialog(null, "Não existe aluno com esse RA!");
                    }
                }
                
            }
        });
    }

    public void viewAll(Container tela){
        String[] colunas = {"Nome", "Idade", "RA", "ID", "Curso", "Período"};
        

        JTitulo = new JLabel("ALUNOS");
        tela.add(JTitulo);
        JTitulo.setBounds(175, 5, 200, 20);

        BtnVoltar = new JButton("Voltar");
        tela.add(BtnVoltar);
        BtnVoltar.setBounds(145, 25, 100, 25);
        voltarMenu(tela);



        DefaultTableModel modelo = new DefaultTableModel(ALUNO.Select(), colunas);
        JTable tabela = new JTable(modelo);

        JScrollPane painel = new JScrollPane(tabela);
        tela.add(painel);
        painel.setBounds(5, 65, 380, 195);

    }


    public void voltarMenu(Container tela){
        BtnVoltar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evento){
                tela.removeAll();
                tela.revalidate();
                tela.repaint();

                formMenu(tela);
            }
        });
    }
}
