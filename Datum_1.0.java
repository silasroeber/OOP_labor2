

/**
 * Aufgabe 2 a)
 *
 * @author  Eike Hoffmann   <eike.s.hoffmann@student.fh-kiel.de>
 *          Silas Röber     <silas.roeber@student.fh-kiel.de>
 */
public class Datum {
    private int tag;    //Könnte man die 3 Werte nicht final machen wie nummer 
    private int monat;  //in Person? Ändern soll man sie ja nach dem setzen
    private int jahr;   //nicht mehr.
    private String art = "Geburtsdatum";

//------------------------------------------------------------------------------
    
    public final int getJahr() {return this.jahr;}
    public final void setJahr(final int jahr) {this.jahr = jahr;}

    public final int getMonat() {return this.monat;}
    public final void setMonat(final int monat) {this.monat = monat;}

    public final int getTag() {return this.tag;}
    public final void setTag(final int tag) {this.tag = tag;}
    
    public final String getArt() {return this.art;}
    public final void setArt(final String art) {this.art = art;}
    
//------------------------------------------------------------------------------
    
    //Aufgebläht aber effektiv ;-)
    //mir ist irgendwie nichts schöneres eingefallen
    public Datum(final int tag, final int monat, final int jahr) {
        if((1 > jahr) || (jahr > 3000)) 
            throw new IllegalArgumentException("Jahr sollte zwischen 1 und 3000 liegen");
        if((1 > monat) || (monat > 12)) 
            throw new IllegalArgumentException("Monat sollte zwischen 1 und 12 liegen");
        switch(monat) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                if((1 > tag) || (tag > 31)) 
                    throw new IllegalArgumentException("Dieser Monat hat zwischen 1 und 31 Tagen");
                else break;
            case 4: case 6: case 9: case 11:
                if((1 > tag) || (tag > 30)) 
                    throw new IllegalArgumentException("Dieser Monat hat zwischen 1 und 30 Tagen");
                else break;
            case 2:
                if((1 > tag) || (tag > 28)) 
                    throw new IllegalArgumentException("Februar hat zwischen 1 und 28 Tagen");
                else break;
            default: break;
        }
        this.setJahr(jahr);
        this.setMonat(monat);
        this.setTag(tag);
    }
    
    public Datum(final int tag, final int monat, final int jahr, final String Art) {
        this(tag, monat, jahr);
        this.setArt(Art);
    }
    
//------------------------------------------------------------------------------
    
    @Override
    public String toString() 
    {
        return String.format("%s: %d.%d.%d",  
              getArt(), getTag(), getMonat(), getJahr());
    }
    
    
    
}
