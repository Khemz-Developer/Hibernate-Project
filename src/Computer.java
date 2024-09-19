import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class Computer {

    @Id
    private String code;
    private String brand;
    @OneToOne
    @JoinColumn(name = "customer_id", unique = true)
    private Customer customer;

    public Computer() {
    }

    public Computer(String code, String brand, Customer customer) {
        this.code = code;
        this.brand = brand;
        this.customer = customer;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "code='" + code + '\'' +
                ", brand='" + brand + '\'' +
                ", customer=" + customer +
                '}';
    }


}
