package hotelklasy;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Pokoj")
public class Pokoj implements Serializable {
    
    @Column(name="id_pokoju", unique=true)
    @Id
    @GeneratedValue
    private int id_pokoju;
    
    @ManyToOne
    @JoinColumn(name="id_pracownika",nullable=false)
    private Pracownik Pracownik;
    
    public Pokoj(){}

    public int getId_pokoju() {
        return id_pokoju;
    }

    public void setId_pokoju(int id_pokoju) {
        this.id_pokoju = id_pokoju;
    }



    public Pracownik getPracownik() {
        return Pracownik;
    }

    public void setPracownik(Pracownik Pracownik) {
        this.Pracownik = Pracownik;
    }

   @Override
    public String toString() {
        return  "Pokój nr "+id_pokoju +" Pracownik: "+ Pracownik.toString();
    }
  
}
