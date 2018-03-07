package hotelklasy;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Rezerwacja")
public class Rezerwacja implements Serializable {
    
    @Column(name = "id_rezerwacji", unique = true)
    @Id
    @GeneratedValue
    private int id_rezerwacji;
    
    @Column(name = "data")
    private Date data;

    @OneToOne
    @JoinColumn(name = "Klient", nullable = false)
    
    private Klient Klient;

    @OneToOne
    @JoinColumn(name = "Stolik", nullable = false)

    private Pokoj Pokoj;

    public Rezerwacja(Klient Klient, Pokoj Pokoj, Date data) {
        this.Klient = Klient;
        this.Pokoj = Pokoj;
        this.data = data;
    }
    
    public Rezerwacja(){}

    public int getId_rezerwacji() {
        return id_rezerwacji;
    }

    public void setId_rezerwacji(int id_rezerwacji) {
        this.id_rezerwacji = id_rezerwacji;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Klient getKlient() {
        return Klient;
    }

    public void setKlient(Klient Klient) {
        this.Klient = Klient;
    }

    public Pokoj getPokoj() {
        return Pokoj;
    }

    public void setPokoj(Pokoj Pokoj) {
        this.Pokoj = Pokoj;
    }

    @Override
    public String toString() {
        int dzien = 0, miesiac = 0, rok = 0, godzina = 0, minuta = 0;

        try {
            dzien = data.getDate();
            miesiac = data.getMonth() + 1;
            rok = data.getYear() + 1900;
            godzina = data.getHours();
            minuta = data.getMinutes();
            return Klient.getImie() + " " + Klient.getNazwisko() + ", Pokój " + Pokoj.getId_pokoju() + ".  " + dzien + "-" + miesiac + "-" + rok + " " + godzina + ":" + minuta;
        } catch (Exception x) {
            return Klient.getImie() + " " + Klient.getNazwisko() + ", Pokój " + Pokoj.getId_pokoju() + ".  " + dzien + "-" + miesiac + "-" + rok + " " + godzina + ":" + minuta;
        }

    }
    
    
}
