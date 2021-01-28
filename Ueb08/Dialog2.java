import java.util.Scanner;

public class Dialog2 {
   Scanner input = new Scanner(System.in);
   final Lager lager = new Lager(10);

   public Dialog2() {

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

      Dialog2 dialog = new Dialog2();
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
