package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import spieler.SpielerEnum;

public class SpielerEnumTest {

    @Test
    public void naechsterSpieler_test(){
        SpielerEnum spielerEnum = SpielerEnum.X;

        Assertions.assertEquals(SpielerEnum.O, spielerEnum.getNaechsterSpieler());

        spielerEnum = spielerEnum.getNaechsterSpieler();
        Assertions.assertEquals(SpielerEnum.X, spielerEnum.getNaechsterSpieler());
    }
}
