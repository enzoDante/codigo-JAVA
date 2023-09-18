import java.awt.*;
public class Atividade10 extends Frame{
    Label lb;
    Label lb2;
    TextField txt;
    Button btn;
    Panel p1;
    Panel p2;
    Panel p3;
    public Atividade10(){
        btn = new Button("Ok");
        p1 = new Panel();
        lb = new Label("Digite um número: ");
        txt = new TextField(10);
        add("North", p1);
        p1.add(lb);
        p1.add(txt);

        p2 = new Panel();
        add("Center", p2);
        lb2 = new Label("==============================================");
        p2.add(lb2);

        p3 = new Panel();
        add("South", p3);
        p3.add(btn);


        reshape(100, 100, 400, 300);
        show();
    }
    public boolean action(Event evt, Object arg){
        if("Ok".equals(arg)){
            int num = Integer.parseInt(txt.getText());

            Numero n = new Numero();
            n.setNum(num);
            String vals = n.calcFibo();
            lb2.setText(vals);
        }
        return true;
    }
    public static void main(String args[]){
        new Atividade10();
    }
}
