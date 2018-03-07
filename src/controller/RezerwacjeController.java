package controller;

import hotelklasy.Klient;
import hotelklasy.Pokoj;
import hotelklasy.Rezerwacja;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import modeldao.KlientDAO;
import modeldao.PokojDAO;
import modeldao.RezerwacjaDAO;


public class RezerwacjeController{
    
    @FXML
    private ListView<Rezerwacja> lista;
    
    @FXML
    private ComboBox<Klient> comboKlient;
    
    @FXML
    private ComboBox<Pokoj> comboPokoj;
    
    @FXML
    private ComboBox comboGodz;
    
    @FXML
    private ComboBox comboMin;
    
    @FXML
    private DatePicker data;

    private MainScreenController mainScreenController;
    
    private List<Klient> klienci;
    private SimpleListProperty listPropertyKli;
    private ObservableList<Klient> listaKlientow;
    
    private List<Pokoj> pokoje;
    private SimpleListProperty listPropertyPo;
    private ObservableList<Pokoj> listaPokojow;

    private List<Rezerwacja> rezerwacje;
    private SimpleListProperty listPropertyRez;
    private ObservableList<Rezerwacja> listaRezerwacja;
    
    
    public void initialize() {
        loadGodz();
        loadKlienci();
        loadPokoj();
        loadData();
        load();
    }
   
    //ustawianie kontrolera głównego widoku
    public void setMainScreenController(MainScreenController mainScreenController) {
        this.mainScreenController = mainScreenController;
    }
    
    //Dodawanie rezerwacji do bazy danych
     public void dodaj(){

        Klient klient = comboKlient.getSelectionModel().getSelectedItem();
        Pokoj pokoj = comboPokoj.getSelectionModel().getSelectedItem();
        
        int rok = data.getValue().getYear() -1900;
        int miesiac = data.getValue().getMonthValue()-1;
        int dzien = data.getValue().getDayOfMonth();
        int godzina = (int) comboGodz.getValue();
        int minuta = (int) comboMin.getValue();
        
        
        
        Date dataC = new Date(rok,miesiac,dzien,godzina,minuta);
        
        Rezerwacja rezerwacja = new Rezerwacja(klient,pokoj,dataC);
        
        RezerwacjaDAO rezerwacjaDAO = new RezerwacjaDAO();
        
        try{
        rezerwacjaDAO.save(rezerwacja);
        }
        catch(Exception ex ) {}
        load();
        
   }
     
     //wracanie do głównego menu programu
     public void wstecz(){
        mainScreenController.loadMenu();
    }
    
    //usuwanie rezerwacji
    public void usun(){
        Rezerwacja id = lista.getSelectionModel().getSelectedItem();
        RezerwacjaDAO RezerwacjaDAO = new RezerwacjaDAO();
        try {
            RezerwacjaDAO.delete(id);
        } catch (Exception ex) {
     

        }
        load();
        
    }
    
     //przeładowywanie listy gdy nastąpi edycja oraz wyświetlanie elementów
    //na liście 
     private void load(){
        
        
        RezerwacjaDAO rezerwacjaDAO = new RezerwacjaDAO();
        rezerwacje = rezerwacjaDAO.findAll();

        listPropertyRez = new SimpleListProperty();
        listaRezerwacja = FXCollections.observableArrayList(rezerwacje);
        listPropertyRez.set(listaRezerwacja);
        lista.itemsProperty().bindBidirectional(listPropertyRez);
        
    }
     
    //dodawanie godziny do listy  
    private void loadGodz(){
        
        
        ObservableList godziny = FXCollections.observableArrayList();
        for(int i=0;i<=24;i++){
            godziny.add(i);
        }
        comboGodz.setItems(godziny);
        
        
         ObservableList minuty = FXCollections.observableArrayList();
        
         for(int i=0;i<60;i+=10){
             minuty.add(i);
         }
        comboMin.setItems(minuty);
        
        comboGodz.setValue(0);
        comboMin.setValue(0);
    }
    
    //ładowanie klientów do listy
     private void loadKlienci(){
        KlientDAO klientDAO = new KlientDAO();
        klienci = klientDAO.findAll();

        listPropertyKli = new SimpleListProperty();
        listaKlientow = FXCollections.observableArrayList(klienci);
        listPropertyKli.set(listaKlientow);
        comboKlient.itemsProperty().bindBidirectional(listPropertyKli);
    }
     
      //dodawanie pokoi do listy 
      private void loadPokoj(){
        PokojDAO PokojDAO = new PokojDAO();
        pokoje = PokojDAO.findAll();

        listPropertyPo = new SimpleListProperty();
        listaPokojow = FXCollections.observableArrayList(pokoje);
        listPropertyPo.set(listaPokojow);
        comboPokoj.itemsProperty().bindBidirectional(listPropertyPo);
    }
    
     //dodawanie daty do listy
    private void loadData(){
        LocalDate aa = LocalDate.now();
        data.setValue(aa);
    }      
}
