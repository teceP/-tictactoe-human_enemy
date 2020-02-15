package spieler;

public enum SpielerEnum {
    X, O;

    public SpielerEnum getNaechsterSpieler(){
        if(this.equals(SpielerEnum.X)){
            return SpielerEnum.O;
        }else{
            return SpielerEnum.X;
        }
    }
}
