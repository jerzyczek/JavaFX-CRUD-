package controller;

import java.util.List;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import modeldao.KlientDAO;
import hotelklasy.Klient;


public class KlienciController{

    @FXML
    private ListView<Klient> lista;

    @FXML
    private TextField name;

    @FXML
    private TextField surname;
    
    @FXML
    private TextField number;
    
    @FXML 
    private TextField pesel;
    
    
    private MainScreenController mainScreenController;
    private List<Klient> klienci;
    private SimpleListProperty listProperty;
    private ObservableList<Klient> listaKlientow;
  
     //ustawianie kontrolera głównego widoku
    public void setMainScreenController(MainScreenController mainScreenController) {
        this.mainScreenController = mainScreenController;
    }
    
    //dodawanie klienta
    public void dodaj() {
        
        KlientDAO klientDAO = new KlientDAO();
        String imie = name.getText();
        String nazwisko = surname.getText();
        String numerTelefonu = number.getText();
        int numerTelefonu1 = Integer.parseInt(numerTelefonu);
        String peselString = pesel.getText();
        long peselInt = Long.parseLong(peselString);
        Klient klient = new Klient(imie, nazwisko, numerTelefonu1, peselInt);
        klientDAO.save(klient);
        load();
        name.setText("");
        surname.setText("");
        number.setText("");
        pesel.setText("");
        
    }
    
    //usuwanie klienta
    public void usun() {
        Klient id = lista.getSelectionModel().getSelectedItem();
        KlientDAO klientDAO = new KlientDAO();
        try {
            klientDAO.delete(id);
        } catch (Exception ex) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Błąd");
            alert.setHeaderText("Nie można usunąć");
            alert.setContentText("Nie wybrałeś klienta lub posiada on rezerwacje");
            alert.showAndWait();

        }
        load();
    }
    
    //powrót do menu głównego programu
     public void wstecz() {

        mainScreenController.loadMenu();
    }
    
    
    
    public void initialize() {
      load();
    }    
    
    //przeładowywanie listy gdy nastąpi edycja oraz wyświetlanie elementów
    //na liście 
    private void load() {
        KlientDAO klientDAO = new KlientDAO();
        klienci = klientDAO.findAll();

        listProperty = new SimpleListProperty();
        listaKlientow = FXCollections.observableArrayList(klienci);
        listProperty.set(listaKlientow);
        lista.itemsProperty().bindBidirectional(listProperty);

    }
    
}
