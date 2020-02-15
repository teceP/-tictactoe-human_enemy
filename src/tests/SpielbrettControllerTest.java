package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import spielbrett.Spielbrett;
import spielbrett.SpielbrettController;
import spieler.SpielerEnum;

public class SpielbrettControllerTest {

    @Test
    public void pruefeGewinner_false_nicht_genug_zuege(){

        /**
         * x - -
         * x - -
         * - - -
         *
         */

        SpielbrettController controller = new SpielbrettController();
        Spielbrett spielbrett = new Spielbrett();
        controller.setSpielbrett(spielbrett);
        spielbrett.setAmZug(SpielerEnum.X);

        spielbrett.setFeld(0,0, SpielerEnum.X);
        spielbrett.setFeld(1,0, SpielerEnum.X);

        //Bevor weniger als 5 Spielzuege, sowieso false
        Assertions.assertFalse(controller.pruefeGewinner());
    }

    @Test
    public void pruefeGewinner_false_nicht_gewonnen(){

        /**
         * x - -
         * x - -
         * - - -
         *
         */

        SpielbrettController controller = new SpielbrettController();
        Spielbrett spielbrett = new Spielbrett();
        controller.setSpielbrett(spielbrett);
        spielbrett.setAmZug(SpielerEnum.X);

        spielbrett.setFeld(0,0, SpielerEnum.X);
        spielbrett.setFeld(1,0, SpielerEnum.X);

        controller.setSpielzuege(5);

        //Jetzt false, weil nicht gewonnen
        Assertions.assertFalse(controller.pruefeGewinner());

    }

    @Test
    public void pruefeGewinner_spalte(){

        /**
         * x - -
         * x - -
         * x - -
         *
         */

        SpielbrettController controller = new SpielbrettController();
        Spielbrett spielbrett = new Spielbrett();
        controller.setSpielbrett(spielbrett);
        spielbrett.setAmZug(SpielerEnum.X);
        controller.setSpielzuege(5);

        spielbrett.setFeld(0,0, SpielerEnum.X);
        spielbrett.setFeld(1,0, SpielerEnum.X);
        spielbrett.setFeld(2,0, SpielerEnum.X);

        Assertions.assertFalse(controller.pruefeGewinner());
    }

    @Test
    public void pruefeGewinner_zeile(){

        /**
         * x x x
         * - - -
         * - - -
         *
         */

        SpielbrettController controller = new SpielbrettController();
        Spielbrett spielbrett = new Spielbrett();
        controller.setSpielbrett(spielbrett);
        spielbrett.setAmZug(SpielerEnum.X);
        controller.setSpielzuege(5);

        spielbrett.setFeld(0,0, SpielerEnum.X);
        spielbrett.setFeld(0,1, SpielerEnum.X);
        spielbrett.setFeld(0,2, SpielerEnum.X);

        Assertions.assertTrue(controller.pruefeGewinner());
    }

    @Test
    public void pruefeGewinner_diagonal_0(){

        /**
         * x - -
         * - x -
         * - - x
         *
         */

        SpielbrettController controller = new SpielbrettController();
        Spielbrett spielbrett = new Spielbrett();
        controller.setSpielbrett(spielbrett);
        spielbrett.setAmZug(SpielerEnum.X);
        controller.setSpielzuege(5);

        spielbrett.setFeld(0,0, SpielerEnum.X);
        spielbrett.setFeld(1,1, SpielerEnum.X);
        spielbrett.setFeld(2,2, SpielerEnum.X);

        Assertions.assertTrue(controller.pruefeGewinner());
    }

    @Test
    public void pruefeGewinner_diagonal_1(){

        /**
         * - - x
         * - x -
         * x - -
         *
         */

        SpielbrettController controller = new SpielbrettController();
        Spielbrett spielbrett = new Spielbrett();
        controller.setSpielbrett(spielbrett);
        spielbrett.setAmZug(SpielerEnum.X);
        controller.setSpielzuege(5);

        spielbrett.setFeld(0,2, SpielerEnum.X);
        spielbrett.setFeld(1,1, SpielerEnum.X);
        spielbrett.setFeld(2,0, SpielerEnum.X);

        Assertions.assertTrue(controller.pruefeGewinner());
    }

    @Test
    public void pruefeGewinner_unentschieden(){

        /**
         * o x o
         * x o x
         * x o x
         *
         */

        SpielbrettController controller = new SpielbrettController();
        Spielbrett spielbrett = new Spielbrett();
        controller.setSpielbrett(spielbrett);
        spielbrett.setAmZug(SpielerEnum.X);
        controller.setSpielzuege(5);

        spielbrett.setFeld(0,0, SpielerEnum.O);
        spielbrett.setFeld(0,2, SpielerEnum.O);
        spielbrett.setFeld(1,1, SpielerEnum.O);
        spielbrett.setFeld(1,2, SpielerEnum.O);
        spielbrett.setFeld(1,0, SpielerEnum.X);
        spielbrett.setFeld(2,0, SpielerEnum.X);
        spielbrett.setFeld(1,2, SpielerEnum.X);
        spielbrett.setFeld(2,2, SpielerEnum.X);

        Assertions.assertFalse(controller.pruefeGewinner());
    }
}
