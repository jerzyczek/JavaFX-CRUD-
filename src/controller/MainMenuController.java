package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import modeldao.HibernateUtil;


public class MainMenuController {

    private MainScreenController mainScreenController;

    @FXML
    private Button wypelnij;

    private static boolean wypelniono = false;

    public void initialize() {
        if (wypelniono) { 
            wypelnij.setVisible(false);
        }

    }
    //ustawianie kontrolera głównego widoku
    public void setMainScreenController(MainScreenController mainScreenController) {
        this.mainScreenController = mainScreenController;
    }
    
    //otwieranie widoku Klienci 
    public void openKlienci() {
        
        HibernateUtil.setMainConfiguration("cfg/hibernate.cfg.xml");
      
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/Klienci.fxml"));

        Pane panel = null;
        try {
            panel = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

        KlienciController KlientKontrol = loader.getController();
        KlientKontrol.setMainScreenController(mainScreenController);
        mainScreenController.setScreen(panel);
    }
    
    //otwieranie widoku Pokoje
    public void openPokoje() {

        
        HibernateUtil.setMainConfiguration("cfg/hibernate.cfg.xml");
        
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/Pokoj.fxml"));

        Pane panel = null;
        try {
            panel = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

        PokojController PokojKontrol = loader.getController();
        PokojKontrol.setMainScreenController(mainScreenController);
        mainScreenController.setScreen(panel);
    }

    //otwieranie widoku Pracownicy
    public void openPracownicy() {

        HibernateUtil.setMainConfiguration("cfg/hibernate.cfg.xml");
      
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/Pracownik.fxml"));

        Pane panel = null;
        try {
            panel = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

        PracownikController PracownikKontrol = loader.getController();
        PracownikKontrol.setMainScreenController(mainScreenController);
        mainScreenController.setScreen(panel);
    }
    
    //otwieranie widoku Rezerwacje 
    public void openRezerwacje() {

        HibernateUtil.setMainConfiguration("cfg/hibernate.cfg.xml");
        
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/Rezerwacje.fxml"));

        Pane panel = null;
        try {
            panel = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

        RezerwacjeController rezerwacjeKontrol = loader.getController();
        rezerwacjeKontrol.setMainScreenController(mainScreenController);
        mainScreenController.setScreen(panel);
    }
    
    //otwieranie widoku Pracownik
    public void openEditPracownik(){
        
        HibernateUtil.setMainConfiguration("cfg/hibernate.cfg.xml");
        
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/EditPracownik.fxml"));
        
        Pane panel = null;
        try {
            panel = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

        EditPracownikController editPracownik = loader.getController();
        editPracownik.setMainScreenController(mainScreenController);
        mainScreenController.setScreen(panel);
        
        
    }
    
    //otwieranie widoku Klient 
    public void openEditKlient(){
         
        HibernateUtil.setMainConfiguration("cfg/hibernate.cfg.xml");
        
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/EditKlient.fxml"));
        
        Pane panel = null;
        try {
            panel = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

        EditKlientController editKlient = loader.getController();
        editKlient.setMainScreenController(mainScreenController);
        mainScreenController.setScreen(panel);
    }


}
