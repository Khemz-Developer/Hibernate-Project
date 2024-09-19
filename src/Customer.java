import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    private String id;
    private String name;
    private String address;
    private double salary;
    @OneToOne(mappedBy = "customer")
    private Computer computer;

    @OneToMany(mappedBy = "customer")
    private List<CustomerOrder> orders;

    public Customer() {
    }

    public Customer(String id, String name, String address, double salary, Computer computer) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.computer = computer;
    }




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                '}';
    }
}
