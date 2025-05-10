import java.awt.*;
import javax.swing.*;

public class AppSWING extends JFrame{
    ComponentesSWING comp = new ComponentesSWING();

    public AppSWING(){
        setTitle("Sistema cadastro de alunos");

        Container tela = getContentPane();
        
        comp.inicializarArquivo();
        comp.renderizar(tela, new FormMenu(tela, comp));


        setSize(400,300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String args[]){
        new AppSWING();
    }
}