package babinvas;

import babinvas.repository.Greeter;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AppTest {
	@Test
	public void init() {
		Greeter jpaGreeter = new Greeter();
		jpaGreeter.setGreeting("Hello");
		jpaGreeter.setTarget("JPA");

		Greeter hibernateGreeter = new Greeter();
		hibernateGreeter.setGreeting("Hi");
		hibernateGreeter.setTarget("Hibernate");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("babinvas");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		em.persist(jpaGreeter);
		em.persist(hibernateGreeter);
		em.getTransaction().commit();
		em.close();

		em = emf.createEntityManager();
		em.getTransaction().begin();

		List<Greeter> greetersList = em.createQuery("from Greeter", Greeter.class).getResultList();

		for (Greeter greeter : greetersList) {
			System.out.printf("%s, %s!%n", greeter.getGreeting(), greeter.getTarget());
		}
	}
}
