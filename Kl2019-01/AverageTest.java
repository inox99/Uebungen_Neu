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

        for(int i = 0; i < test.length; i++){
            if(test[i] > ds){
                bigger++;
            }
        }

        return bigger;
    }

    public static void main(String[] args) {
        AverageTest at = new AverageTest();

        StringBuilder sb1 = new StringBuilder("Hallo HTW!");
        StringBuilder sb2 = new StringBuilder("Hallo Informatik!");

        //sb1 = sb2;

        //sb1.replace(0, 5, "Guten Morgen");

        System.out.println(sb1);
        System.out.println(sb2);
    }
}
