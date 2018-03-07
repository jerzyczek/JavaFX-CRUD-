package controller;

import hotelklasy.Klient;
import java.util.List;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import modeldao.KlientDAO;


public class EditKlientController {
  
    
    
    @FXML
    private TextField name;

    @FXML
    private TextField surname;

    @FXML
    private ListView<Klient> lista;

    @FXML
    private TextField number;

    @FXML
    private TextField pesel;
    
    private MainScreenController mainScreenController;
    private List<Klient> klienci;
    private SimpleListProperty listProperty;
    private ObservableList<Klient> listaKlientow;
    
       //ustawianie kontrolera głównego widoku
       public void setMainScreenController(MainScreenController mainScreenController){
        this.mainScreenController = mainScreenController;
    }
       
       //edytowanie klienta
        public void editKlientRecord(){
            
       if ((!lista.getSelectionModel().isEmpty())) {
           try{
            int id_edit = lista.getSelectionModel().getSelectedItem().getId_klienta();
       
            KlientDAO kDAO = new KlientDAO();
        
        Klient k;
        if(!((name.getText().equals(""))&&(surname.getText().equals(""))&&(number.getText().equals(""))&&(pesel.getText().equals("")))){
            int numerTel = Integer.parseInt(number.getText());
            long peselLong = Long.parseLong(pesel.getText());
            k = new Klient(name.getText(), surname.getText(), numerTel, peselLong);
             int z = 0;
             for (int i = 0; i < pesel.getText().length(); i++){
                 z++;
             }
             int e = 0;
             for(int j=0; j<number.getText().length(); j++){
                 e++;
             }
             if(z==11 && e==9){
             for (Klient k2 : kDAO.findAll()) {
             if (k2.getId_klienta()==id_edit) {
             k2.setImie(name.getText());
             k2.setNazwisko(surname.getText());
             k2.setTelefon(numerTel);
             k2.setPesel(peselLong);
             kDAO.update(k2);
                }
             }
             load();
             }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Błąd");
            alert.setHeaderText("Pole numer telefonu bądź pesel zostały niepoprawnie wypełnione");
            alert.showAndWait();
             }
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Błąd");
            alert.setHeaderText("Wypełnij pole imie, nazwisko, numer telefonu i pesel");
            alert.showAndWait();
        }
    }catch(NumberFormatException  e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Błąd");
            alert.setHeaderText("Pole numer telefonu i pesel muszą być liczbami bądź jedno z pól nie zostało wypełnione poprawnie");
            alert.showAndWait();
    }}
           else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Błąd");
            alert.setHeaderText("Klient nie istnieje lub nie wybrałeś go na liście");
            alert.showAndWait();
            }
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
