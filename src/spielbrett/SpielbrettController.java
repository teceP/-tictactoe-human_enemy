package spielbrett;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import spieler.SpielerEnum;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class SpielbrettController implements Initializable {

    private int spielzuege;

    private SpielerEnum spieler;

    @FXML
    private Spielbrett spielbrett;

    @FXML
    private Text txtInfo;

    @FXML
    private Button btnStarten;

    @FXML
    private Button btnRefresh;

    @FXML
    private GridPane gridFelder;

    @FXML
    Rectangle rectAA;
    @FXML
    Rectangle rectAB;
    @FXML
    Rectangle rectAC;
    @FXML
    Rectangle rectBA;
    @FXML
    Rectangle rectBB;
    @FXML
    Rectangle rectBC;
    @FXML
    Rectangle rectCA;
    @FXML
    Rectangle rectCB;
    @FXML
    Rectangle rectCC;

    private List<Rectangle> rectangleList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.rectanglesZurListe();
        this.btnRefresh.setVisible(false);

        this.spielbrett = new Spielbrett();
        this.setBindings();

        this.setRectangleEvents();

        /* Damit keine Felder gedrueckt werden, solange das Spiel noch nicht gestartet ist.
         * Man koennte die ClickListener auch erst beim Spielstart initalisieren, was bei so
         * kleinen Spielen auch eher einfacher waere, bei großen Spielen aber schlecht waere,
         * da man beim Spielstart das Spiel starten und nicht laden moechte.
         */
        this.gridFelder.setDisable(true);

        this.setRectangleEvents();
    }

    private void rectanglesZurListe() {
        this.rectangleList = new ArrayList<>();
        this.rectangleList.add(rectAA);
        this.rectangleList.add(rectAB);
        this.rectangleList.add(rectAC);
        this.rectangleList.add(rectBA);
        this.rectangleList.add(rectBB);
        this.rectangleList.add(rectBC);
        this.rectangleList.add(rectCA);
        this.rectangleList.add(rectCB);
        this.rectangleList.add(rectCC);
    }

    private void setBindings() {
        /**
         * Immer die aktuellste Nachricht anzeigen lassen
         */
        this.txtInfo.textProperty().bind(this.spielbrett.aktuelleNachrichtProperty());

        /**
         * Alle Felder vom Model, mit dem der View verbinden.
         */
        this.spielbrett.getFeld(0, 0).getZeileUndSpalteProperty().bind(this.rectAA.idProperty());
        this.spielbrett.getFeld(0, 1).getZeileUndSpalteProperty().bind(this.rectAB.idProperty());
        this.spielbrett.getFeld(0, 2).getZeileUndSpalteProperty().bind(this.rectAC.idProperty());
        this.spielbrett.getFeld(1, 0).getZeileUndSpalteProperty().bind(this.rectBA.idProperty());
        this.spielbrett.getFeld(1, 1).getZeileUndSpalteProperty().bind(this.rectBB.idProperty());
        this.spielbrett.getFeld(1, 2).getZeileUndSpalteProperty().bind(this.rectBC.idProperty());
        this.spielbrett.getFeld(2, 0).getZeileUndSpalteProperty().bind(this.rectCA.idProperty());
        this.spielbrett.getFeld(2, 1).getZeileUndSpalteProperty().bind(this.rectCB.idProperty());
        this.spielbrett.getFeld(2, 2).getZeileUndSpalteProperty().bind(this.rectCC.idProperty());
    }

    /**
     * Prueft, ausgehend vom letzten spieler, ob dieser mit
     * seinem letzten Zug gewonnen hat.
     */
    public boolean pruefeGewinner() {

        for (int c = 0; c < this.spielbrett.getFelder().length; c++) {

            //Zeile
            if (spielbrett.getFeld(c, 0).getSpieler() == this.spielbrett.getAmZug()
                    && spielbrett.getFeld(c, 1).getSpieler() == this.spielbrett.getAmZug()
                    && spielbrett.getFeld(c, 2).getSpieler() == this.spielbrett.getAmZug()) {
                return true;
            }

            //Spalte
            if (spielbrett.getFeld(0, c).getSpieler() == this.spielbrett.getAmZug()
                    && spielbrett.getFeld(1, c).getSpieler() == this.spielbrett.getAmZug()
                    && spielbrett.getFeld(2, c).getSpieler() == this.spielbrett.getAmZug()) {
                return true;
            }
        }

        /**
         * Diagonal 1
         */
        if (spielbrett.getFeld(0, 0).getSpieler() == this.spielbrett.getAmZug()
                && spielbrett.getFeld(1, 1).getSpieler() == this.spielbrett.getAmZug()
                && spielbrett.getFeld(2, 2).getSpieler() == this.spielbrett.getAmZug()) {
            return true;
        }

        /**
         * Diagonal 2
         */
        if (spielbrett.getFeld(0, 2).getSpieler() == this.spielbrett.getAmZug()
                && spielbrett.getFeld(1, 1).getSpieler() == this.spielbrett.getAmZug()
                && spielbrett.getFeld(2, 0).getSpieler() == this.spielbrett.getAmZug()) {
            return true;
        }

        return false;
    }

    private void setRectangleEvents() {

        this.rectAA.setOnMouseClicked(mouseEvent -> {
            this.rectangleClickEvent(rectAA);
        });

        this.rectAB.setOnMouseClicked(mouseEvent -> {
            this.rectangleClickEvent(rectAB);
        });

        this.rectAC.setOnMouseClicked(mouseEvent -> {
            this.rectangleClickEvent(rectAC);
        });

        this.rectBA.setOnMouseClicked(mouseEvent -> {
            this.rectangleClickEvent(rectBA);
        });

        this.rectBB.setOnMouseClicked(mouseEvent -> {
            this.rectangleClickEvent(rectBB);
        });

        this.rectBC.setOnMouseClicked(mouseEvent -> {
            this.rectangleClickEvent(rectBC);
        });

        this.rectCA.setOnMouseClicked(mouseEvent -> {
            this.rectangleClickEvent(rectCA);
        });

        this.rectCB.setOnMouseClicked(mouseEvent -> {
            this.rectangleClickEvent(rectCB);
        });

        this.rectCC.setOnMouseClicked(mouseEvent -> {
            this.rectangleClickEvent(rectCC);
        });
    }

    private void rectangleClickEvent(Rectangle rectangle) {
        ImagePattern imagePattern;

        if (this.spielbrett.getAmZug().equals(SpielerEnum.X)) {
            imagePattern = new ImagePattern(new Image("view/X.png"));
        } else {
            imagePattern = new ImagePattern(new Image("view/O.png"));
        }

        rectangle.setFill(imagePattern);
        rectangle.setDisable(true);

        //Herausfinden, welches feld gedrueckt (zeile, spalte)
        int zeile = MyRectangle.wandleCharZuInt(rectangle.getId().charAt(rectangle.getId().length() - 2));
        int spalte = MyRectangle.wandleCharZuInt(rectangle.getId().charAt(rectangle.getId().length() - 1));

        //spieler auf Feld speichern
        this.spielbrett.getFeld(zeile, spalte).setSpieler(this.spielbrett.getAmZug());

        this.spielzuege++;

        /**
         * Vor 5 Spielzuegen macht es keinen Sinn zu pruefen, ob jemand gewonnen hat
         */
        if (this.spielzuege > 4) {
            if (this.pruefeGewinner()) {
                this.spielbrett.setAktuelleNachricht("Gewonnen hat " + this.spielbrett.getAmZug() + ". Glueckwunsch!");
                this.spielVorbei();
            }
        }

        if (this.spielzuege == 9) {
            this.spielbrett.setAktuelleNachricht("Unentschieden!");
            this.spielVorbei();
        }

        this.spielbrett.setAmZug(this.spielbrett.getAmZug().getNaechsterSpieler());
    }


    public void anfaengerWaehlen() {
        Random rand = new Random();
        int n = rand.nextInt(2);

        if (n == 0) {
            this.spielbrett.setAmZug(SpielerEnum.X);
        } else {
            this.spielbrett.setAmZug(SpielerEnum.O);
        }
    }

    /**
     * Buttons
     */

    @FXML
    private void spielVorbei() {
        this.btnRefresh.setVisible(true);
    }

    @FXML
    private void refresh() {
        for (Rectangle r : this.rectangleList) {
            r.setFill(Color.web("#d3d3d3"));
            r.setDisable(true);
        }

        this.spielbrett.reset();
        this.btnRefresh.setVisible(false);
        this.btnStarten.setDisable(false);
        this.spielbrett.setAktuelleNachricht("Druecke auf Spiel starten.");
    }

    @FXML
    private void starteSpiel() {

        this.btnStarten.setDisable(true);

        for (Rectangle r : this.rectangleList) {
            r.setDisable(false);
        }

        this.spielzuege = 0;

        /**
         * Bei dem Spiel eigentlich egal, wer beginnt.
         * Eventuell interessant, wenn man gegen den Computer spielt.
         */
        this.anfaengerWaehlen();

        this.spielbrett.setAktuelleNachricht("Spiel gestartet! " + this.spielbrett.getAmZug() + " beginnt.");

        /**
         * Felder anklickbar machen.
         */
        this.gridFelder.setDisable(false);

        if (this.spielbrett.getAmZug().equals(SpielerEnum.O)) {
            // this.spieler.naechsterZug(this.spielbrett);
        }
    }
}
