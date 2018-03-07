package modeldao;

import java.util.List;
import hotelklasy.Rezerwacja;

public class RezerwacjaDAO extends DAO<Rezerwacja, Integer> {
    
    @Override
    public List<Rezerwacja> findAll() {
        openCurrentSession();
        List<Rezerwacja> rezerwacje = (List<Rezerwacja>) getCurrentSession().createQuery("from Rezerwacja").list();
        closeCurrentSession();
        return rezerwacje;
    }

    @Override
    public Rezerwacja findById(Integer id) {
        openCurrentSession();
        Rezerwacja rezerwacja = (Rezerwacja) getCurrentSession().get(Rezerwacja.class, id);
        closeCurrentSession();
        return rezerwacja;
    }
    
    public Rezerwacja findByNumber(long number) {
        openCurrentSession();
        Rezerwacja rezerwacja = (Rezerwacja) getCurrentSession().get(Rezerwacja.class, number);
        closeCurrentSession();
        return rezerwacja;
    }
    
}
