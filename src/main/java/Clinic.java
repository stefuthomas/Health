import jakarta.persistence.*;

import java.util.List;

@Entity
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clinicId;
    private String location;

    @ManyToMany
    @JoinTable(
    name = "clinic_customer",
    joinColumns = @JoinColumn(name="clinicId"),
    inverseJoinColumns = @JoinColumn(name="custId")
    )
    private List<Customer> customers;

    public Clinic() {
    }

    public Clinic(String location, List<Customer> customers) {
        this.location = location;
        this.customers = customers;
    }
}
