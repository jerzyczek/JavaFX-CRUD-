package controller;

import hotelklasy.Pracownik;
import java.awt.event.MouseEvent;
import java.util.List;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import modeldao.PracownikDAO;


public class EditPracownikController {

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
    
     //ustawianie kontrolera głównego widoku
    public void setMainScreenController(MainScreenController mainScreenController) {
        this.mainScreenController = mainScreenController;
    }
    
      public void initialize() {
        load();
        

       
    }
       //wracanie do menu głównego programu
        public void wstecz() {

        mainScreenController.loadMenu();
    }

        
      //edycja pracownika
      public void editPracownikRecord(){
            
       if ((!lista.getSelectionModel().isEmpty())) {
           
            int id_edit = lista.getSelectionModel().getSelectedItem().getId_pracownika();
            
            PracownikDAO pDAO = new PracownikDAO();
            
            
            
        Pracownik p;
        if(!((name.getText().equals(""))&&(surname.getText().equals("")))){
            p = new Pracownik(name.getText(), surname.getText());
             
             for (Pracownik p2 : pDAO.findAll()) {
             if (p2.getId_pracownika()==id_edit) {
             
             p2.setImie(name.getText());
             p2.setNazwisko(surname.getText());
             pDAO.update(p2);
        
                }
             }
             load();
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Błąd");
            alert.setHeaderText("Wypełnij pole imie i nazwisko");
            
            alert.showAndWait();
        }
    }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Błąd");
            alert.setHeaderText("Pracownik nie istnieje lub nie wybrałeś go na liście");
            
            alert.showAndWait();
       }
}       
      
      
      //przeładowywanie listy gdy nastąpi edycja oraz wyświetlanie elementów
      //na liście 
       private void load() {
        PracownikDAO klientDAO = new PracownikDAO();
        pracownicy = klientDAO.findAll();
        listProperty = new SimpleListProperty();
        listaPracownikow = FXCollections.observableArrayList(pracownicy);
        listProperty.set(listaPracownikow);
        lista.itemsProperty().bindBidirectional(listProperty);
        
    }
       

      

    
}
