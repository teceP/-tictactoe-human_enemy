package spielbrett;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import spieler.SpielerEnum;
import java.awt.*;

public class MyRectangle extends Rectangle {

    private StringProperty zeileUndSpalte = new SimpleStringProperty("");
    private SpielerEnum spieler;
    private int zeile;
    private int spalte;

    public void setZeile(){
        this.zeile = this.wandleCharZuInt(this.getZeileUndSpalte().charAt(0));
    }

    public void setSpalte(){
        this.spalte = this.wandleCharZuInt(this.getZeileUndSpalte().charAt(1));
    }

    /**
     * Wandelt einen Character in den entspechenden Int-Wert um
     * @param character
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



    public final String getZeileUndSpalte(){
        return this.zeileUndSpalte.get();
    }

    public final void setZeileUndSpalte(String zeileUndSpalte){
        this.zeileUndSpalte.set(zeileUndSpalte);
    }

    public StringProperty getZeileUndSpalteProperty(){
        return this.zeileUndSpalte;
    }

    public SpielerEnum getSpieler() {
        return spieler;
    }

    public void setSpieler(SpielerEnum spieler) {
        this.spieler = spieler;
    }
}
