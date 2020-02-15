package spielbrett;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import spieler.SpielerEnum;

public class Spielbrett {

    /**
     * Alle Spielfelder
     */
    private MyRectangle[][] felder;

    /**
     * Der Spieler der zur Zeit am Zug ist
     */
    private SpielerEnum amZug;

    /**
     * Aktuelle Nachricht
     * z.B. "X hat gewonnen!"
     */
    private StringProperty aktuelleNachricht;

    public Spielbrett() {
        this.aktuelleNachricht = new SimpleStringProperty("Willkommen zu TicTacToe! Starte das Spiel unten rechts.");
        this.felder = new MyRectangle[3][3];

        for(int c = 0; c < felder.length; c++){
            for(int r = 0; r < felder.length; r++){
                felder[c][r] = new MyRectangle(SpielerEnum.F);
            }
        }
    }

    /**
     * Setzt alle Felder auf die Standartwerte zurueck
     *
     */
    public void reset(){
        for(int c = 0; c < felder.length; c++){
            for(int r = 0; r < felder.length; r++){
                felder[c][r].setSpieler(SpielerEnum.F);
            }
        }
    }

    /**
     * Gibt ein Rectangle zurueck
     * @param zeile die Zeile
     * @param spalte die Spalte
     * @return MyRectangleobjekt
     */
    public MyRectangle getFeld(int zeile, int spalte){
        return this.felder[zeile][spalte];
    }

    /**
     * Setzt ein Feld mit dem uebergebenen SpielerEnum
     * @param zeile die Zeile
     * @param spalte die Spalte
     * @param spieler SpielerEnum: X, O oder F
     */
    public void setFeld(int zeile, int spalte, SpielerEnum spieler){
        felder[zeile][spalte].setSpieler(spieler);
    }

    /**
     * Gibt alle Felder zurueck
     */
    public MyRectangle[][] getFelder() {
        return felder;
    }

    /**
     * Setzt alle Felder
     */
    public void setFelder(MyRectangle[][] felder) {
        this.felder = felder;
    }

    /**
     * Gibt die aktuelle Nachricht zurueck
     * @return
     */
    public final String getAktuelleNachricht() {
        return this.aktuelleNachricht.toString();
    }

    /**
     * Setzt eine neue Nachricht, welche auf der JavaFX Oberflaeche angezeigt wird
     */
    public final void setAktuelleNachricht(String neueNachricht) {
        this.aktuelleNachricht.set(neueNachricht);
    }

    /**
     * Gibt die StringProperty der aktuellen Nachricht zurueck
     */
    public final StringProperty aktuelleNachrichtProperty() {
        return this.aktuelleNachricht;
    }

    /**
     * Gibt zurueck, wer zur Zeit am Zug ist
     */
    public SpielerEnum getAmZug() {
        return amZug;
    }

    /**
     * Setzt den Spieler, der den naechsten Zug macht
     */
    public void setAmZug(SpielerEnum spielerEnum) {
        this.amZug = spielerEnum;
    }
}
