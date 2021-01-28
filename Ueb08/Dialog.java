import java.util.Scanner;

// public class Dialog {

//    public int leseInt() {
//       Scanner input = new Scanner(System.in);
//       int intEingabe = input.nextInt();
//       input.close();
//       return intEingabe;
//    }

//    public String leseString() {
//       Scanner input = new Scanner(System.in);
//       String stringEingabe = input.nextLine();
//       input.close();
//       return stringEingabe;
//    }

//    public double leseDouble() {
//       Scanner input = new Scanner(System.in);
//       double doubleEingabe = input.nextDouble();
//       input.close();
//       return doubleEingabe;
//    }

//    public int leseArtikelNr() {
//       System.out.print("Artikelnummer: ");
//       int geleseneArtikelNr = leseInt();
//       return geleseneArtikelNr;
//    }

//    public String leseBezeichnung() {
//       System.out.print("Bezeichnung: ");
//       String geleseneBezeichnung = leseString();
//       return geleseneBezeichnung;
//    }

//    public int leseBestand() {
//       System.out.print("Bestand: ");
//       int gelesenerBestand = leseInt();
//       return gelesenerBestand;
//    }

//    public int leseMenge() {
//       System.out.print("Menge: ");
//       int geleseneMenge = leseInt();
//       return geleseneMenge;
//    }

//    public int leseNutzerEingabe() {
//       System.out.print("Auswahl: ");
//       int geleseneNutzerEingabe = leseInt();
//       return geleseneNutzerEingabe;
//    }

//    public double lesePreis() {
//       System.out.print("Preis: ");
//       double gelesenerPreis = leseDouble();
//       return gelesenerPreis;

//    }

//    public Artikel kontruiereArtikel4() {
//       return new Artikel(leseArtikelNr(), leseBezeichnung(), leseBestand(), lesePreis());
//    }

//    public Artikel konstruiereArtikel3() {
//       return new Artikel(leseArtikelNr(), leseBezeichnung(), leseBestand());
//    }

//    public Artikel konstruiereArtikel2() {
//       return new Artikel(leseArtikelNr(), leseBezeichnung());
//    }

//    public void start() {
//       final int ARTIKELMIT = 1;
//       final int ARTIKELOHNE = 2;
//       final int ZUBUCHEN = 3;
//       final int ABBUCHEN = 4;
//       final int SHOWARTIKEL = 5;
//       final int BEENDEN = 0;
//       Artikel a1 = null;
//       int eingabe = -1;

//       while (eingabe != BEENDEN) {
//          System.out.println("Artikel mit Bestand :   " + ARTIKELMIT + "   Artikel ohne Bestand   " + ARTIKELOHNE
//                + "   Bestand zubuchen   " + ZUBUCHEN + "   Bestand abbuchen   " + ABBUCHEN + "   Artikel anzeigen   "
//                + SHOWARTIKEL + "   Beenden   " + BEENDEN);
//          try {
//             eingabe = leseNutzerEingabe();
//             if (eingabe == ARTIKELMIT) {
//                a1 = kontruiereArtikel4();
//             } else if (eingabe == ARTIKELOHNE) {
//                a1 = konstruiereArtikel3();
//             } else if (eingabe == ZUBUCHEN) {
//                if (a1 != null) {
//                   a1.bucheZugang(leseMenge());
//                } else {
//                   throw new IllegalStateException("Kein Artikel vorhanden");
//                }
//             } else if (eingabe == ABBUCHEN) {
//                if (a1 != null) {
//                   a1.bucheAbgang(leseMenge());
//                } else {
//                   throw new IllegalStateException("Kein Artikel vorhanden");
//                }
//             } else if (eingabe == SHOWARTIKEL) {
//                if (a1 != null) {
//                   System.out.println(a1);
//                } else {
//                   throw new IllegalStateException("Kein Artikel vorhanden");
//                }
//             } else if (eingabe == BEENDEN) {
//                return;
//             } else if (eingabe > 6) {
//                throw new IllegalStateException("Keine Funktion mit der Nummer vorhanden");
//             }
//          } catch (Exception e) {
//             System.out.println(e.toString());
//          }
//       }
//    }

public class Dialog {
   Scanner input = new Scanner(System.in);
   final Lager lager = new Lager(10);

   public Dialog() {

   }

   protected void finalize() {
      input.close();
   }

   public int leseInt(String hint) {
      System.out.print(hint);
      int intEingabe = input.nextInt();
      input.nextLine();
      return intEingabe;
   }

   public String leseString(String hint) {
      System.out.print(hint);
      String Eingabe = input.nextLine();
      return Eingabe;
   }

   public double leseDouble(String hint) {
      System.out.print(hint);
      double doubleEingabe = input.nextDouble();
      input.nextLine();
      return doubleEingabe;
   }

   public Video leseVideo() {
      System.out.print("Daten für Video eingeben\n");
      // Video(artikelNr, bestand, preis, titel, spieldauer, jahr)
      Video video = new Video(leseInt("\tArtikel-Nr: "), // artikelNr,
            leseInt("\tBestand: "), // bestand,
            leseDouble("\tEinzel-Preis: "), // preis,
            leseString("\tTitel: "), // titel,
            leseInt("\tSpieldauer [min]: "), // spieldauer,
            leseInt("\tErscheinungsjahr: ") // jahr
      );
      return video;
   }

   public void MainMenu() {
      final int MM_ENDE = 0;
      final int MM_AUSGABEBESTAND = 1;
      final int MM_AUSGABELAGER = 2;
      final int MM_NEUARTIKEL = 3;
      final int M1_NEUARTIKEL_ARTIKEL = 1;
      final int MM_NEUARTIKEL_VIDEO = 2;
      final int MM_NEUARTIKEL_CD = 3;
      final int MM_NEUARTIKEL_BUCH = 4;
      while (true) {
         switch (leseInt(
               String.format("\nFunktion wählen %d: Ende, %d: Bestandsliste, %d: Lagerliste, %d: neuer Artikel\t",
                     MM_ENDE, MM_AUSGABEBESTAND, MM_AUSGABELAGER, MM_NEUARTIKEL))) {
            case MM_ENDE:
               return;
            case MM_AUSGABEBESTAND:
               // System.out.println(lager.toString());
               lager.ausgebenBestandsListe();
               break;
            case MM_AUSGABELAGER:
               System.out.println("Lagerliste");
               System.out.println(lager.toString());
               break;

            case MM_NEUARTIKEL:
               if (lager.lagerVoll()) {
                  System.out.println("Es können keine Artikel angelegt werden, Lager voll");
                  break;
               }
               switch (leseInt(
                     String.format("neuer Artikel - Art wählen %d: Artikel, %d: Video, %d: CD, %d: Buch (0:Ende)\t",
                           M1_NEUARTIKEL_ARTIKEL, MM_NEUARTIKEL_VIDEO, MM_NEUARTIKEL_CD, MM_NEUARTIKEL_BUCH))) {
                  case MM_ENDE:
                     return;
                  case MM_NEUARTIKEL_VIDEO:
                     try {
                        Video video = leseVideo();
                        lager.legeAnArtikel(video);
                     } catch (Exception e) {
                        System.out.println("Video konnte nicht angelegt werden " + e.getMessage());
                     }
                     break;
                  case MM_NEUARTIKEL_BUCH:
                     System.out.println("MM_NEUARTIKEL_BUCH -not yet implemented");
                     break;
                  case MM_NEUARTIKEL_CD:
                     System.out.println("MM_NEUARTIKEL_CD -not yet implemented");
                     break;
               }
               break;
            default:
               break;
         }
      }
   }

   public static void main(String[] args) {
      // new Dialog().start();

      Dialog dialog = new Dialog();
      // Video(int artikelNr, int bestand, double preis, String titel, int spieldauer,
      // int jahr)
      dialog.lager.legeAnArtikel(new Video(1234, 15, 40.00, "Star Wars I", 45, 2001));
      // public Buch(int artikelNr, int bestand, double preis, String autor, String
      // titel, String verlag)
      dialog.lager.legeAnArtikel(new Buch(1456, 51, 49.95, "Stroustrup", "The C++ Programming Language", "erlag1"));
      // CD(int artikelNr, int bestand, double preis, String interpret, String titel,
      // int anzahlTitel)
      dialog.lager.legeAnArtikel(new CD(2345, 10, 10.90, "Santana", "Supernatural", 7));
      dialog.MainMenu();

      // Artikel artikel = new Artikel(1111, "Hose");
      // System.out.println(artikel.toString());
   }
}
