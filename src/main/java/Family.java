
import java.util.Random;
import java.util.Set;

public class Family {
    
    public static void main(String[] args) {
        Pessoas pessoa = new Pessoas();
        Familia familia = new Familia();
        
        Pessoas boa = new Pessoas("Luisovski", "Colombo", "Caporegime", 10000012,"Miguel");
        pessoa.addPessoa(boa);
        Pessoas bonann = new Pessoas("Marcio","Bonanno","Consigliere",30000000,"Miguel");
        pessoa.addPessoa(bonann);
        Pessoas bonanno2 = new Pessoas("Rodrigo","Bonanno","Associate",30000000,"Miguel");
        pessoa.addPessoa(bonanno2);
        Pessoas bonanno3 = new Pessoas("Pedro","Bonanno","Associate",24000000,"Miguel");
        pessoa.addPessoa(bonanno3);
        Pessoas bonanno4 = new Pessoas("Inês","Bonanno","UnderBoss",13000000,"Joe");
        pessoa.addPessoa(bonanno4);
        Pessoas bonanno5 = new Pessoas("Miguel","Bonanno","Caporegime",12000000,"Inês");
        pessoa.addPessoa(bonanno5);
        Pessoas bonanno = new Pessoas("Joe", "Bonanno", "Boss", 10000000,"none",100,100,100,100,100);
        pessoa.addPessoa(bonanno);
        Pessoas colombo = new Pessoas("Joseph", "Colombo", "Boss", 22000000,"none",100,100,100,100,100);
        pessoa.addPessoa(colombo);
        Pessoas colombo2 = new Pessoas("Simao", "Colombo", "UnderBoss", 20030000,"Joseph");
        pessoa.addPessoa(colombo2);
        Pessoas gambino = new Pessoas("Carlo", "Gambino", "Boss", 24000000,"none",100,100,100,100,100);
        pessoa.addPessoa(gambino);
        Pessoas gambino2 = new Pessoas("Manel", "Gambino", "UnderBoss", 20000000,"Carlo");
        pessoa.addPessoa(gambino2);
        Pessoas genevese = new Pessoas("Vito", "Genevese", "Boss", 40000000,"none",100,100,100,100,100);
        pessoa.addPessoa(genevese);
        Pessoas lucchese = new Pessoas("Tommy", "Lucchese", "Boss", 50000000,"none",100,100,100,100,100);
        pessoa.addPessoa(lucchese);
        
        familia.addRiqueza("Bonanno", familia.Random());
        familia.addRiqueza("Colombo", familia.Random());
        familia.addRiqueza("Gambino", familia.Random());
        familia.addRiqueza("Genevese", familia.Random());
        familia.addRiqueza("Lucchese", familia.Random()); 
        
       
        Custo custo = new Custo();
        Custo c = new Custo("Bonanno","Lealdade menor que 20", 350);
        custo.addCustos(c);
        Custo c2 = new Custo("Bonanno","Lealdade menor que 30", 150);
        custo.addCustos(c2);
        Custo c3 = new Custo("Bonanno","Lealdade menor que 10", 350);
        custo.addCustos(c3);
        Custo c4 = new Custo("Colombo","Mal-comportado", 350);
        custo.addCustos(c4);
        
        System.out.println(familia.getRiqueza());
        familia.Menu();
    }
    
}