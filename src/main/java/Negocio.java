import java.util.*;

public class Negocio {

    private int baseTri;
    private int rentabilidade;
    private String nome;
    private String capo;
    private String on;
    private String persoNec;
    private static ArrayList<Negocio> negocio = new ArrayList<Negocio>();

    private final String[] tipo = {"Contrabando", "Assalto", "Assasinato", "Lavagem de dinheiro", "Prostituição", "Trafico de drogas"};
    private final String[] pers = {"Inteligência" ,"Lealdade", "Carisma" , "Musculo", "Estratega"};

    private Random rand = new Random();

    public Negocio() {
        nome = "";
        capo = "";
        baseTri = 0;
        rentabilidade = 0;
        on="ON";
        persoNec="";
    }

    public Negocio(String nome, int baseTri, int rentabilidade, String capo,String on,String persoNec) {
        this.baseTri = baseTri;
        this.rentabilidade = rentabilidade;
        this.nome = nome;
        this.capo = capo;
        this.on=on;
        this.persoNec=persoNec;
    }

    public int Random() {
        int n = rand.nextInt(5000) + 2000;
        return n;
    }

    @Override
    public String toString() {
        String texto;
        texto = "";
        texto += " nome=" + nome;
        texto += " baseTri=" + baseTri;
        texto += " rentabilidade=" + rentabilidade;
        texto += " Caporegime=" + capo;
        texto += " On= " + on;
        texto += " Personalidade: " +  persoNec +'}';
        return texto;
    }

    public void criaNegocio() {
        Negocio negocio=new Negocio();
        int indice = rand.nextInt(tipo.length);
        String nome = tipo[indice];
        String capo = "";
        int baseTri = Random();
        int rentabilidade = 0;
        String on="ON";
        int a= rand.nextInt(pers.length);
        String persoNec = pers[a];
        Negocio neg = new Negocio(nome,baseTri,rentabilidade,capo,on,persoNec);
        negocio.addNegocio(neg);
    }
    
    public ArrayList<Negocio> getNegocio() {
        return negocio;
    }
    
    public Negocio getNegocio(int indice) {
        return negocio.get(indice);
    }
    
    public void addNegocio(Negocio neg){
        negocio.add(neg);
    }

    public void setCapo(int indice) {
        Pessoas pessoa = new Pessoas();
        Mafia maf = new Mafia();
        Negocio neg = new Negocio();

        String ultimoNome = "";
        String superior = "";
        int smart = 0;
        int cari = 0;
        int musc = 0;
        int leal = 0;
        int estra = 0;
        int n = 0;

        int fam = maf.MenuMafia();

        if (fam == 1) {
            ultimoNome = "Bonanno";
        } else if (fam == 2) {
            ultimoNome = "Colombo";
        } else if (fam == 3) {
            ultimoNome = "Gambino";
        } else if (fam == 4) {
            ultimoNome = "Genevese";
        } else if (fam == 5) {
            ultimoNome = "Lucchese";
        }

        for (int i = 0; i < pessoa.getPeople().size(); i++) {
            if (pessoa.getPosto(i).contains(pessoa.getPosto("Caporegime")) && pessoa.getApelido(i).contains(pessoa.getApelido(ultimoNome))) {
                System.out.println("(" + i + ") Pessoa: " + pessoa.getNome(i) + "   Apelido: " + pessoa.getApelido(i) + "   Posto: " + pessoa.getPosto(i) + "  CCLD: " + pessoa.getCcld(i));
                superior = pessoa.getNome(i);
            }
        }
        for (int i = 0; i < pessoa.getPeople().size(); i++) {
            if (pessoa.getPosto(i).contains(pessoa.getPosto("Soldier")) && pessoa.getSuperior(i).contains(pessoa.getSuperior(superior))) {
                smart = smart + pessoa.getInteligência(i);
                cari = cari + pessoa.getCarisma(i);
                musc = musc + pessoa.getMusculo(i);
                leal = leal + pessoa.getLealdade(i);
                estra = estra + pessoa.getEstratega(i);
                n++;
            } else if (pessoa.getPosto(i).contains(pessoa.getPosto("Associate")) && pessoa.getSuperior(i).contains(pessoa.getSuperior(superior))) {
                smart = smart + pessoa.getInteligência(i);
                cari = cari + pessoa.getCarisma(i);
                musc = musc + pessoa.getMusculo(i);
                leal = leal + pessoa.getLealdade(i);
                estra = estra + pessoa.getEstratega(i);
                n++;
            }
        }

        smart = smart / n;
        cari = cari / n;
        musc = musc / n;
        leal = leal / n;
        estra = estra / n;

        System.out.println("    A media das caracteristicas dos membros da equipa:");
        System.out.println("    Inteligência: " + smart + "    Carisma: " + cari + "    Musculo: " + musc + "    Lealdade: " + leal + "    Estratega: " + estra + ".");

        Scanner c = new Scanner(System.in);
        System.out.println("Escolha qual a equipa do Caporegime que que:");
        int m = c.nextInt();

        neg = negocio.get(indice);
        neg.capo = pessoa.getNome(m);
        neg.on="OFF";

        neg.setRentabilidade(neg.calculoRentabilidade(indice), indice);
        ganhaDinheiro(ultimoNome,indice);
        Familia familia = new Familia();
    }
    
    public void ganhaDinheiro(String nome, int indice){
        Negocio neg = new Negocio();
        neg = getNegocio(indice);
        int i = neg.getRentabilidade(indice);
        int j = neg.getBaseTri(indice);
        int valor = j + (j*(i/100));
        Familia fam = new Familia();
        fam.addRiqueza(nome, + valor);
    }
    
    public String getCapo(int indice) {
        Negocio neg = new Negocio();
        neg = negocio.get(indice);
        this.capo = neg.capo;
        return capo;
    }
    
    public String getCapo(String nome) {
        for (Negocio neg : negocio) {
            if (negocio.contains(nome)) {
                System.out.println(nome);
            }
        }
        return nome;
    }

    public String[] selecionaTipoNegocio(int indice) {
        System.out.println(tipo[indice]);
        return tipo;
    }

    public int getBaseTri(int indice) {
        Negocio neg = new Negocio();
        neg = negocio.get(indice);
        this.baseTri = neg.baseTri;
        return baseTri;
    }
    
    public int setBaseTri(int indice, int valor){
        Negocio neg = new Negocio();
        neg = negocio.get(indice);
        this.baseTri += valor;
        return baseTri;
    }

    public int getRentabilidade(int indice) {
        Negocio neg = new Negocio();
        neg = negocio.get(indice);
        this.rentabilidade = neg.rentabilidade;
        return rentabilidade;
    }

    public void setRentabilidade(int rentabilidade, int indice) {
        Negocio neg = new Negocio();
        neg = negocio.get(indice);
        neg.rentabilidade = rentabilidade;

    }

    public int calculoRentabilidade(int indice) {
        Pessoas p = new Pessoas();
        String n = "";
        n = getCapo(indice);
        int musc = 0;
        int smart = 0;
        int estra = 0;

        for (int i = 0; i < p.getPeople().size(); i++) {
            if (p.getSuperior(i).contains(p.getSuperior(n))) {
                smart = smart + p.getInteligência(i);
                musc = musc + p.getMusculo(i);
                estra = estra + p.getEstratega(i);
            }
        }

        rentabilidade = rentabilidade + musc + smart + estra;
        rentabilidade = rentabilidade / 3;

        if (rentabilidade >= 100) {
            rentabilidade = 100;
        }
        if (rentabilidade <= 0) {
            rentabilidade = 0;
        }

        return rentabilidade;
    }
    
    public String getNome(int indice){
        Negocio neg = new Negocio();
        neg = negocio.get(indice);
        this.nome=neg.nome;
        return nome;
    }
    
    public String getNome(String nome) {
        for (Negocio neg : negocio) {
            if (negocio.contains(nome)) {
                System.out.println(nome);
            }
        }
        return nome;
    }
    
    public String getOn(int indice){
        Negocio neg = new Negocio();
        neg=negocio.get(indice);
        this.on=neg.on;
        return on;
    }
    
    public String getOn(String on) {
        for (Negocio neg : negocio) {
            if (negocio.contains(on)) {
                System.out.println(on);
            }
        }
        return on;
    }
    
    public String getPersNec(int indice){
        Negocio neg = new Negocio();
        neg = negocio.get(indice);
        this.persoNec=neg.persoNec;
        return persoNec;
    }
}