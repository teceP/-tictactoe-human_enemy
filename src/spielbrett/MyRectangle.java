package spielbrett;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import spieler.SpielerEnum;
import java.awt.*;

public class MyRectangle extends Rectangle {

    /**
     * Property eines Feldes, welches den Index des Feldes repräsentiert
     */
    private StringProperty zeileUndSpalte = new SimpleStringProperty("");

    /**
     * Spielerzeichen (X oder O)
     */
    private SpielerEnum spieler;


    public MyRectangle(SpielerEnum spieler){
        this.spieler = spieler;
    }
    /**
     * Wandelt einen Character in den entspechenden Int-Wert um
     *
     * @param character die Zeile als Buchstabe
     * @return int die Zeile als Int-wert
     * @return -1, falls Character keinem der vorgesehenen entspricht
     */
    public static int wandleCharZuInt(char character){
        switch(character){
            case('A'):
                return 0;
            case('B'):
                return 1;
            case('C'):
                return 2;
            default:
                return -1;
        }
    }

    /**
     * Gibt Stringproperty zurueck
     */
    public StringProperty getZeileUndSpalteProperty(){
        return this.zeileUndSpalte;
    }

    /**
     * Gibt das Spielerenum zurueck
     */
    public SpielerEnum getSpieler() {
        return spieler;
    }

    /**
     * Setzt das Spielerenum
     * @param spieler
     */
    public void setSpieler(SpielerEnum spieler) {
        this.spieler = spieler;
    }
}
