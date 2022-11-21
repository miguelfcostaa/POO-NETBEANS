
import java.util.*;

public class Familia extends Pessoas {
    
    private static HashMap<String, Integer> riqueza = new HashMap<>();
    private Random rand = new Random();

    public HashMap<String, Integer> getRiqueza() {
        return riqueza;
    }
    
    public Integer addRiqueza(String familia, int riquezaAcumulada) {
        return riqueza.put(familia, riquezaAcumulada);
    }
    

    public void Menu() {
        Boss boss = new Boss();
        Consigliere con = new Consigliere();
        UnderBoss und = new UnderBoss();
        int option = -1;
        Scanner scanchoice = new Scanner(System.in);
        while (option < 1 || option > 5) {
            System.out.println("---------------");
            System.out.println("Escolhe o menu: ");
            System.out.println("(1) - Boss");
            System.out.println("(2) - UnderBoss");
            System.out.println("(3) - Consigliere");
            System.out.println("(4) - Familia");
            System.out.println("Escolha a opção:");
            if (scanchoice.hasNextInt()) {
                option = scanchoice.nextInt();
            }
        }
        switch (option) {
            case 1:
                System.out.println("---- Boss ----");
                boss.MenuBoss();
                break;
            case 2:
                System.out.println("---- UnderBoss ----");
                und.MenuUnderBoss();
                break;
            case 3:
                System.out.println("---- Consigliere ----");
                con.MenuConsigliere();
                break;
            case 4:
                System.out.println("---- Familia ----");
                MenuFamilia();
                break;
            default:
                System.out.println("---- Opcao invalida ----");
                break;
        }
    }

    public void MenuFamilia() {
        int option = -1;
        Scanner scanchoice = new Scanner(System.in);
        while (option < 1 || option > 9) {
            System.out.println("(1) - Retrato de família");
            System.out.println("(2) - Plano de negócios");
            System.out.println("(3) - Mapa de custos");
            System.out.println("(4) - Espírito de equipa");
            System.out.println("(5) - Obituário");
            System.out.println("(6) - Encarcerados");
            System.out.println("(7) - All out war");
            System.out.println("(8) - Sair da aplicação");
            System.out.println("Escolha a opção:");
            if (scanchoice.hasNextInt()) {
                option = scanchoice.nextInt();
            }
        }
        switch (option) {
            case 1:
                System.out.println("--- Retrato de família ---");
                Retrato();
                Menu();
                break;
            case 2:
                System.out.println("---- Plano de negócios ----");
                PlanoNegocios();
                Menu();
                break;
            case 3:
                System.out.println("---- Mapa de custos ----");
                MapaCustos();
                Menu();
                break;
            case 4:
                System.out.println("---- Espírito de equipa ----");
                EspiritoEquipa();
                Menu();
                break;
            case 5:
                System.out.println("---- Obituário ----");
                Obituario();
                Menu();
                break;
            case 6:
                System.out.println("Encarcerados:");
                Encarcerados();
                Menu();
                break;
            case 7:
                System.out.println("All out war:");
                Menu();
                break;
            case 8:
                System.exit(0);
                Menu();
                break;
            default:
                System.out.println("Opcão invalida");
        }
    }

    public void Retrato() {
        Custo c = new Custo();
        Negocio neg = new Negocio();
        Mafia maf = new Mafia();
        int n = 1;
        int fam = maf.MenuMafia();
        String nome_familia = "";
        switch (fam) {
            case 1:
                nome_familia = "Bonanno";
                break;
            case 2:
                nome_familia = "Colombo";
                break;
            case 3:
                nome_familia = "Gambino";
                break;
            case 4:
                nome_familia = "Genevese";
                break;
            case 5:
                nome_familia = "Lucchese";
                break;
            default:
                break;
        }
        for (int i = 0; i < getPeople().size(); i++) {
            if (getApelido(i).contains(getApelido(nome_familia))) {
                System.out.println("(" + n + ") Pessoa: " + getNome(i) + "   Apelido: " + getApelido(i) + "   Posto: " + getPosto(i) + "  CCLD: " + getCcld(i) + "  Superior: " + getSuperior(i));
                n++;
            }
        }   
        System.out.println("> Obituario:");
        for (int j = 0; j < getObituario().size(); j++) {
            if (getApelidoO(j).contains(getApelidoO(nome_familia))) {
                if (getObituario().size() > 0) {
                    System.out.println("(" + n + ") Pessoa: " + getNomeO(j) + "    Apelido: " + getApelidoO(j) + "    Posto: " + getPostoO(j) + "    Ccld: " + getCcldO(j));
                    n++;
                }
                if (n==0) {
                    System.out.println("Não há mortos.");
                }
            }
        }   
        System.out.println("> Encarcerados:");
        for (int k = 0; k < getPresos().size(); k++) {
            if (getApelidoP(k).contains(getApelidoP(nome_familia))) {
                if (getPresos().size() > 0) {
                    System.out.println("(" + n + ") Pessoa: " + getNomeP(k) + "    Apelido: " + getApelidoP(k) + "    Posto: " + getPostoP(k) + "    Ccld: " + getCcldP(k));
                    n++;
                }
                if (n==0) {
                    System.out.println("Não há presos.");
                }
            }
        }   
        System.out.println("> Negócios:" );
        String name="";
        for (int j = 0; j<getPeople().size();j++){
            if (getApelido(j).contains(getApelido(nome_familia)) && getPosto(j).contains(getPosto("CapoRegime"))) {
                name=getNome(j);
            }
        }
        for (int k = 0; k < neg.getNegocio().size(); k++) {
                    if (neg.getCapo(k).contains(neg.getCapo(name)) && neg.getOn(k).contains(neg.getOn("OFF"))) {
                        System.out.println(" (" + n + ") Nome: " + neg.getNome(k) + "    Base Tributaria: " + neg.getBaseTri(k) + "    Personalidade: " + neg.getPersNec(k) + "    CapoRegime: " + neg.getCapo(k));
                        n++;
                        for (int i = 0; i<getPeople().size();i++){
                                if (getApelido(i).contains(getApelido(nome_familia)) && getPosto(i).contains(getPosto("Caporegime"))) {
                                    System.out.println("-> CapoRegime dentro do negocio: ");
                                    System.out.println(getPeople(i) + ".");
                                }
                            }
                        for (int b = 0; b<getPeople().size();b++){
                            if (getApelido(b).contains(getApelido(nome_familia)) && getPosto(b).contains(getPosto("Soldier")) && getSuperior(b).contains(getSuperior(name))) {
                                System.out.println("-> Soldiers dentro do negocio: ");
                                System.out.println(getPeople(b) + ".");
                            }
                        }
                        for (int b = 0; b<getPeople().size();b++){
                            if (getApelido(b).contains(getApelido(nome_familia)) && getPosto(b).contains(getPosto("Associate")) && getSuperior(b).contains(getSuperior(name))) {
                                System.out.println("-> Associates dentro do negocio: ");
                                System.out.println(getPeople(b) + ".");
                            }
                        }
                    }
                }
       System.out.println("> Custos: " + c.getValor(nome_familia));
       System.out.println("> Riqueza acumulada: " + getRiqueza().get(nome_familia));
    }

    public void PlanoNegocios() {
        Mafia maf = new Mafia();
        Negocio neg = new Negocio();
        int fam = maf.MenuMafia();
        String nome_familia = "";
        switch (fam) {
            case 1:
                nome_familia = "Bonanno";
                break;
            case 2:
                nome_familia = "Colombo";
                break;
            case 3:
                nome_familia = "Gambino";
                break;
            case 4:
                nome_familia = "Genevese";
                break;
            case 5:
                nome_familia = "Lucchese";
                break;
            default:
                break;
        }
        System.out.println("> NegÃ³cios:" );
        String name="";
        int n=0;
        for (int j = 0; j<getPeople().size();j++){
            if (getApelido(j).contains(getApelido(nome_familia)) && getPosto(j).contains(getPosto("CapoRegime"))) {
                name=getNome(j);
            }
        }
        for (int k = 0; k < neg.getNegocio().size(); k++) {
            if (neg.getCapo(k).contains(neg.getCapo(name)) && neg.getOn(k).contains(neg.getOn("OFF"))) {
                if (neg.getNegocio().size() > 0) {
                    System.out.println(" (" + n + ") Nome: " + neg.getNome(k) + "    Base Tributaria: " + neg.getBaseTri(k) + "    Personalidade: " + neg.getPersNec(k) + "    CapoRegime: " + neg.getCapo(k));
                    n++;
                    for (int j = 0; j<getPeople().size();j++){
                        if (getApelido(j).contains(getApelido(nome_familia)) && getPosto(j).contains(getPosto("Caporegime"))) {
                        System.out.println("-> CapoRegime dentro do negocio: ");
                        System.out.println(getPeople(j) + ".");
                        }
                    }
                    for (int b = 0; b<getPeople().size();b++){
                         if (getApelido(b).contains(getApelido(nome_familia)) && getPosto(b).contains(getPosto("Soldier")) && getSuperior(b).contains(getSuperior(name))) {
                            System.out.println("-> Soldiers dentro do negocio: ");
                            System.out.println(getPeople(b) + ".");
                        }
                    }
                    for (int b = 0; b<getPeople().size();b++){
                        if (getApelido(b).contains(getApelido(nome_familia)) && getPosto(b).contains(getPosto("Associate")) && getSuperior(b).contains(getSuperior(name))) {
                            System.out.println("-> Associates dentro do negocio: ");
                            System.out.println(getPeople(b) + ".");
                        }
                    }
                }
            }
        }
    }

    public void MapaCustos() {
        Custo c = new Custo();
        Mafia maf = new Mafia();
        int n = 1;
        int fam = maf.MenuMafia();
        String nome_familia = "";
        switch (fam) {
            case 1:
                nome_familia = "Bonanno";
                break;
            case 2:
                nome_familia = "Colombo";
                break;
            case 3:
                nome_familia = "Gambino";
                break;
            case 4:
                nome_familia = "Genevese";
                break;
            case 5:
                nome_familia = "Lucchese";
                break;
            default:
                break;
        }
        if (c.getCustos().isEmpty()) {
            System.out.println("Custos: 0");
        }
        else if (c.getCustos().size() > 0) {
            for (int i=0;i<c.getCustos().size();i++){
                if (c.getFamilia(i).contains(c.getFamilia(nome_familia))){
                    System.out.println(c.getCustos(i));
                }
            }
        }
    }

    public void EspiritoEquipa() {
        Mafia maf = new Mafia();
        int fam=maf.MenuMafia();
        String ultimoNome="";
        String superior="";
        
        switch (fam) {
            case 1:
                ultimoNome = "Bonanno";
                break;
            case 2:
                ultimoNome = "Colombo";
                break;
            case 3:
                ultimoNome = "Gambino";
                break;
            case 4:
                ultimoNome = "Genevese";
                break;
            case 5:
                ultimoNome = "Lucchese";
                break;
            default:
                break;
        }
        int n = 0;
        for (int i =0;i<getPeople().size();i++){
            if (getPosto(i).contains(getPosto("Caporegime")) && getApelido(i).contains(getApelido(ultimoNome))) {
                    System.out.println("(" + n + ") Pessoa: " + getNome(i) + "   Apelido: " + getApelido(i) + "   Posto: " + getPosto(i) + "  CCLD: " + getCcld(i));
            }
        }
        
        Scanner c = new Scanner(System.in);
        System.out.println("Escolha qual a equipa do Caporegime vai querer?");
        int m = c.nextInt();
        superior = getNome(m);
        for(int i=0;i<getPeople().size();i++){
            System.out.println("Equipa: ");
            if (getPosto(i).contains(getPosto("Soldier")) && getSuperior(i).contains(getSuperior(superior))) {
                System.out.println("(" + i + ") Pessoa: " + getNome(i) + "   Apelido: " + getApelido(i) + "   Posto: " + getPosto(i) + "  CCLD: " + getCcld(i));
            }
            else if (getPosto(i).contains(getPosto("Associate")) && getSuperior(i).contains(getSuperior(superior))) {
                System.out.println("(" + i + ") Pessoa: " + getNome(i) + "   Apelido: " + getApelido(i) + "   Posto: " + getPosto(i) + "  CCLD: " + getCcld(i));
            }
        }
    }

    public void Obituario() {
        Pessoas p = new Pessoas();
        for (int i = 0; i < p.getObituario().size(); i++) {
            System.out.println("Pessoa: " + getNomeO(i) + "    Apelido: " + getApelidoO(i) + "    Posto: " + getPostoO(i) + "    Ccld: " + getCcldO(i));
        }
    }

    public void Encarcerados() {
        Pessoas p = new Pessoas();
        for (int i = 0; i < p.getPresos().size(); i++) {
            System.out.println("Pessoa: " + getNomeP(i) + "    Apelido: " + getApelidoP(i) + "    Posto: " + getPostoP(i) + "    Ccld: " + getCcldP(i));
        }
    }

    public void AllOfWar() {
    }

    public int Random() {
        int n = rand.nextInt(10000) + 1000;
        return n;
    }
}
