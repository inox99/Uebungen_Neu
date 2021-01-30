
Einstellungen
   remotes:
      PS C:\Users\ep90\source\repos\_test\SimonTest\Uebungen_Neu\Ueb08> git remote -v
      origin  https://github.com/TaiSonRZR/Uebungen_Neu.git (fetch)
      origin  https://github.com/TaiSonRZR/Uebungen_Neu.git (push)
      staging https://github.com/inox99/Uebungen_Neu.git (fetch)
      staging https://github.com/inox99/Uebungen_Neu.git (push)


====================================================================================================

Know how (Java)

Variablen Typen Datentypen

   - Eine Variable hat immer einen (Variablen-) Typ
      siehe https://www.w3schools.com/java/java_data_types.asp

   - Bei den Typen (char, boolean, int, long, float, string Object(class)) gibt es zwei Arten
      a) Value-Type (Primitive Data Types)
      b) Reference-Type (siehe Non-Primitive Data Types)

      zu a) gehören die sogenannten simple oder primitive -types (int, long, float, ...)
      zu b) gehören Strings, Arrays und Objekte und

      zu a)
         wenn da steht:
         int i = 5;
         long l = 1L;

         dann belegt die Variable i (weil sie ein int ist) 4 Bytes (32-bit). Der Inhalt der Variablen ist 5 
         dann belegt die Variable l (weil sie ein long ist) 8 Bytes (64-bit). Der Inhalt der Variablen ist 1 

      zu b)
         wenn da steht:
         String s1;
         String s2 = "123";

         dann ist der Wert von s1 = null,
         der Wert von s2 (nicht "123" sondern) ein Zeiger oder referenz auf eine Adresse im Speicher wo "123" steht
         der eigentliche referenzwert ist intern 32-bit wert bei einem 32-bit Betriebssystem und 64 bit bei einem 64-bit Betriebssystem

         bei assign ( = ) gibt es verschiedene Fälle:
            rechts steht null;   // geht immer
            literal: String s1 = "123";   // 
                     StringBuilder sb1 = "123"  // geht nicht

            Die Frage ist: 
               kann die String-konstante (Literal) "123" in ein String-Objekt konvertiert werden? => ja
               kann die String-konstante (Literal) "123" in ein StringBuilder-Objekt kanvertiert werden? => nein
            anders gefragt: was macht der assign ( = ) operator? kommt drauf an

            rechts steht ein anderes Object  
               hier kommt es drauf an ob der Rechtswert in den Typ des Linkswertes umgewandelt werden kann
               (oder vom Typ gleich ist)
               gleiches gilt, wenn rechts vom = new ...() steht

         wenn da steht:
         StringBuilder sb1 = new StringBuilder("Hallo HTW!");
         StringBuilder sb2 = new StringBuilder("Hallo Informatik!");
         String s1 = new String("Hallo HTW!"); //
         String s2 = new String("Hallo Informatik!");

         dann wwerden bei:
               s1 = s2;
         und   sb1 = sb2;
         unterschiedliche Dinge gemacht.
            bei s1 = s2;   wird ein neuer String erzeugt, der den Inhalt von s2 erhält und s1 zugewiesen, d.h es wird ein neues String-Objekt erzeugt

         bei sb1 = sb2; wird der referenzwert oder zeigerwert von sb2 in sb1 geschrieben, sb1 und sb2 
         zeigen ab jetzt auf das selbe (also das selbe, nicht das gleiche) Objekt.
         dh ändert man eins, ändert man das andere mit, es ist ja das selbe.
         das ursprüngliche sb1 (das mit new angelegt wurde) ist verwaist, eine Leiche, nicht mehr da, im Müll, ...
         also, anders als beim String wird hier kein neues Objekt erzeugt
