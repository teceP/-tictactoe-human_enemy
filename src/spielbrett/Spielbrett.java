package spielbrett;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import spieler.SpielerEnum;

public class Spielbrett {

    private MyRectangle[][] felder;
    private SpielerEnum amZug;
    private StringProperty aktuelleNachricht;

    public Spielbrett() {
        this.aktuelleNachricht = new SimpleStringProperty("Willkommen zu TicTacToe! Starte das Spiel unten rechts.");
        this.felder = new MyRectangle[3][3];

        for(int c = 0; c < felder.length; c++){
            for(int r = 0; r < felder.length; r++){
                felder[c][r] = new MyRectangle();
            }
        }
    }

    public void reset(){
        for(int c = 0; c < felder.length; c++){
            for(int r = 0; r < felder.length; r++){
                felder[c][r].setSpieler(null);
            }
        }
    }

    public MyRectangle getFeld(int zeile, int spalte){
        return this.felder[zeile][spalte];
    }

    public MyRectangle[][] getFelder() {
        return felder;
    }

    public void setFelder(MyRectangle[][] felder) {
        this.felder = felder;
    }

    public final String getAktuelleNachricht() {
        return this.aktuelleNachricht.toString();
    }

    public final void setAktuelleNachricht(String neueNachricht) {
        this.aktuelleNachricht.set(neueNachricht);
    }

    public final StringProperty aktuelleNachrichtProperty() {
        return this.aktuelleNachricht;
    }

    public SpielerEnum getAmZug() {
        return amZug;
    }

    public void setAmZug(SpielerEnum spielerEnum) {
        this.amZug = spielerEnum;
    }

}
