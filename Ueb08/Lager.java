public class Lager {

   private Artikel[] lager;

   public Lager(int dimension) {
      if (dimension < 0) {
         throw new IllegalArgumentException();
      } else {
         lager = new Artikel[dimension];
      }
   }

   public Lager() {
      lager = new Artikel[10];
   }

   public int pruefIndex() {
      for (int i = 0; i < lager.length; i++) {
         if (lager[i] == null) {
            return i;
         }
      }
      throw new IllegalArgumentException();
   }

   public void legeAnArtikel(Artikel artikel) {
      try {
         if (artikel != null) {
            lager[pruefIndex()] = artikel;
         } else {
            throw new IllegalStateException("Kein Artikel vorhanden.");
         }
      } catch (Exception e) {
         System.out.println(e.toString());
      }
   }

   public void entferneArtikel(int artikelNr) {
      for (int i = 0; i < lager.length; i++) {
         if (lager[i].getArtikelNr() == artikelNr && lager[i] != null) {
            for (int j = i + 1; j < lager.length; i++) {
               lager[j - 1] = lager[j];
            }
            lager[lager.length - 1] = null;
         }
      }
   }

   public void bucheZugang(int artikelNr, int menge) {
      for (Artikel artikel : lager) {
         if (artikel.getArtikelNr() == artikelNr) {
            artikel.bucheZugang(menge);
         }
      }
   }

   public void bucheAbgang(int artikelNr, int menge) {
      for (Artikel artikel : lager) {
         if (artikel.getArtikelNr() == artikelNr) {
            artikel.bucheAbgang(menge);
            ;
         }
      }
   }

   public void aenderePreisAllerArtikel(double prozent) {
      for (Artikel artikel : lager) {
         if (artikel != null) {
            artikel.aenderePreis(prozent);
         }
      }
   }

   public int getArtikelAnzahl() {
      int i = 0;
      for (Artikel artikel : lager) {
         if (artikel != null) {
            i++;
         }
      }
      return i;
   }

   public int getLagerGroesse() {
      int i = lager.length;
      return i;
   }

   public Artikel getArtikel(int artikelNr) {
      for (Artikel artikel : lager) {
         if (artikel != null && artikel.getArtikelNr() == artikelNr) {
            return artikel;
         }
      }
      return null;
   }

   public boolean lagerVoll() {
      boolean b = true;
      if (getArtikelAnzahl() < getLagerGroesse()) {
         b = false;
      }
      return b;
   }

   public void augebenBestandsListe() {
      String s = ("Artikelnummer \t Beschreibung \t Preis \t Bestand \t Gesamtpreis\n");
      double gesamtPreis = 0;
      for (Artikel artikel : lager) {
         if (artikel != null) {
            gesamtPreis += artikel.getBestand() * artikel.getPreis();
            s += String.format("%d \t %s \t %f \t %d \t %f \n", artikel.getArtikelNr(), artikel.getBeschreibung(),
                  artikel.getPreis(), artikel.getBestand(), artikel.getBestand() * artikel.getPreis());
         }
      }
      s += ("Gesamtpreis: " + gesamtPreis);
      System.out.println(s);
   }

   public void ausgebenBestandsListe() {
      System.out.printf("%-6s %-45s %10s  %-10s %9s\n", "ArtNr", "Beschreibung", "Preis", "Bestand", "Gesamt");
      double gesamtPreis = 0;
      for (Artikel artikel : lager) {
         if (artikel != null) {
            gesamtPreis += artikel.getBestand() * artikel.getPreis();
            System.out.printf("%5d  %-45s %10.2f %8d %12.2f\n", artikel.getArtikelNr(), artikel.getBeschreibung(),
                  artikel.getPreis(), artikel.getBestand(), artikel.getBestand() * artikel.getPreis());
         }
      }
      System.out.printf("%-77s%8.2f\n", "Gesamtwert", gesamtPreis);
   }

   @Override
   public String toString() {
      // String s = "Artikelnummer \t Beschreibung \t Preis \t Bestand \t
      // Gesamtpreis\n";
      String s = "";
      double gesamtPreis = 0;
      for (Artikel artikel : lager) {
         if (artikel != null) {
            gesamtPreis += artikel.getBestand() * artikel.getPreis();
            // s += String.format("%d \t %s \t %f \t %d \t %f \n", artikel.getArtikelNr(),
            // artikel.getBeschreibung(),
            // artikel.getPreis(), artikel.getBestand(), artikel.getBestand() *
            // artikel.getPreis());
            s += artikel.toString() + "\n";
         }
      }
      s += ("Gesamtpreis: " + gesamtPreis);
      return (s);
   }

}
