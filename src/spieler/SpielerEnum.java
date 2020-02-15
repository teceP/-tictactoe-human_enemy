package spieler;

public enum SpielerEnum {
    /**
     * X & O sind die Spieler.
     * F steht für ein freies Feld.
     */
    X, O, F;

    /**
     * Gibt den naechsten Spieler zurueck:
     * @return SpielerEnum.X wenn O zuletzt dran war.
     * @return SpielerEnum.O wenn X zuletzt dran war.
     */
    public SpielerEnum getNaechsterSpieler(){
        if(this.equals(SpielerEnum.X)){
            return SpielerEnum.O;
        }else{
            return SpielerEnum.X;
        }
    }
}
