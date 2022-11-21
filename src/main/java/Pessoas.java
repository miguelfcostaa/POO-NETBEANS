
import java.util.*;

public class Pessoas {

    private String nome;        //Primeiro nome
    private String apelido;     //Ultimo nome
    private String posto;       //Posto de soldier a boss
    private int ccld;           // ccld unico de 8 digitos
    private int lealdade;       //valor de 0 a 100
    private int musculo;        //valor de 0 a 100
    private int inteligência;   //valor de 0 a 100
    private int estratega;      //valor de 0 a 100
    private int carisma;        //valor de 0 a 100
    private String superior;
    private static ArrayList<Pessoas> people = new ArrayList<>();
    private static ArrayList<Pessoas> obituario = new ArrayList<>();
    private static ArrayList<Pessoas> presos = new ArrayList<>();

    private Random rand = new Random();

    public Pessoas() {
        nome = " ";
        apelido = " ";
        posto = " ";
        ccld = 00000000;
        superior = "";
        lealdade = 0;
        musculo = 0;
        inteligência = 0;
        estratega = 0;
        carisma = 0;
    }

    public Pessoas(String nome, String apelido, String posto, int ccld, String superior) {
        this.nome = nome;
        this.apelido = apelido;
        this.posto = posto;
        this.ccld = ccld;
        this.superior = superior;

        this.lealdade = Random();
        this.inteligência = Random();
        this.estratega = Random();
        this.musculo = Random();
        this.carisma = Random();
    }

    public Pessoas(int inteligência, int estratega, int musculo) {
        this.inteligência = inteligência;
        this.estratega = estratega;
        this.musculo = musculo;
    }

    public Pessoas(String nome, String apelido, String posto, int ccld, String superior, int leal, int smart, int estra, int musc, int cari) {
        this.nome = nome;
        this.apelido = apelido;
        this.posto = posto;
        this.ccld = ccld;
        this.superior = superior;

        this.lealdade = leal;
        this.inteligência = smart;
        this.estratega = estra;
        this.musculo = musc;
        this.carisma = cari;
    }

    public ArrayList<Pessoas> getPeople() {
        return people;
    }

    public void addPessoa(Pessoas pes) {
        people.add(pes);
    }

    public Pessoas getPeople(int indice) {
        return people.get(indice);
    }

    public void setPeople(ArrayList<Pessoas> people) {
        this.people = people;
    }

    public void retiraPessoa(int indice) {
        if (indice >= 0 && indice < people.size()) {
            people.remove(indice);
        } else {
            System.out.println("Indice incorreto");
        }
    }

    public int Random() {
        int n = rand.nextInt(100) + 1;
        return n;
    }

    //getter & add do Obituario
    public void addObituario(Pessoas dead) {
        obituario.add(dead);
    }

    public ArrayList<Pessoas> getObituario() {
        return obituario;
    }

    public Pessoas getObituario(int indice) {
        return obituario.get(indice);
    }

    //getter & add & retira dos Presos
    public void addPresos(Pessoas lock) {
        presos.add(lock);
    }

    public ArrayList<Pessoas> getPresos() {
        return presos;
    }

    public Pessoas getPresos(int indice) {
        return presos.get(indice);
    }

    public void retiraPresos(int indice) {
        if (indice >= 0 && indice < presos.size()) {
            presos.remove(indice);
        } else {
            System.out.println("Indice incorreto");
        }
    }

    @Override
    public String toString() {
        String texto;
        texto = "";
        texto += " nome=" + nome;
        texto += " apelido=" + apelido;
        texto += " posto=" + posto;
        texto += " ccld=" + ccld;
        texto += " lealdade=" + lealdade;
        texto += " musculo=" + musculo;
        texto += " inteligência=" + inteligência;
        texto += " estratega=" + estratega;
        texto += " carisma=" + carisma;
        texto += " superior=" + superior + '}';
        return texto;
    }

    public int getIndice(String nome) {
        for (int i = 0; i < people.size(); i++) {
            if (getNome(i).contains(getNome(nome))) {
                return i;
            }
        }
        System.out.println("Nao foi encontrado nada. :)");
        return 0;
    }

    public boolean comparaPosto(String posto) {
        boolean verificado = false;
        for (int i = 0; i < people.size(); i++) {
            if (getApelido(i).equals(posto)) {
                verificado = true;
                break;
            } else {
                verificado = false;
            }
        }
        //System.out.println(verificado);
        return verificado;
    }

    public boolean comparaApelido(String apelido) {
        boolean verificado = false;
        for (int i = 0; i < people.size(); i++) {
            if (getApelido(i).equals(apelido)) {
                verificado = true;
                break;
            } else {
                verificado = false;
            }
        }
        //System.out.println(verificado);
        return verificado;
    }

    public int getCcld(int indice) {
        Pessoas p = new Pessoas();
        p = people.get(indice);
        this.ccld = p.ccld;
        return ccld;
    }

    public int getCcldIndice(int ccld) {
        for (Pessoas pes : people) {
            if (people.contains(ccld)) {
                System.out.println(ccld);
            }
        }
        return ccld;
    }

    public int getLealdade(int indice) {
        Pessoas p = new Pessoas();
        p = people.get(indice);
        this.lealdade = p.lealdade;
        return lealdade;
    }

    public int getMusculo(int indice) {
        Pessoas p = new Pessoas();
        p = people.get(indice);
        this.musculo = p.musculo;
        return musculo;
    }

    public int getInteligência(int indice) {
        Pessoas p = new Pessoas();
        p = people.get(indice);
        this.inteligência = p.inteligência;
        return inteligência;
    }

    public int getEstratega(int indice) {
        Pessoas p = new Pessoas();
        p = people.get(indice);
        this.estratega = p.estratega;
        return estratega;
    }

    public int getCarisma(int indice) {
        Pessoas p = new Pessoas();
        p = people.get(indice);
        this.carisma = p.carisma;
        return carisma;
    }

    public String getApelido(int indice) {
        Pessoas p = new Pessoas();
        p = people.get(indice);
        this.apelido = p.apelido;
        return apelido;
    }

    public String getApelido(String apelido) {
        for (Pessoas pes : people) {
            if (people.contains(apelido)) {
                System.out.println(apelido);
            }
        }
        return apelido;
    }

    public String getNome(int indice) {
        Pessoas p = new Pessoas();
        p = people.get(indice);
        this.nome = p.nome;
        return nome;
    }

    public String getNome(String nome) {
        for (Pessoas pes : people) {
            if (people.contains(nome)) {
                System.out.println(nome);
            }
        }
        return nome;
    }

    public void setPosto(int indice, String posto) {
        Pessoas p = new Pessoas();
        p = people.get(indice);
        p.posto = posto;
    }

    public String getPosto(int indice) {
        Pessoas p = new Pessoas();
        p = people.get(indice);
        this.posto = p.posto;
        return posto;
    }

    public String getPosto(String posto) {
        for (Pessoas pes : people) {
            if (people.contains(posto)) {
                System.out.println(posto);
            }
        }
        return posto;
    }

        public String getSuperior(int indice) {
        Pessoas p = new Pessoas();
        p = people.get(indice);
        this.superior = p.superior;
        return superior;
    }
    
    public String getSuperior(String apelido) {
        for (Pessoas pes : people) {
            if (people.contains(superior)) {
                System.out.println(superior);
            }
        }
        return superior;
    }

    //getter das informações dos Presos
    public String getNomeP(int indice) {
        Pessoas p = new Pessoas();
        p = presos.get(indice);
        this.nome = p.nome;
        return nome;
    }

    public String getApelidoP(int indice) {
        Pessoas p = new Pessoas();
        p = presos.get(indice);
        this.apelido = p.apelido;
        return apelido;
    }
    public String getApelidoP(String apelido) {
        for (Pessoas pes : presos) {
            if (presos.contains(apelido)) {
                System.out.println(apelido);
            }
        }
        return apelido;
    }

    public String getPostoP(int indice) {
        Pessoas p = new Pessoas();
        p = presos.get(indice);
        this.posto = p.posto;
        return posto;
    }

    public int getCcldP(int indice) {
        Pessoas p = new Pessoas();
        p = presos.get(indice);
        System.out.println(p);
        this.ccld = p.ccld;
        return ccld;
    }

    public String getSuperiorP(int indice) {
        Pessoas p = new Pessoas();
        p = presos.get(indice);
        this.superior = superior;
        return superior;
    }
    
    public void retiraPessoaP(int indice) {
        if (indice >= 0 && indice < presos.size()) {
            presos.remove(indice);
        } else {
            System.out.println("Indice incorreto");
        }
    }

    //getter das informações dos Mortos
    public String getNomeO(int indice) {
        Pessoas p = new Pessoas();
        p = obituario.get(indice);
        this.nome = p.nome;
        return nome;
    }

    public String getPostoO(int indice) {
        Pessoas p = new Pessoas();
        p = obituario.get(indice);
        this.posto = p.posto;
        return posto;
    }

    public int getCcldO(int indice) {
        Pessoas p = new Pessoas();
        p = obituario.get(indice);
        this.ccld = p.ccld;
        return ccld;
    }

    public String getApelidoO(int indice) {
        Pessoas p = new Pessoas();
        p = obituario.get(indice);
        this.apelido = p.apelido;
        return apelido;
    }
    public String getApelidoO(String apelido) {
        for (Pessoas pes : obituario) {
            if (obituario.contains(apelido)) {
                System.out.println(apelido);
            }
        }
        return apelido;
    }
}
