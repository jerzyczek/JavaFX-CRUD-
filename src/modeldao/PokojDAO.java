package modeldao;

import java.util.List;
import hotelklasy.Pokoj;

public class PokojDAO extends DAO<Pokoj, Integer> {
    
    @Override
    public List<Pokoj> findAll() {
        openCurrentSession();
        List<Pokoj> stanowisko = (List<Pokoj>) getCurrentSession().createQuery("from Pokoj").list();
        closeCurrentSession();
        return stanowisko;
    }

    @Override
    public Pokoj findById(Integer id) {
        openCurrentSession();
        Pokoj stanowisko = (Pokoj) getCurrentSession().get(Pokoj.class, id);
        closeCurrentSession();
        return stanowisko;
    }
    
    public Pokoj findByNumber(long number) {
        openCurrentSession();
        Pokoj stanowisko = (Pokoj) getCurrentSession().get(Pokoj.class, number);
        closeCurrentSession();
        return stanowisko;
    }
    
}
