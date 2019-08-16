package model;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Product {

    private int productId;
    private String name;

    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }

    public Product(int productId, String name) {
        this.productId = productId;
        this.name = name;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", name=" + name + '}';
    }

    public static List<Product> getAllProduct() throws ClassNotFoundException {
//        System.out.println("-----------------sdffsda-----------------------------------------");
        List<Product> listOfAllProducts = new ArrayList<>();

        Class.forName("com.mysql.jdbc.Driver");
        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/store", "root", "password");) {
            Statement st = conn.createStatement();
            st.executeQuery("select * from product");
            ResultSet rs = st.getResultSet();
            Product product = null;
            while (rs.next()) {
                product = new Product(Integer.valueOf(rs.getString(1)), rs.getString(2));
                listOfAllProducts.add(product);
//                System.out.println("---------------------------------------------------------------------------");
//                System.out.println("product: "+product);
//                System.out.println("---------------------------------------------------------------------------");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listOfAllProducts;
    }

    public static void createNewProduct(String name) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/store", "root", "password");) {
            Statement st = conn.createStatement();
            st.executeUpdate("insert into product value (null, '" + name + "')");
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void deleteProduct(int id) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/store", "root", "password");) {
            Statement st = conn.createStatement();
            st.executeUpdate("delete from product where idproduct='" + id + "'");
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String getNameById(int id) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String name = null;
        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/store", "root", "password");) {
            Statement st = conn.createStatement();
            st.executeQuery("select name from product where idproduct='" + id + "'");
            ResultSet rs = st.getResultSet();
            rs.next();
            name = rs.getString(1);
            System.out.println("//////////////////////////name/+++++++++++++++++++++++++++++++++++: "+name);
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        return name;
    }
    
        public static void changeProduct(Product p) throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        try (java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/store", "root", "password");) {
            Statement st = conn.createStatement();
            st.executeUpdate("update product set name ='"+p.getName()+"' where idproduct="+p.getProductId());
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
