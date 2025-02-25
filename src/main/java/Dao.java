import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Dao {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("HealthPU");

    public void saveCustomer(Customer customer) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(customer);
        em.getTransaction().commit();
        em.close();
    }

    public Customer getCustomer(int custId) {
        EntityManager em = emf.createEntityManager();
        Customer customer = em.find(Customer.class, custId);
        em.close();
        return customer;
    }

    public void saveContractCustomer(ContractCustomer contractCustomer) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(contractCustomer);
        em.getTransaction().commit();
        em.close();
    }

    public void saveBasicProfile(BasicProfile basicProfile) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(basicProfile);
        em.getTransaction().commit();
        em.close();
    }

    public void saveClinic(Clinic clinic) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(clinic);
        em.getTransaction().commit();
        em.close();
    }

    public Clinic getClinic(int clinicId) {
        EntityManager em = emf.createEntityManager();
        Clinic clinic = em.find(Clinic.class, clinicId);
        em.close();
        return clinic;
    }
}