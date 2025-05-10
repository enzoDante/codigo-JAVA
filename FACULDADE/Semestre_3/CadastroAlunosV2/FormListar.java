import java.awt.Container;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FormListar extends JPanel {
    public FormListar(Container tela, ComponentesSWING comp){
        setLayout(null);
        String[] colunas = {"Nome", "Idade", "RA", "ID", "Curso", "Período"};
        

        JLabel JTitulo = new JLabel("ALUNOS");
        add(JTitulo);
        JTitulo.setBounds(175, 5, 200, 20);

        JButton BtnVoltar = new JButton("Voltar");
        add(BtnVoltar);
        BtnVoltar.setBounds(145, 25, 100, 25);
        BtnVoltar.addActionListener(e -> comp.renderizar(tela, new FormMenu(tela, comp)));



        DefaultTableModel modelo = new DefaultTableModel(comp.ALUNO.Select(), colunas);
        JTable tabela = new JTable(modelo);

        JScrollPane painel = new JScrollPane(tabela);
        add(painel);
        painel.setBounds(5, 65, 380, 195);
    }
}
