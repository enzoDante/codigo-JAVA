import java.awt.*;
public class Atividade8 extends Frame{
	Panel p1;
	Panel p2;
	Panel p3;
	Label labe1;
	Label labe2;
	TextField text1;
	Button btn1;
	public Atividade8(){
		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();
		labe1 = new Label("Digite um número entre 0 e 9999: ");
		labe2 = new Label("============================================");
		text1 = new TextField(30);

		btn1 = new Button("Extenso");

		add("North", p1);
		p1.add(labe1);
		p1.add(text1);

		add("South", p2);
		p2.add(btn1);

		add("Center", p3);
		p3.add(labe2);

		reshape(100, 100, 500, 300);
		show();
	}
	public boolean action(Event evt, Object ob){
		if("Extenso".equals(ob)){
			int num = Integer.parseInt(text1.getText());
			ControleAlgarism ctrl = new ControleAlgarism(num);
			Caracteres FormatarExtenso = new Caracteres(ctrl.getNumerExtenso());
			String valorExtenso = FormatarExtenso.getValor();
			labe2.setText(valorExtenso);
		}

		return true;
	}
	public static void main(String args[]){
		new Atividade8();
	}
}