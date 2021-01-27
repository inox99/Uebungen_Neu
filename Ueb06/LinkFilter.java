import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * LinkFilter
 * Soll eine Datei nach ihren URL´s Filtern und die URL´s mit Zeilenangabe auflisten.
 */
public class LinkFilter {
    Pattern pattern = Pattern.compile("(https|http)\\:\\/\\/(\\w+|[w]{3})\\.[a-z0-9]*\\.[a-z]{2,3}");
    private Scanner reader = null;
    private File[] fileTab = new File[1];
    private int totalNumberOfMatches = 0;

    /**
     * Hier wird die Datei in ein File Array gespeichert
     * @param args ist die erste eingabe in der Kommandozeile nach "java LinkFilter"
     */
    public LinkFilter(String[] args){
        fileTab[0] = new File(args[0]);
    }


    /**
     * Filtert hier jede Zeile der Datei(File file) nach einer URL die im pattern definiert ist.
     * Gibt die Zeile mit dem Match an.
     * @param file ist die Datei an der ersten stelle im File Array
     */
    public void readFile(File file){
        String line;
        int numberOfLines = 0;
        int numberOfMatches = 0;

        try{
            reader = new Scanner(file);
            while(reader.hasNextLine()){
                line = reader.nextLine();
                numberOfLines ++;
                Matcher m = pattern.matcher(line);
                while(m.find()){
                    numberOfMatches ++;
                    System.out.printf("Zeile %3d: %s\n",numberOfLines, line.substring(m.start(), m.end()));
                }
            }   
                
        } catch (FileNotFoundException e){
            System.out.println(e);
        } catch (Exception e){
            System.out.println(e);
        } finally {
            if(numberOfMatches > 0){
                totalNumberOfMatches += numberOfMatches;
                System.out.printf("%s: Anzahl der matches: %d\n\n", file.getName(), numberOfMatches);
            }
        }
    }

    /**
     * Startet das Programm solange sich eine Datei im File Array befindet
     */
    public void start(){
        for(File file : fileTab){
            readFile(file);
        }
        System.out.printf("Gesamte matches:%d\n", totalNumberOfMatches);
    }

    public static void main(String[] args) {
        if(args.length > 0){
            LinkFilter filter = new LinkFilter(args);
            filter.start();
        } else {
            System.out.println("Eingabe wie folgt: java LinkFilter Dateiname");
        }
    }

}