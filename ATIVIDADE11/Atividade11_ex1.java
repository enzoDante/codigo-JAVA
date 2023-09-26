import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Atividade11_ex1 extends JFrame{

public Atividade11_ex1(){
       Container JANELA = getContentPane();
       JANELA.setLayout(null);

       setSize(400,300);
       setVisible(true);

}
        public static void main(String args[]){
            Atividade11_ex1 app = new Atividade11_ex1();
            app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
}