public class Spielfeld
{
    char[][] felder = new char[3][3];
    boolean gewonnen = false;
    public Spielfeld() {
        char ch = '1';
        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                felder[i][j] = ch++;
            }
        }
    }
    public void spielfeldLeeren(){
        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 3; ++j) {
                felder[i][j] = ' ';
            }
        }
    }
    public void spielfeldAusgeben(){
        for (int i = 0; i < felder.length; i++) {
            for (int j = 0; j < felder[i].length; j++) {
                if (j == felder[i].length - 1) System.out.print(felder[i][j]);
                else System.out.print( felder[i][j] + " | ");
            }
            System.out.println();
        }
    }
    public boolean istFeldBelegt(int zeile, int spalte){
        if(felder[zeile][spalte] == ' ') return false;
        return true;
    }
    public void feldSetzen(int zeile, int spalte, char zeichen){
        if(istFeldBelegt(zeile, spalte) == false){
            felder[zeile][spalte] = zeichen;
        }
    }
    public boolean istSpielfeldVoll(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(felder[i][j] == ' ') return false;
            }
        }
        return true;
    }
    public char pruefeAufGewinner(){
        for(int i = 0; i < 3; i++){
            if(felder[i][0] == (felder[i][1]) && felder[i][1] == (felder[i][2]) && felder[i][2] != ' '){
                gewonnen = true;
                return felder[i][0];
            }
            if(felder[0][i] == (felder[1][i]) && felder[1][i] == (felder[2][i]) && felder[2][i] != ' '){
                gewonnen = true;
                return felder[0][i];
            }
        }
        if(felder[0][0] == (felder[1][1]) && felder[1][1] == (felder[2][2]) && felder[2][2] != ' '){
            gewonnen = true;
            return felder[0][0];
        }
        if(felder[0][2] == (felder[1][1]) && felder[1][1] == (felder[2][0]) && felder[2][0] != ' '){
            gewonnen = true;
            return felder[0][2];
        }
        return 'E';
    }
}