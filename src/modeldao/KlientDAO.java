package modeldao;

import java.util.List;
import hotelklasy.Klient;

public class KlientDAO extends DAO<Klient, Integer> {
   
    @Override
    public List<Klient> findAll() {
        openCurrentSession();
        List<Klient> klienci = (List<Klient>) getCurrentSession().createQuery("from Klient").list();
        closeCurrentSession();
        return klienci;
    }

    @Override
    public Klient findById(Integer id) {
        openCurrentSession();
        Klient klient = (Klient) getCurrentSession().get(Klient.class, id);
        closeCurrentSession();
        return klient;
    }
    
    public Klient findByNumber(long number) {
        openCurrentSession();
        Klient klient = (Klient) getCurrentSession().get(Klient.class, number);
        closeCurrentSession();
        return klient;
    }
    
    
}
