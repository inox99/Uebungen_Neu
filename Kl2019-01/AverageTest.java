public class AverageTest {
   public int average() {
      Double[] test = new Double[10];
      double summe = 0.0;
      double ds = 0.0;
      int bigger = 0;

      for (int i = 0; i < test.length; i++) {
         test[i] = Math.random();
         summe += test[i];
      }
      ds = summe / 10;

      for (int i = 0; i < test.length; i++) {
         if (test[i] > ds) {
            bigger++;
         }
      }

      return bigger;
   }

   public static void main(String[] args) {
      AverageTest at = new AverageTest();

      StringBuilder sb1 = new StringBuilder("Hallo HTW!");
      StringBuilder sb2 = new StringBuilder("Hallo Informatik!");

      System.out.println("s1b: " + sb1);
      System.out.println("s2b: " + sb2);
      //sb1 = sb2;
      sb1.replace(0, 5, "Guten Morgen");
      System.out.println("2--------------------------------");
      System.out.println("s1b: " + sb1);
      System.out.println("s2b: " + sb2);

      String s1 = new String("Hallo HTW!"); //
      String s2 = new String("Hallo Informatik!");
      System.out.println("3--------------------------------");
      System.out.println("s1: " + s1);
      System.out.println("s2: " + s2);
      
      s1 = s2;
      s1.replace("Hallo", "Guten Morgen");
      System.out.println("4--------------------------------");
      System.out.println("s1: " + s1);
      System.out.println("s2: " + s2);
      System.out.println("warum wurde hier s1 nicht geändert? ");
      // die replace-methode ändert den String nicht, sie erzeugt einen neuen geänderten string der neu zugewiesen werden muss

      s1 = s1.replace("Hallo", "Guten Morgen");
      System.out.println("5--------------------------------");
      System.out.println("s1: " + s1);
      System.out.println("s2: " + s2);
      System.out.println("warum wurde hier s1  geändert? ");

      System.out.println("---------------------------------");
   }
}
