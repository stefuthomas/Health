import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "customer_type", discriminatorType = DiscriminatorType.STRING)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int custId;
    private String firstName;
    private String lastName;

    @OneToOne(mappedBy = "customer")
    private BasicProfile basicProfile;

    public Customer() {
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getCustId() {
        return custId;
    }
}

@Entity
@DiscriminatorValue("ContractCustomer")
class ContractCustomer extends Customer {
    private int contractId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public ContractCustomer() {
    }

    public ContractCustomer(String firstName, String lastName, int contractId, LocalDateTime startDate, LocalDateTime endDate) {
        super(firstName, lastName);
        this.contractId = contractId;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
