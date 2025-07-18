import java.awt.Component;
import java.awt.Container;
import java.io.IOException;

import javax.swing.*;

import DadosAlunoPac.Aluno;

public class FormCadastro extends JPanel {
    public FormCadastro(Container tela, ComponentesSWING comp){
        setLayout(null);

        JLabel JTitulo = new JLabel("CADASTRO");
        add(JTitulo);
        JTitulo.setBounds(150, 5, 200, 20);

        JTextField Nome = criarCampo(add(new JLabel("Nome")), 10, 40, 200);
        JTextField Idade = criarCampo(add(new JLabel("Idade")), 10, 80, 100);
        JTextField ID = criarCampo(add(new JLabel("ID")), 250, 40, 100);
        JTextField RA = criarCampo(add(new JLabel("RA")), 250, 80, 100);
        JTextField Curso = criarCampo(add(new JLabel("Curso")), 10, 120, 200);
        JTextField Periodo = criarCampo(add(new JLabel("Periodo")), 250, 120, 100);

        JButton BtnVoltar = new JButton("Cancelar");
        add(BtnVoltar);
        BtnVoltar.setBounds(80, 160, 100, 25);
        BtnVoltar.addActionListener(e -> comp.renderizar(tela, new FormMenu(tela, comp)));

        JButton BtnAvancar = new JButton("Cadastrar");
        add(BtnAvancar);
        BtnAvancar.setBounds(200, 160, 100, 25);

        BtnAvancar.addActionListener(e -> {
            boolean validado = true;
            String msg = "Corrija os seguintes campos:\n";

            if(!comp.ALUNO.ValidStrAlfa(Nome.getText())){
                msg += "- Nome inválido\n";
                validado = false;
            }
            if(!comp.ALUNO.ValidPerid(Periodo.getText())){
                msg += "- Período inválido\n";
                validado = false;
            }
            if(!comp.ALUNO.ValidIdade(Idade.getText())){
                msg += "- Idade inválida\n";
                validado = false;
            }
            if(!comp.ALUNO.ValidStrAlfa(Curso.getText())){
                msg += "- Curso inválido\n";
                validado = false;
            }
            if(!comp.ALUNO.validarRA(RA.getText())){
                if(comp.ALUNO.VerificarRADuplicatas(RA.getText())){
                    msg += "- RA ja existente\n";
                }else
                    msg += "- RA inválido\n";
                
                validado = false;
            }

            if(validado){
                Aluno aluno = new Aluno(Nome.getText(), Integer.parseInt(Idade.getText()), ID.getText(), RA.getText(), Curso.getText(), Integer.parseInt(Periodo.getText()));
                try {
                    if(comp.ALUNO.Inserir(aluno)){
                        comp.persistencia.salvarAlunos(comp.ALUNO.Alunos, comp.caminho);
                        JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");
                        comp.renderizar(tela, new FormMenu(tela, comp));
                    }else{
                        JOptionPane.showMessageDialog(null, "RA já cadastrado.");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                    // TODO: handle exception
                }
            }else{
                JOptionPane.showMessageDialog(null, msg);
            }


        });
    }
    private JTextField criarCampo(Component label, int x, int y, int w){
        label.setBounds(x, y - 20, 100, 20);
        JTextField campo = new JTextField();
        
        campo.setBounds(x, y, w, 20);
        add(label);
        add(campo);
        return campo;
    }
}
