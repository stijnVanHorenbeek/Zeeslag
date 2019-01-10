package javafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import models.Helicopter;
import models.Ship;
import models.Tower;

public class ZeeslagController {
    @FXML
    private ListView<Tower> TowersListview;

    @FXML
    private ListView<Ship> ShipsListview;

    @FXML
    private ListView<Helicopter> HelicoptersListView;

    @FXML
    private TextArea LogTextArea;

    @FXML
    private Tab TowerTab;

    @FXML
    private TextField CoordinaatXTowerTextfield;

    @FXML
    private TextField coordinaatYTowerTextfield;

    @FXML
    private TextField sizeTowerTextfield;

    @FXML
    private TextField capacityTowerTextfield;

    @FXML
    private Button changeTowerInfoButton;

    @FXML
    private Button addTowerButton;

    @FXML
    private CheckBox activeTowerChecked;

    @FXML
    private Button removeTowerButton;

    @FXML
    private Tab ShipTab;

    @FXML
    private TextField CoordinaatXShipTextfield;

    @FXML
    private TextField CoordinaatYShipTextfield;

    @FXML
    private TextField speedShipTextfield;

    @FXML
    private TextField agilityShipTextField;

    @FXML
    private TextField capacityShipTextfield;

    @FXML
    private TextField sizeShipTextfield;

    @FXML
    private TextField vectorShipTextfield;

    @FXML
    private Button changeShipInfoButton;

    @FXML
    private Button addShipButton;

    @FXML
    private Button removeShipButton;

    @FXML
    private Tab HelicopterTab;

    @FXML
    private TextField coordinaatXHelicopterTextfield;

    @FXML
    private TextField coordinaatYHelicopterTextfield;

    @FXML
    private TextField speedHelicopterTextfield;

    @FXML
    private TextField agilityHelicopterTextfield;

    @FXML
    private TextField capacityHelicopterTextfield;

    @FXML
    private TextField vectorHelicopterTextfield;

    @FXML
    private TextField sizeHelicopterTextField;

    @FXML
    private Button changeHelicopterButton;

    @FXML
    private Button removeHelicopterButton;

    @FXML
    private Button addHelicopterButton;

}
