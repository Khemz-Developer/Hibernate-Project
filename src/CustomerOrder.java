import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "customer_order")
public class CustomerOrder {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderid;
    @Column(columnDefinition = "DATETIME")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany()
    private List<Product> products;
}
