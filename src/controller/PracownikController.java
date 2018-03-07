package controller;

import hotelklasy.Pracownik;
import java.util.List;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import modeldao.PracownikDAO;


public class PracownikController{

    
    @FXML
    private ListView<Pracownik> lista;

    @FXML
    private TextField name;

    @FXML
    private TextField surname;

    private MainScreenController mainScreenController;
    private List<Pracownik> pracownicy;
    private SimpleListProperty listProperty;
    private ObservableList<Pracownik> listaPracownikow;


    
    
    
    
    public void initialize() {
       load();
    }
        
     //ustawianie kontrolera głównego widoku
     public void setMainScreenController(MainScreenController mainScreenController) {
        this.mainScreenController = mainScreenController;
    }
    
    //dodawanie klienta do bazy danych
    public void dodaj() {
       
        PracownikDAO pracownikDAO = new PracownikDAO();
        String imie = name.getText();
        String nazwisko = surname.getText();
        Pracownik pracownik = new Pracownik(imie, nazwisko);
        pracownikDAO.save(pracownik);
        load();
        name.setText("");
        surname.setText("");
    }
    
    
    //usuwanie klienta z bazy danych
    public void usun() {
        try{
        Pracownik id = lista.getSelectionModel().getSelectedItem();
        PracownikDAO pracownikDAO = new PracownikDAO();
        
        pracownikDAO.delete(id);
        }
        catch(Exception ex){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Błąd");
            alert.setHeaderText("Nie można usunąć pracownika, który jest przypisany do pokoju");
            
            alert.showAndWait();
        }
       
        load();
    }
    
    
     //powrót do menu głównego programu
     public void wstecz() {

        mainScreenController.loadMenu();
        
    }
     
     //przeładowywanie listy gdy nastąpi edycja oraz wyświetlanie elementów
    //na liście 
     private void load() {
        PracownikDAO pracownikDAO = new PracownikDAO();
        pracownicy = pracownikDAO.findAll();
        listProperty = new SimpleListProperty();
        listaPracownikow = FXCollections.observableArrayList(pracownicy);
        listProperty.set(listaPracownikow);
        lista.itemsProperty().bindBidirectional(listProperty);

    }
    
    
}
