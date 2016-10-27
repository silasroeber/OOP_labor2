

import java.util.Arrays;
import jdk.nashorn.internal.codegen.CompilerConstants;

/**
 * Aufgabe 2
 *
 * @author  Eike Hoffmann   <eike.s.hoffmann@student.fh-kiel.de>
 *          Silas Röber     <silas.roeber@student.fh-kiel.de>
 */
public class Labor2 {

    
    public static void ausgabe(Person[] personen) 
    {
        for( Person person : personen)
        {
            System.out.println(person);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try 
        {   
            //Eltern werden geboren
            Person personFrauTest = new Person(1,"Frau","Elisabeth","Müller",13,3,1983);
            Person personMannTest = new Person(2,"Herr","Max","Mustermann",24,12,1981);
                System.out.println("\n"
                        + "Eltern werden geboren");
                System.out.println(personFrauTest);
                System.out.println(personMannTest);
                
            //Sie heiraten
            personFrauTest.setEhepartner(personMannTest);
            personFrauTest.setNachname(personFrauTest.getEhepartner().getNachname());
                System.out.println("\n"
                        + "Sie heiraten");
                System.out.println(personFrauTest);
                System.out.println(personMannTest);

            //Sie bekomen Kinder
            Person personKind1Test = new Person(12,"Frau","Baby1","Mustermann",21,10,2016,personFrauTest,personMannTest);
            Person personKind2Test = new Person(13,"Herr","Baby2","Mustermann",22,10,2016,personFrauTest,personMannTest);
                System.out.println("\n"
                        + "Sie bekomen Kinder");
                System.out.println(personFrauTest);
                System.out.println(personMannTest);
                System.out.println(personKind1Test);
                System.out.println(personKind2Test);
            
            //Die Eltern sterben
            personMannTest.setTodDatum(22,12,2030);
            personFrauTest.setTodDatum(4,7,2032);
                System.out.println("\n"
                        + "eltern Sterben");
                System.out.println(personFrauTest);
                System.out.println(personMannTest);
                System.out.println(personKind1Test);
                System.out.println(personKind2Test);
            
            //Person[] personen = {personFrauTest,personMannTest,personKind1Test,personKind2Test};
            //ausgabe(personen);
        } 
        catch (Exception e) {System.out.println(e.getMessage() + ", bitte Daten überprüfen!");}
        
    
    
    }
    
    
}
