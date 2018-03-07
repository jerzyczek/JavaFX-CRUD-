package hotelklasy;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Pracownik")
public class Pracownik implements Serializable {
    
    @Column(name="id_pracownika", unique=true)
    @Id
    @GeneratedValue
    private int id_pracownika;
    
    @Column(name="imie")
    private String imie;
    
    @Column(name="nazwisko")
    private String nazwisko;
    

    

    public Pracownik(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public Pracownik() {
    }

    public int getId_pracownika() {
        return id_pracownika;
    }

    public void setId_pracownika(int id_pracownika) {
        this.id_pracownika = id_pracownika;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }    
 
    @Override
    public String toString() {
        return imie + " " + nazwisko;
    }
    
}
