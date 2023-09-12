public class QVogais extends QConsoantes{
    private String vogais = "aeiouAEIOU";
    private int TotalVogs = 0;

    public void VerificarV(String str){
       
        for (int i = 0; i < str.length(); i++) {
            if(this.vogais.indexOf(str.charAt(i)) != -1)
                this.setTotalVogs(this.getTotalVogs() + 1);
            else
                this.setTotalCons(this.getTotalCons() + 1);
        }
    }

    public void setTotalVogs(int v){
        this.TotalVogs = v;
    }
    public int getTotalVogs(){
        return this.TotalVogs;
    }
}
