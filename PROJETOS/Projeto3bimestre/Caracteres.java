class Caracteres{
    private String valorExtenso = "";


    public Caracteres(String value){
        this.setExtensFormat(value);
    }
    public String getValor(){
        return this.valorExtenso;
    }
    public void setExtensFormat(String value){
        //String caractereM = value.charAt(0);
        String caractereM = value.substring(0, 1);
        caractereM = caractereM.toUpperCase();
        this.valorExtenso = caractereM + value.substring(1, value.length());
    }
    public void getExtensFormat(){
        System.out.println(this.getValor());
    }
}