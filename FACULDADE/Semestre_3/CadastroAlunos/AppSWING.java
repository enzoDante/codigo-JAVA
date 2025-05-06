import java.awt.*;
import javax.swing.*;

public class AppSWING extends JFrame{
    ComponentesSWING comp = new ComponentesSWING();

    public AppSWING(){
        Container tela = getContentPane();
        tela.setLayout(null);

        // comp.formCadastro(tela);
        comp.inicializarArquivo();
        comp.formMenu(tela);


        setSize(400,300);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String args[]){
        AppSWING app = new AppSWING();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
