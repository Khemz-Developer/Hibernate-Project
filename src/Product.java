import javax.persistence.*;
import java.util.List;

@Entity(name = "product") // database ake table ake nama hadenna oni eka denne methana
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long code;

    @Column(name = "description",nullable = false,length = 100)
    private String description;

    @ManyToMany(mappedBy = "products")
    private List<CustomerOrder> orders;


}
