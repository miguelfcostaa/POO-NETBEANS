
import java.util.*;
import java.util.Scanner;

public class Boss {

    public void MenuBoss() {
        Familia fam = new Familia();
        int option = -1;
        Scanner scanchoice = new Scanner(System.in);
        while (option < 1 || option > 6) {
            System.out.println("1- Recruta Soldier:");
            System.out.println("2- Recruta CapoRegime:");
            System.out.println("3- Recruta UnderBoss:");
            System.out.println("4- Gera negócios para caporegime:");
            System.out.println("5- Nomear consigllieri:");
            System.out.println("6- Voltar.");
            System.out.println("Escolha a opção:");
            if (scanchoice.hasNextInt()) {
                option = scanchoice.nextInt();
            }
        }
        switch (option) {
            case 1:
                System.out.println("Recruta Soldier:");
                Recruta("Soldier");
                fam.Menu();
                break;
            case 2:
                System.out.println("Recruta CapoRegime:");
                Recruta("Caporegime");
                fam.Menu();
                break;
            case 3:
                System.out.println("Recruta UnderBoss:");
                Recruta("UnderBoss");
                fam.Menu();
                break;
            case 4:
                System.out.println("Gera negócios para caporegime:");
                GeraNegCap();
                fam.Menu();
                break;
            case 5:
                System.out.println("Nomear consigllieri:");
                NomearCons();
                fam.Menu();
                break;
            case 6:
                System.out.println("Voltar");
                fam.Menu();
            default:
                System.out.println("Opcao invalida");
        }
    }

    public void Recruta(String b) {
        Pessoas pes = new Pessoas();
        Mafia maf = new Mafia();
        
        String ultimoNome="";
        String superior="";
        int fam = maf.MenuMafia();
        int n = 0;
        
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
        
        if(b=="Soldier"){
            for (int i = 0; i < pes.getPeople().size(); i++) {
                if (pes.getPosto(i).contains(pes.getPosto("Caporegime")) && pes.getApelido(i).contains(pes.getApelido(ultimoNome))) {
                    System.out.println("(" + i + ") Pessoa: " + pes.getNome(i) + "   Apelido: " + pes.getApelido(i) + "   Posto: " + pes.getPosto(i) + "  CCLD: " + pes.getCcld(i));
                    n++;
                }
            }
            if(n==0){
                System.out.println("Nao existem Caporegimes. Tente recrutar um Caporegime primeiro");
                MenuBoss();
            }
            else if(n!=0){
                Scanner c = new Scanner(System.in);
                System.out.println("Escolha qual o Caporegime quer que seja o superior do Soldier");
                int m = c.nextInt();
                superior = pes.getNome(m);
            }
            
        }
        else if(b=="Caporegime"){
            for (int i = 0; i < pes.getPeople().size(); i++) {
                if (pes.getPosto(i).contains(pes.getPosto("UnderBoss")) && pes.getApelido(i).contains(pes.getApelido(ultimoNome))) {
                    System.out.println("(" + i + ") Pessoa: " + pes.getNome(i) + "   Apelido: " + pes.getApelido(i) + "   Posto: " + pes.getPosto(i) + "  CCLD: " + pes.getCcld(i));
                    n++;
                }
            }
            if(n==0){
                System.out.println("Nao existem UnderBosses. Tente recrutar um UnderBosses primeiro");
                MenuBoss();
            }
            else if(n!=0){
                Scanner c = new Scanner(System.in);
                System.out.println("Escolha qual o UnderBoss quer que seja o superior do Caporegime");
                int m = c.nextInt();
                superior = pes.getNome(m);
            }
        }
        else if(b=="UnderBoss"){
            for (int i = 0; i < pes.getPeople().size(); i++) {
                if (pes.getPosto(i).contains(pes.getPosto("Boss")) && pes.getApelido(i).contains(pes.getApelido(ultimoNome))) {
                    System.out.println("(" + i + ") Pessoa: " + pes.getNome(i) + "   Apelido: " + pes.getApelido(i) + "   Posto: " + pes.getPosto(i) + "  CCLD: " + pes.getCcld(i));
                    n++;
                }
            }
            if(n==0){
                System.out.println("Nao existem Bosses. Tente recrutar um Boss primeiro");
                MenuBoss();
            }
            else if(n!=0){
                Scanner c = new Scanner(System.in);
                System.out.println("Escolha qual o Boss quer que seja o superior do UnderBoss");
                int m = c.nextInt();
                superior = pes.getNome(m);
            }
        }
        
        Scanner s = new Scanner(System.in);
        System.out.println("Primeiro Nome:");
        String primeiroNome = s.next();
        s = new Scanner(System.in);
        System.out.println("ccld:");
        int ccld = s.nextInt();

        Pessoas a = new Pessoas(primeiroNome, ultimoNome, b, ccld,superior);
        pes.addPessoa(a);
    }

    public void GeraNegCap() {
        Negocio neg = new Negocio();
        Familia fam = new Familia();
        int option = -0;
        Scanner scanchoice = new Scanner(System.in);
        while (option < 1 || option > 4) {
            System.out.println("1- Criar Negocios Novos:");
            System.out.println("2- Ver Negocios ja criados:");
            System.out.println("3- Voltar.");
            System.out.println("Escolha a opção:");
            if (scanchoice.hasNextInt()) {
                option = scanchoice.nextInt();
            }
        }
        switch (option) {
            case 1:
                for (int i = 0; i < 3; i++) {
                    neg.criaNegocio();
                }
                System.out.println("Negocios Novos:");
                int n = neg.getNegocio().size();
                n = n - 3;
                for (int i = n; i < neg.getNegocio().size(); i++) {
                    System.out.println("----------|" + i + "|----------");
                    System.out.println("Nome: " + neg.getNome(i) + ".");
                    System.out.println("Base Tributaria: " + neg.getBaseTri(i) + ".");
                    System.out.println("Personalidade necessaria: " + neg.getPersNec(i) + ".");
                }
                Scanner c = new Scanner(System.in);
                System.out.println("Escolha o negocio que quer:");
                int m = c.nextInt();
                neg.setCapo(m);
                break;
            case 2:
                System.out.println("Ver Negocios já criados (Que ainda não estão a ser feitos) :");
                for (int i = 0; i < neg.getNegocio().size(); i++) {
                    if(neg.getOn(i).contains(neg.getOn("ON"))){
                        System.out.println("----------|" + i + "|----------");
                        System.out.println("Nome: " + neg.getNome(i) + ".");
                        System.out.println("Base Tributaria: " + neg.getBaseTri(i) + ".");
                        System.out.println("Personalidade necessaria: " + neg.getPersNec(i) + ".");
                    }
                    
                }
                Scanner f = new Scanner(System.in);
                System.out.println("Escolha o negocio que quer:");
                int k = f.nextInt();
                neg.setCapo(k);
                break;
            case 3:
                System.out.println("Voltar");
                
                fam.Menu();
            default:
                System.out.println("Opcao invalida");
        }
    }

    public void NomearCons() {
        Pessoas pessoa = new Pessoas();
        Scanner scanchoice = new Scanner(System.in);
        int option = -1;
        int n = 1;
        for (int i = 0; i < pessoa.getPeople().size(); i++) {
            if (pessoa.getPosto(i).contains(pessoa.getPosto("Associate"))) {
                System.out.println("(" + n + ") Pessoa: " + pessoa.getNome(i) + "   Apelido: " + pessoa.getApelido(i) + "   Posto: " + pessoa.getPosto(i) + "  CCLD: " + pessoa.getCcld(i));
                n++;
            }
        }
        int m = n;
        System.out.println("(" + m + ") Voltar.");
        System.out.println("Qual pertende escolher: ");
        option = scanchoice.nextInt();
        if (option != m){
            if (pessoa.getPosto(option).contains(pessoa.getPosto("Associate"))) {
                pessoa.setPosto(pessoa.getIndice(pessoa.getNome(option)),"Consigliere");
                System.out.println("Pessoa: " + pessoa.getNome(option) + "   Apelido: " + pessoa.getApelido(option) + "   Posto: " + pessoa.getPosto(option) + "  CCLD: " + pessoa.getCcld(option));
                
            }
        }
        if (option == m){
            System.out.println("(" + m + ") Voltar.");
            MenuBoss();
        }
    }
}
