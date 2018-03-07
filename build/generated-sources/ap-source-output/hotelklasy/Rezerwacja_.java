package hotelklasy;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Rezerwacja.class)
public abstract class Rezerwacja_ {

	public static volatile SingularAttribute<Rezerwacja, Integer> id_rezerwacji;
	public static volatile SingularAttribute<Rezerwacja, Date> data;
	public static volatile SingularAttribute<Rezerwacja, Pokoj> Pokoj;
	public static volatile SingularAttribute<Rezerwacja, Klient> Klient;

}

