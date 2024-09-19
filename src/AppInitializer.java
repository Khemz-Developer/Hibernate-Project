import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;

public class AppInitializer {
    public static void main(String[] args) {

        HibernateUtil.getSession();

//        Customer c1 = new Customer("C001", "John", "Colombo", 45000);
//        if(saveCustomer(c1)){
//            System.out.println("Customer Saved");
//        }

//        Customer c1 = new Customer("C001", "John", "Colombo", 45000.0, null);
//        Computer computer = new Computer("COO1", "Dell", c1);
//        c1.setComputer(computer);
//        if(saveCustomer(c1)){
//            System.out.println("Customer Saved");
//        }



//        Customer customer = findCustomer("C001");
//        System.out.println(customer);


//          findAllCustomer().forEach(System.out::println);

//        Customer c1 = new Customer("C001", "John David", "Colombo 07", 45000);
//        if(updateCustomer(c1, "C001")){
//            System.out.println("Customer Updated");
//        }



//          Customer customer = deleteCustomer("C001");
//            if(customer != null){
//                System.out.println("Customer Deleted");
//            }else{
//                System.out.println("Customer Not Found");
//            }


    }


    // ----------------------CRUD Operations--------------------

    // Save Customer-----
    private static boolean saveCustomer(Customer c){
        try(Session session = HibernateUtil.getSession()){
            Transaction transaction= session.beginTransaction();
            session.save(c);
            transaction.commit();
            return true;

        }

    }

    // Find Customer-----
    private static Customer findCustomer(String id){
        try(Session session = HibernateUtil.getSession()){

            return session.get(Customer.class,id);

        }

    }

    // Find All Customers-----
    private static List findAllCustomer(){
        try(Session session = HibernateUtil.getSession()){
            Query query = session.createQuery("FROM Customer", Customer.class);
            return query.getResultList();
        }
    }

    // Update Customer-----
    private static boolean updateCustomer(Customer c, String id){
        try(Session session = HibernateUtil.getSession()){

            Customer customer = session.get(Customer.class, id);
            if(customer != null){
                Transaction transaction = session.beginTransaction();
                customer.setName(c.getName());
                customer.setAddress(c.getAddress());
                customer.setSalary(c.getSalary());
                session.update(customer);
                transaction.commit();
                return true;
            }else{
                return false;
            }

        }

    }

    // Delete Customer-----
    private static Customer deleteCustomer(String id){
        try(Session session = HibernateUtil.getSession()){

            Customer customer = session.get(Customer.class, id);
            if(customer != null){
                Transaction transaction = session.beginTransaction();
                session.delete(customer);
                transaction.commit();
                return customer;
            }else{
                return null;
            }

        }

    }


}
