import jakarta.persistence.*;

@Entity
public class BasicProfile {

    @Id
    private int custId;
    private int birthYear;
    private float weight;
    private int height;

    @OneToOne
    @MapsId
    @JoinColumn(name = "custId")
    private Customer customer;

    public BasicProfile() {
    }

    public BasicProfile(int birthYear, float weight, int height, Customer customer) {
        this.birthYear = birthYear;
        this.weight = weight;
        this.height = height;
        this.customer = customer;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }
}
