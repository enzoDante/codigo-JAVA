import java.awt.*;
import javax.swing.*;

public class Menu {
    private CardLayout layout;
    private Container tela;
    private JPanel cards;

    public Menu(Container tela) {
        this.tela = tela;
        this.layout = new CardLayout();
        this.cards = new JPanel(layout);
        
        criarMenu();
        tela.add(cards);
    }

    public void criarMenu() {
        // Tela de Menu
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel titulo = new JLabel("Campo Minado");
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Cria o combo box com as opções
        String[] opcoes = {"Fácil", "Médio", "Difícil"};
        JComboBox<String> comboDificuldade = new JComboBox<>(opcoes);
        comboDificuldade.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton jogarBtn = new JButton("Jogar");
        jogarBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        jogarBtn.addActionListener(e -> iniciarJogo(comboDificuldade));

        menuPanel.add(Box.createVerticalGlue());
        menuPanel.add(titulo);
        menuPanel.add(Box.createRigidArea(new Dimension(0, 10)));  // espaço
        menuPanel.add(comboDificuldade);
        menuPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        menuPanel.add(jogarBtn);
        menuPanel.add(Box.createVerticalGlue());

        cards.add(menuPanel, "menu");
        layout.show(cards, "menu");
    }

    
    public void iniciarJogo(JComboBox<String> combo) {
        JPanel jogoPanel = new JPanel();
        jogoPanel.setLayout(new BorderLayout());

        int indiceSelecionado = combo.getSelectedIndex();
            int dimensao = -1;

            switch (indiceSelecionado) {
                case 0: dimensao = 10; break;
                case 1: dimensao = 16; break;
                case 2: dimensao = 28; break;
            }

        //int dimensao = 10; // Exemplo de tamanho
        ComponenteSWING comp = new ComponenteSWING(jogoPanel, dimensao);

        comp.cabeca(); // Você deve implementar o cabeçalho no painel se necessário
        comp.iniciarCampo();

        cards.add(jogoPanel, "jogo");
        layout.show(cards, "jogo");
    }
}