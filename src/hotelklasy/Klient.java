package hotelklasy;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Klient")
public class Klient implements Serializable {
    
    private static final long serialVersionUID = -300025L;
    
    
    @Column(name="id_klienta", unique=true)
    @Id
    @GeneratedValue
    private int id_klienta;
    
    @Column(name="imie")
    private String imie;
    
    @Column(name="nazwisko")
    private String nazwisko;
    
    @Column(name="telefon")
  
    private int telefon;
    
    @Column(name="pesel")
    private long pesel;
    


    public Klient(String imie, String nazwisko, int telefon, long pesel) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.telefon = telefon;
        this.pesel = pesel;
    }
    
    public Klient(){}

    public int getId_klienta() {
        return id_klienta;
    }

    public void setId_klienta(int id_klienta) {
        this.id_klienta = id_klienta;
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

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public long getPesel() {
        return pesel;
    }

    public void setPesel(long pesel) {
        this.pesel = pesel;
    }

   @Override
    public String toString() {
        return  imie + " " + nazwisko+" "+" Numer telefonu:"+" "+telefon+" PESEL:"+" "+pesel;
    }
      
}
