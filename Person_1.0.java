

import java.util.Arrays;


/**
 * Aufgabe 2
 *
 * @author  Eike Hoffmann   <eike.s.hoffmann@student.fh-kiel.de>
 *          Silas Röber     <silas.roeber@student.fh-kiel.de>
 */
public class Person {

    
    private final int personalNr;
    private String anrede;
    private String vorname;
    private String nachname;
    private Datum gebDatum;
    // b)
    private Datum todDatum = null;
    private Person ehepartner = null;
    private Person vater = null;
    private Person mutter = null;
    private Person[] kinder = null; 
    
//----------------------------------------------------------------------------------
   
    public final int getPersonalNr() {return this.personalNr;}
    
    public final void setAnrede (final String anrede) {this.anrede = anrede;}
    public final String getAnrede() {return this.anrede;}
    
    public final void setVorname (final String vorname) {this.vorname = vorname;}
    public final String getVorname() {return this.vorname;}
    
    public final void setNachname (final String nachname) {this.nachname = nachname;}
    public final String getNachname() {return this.nachname;}
    
    public final Datum getGebDatum() {return this.gebDatum;}
    //Der folgende setter wird eigentlich nicht benötigt da immer ein Geburtsdatum
    //beim Erstellen eines Exemplars von Person mit angegeben wird.
    private void setGebDatum(final int gTag, final int gMonat, final int gJahr)
    {
        if(this.gebDatum != null) System.out.println("Ein Geburtsdatum kann nicht geändert werden!");
        else this.gebDatum = new Datum(gTag, gMonat, gJahr);
    }
    
    public final Datum getTodDatum() {return this.todDatum;}
    public final void setTodDatum(final int gTag, final int gMonat, final int gJahr)
    {
        if(this.todDatum != null) System.out.println("Ein Todedatum kann nicht geändert werden!");
        else this.todDatum = new Datum(gTag, gMonat, gJahr, "Todesdatum");
    }
    
//------------------------------------------------------------------------------
// b)
    public final void setEhepartner(Person ehepartner) {
        this.ehepartner = ehepartner;
        if(this.ehepartner.getEhepartner() != this) this.ehepartner.setEhepartner(this);
    }
    public final Person getEhepartner() {return this.ehepartner;}

    public final void setVater(Person vater) {
        this.vater = vater;
        this.vater.setKinder(this);
    }
    public Person getVater() {return this.vater;}

    public final void setMutter(Person mutter) {
        this.mutter = mutter;
        this.mutter.setKinder(this);
    }
    public final Person getMutter() {return this.mutter;}

    public final void setKinder(Person kind) {
        if(this.kinder != null)
        {
            for(int i=0; i < this.kinder.length; i++)
            {
                if(this.kinder[i] == null) 
                {    
                    this.kinder[i] = kind; 
                    break;
                }
            }
        } 
        else
        {
            this.kinder = new Person[20];
            Arrays.fill(this.kinder, null);
            this.kinder[0] = kind;
        }
    }
    public final Person[] getKinder() {return this.kinder;}
 
//------------------------------------------------------------------------------

//Konstruktoren in die eine Richtung
/*   
    public Person(final int nummer)
    {
        this(nummer,"Miss");
    }
    
    public Person   (final int nummer,
                    final String anrede)
    {
        this(nummer,anrede,"Duck");
    }
    
    public Person   (final int nummer,
                    final String anrede,
                    final String nachname)
    {
        this(nummer,anrede,anrede.equals("Miss")?"Daisy":"Donald",nachname);
    }
    
    public Person   (final int nummer,
                    final String anrede,
                    final String vorname,
                    final String nachname)
    {
        this.personalNr = nummer;
        this.setAnrede (anrede);
        this.setVorname (vorname);
        this.setNachname (nachname);
    }
*/

//-------------------------------------------------------------------------------

//und in die andere Richtung
    public Person(final int nummer)
    {
        this.personalNr = nummer;
        this.setAnrede("Miss");
        this.setVorname("Daisy");
        this.setNachname("Duck");
        
    }    

    public Person   (final int nummer,
                    final String anrede)
    {
        this(nummer);
        this.setAnrede(anrede);
        this.setVorname(anrede.equals("Miss")?"Daisy":"Donald");
    }
    
    public Person   (final int nummer,
                    final String anrede,
                    final String nachname)
    {
        this(nummer,anrede);
        this.setNachname(nachname);
    }
    
    public Person (final int nummer,
                    final String anrede,
                    final String vorname,
                    final String nachname)
    {
        this(nummer,anrede,nachname);
        this.setVorname(vorname);
    }
    
    public Person (final int nummer,
                    final String anrede,
                    final String vorname,
                    final String nachname,
                    final int gTag,
                    final int gMonat,
                    final int gJahr)
    {
        this(nummer,anrede,vorname,nachname);
        this.gebDatum = new Datum(gTag, gMonat, gJahr);
    }
    
    public Person (final int nummer,
                    final String anrede,
                    final String vorname,
                    final String nachname,
                    final int gTag,
                    final int gMonat,
                    final int gJahr,
                    final int tTag,
                    final int tMonat,
                    final int tJahr)
    {
        this(nummer,anrede,vorname,nachname,gTag,gMonat,gJahr);
        this.todDatum = new Datum(tTag,tMonat,tJahr,"Sterbedatum");
    }
    
    public Person (final int nummer,
                    final String anrede,
                    final String vorname,
                    final String nachname,
                    final int gTag,
                    final int gMonat,
                    final int gJahr,
                    final Person mutter,
                    final Person vater)
    {
        this(nummer,anrede,vorname,nachname,gTag,gMonat,gJahr);
        this.setMutter(mutter);
        this.setVater(vater);
    }
    
    //--------------------------------------------------------------------------
    
    private final String lebtNoch() 
    {
        if(getTodDatum() != null) return getTodDatum().toString();
        else return "Todesdatum: lebt noch";
    }
    
    public final String ausgabeMutterName()
    {   
        if (this.getMutter() != null) 
        {
            return this.getMutter().getVorname()+" "+this.getMutter().getNachname();
        }
        else return "keine";
    }
    
    public final String ausgabeVaterName()
    {   
        if (this.getVater() != null) 
        {
            return this.getVater().getVorname()+" "+this.getVater().getNachname();
        }
        else return "keinen";
    }
    
    public final String ausgabeEhepartnerName()
    {   
        if (this.getEhepartner() != null) 
        {
            return this.getEhepartner().getVorname()+" "+this.getEhepartner().getNachname();
        }
        else return "keinen";
    }
    
    public final String[] ausgebeKinderName()
    {
        String[] kinderNamen = null;
        
        if(this.getKinder() != null){
            int anzahlKinder = 0;
            for(Person pos : this.getKinder())
            {
                if(pos != null) anzahlKinder++;
            }
            if(anzahlKinder > 0) //Sollte eigentlich nicht möglich sein wenn getKinder()!=null
            {
                kinderNamen = new String[anzahlKinder];
            }
            
            int i = 0;
            for(Person pos : this.getKinder())
            {
                if (i >= anzahlKinder) break;
                else 
                {
                    kinderNamen[i] = pos.getVorname()+" "+pos.getNachname();
                    i++;
                }
            }
        }
        else kinderNamen = new String[] {"keine"};
          
        return kinderNamen;
    }

    
    @Override
    public String toString() 
    {
        return String.format("[%d, %s, %s, %s, %s, %s]"
                + "%n Kinder: %s"
                + "%n Ehepartner: %s"
                + "%n Mutter: %s,  Vater: %s",  
             getPersonalNr(), getAnrede(), getVorname(), getNachname(), 
             getGebDatum().toString(), lebtNoch(), Arrays.toString(ausgebeKinderName()), 
             ausgabeEhepartnerName(),ausgabeMutterName(),ausgabeVaterName());
    }
    
    
    
}
