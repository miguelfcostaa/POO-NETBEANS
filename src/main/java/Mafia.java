
import java.util.*;

public class Mafia {

    public int MenuMafia() {

        int option = -1;
        Scanner scanchoice = new Scanner(System.in);
        while (option < 1 || option > 6) {
            System.out.println("---- Escolhe a familia ------");
            System.out.println("(1) - Familia Bonanno");
            System.out.println("(2) - Familia Colombo");
            System.out.println("(3) - Familia Gambino");
            System.out.println("(4) - Familia Genovese");
            System.out.println("(5) - Familia Lucchese");
            System.out.println("(6) - Voltar");
            if (scanchoice.hasNextInt()) {
                option = scanchoice.nextInt();
            }
        }
        switch (option) {
            case 1:
                System.out.println("-------- Familia Bonanno --------"); //joe bonanno
                return 1;
            case 2:
                System.out.println("-------- Familia Colombo --------"); //joseph colombo
                return 2;
            case 3:
                System.out.println("-------- Familia Gambino --------"); //Carlo Gambino
                return 3;
            case 4:
                System.out.println("-------- Familia Genevese --------"); //vito Genevese
                return 4;
            case 5:
                System.out.println("-------- Familia Lucchese --------");//Tommy lucchese
                return 5;
            case 6:
                System.out.println("Voltar");
                Familia fam = new Familia();
                fam.Menu();
            default:
                System.out.println("Opcao invalida");
        }
        return 0;
    }
    
}
