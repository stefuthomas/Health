import java.time.LocalDateTime;
import java.util.List;

public class Main {
    private static final Dao dao = new Dao();

    public static void main(String[] args) {
        Customer customer = new Customer("John", "Doe");
        BasicProfile basicProfile = new BasicProfile(1990, 70.0f, 180, customer);
        dao.saveBasicProfile(basicProfile);

        ContractCustomer contractCustomer = new ContractCustomer("Jane", "Doe", 1, LocalDateTime.now(), LocalDateTime.now().plusYears(1));
        dao.saveContractCustomer(contractCustomer);

        Clinic clinic = new Clinic("New York", List.of(customer, contractCustomer));
        dao.saveClinic(clinic);
    }
}
