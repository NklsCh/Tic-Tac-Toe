import java.util.Scanner;
import basis.*;
public class Hauptklasse
{
    public static void main() {
        Spielfeld feld = new Spielfeld();
        System.out.print('\u000C');
        feld.spielfeldLeeren();
        feld.spielfeldAusgeben();
        char spieler = 'X';
        Scanner in = new Scanner(System.in);
        int auswahl = 2;
        do{
            while(feld.gewonnen != true){
                System.out.println("Gib die Feldcoordinaten für den Spieler " + spieler + " ein:");
                int row = in.nextInt();
                int column = in.nextInt();
                feld.feldSetzen(row, column, spieler);
                System.out.print('\u000C');
                feld.spielfeldAusgeben();

                if (feld.pruefeAufGewinner() != 'E'){
                    System.out.println("Spieler " + spieler + " hat gewonnen!");
                }
                if (spieler == 'O') {
                    spieler = 'X';
                }
                else {
                    spieler = 'O';
                }
            }
            System.out.println("Möchtest du erneut Spielen?\n1: Ja\n2: Nein");
            auswahl = in.nextInt();
        }while(auswahl != 1);
        in.close();
    }
    public static void spielCPU() {
        Spielfeld feld = new Spielfeld();
        System.out.print('\u000C');
        feld.spielfeldLeeren();
        feld.spielfeldAusgeben();
        char spieler = 'X';
        char cpu = 'O';
        Scanner in = new Scanner(System.in);
        boolean cpuBoolean;
        while(feld.gewonnen != true){
            System.out.println("Gib die Feldcoordinaten für den Spieler " + spieler + " ein:");
            int row = in.nextInt();
            int column = in.nextInt();
            feld.feldSetzen(row, column, spieler);
            cpuBoolean = false;
            while(cpuBoolean == false && feld.pruefeAufGewinner() == 'E'){
                int rowCPU = Hilfe.zufall(0,2);
                int columnCPU = Hilfe.zufall(0,2);
                if(feld.istFeldBelegt(rowCPU, columnCPU) == false){
                    feld.feldSetzen(rowCPU, columnCPU, cpu);
                    cpuBoolean = true;
                }
            }
            if (feld.pruefeAufGewinner() != 'E'){
                System.out.println("Spieler " + feld.pruefeAufGewinner() + " hat gewonnen!");
            }
            System.out.print('\u000C');
            feld.spielfeldAusgeben();
        }
        in.close();
    }
}