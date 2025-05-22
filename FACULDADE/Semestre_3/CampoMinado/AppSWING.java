
import java.awt.*;
import javax.swing.JFrame;

public class AppSWING extends JFrame{
    
    
    public AppSWING(){
        setTitle("Campo Minado Ligado");
        
        Container tela = getContentPane();
        int tamanho = 10;
        
        ComponenteSWING comp = new ComponenteSWING(tela, tamanho);
        comp.iniciarCampo();
        


        setSize(600, 600);
        setResizable(false);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new AppSWING();
    }
}
