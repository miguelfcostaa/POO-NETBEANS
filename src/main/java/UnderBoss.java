
import java.util.*;

public class UnderBoss extends Pessoas {

    private Random rand = new Random();

    public void MenuUnderBoss() {
        Familia fam = new Familia();
        int option = -1;
        Scanner scanchoice = new Scanner(System.in);
        while (option < 1 || option > 5) {
            System.out.println("1- Libertar mafioso:");
            System.out.println("2- Período contabilístico:");
            System.out.println("3- Loyalty test:");
            System.out.println("4- Voltar.");
            System.out.println("Escolha a opção:");
            if (scanchoice.hasNextInt()) {
                option = scanchoice.nextInt();
            }
        }
        switch (option) {
            case 1:
                System.out.println("Libertar mafioso:");
                LibertaMafio();
                fam.Menu();
                break;
            case 2:
                System.out.println("Período contabilístico:");
                PeriodoConta();
                fam.Menu();
                break;
            case 3:
                System.out.println("Loyalty test:");
                LoyaltyTest();
                fam.Menu();
                break;
            case 4:
                System.out.println("Voltar.");
                fam.Menu();
            default:
                System.out.println("Opcao invalida");
        }
    }

    public void LibertaMafio() {
        Mafia maf = new Mafia();
        int fam = maf.MenuMafia();
        String a = "";
        switch (fam) {
            case 1:
                a = "Bonanno";
                break;
            case 2:
                a = "Colombo";
                break;
            case 3:
                a = "Gambino";
                break;
            case 4:
                a = "Genevese";
                break;
            case 5:
                a = "Lucchese";
                break;
            default:
                break;
        }
        for (int k = 0; k < getPresos().size(); k++) {
            if (getApelidoP(k).contains(getApelidoP(k))) {
                if (getPresos().size() > 0) {
                    System.out.println("(" + k + ") Pessoa: " + getNomeP(k) + "    Apelido: " + getApelidoP(k) + "    Posto: " + getPostoP(k) + "    Ccld: " + getCcldP(k));
                }
            }
        }
        Scanner c = new Scanner(System.in);

        System.out.println("Qual o encarcerado que quer libertar.");
        int m = c.nextInt();
        String preso = getApelidoP(m);
        retiraPessoaP(m);
        Custo custo = new Custo();
        custo.addCustos(new Custo(preso, "Libertado da prisão", rand.nextInt(500) + 200));
    }

    public void PeriodoConta() {
        Mafia maf = new Mafia();
        Custo c = new Custo();
        Familia familia = new Familia();
        int fam = maf.MenuMafia();
        int oldcusto = 0;
        int custo = 0;
        int result = 0;
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
        oldcusto = familia.getRiqueza().get(nome_familia);
        custo = c.getValor(nome_familia);
        result = oldcusto - custo;
        familia.getRiqueza().put(nome_familia, result);
        
        System.out.println("Riqueza Acumulada: " + oldcusto);
        System.out.println("Custos: " + custo);
        System.out.println("Riqueza Acumulada Atual: " + result);
        int y = 0;
        for (int i=0;i<c.getCustos().size();i++){
            if (nome_familia.equals(c.getFamilia("Bonanno"))){
                y++;
            }
        }
        if (y != 0){
            c.retiraCustos(nome_familia);
        }
        System.out.println("---- Loyalty Test | Familia " + nome_familia + " ----");   
        
        LoyaltyTest(nome_familia);
    }

    public void LoyaltyTest() {
        Mafia maf = new Mafia();
        int fam = maf.MenuMafia();
        int leal = 0;
        String n = "";
        String a = "";

        if (fam == 1) {
            a = "Bonanno";
        } else if (fam == 2) {
            a = "Colombo";
        } else if (fam == 3) {
            a = "Gambino";
        } else if (fam == 4) {
            a = "Genevese";
        } else if (fam == 5) {
            a = "Lucchese";
        }
        for (int i = 0; i < getPeople().size(); i++) {
            n = getApelido(i);
            if (n.equals(a)) {
                leal = getLealdade(i);
                int rand = Random();
                if (rand > leal) {
                    addObituario(getPeople(i));
                    System.out.println("Foi encontrado um informador - " + "Pessoa: " + getNome(i) + ";  Lealdade: " + getLealdade(i) + " :)");
                    retiraPessoa(i);
                }
            }
        }
        System.out.println("-> Não foram encontrados mais informadores.");
    }

    public void LoyaltyTest(String name) {

        int leal = 0;
        String n = "";
        for (int i = 0; i < getPeople().size(); i++) {
            n = getApelido(i);
            if (n.equals(name)) {
                leal = getLealdade(i);
                int rand = Random();
                if (rand > leal) {
                    addObituario(getPeople(i));
                    System.out.println("Foi encontrado um informador - " + "Pessoa: " + getNome(i) + ";  Lealdade: " + getLealdade(i) + " :)");
                    retiraPessoa(i);
                }
            }
        }
        System.out.println("-> Não foram encontrados mais informadores.");
    }

}
