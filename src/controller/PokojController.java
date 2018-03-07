package controller;

import hotelklasy.Pokoj;
import hotelklasy.Pracownik;
import java.util.List;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import modeldao.PokojDAO;
import modeldao.PracownikDAO;


public class PokojController{

    
    @FXML
    private ListView<Pokoj> lista;

    @FXML
    private ComboBox<Pracownik> comboBOX;

    private MainScreenController mainScreenController;
    
    private List<Pokoj> pokoje;
    private SimpleListProperty listPropertySto;
    private ObservableList<Pokoj> listaStolikow;

    private List<Pracownik> pracownicy;
    private SimpleListProperty listPropertyPrac;
    private ObservableList<Pracownik> listaPracownikow;
    
    
    public void initialize() {
        
        load();
        loadComboBox();
        
    }
    
    //ustawianie kontrolera głównego widoku
    public void setMainScreenController(MainScreenController mainScreenController) {
        this.mainScreenController = mainScreenController;
    }
    
    //przeładowywanie listy gdy nastąpi edycja oraz wyświetlanie elementów
    //na liście 
    private void load() {
        PokojDAO PokojeDAO = new PokojDAO();
        pokoje = PokojeDAO.findAll();

        listPropertySto = new SimpleListProperty();
        listaStolikow = FXCollections.observableArrayList(pokoje);
        listPropertySto.set(listaStolikow);
        lista.itemsProperty().bindBidirectional(listPropertySto);
    }
    
    //inicjalizowanie i ładowanie kontrolki comboBox oraz
    //dodawanie do niej pracowników
     private void loadComboBox(){
        
        PracownikDAO PracownikDAO = new PracownikDAO();
        pracownicy = PracownikDAO.findAll();
                
        listPropertyPrac = new SimpleListProperty();
        listaPracownikow = FXCollections.observableArrayList(pracownicy);
        listPropertyPrac.set(listaPracownikow);
        comboBOX.itemsProperty().bindBidirectional(listPropertyPrac);
        
        
    }
    //dodawanie do pokoju pracownika
    public void dodaj(){
    
        PokojDAO PokojeDAO = new PokojDAO();
        
        try{
               Pracownik pracownik = comboBOX.getSelectionModel().getSelectedItem();
        
        Pokoj pokoj = new Pokoj();
        pokoj.setPracownik(pracownik);
        PokojeDAO.save(pokoj);
        
        }
        catch(Exception ex){}
        
        
        
        load();

    }
    //usuwanie pokoju
    public void usun(){
        Pokoj id = lista.getSelectionModel().getSelectedItem();
        PokojDAO PokojDAO = new PokojDAO();
        try {
            PokojDAO.delete(id);
        } catch (Exception ex) {
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Błąd");
            alert.setHeaderText("Nie można usunąć");
            alert.setContentText("Nie wybrałeś pokoju lub posiada on rezerwacje");
            alert.showAndWait();

        }
        load();
    }
    //powrót do menu głównego programu
    public void wstecz(){
        mainScreenController.loadMenu();
    }
    
}
