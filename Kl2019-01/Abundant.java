/**
 * Abundant
 */
public class Abundant {

   public boolean abundant(int zahl) {
      int summe = 0;

      StringBuilder sb = new StringBuilder("Teilersumme von ");
      sb.append(zahl);
      sb.append(": ");

      for (int i = 1; i <= (zahl / 2); i++) {
         if (zahl % i == 0) {
            summe += i;
            sb.append("+" + i);
         }
      }
      sb.append("=");
      sb.append(summe);
      System.out.println(sb);
      return summe > zahl;
   }

   public static void main(String[] args) {
      Abundant a = new Abundant();

      System.out.println(a.abundant(12));
   }
}