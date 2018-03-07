package modeldao;

import java.util.List;
import hotelklasy.Pracownik;
 

public class PracownikDAO extends DAO<Pracownik, Integer> {
    
    @Override
    public  List<Pracownik> findAll() {
        openCurrentSession();
        List<Pracownik> pracownicy = (List<Pracownik>) getCurrentSession().createQuery("from Pracownik").list();
        closeCurrentSession();
        return pracownicy;
    }

    @Override
    public Pracownik findById(Integer id) {
        openCurrentSession();
        Pracownik pracownik = (Pracownik) getCurrentSession().get(Pracownik.class, id);
        closeCurrentSession();
        return pracownik;
    }
    
    public Pracownik findByNumber(long number) {
        openCurrentSession();
        Pracownik pracownik = (Pracownik) getCurrentSession().get(Pracownik.class, number);
        closeCurrentSession();
        return pracownik;
    }
    

    
    
}
