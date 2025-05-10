import java.awt.Container;

import javax.swing.*;

public class FormMenu extends JPanel {
    public FormMenu(Container tela, ComponentesSWING comp){
        setLayout(null);

        JLabel JTitulo = new JLabel("MENU", SwingConstants.CENTER);
        add(JTitulo);
        JTitulo.setBounds(90, 5, 200, 20);
        // JTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        JButton BtnCadastro = new JButton("CADASTRAR");
        add(BtnCadastro);
        BtnCadastro.setBounds(115, 35, 150, 20);

        JButton BtnRemover = new JButton("REMOVER");
        add(BtnRemover);
        BtnRemover.setBounds(115, 65, 150, 20);

        JButton BtnListar = new JButton("LISTAR");
        add(BtnListar);
        BtnListar.setBounds(115, 95, 150, 20);

        JButton BtnVoltar = new JButton("SAIR");
        add(BtnVoltar);
        BtnVoltar.setBounds(115, 125, 150, 20);

        BtnCadastro.addActionListener(e -> comp.renderizar(tela, new FormCadastro(tela, comp)));
        
        BtnRemover.addActionListener(e -> {
            if(!comp.ALUNO.Alunos.estaVazia()){
                comp.renderizar(tela, new FormRemover(tela, comp));
            }else{
                JOptionPane.showMessageDialog(null, "Não existe aluno para remover");
            }
        });

        BtnListar.addActionListener(e -> comp.renderizar(tela, new FormListar(tela, comp)));

        BtnVoltar.addActionListener(e -> System.exit(0));

    }
}
