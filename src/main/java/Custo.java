
import java.util.ArrayList;


public class Custo {
    
    private static ArrayList<Custo> custos = new ArrayList<>();
    private String Familia;
    private String motivo;
    private int valor;
    
    public Custo(){
        Familia = "";
        motivo = "";
        valor = 0;
    }
    
    public Custo(String Familia, String motivo, int valor){
        this.Familia = Familia;
        this.motivo = motivo;
        this.valor = valor;
    }
    
     public ArrayList<Custo> getCustos() {
        return custos;
    }
     
    public Custo getCustos(int indice) {
        return custos.get(indice);
    }
     
    public void addCustos(Custo custo) {
        custos.add(custo);
    }
    
    public void retiraCustos(int indice) {
        if (indice >= 0 && indice < custos.size()) {
            custos.remove(indice);
        } else {
            System.out.println("Indice incorreto");
        }
    }
    
    public void retiraCustos(String nome) {
        for (int i = 0; i < custos.size(); i++) {
            while (getFamilia(i).contains(getFamilia(nome))) {
                retiraCustos(i);
            }
        }
    }
    
    @Override
    public String toString() {
        String texto;
        texto = "{";
        texto += "Familia: " + Familia;
        texto += "; Motivo: " + motivo;
        texto += "; Valor: " + valor + '}';
        return texto;
    }
    
    public String getFamilia(int indice) {
        Custo c = new Custo();
        c = custos.get(indice);
        this.Familia = c.Familia;
        return Familia;
    }
    
    public String getFamilia(String nome) {
        for (Custo c : custos) {
            if (custos.contains(nome)) {
                System.out.println(nome);
            }
        }
        return nome;
    }
    
    public int getValor(int indice) {
        Custo c = new Custo();
        c = custos.get(indice);
        this.valor = c.valor;
        return valor;
    }
    
    public int getValor(String nome) {
        int v = 0;
        for (int i = 0; i < custos.size(); i++) {
            if (getFamilia(i).contains(getFamilia(nome))) {
                v  += getValor(i);
            }
        }
        return v;
    }
}
