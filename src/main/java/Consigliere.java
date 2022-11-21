import java.util.*;

public class Consigliere {

    public void MenuConsigliere() {
        Familia fam = new Familia();
        int option = -1;
        Scanner scanchoice = new Scanner(System.in);
        while (option < 1 || option > 3) {
            System.out.println("(1) - Expandir negócio:");
            System.out.println("(2) - Mafia sitdown:");
            System.out.println("(3) - Voltar.");
            System.out.println("Escolha a opção:");
            if (scanchoice.hasNextInt()) {
                option = scanchoice.nextInt();
            }
        }
        switch (option) {
            case 1:
                System.out.println("Expandir negócio:");
                ExpandirNegocio();
                fam.Menu();
                break;
            case 2:
                System.out.println("Mafia sitdown:");
                fam.Menu();
                break;
            case 3:
                System.out.println("Voltar.");
                fam.Menu();
                break;
            default:
                System.out.println("Opcao invalida");
        }
    }

    public void ExpandirNegocio() {
        Random rand = new Random();
        Pessoas pessoa = new Pessoas();
        Negocio neg = new Negocio();
        for (int i = 0; i < pessoa.getPeople().size(); i++) {
            if (pessoa.getPosto(i).contains(pessoa.getPosto("Consigliere"))) {
                if (pessoa.getEstratega(i) > 60 ){
                    neg.setBaseTri(i, rand.nextInt(1000) + 500);
                    System.out.println("Pessoa: " + pessoa.getNome(i)+ "    Estratega: " + pessoa.getEstratega(i));
                    System.out.println("Negocio: " + neg.getNome(i) + "    Base Tributavel atualizada: " + neg.getBaseTri(i));
                }
                else if (pessoa.getEstratega(i) > 40){
                    neg.setBaseTri(i, rand.nextInt(700) + 300);
                    System.out.println("Pessoa: " + pessoa.getNome(i)+ "    Estratega: " + pessoa.getEstratega(i));
                    System.out.println("Negocio: " + neg.getNome(i) + "    Base Tributavel atualizada: " + neg.getBaseTri(i));
                }
                else if (pessoa.getEstratega(i) < 40) {
                    System.out.println("Não há Consiglieres com Estratega suficiente.");
                }
            }
        }
    }

    public void MafiaSitdown() {
    }

}