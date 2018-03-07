package controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class MainScreenController{
    
    @FXML
    private StackPane mainScreen;
    
   //ładowanie głównego menu aplikacji 
   public void loadMenu() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(this.getClass().getResource("/fxml/MainMenu.fxml"));
        
        Pane Pane = null;
        try {
            Pane = loader.load();
        } catch (IOException ex) {
          
        }
        
        setScreen(Pane);
        
        MainMenuController kontrol = loader.getController();
        kontrol.setMainScreenController(this);
    }    
    
   //dodawanie panelu do głównego okan aplikacji
   public void setScreen(Pane Pane) {
        mainScreen.getChildren().clear();
        mainScreen.getChildren().add(Pane);
    }
   
    
    public void initialize() {
        loadMenu(); 
    }    
    
}
