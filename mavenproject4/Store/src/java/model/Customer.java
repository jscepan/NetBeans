package model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Customer {

    private int customerId;
    private String name;

    public Customer() {
    }

    public Customer(int customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" + "customerId=" + customerId + ", name=" + name + '}';
    }
    
        public static List<Customer> getAllCustomers() throws ClassNotFoundException {
//        System.out.println("-----------------sdffsda-----------------------------------------");
        List<Customer> listOfAllCustomers = new ArrayList<>();

        Class.forName("com.mysql.jdbc.Driver");
        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/store", "root", "password");) {
            Statement st = conn.createStatement();
            st.executeQuery("select * from customer");
            ResultSet rs = st.getResultSet();
            Customer customer = null;
            while (rs.next()) {
                customer = new Customer(Integer.valueOf(rs.getString(1)), rs.getString(2));
                listOfAllCustomers.add(customer);
//                System.out.println("---------------------------------------------------------------------------");
//                System.out.println("customer: "+customer);
//                System.out.println("---------------------------------------------------------------------------");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listOfAllCustomers;
    }

    public static void createNewCustomer(String name) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/store", "root", "password");) {
            Statement st = conn.createStatement();
            st.executeUpdate("insert into customer value (null, '" + name + "')");
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void deleteCustomer(int id) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/store", "root", "password");) {
            Statement st = conn.createStatement();
            st.executeUpdate("delete from customer where idcustomer='" + id + "'");
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String getNameById(int id) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String name = null;
        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/store", "root", "password");) {
            Statement st = conn.createStatement();
            st.executeQuery("select name from customer where idcustomer='" + id + "'");
            ResultSet rs = st.getResultSet();
            rs.next();
            name = rs.getString(1);
            System.out.println("//////////////////////////name/+++++++++++++++++++++++++++++++++++: "+name);
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return name;
    }
    
        public static void changeCustomer(Customer p) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/store", "root", "password");) {
            Statement st = conn.createStatement();
            st.executeUpdate("update customer set name ='"+p.getName()+"' where idcustomer="+p.getCustomerId());
        } catch (SQLException ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
