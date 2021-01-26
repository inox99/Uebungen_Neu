/**
 * CD
 */
public class CD extends Artikel {

    private int artikelNr;
    private int bestand;
    private double preis;
    private String interpret;
    private String titel;
    private int anzahlTitel;



    CD(int artikelNr, int bestand, double preis, String interpret, String titel, int anzahlTitel) {
        if (artikelNr < 100 || artikelNr > 9999) {
            throw new IllegalArgumentException("Artikelnummer nicht 4-stellig");
        }
        if (bestand < 0) {
            throw new IllegalArgumentException("Bestand ist kleiner 0");
        }
        if (preis < 0) {
            throw new IllegalArgumentException("Preis ist kleiner 0");
        }
        if(interpret == null){
            throw new IllegalArgumentException("Kein Interpret");
        }
        if(titel == null){
            throw new IllegalArgumentException("Kein Titel");
        }
        if(anzahlTitel < 1){
            throw new IllegalArgumentException("Keine Titel");
        }

        this.artikelNr = artikelNr;
        this.bestand = bestand;
        this.preis = preis;
        this.interpret = interpret;
        this.titel = titel;
        this.anzahlTitel = anzahlTitel;
    }

    public int getArtikelNummer(){
        return artikelNr;
    }

    public int getBestand(){
        return bestand;
    }

    public double getPreis(){
        return preis;
    }

    public String getTitel(){
        return titel;
    }

    public String getInterpret(){
        return interpret;
    }

    public void setPreis(double preisNeu){
        if(preisNeu < 0){
            throw new IllegalArgumentException("Neuer Preis kleiner 0")
        }
        preis = preisNeu;
    }

    public String toString(){
        String s = "Artikelnummer: " + artikelNr + " \n" +
                   "Bestand: " + bestand + "\n" +
                   "Preis: " + preis + "\n" +
                   "Interpret: " + interpret + "\n" +
                   "Titel: " + titel + "\n" +
                   "Anzahltitel: " + anzahlTitel;
    
        return s;
    }

    

}