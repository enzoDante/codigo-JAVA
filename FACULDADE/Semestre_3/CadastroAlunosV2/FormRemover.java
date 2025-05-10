import java.awt.Container;
import java.io.IOException;

import javax.swing.*;

import org.w3c.dom.events.MouseEvent;

public class FormRemover extends JPanel {
    public FormRemover(Container tela, ComponentesSWING comp){
        setLayout(null);

        JLabel JTitulo = new JLabel("REMOVER ALUNO");
        add(JTitulo);
        JTitulo.setBounds(145, 5, 200, 20);
        
        JLabel JRA = new JLabel("Digite o RA");
        add(JRA);
        JRA.setBounds(145, 30, 100, 20);

        JTextField RA = new JTextField();
        add(RA);
        RA.setBounds(145, 50, 100, 20);

        JButton BtnVoltar = new JButton("Cancelar");
        add(BtnVoltar);
        BtnVoltar.setBounds(85, 85, 100, 25);
        BtnVoltar.addActionListener(e -> comp.renderizar(tela, new FormMenu(tela, comp)));

        JButton delete = new JButton("Remover");
        add(delete);
        delete.setBounds(195, 85, 100, 25);
        delete.addActionListener(e -> {
            if(!comp.ALUNO.validarRA(RA.getText())){
                JOptionPane.showMessageDialog(null, "RA inválido!");
            }else{
                try {
                    if(comp.ALUNO.Delete(RA.getText())){
                        comp.persistencia.salvarAlunos(comp.ALUNO.Alunos, comp.caminho);
                        JOptionPane.showMessageDialog(null, "Aluno removido com sucesso!");

                        comp.renderizar(tela, new FormMenu(tela, comp));
                    }else
                        JOptionPane.showMessageDialog(null, "Não existe Aluno com esse RA!");
                } catch (IOException ex) {
                    ex.printStackTrace();
                    // TODO: handle exception
                }
            }
        });

    }
}
