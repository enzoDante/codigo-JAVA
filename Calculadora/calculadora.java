import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class calculadora extends JFrame{
    JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnSum, btnMinus, btnDivd, btnMult;
    JLabel rotulo;
    Elementos criar;
    String valor1 = "", valor2 = "";
    boolean valor1Exist = false;
    matematica mat;

    public calculadora(){
        Container tela = getContentPane();
        tela.setLayout(null);

        criar = new Elementos(tela);
        mat = new matematica();
        rotulo = criar.Label("", new int[]{10, 10, 200, 20});
        // rotulo.setText("aaaaa");

        btns();

        setSize(800, 500);
        setVisible(true);
    }

    public void btns(){
        btn1 = criar.btn("1", new int[]{10, 40, 50, 40});
        btn1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evento){
                if(!valor1Exist){
                    valor1 += "1";
                    rotulo.setText(valor1);
                }
            }
        });

        btn2 = criar.btn("2", new int[]{70, 40, 50, 40});
        btn2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evento){
                if(!valor1Exist){
                    valor1 += "2";
                    rotulo.setText(valor1);
                }
            }
        });

        btn3 = criar.btn("3", new int[]{130, 40, 50, 40});
        btn3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evento){
                if(!valor1Exist){
                    valor1 += "3";
                    rotulo.setText(valor1);
                }
            }
        });

        btnSum = criar.btn("+", new int[]{190, 40, 50, 40});
        btnSum.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evento){
                if(!valor1Exist){

                    //ao invés de fazer esse bloco todo, verificar somente o último caractere!!!!
                    if(!mat.posicaoD(valor1, "+")){
                        int existeOp = mat.verificarSinal(valor1);
                        if(existeOp != -1){
                            char[] chars = valor1.toCharArray();
                            chars[existeOp] = '+';
                            valor1 = String.valueOf(chars);
                        }else
                            valor1 += "+";
                        rotulo.setText(valor1);
                    }
                }else{
                    //verdadeiro
                    
                    rotulo.setText(mat.calcularSoma(valor1));

                }
            }
        });
        //======================================================
        btn4 = criar.btn("4", new int[]{10, 90, 50, 40});
        btn4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evento){
                if(!valor1Exist){
                    valor1 += "4";
                    rotulo.setText(valor1);
                }
            }
        });

        btn5 = criar.btn("5", new int[]{70, 90, 50, 40});
        btn5.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evento){
                if(!valor1Exist){
                    valor1 += "5";
                    rotulo.setText(valor1);
                }
            }
        });

        btn6 = criar.btn("6", new int[]{130, 90, 50, 40});
        btn6.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evento){
                if(!valor1Exist){
                    valor1 += "6";
                    rotulo.setText(valor1);
                }
            }
        });

        btnMinus = criar.btn("-", new int[]{190, 90, 50, 40});
        btnMinus.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evento){
                if(!valor1Exist){
                    valor1 += "-";
                    rotulo.setText(valor1);
                }
            }
        });
        //======================================================
        btn7 = criar.btn("7", new int[]{10, 140, 50, 40});
        btn7.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evento){
                if(!valor1Exist){
                    valor1 += "7";
                    rotulo.setText(valor1);
                }
            }
        });

        btn8 = criar.btn("8", new int[]{70, 140, 50, 40});
        btn8.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evento){
                if(!valor1Exist){
                    valor1 += "8";
                    rotulo.setText(valor1);
                }
            }
        });

        btn9 = criar.btn("9", new int[]{130, 140, 50, 40});
        btn9.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evento){
                if(!valor1Exist){
                    valor1 += "9";
                    rotulo.setText(valor1);
                }
            }
        });

        btnDivd = criar.btn("/", new int[]{190, 140, 50, 40});
        btnDivd.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evento){
                if(!valor1Exist){
                    valor1 += "/";
                    rotulo.setText(valor1);
                }
            }
        });
        //====================================================
        btn0 = criar.btn("0", new int[]{70, 190, 50, 40});
        btn0.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evento){
                if(!valor1Exist){
                    valor1 += "0";
                    rotulo.setText(valor1);
                }
            }
        });

        btnMult = criar.btn("x", new int[]{130, 190, 50, 40});
        btnMult.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evento){
                if(!valor1Exist){
                    valor1 += "*";
                    rotulo.setText(valor1);
                }
            }
        });
        btnSum = criar.btn("=", new int[]{190, 190, 50, 40});
        btnSum.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evento){
                
            }
        });
    }

    public static void main(String[] args) {
        calculadora app = new calculadora();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}