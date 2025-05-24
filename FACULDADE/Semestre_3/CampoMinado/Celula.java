public class Celula{
    //icone pode ser caminho da imagem
    public String icone = ""; // "" - vazio  "F" - bandeira  "B" - Bomba (derrota)  "123..." bombas ao redor
    public boolean bandeira = false;
    public boolean bomba = false;
    public int bombasVizinho = 0;
    public boolean revelado = false;

    Celula direita, esquerda, cima, baixo;
    Celula CD, CE, BD, BE;
}