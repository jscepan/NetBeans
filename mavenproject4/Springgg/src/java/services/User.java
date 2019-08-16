package services;

import annotations.Pid;
import javax.validation.constraints.*;
//import org.hibernate.validator.constraints.*;

public class User {

    @NotEmpty(message = "First name can not be left empty")
    private String first_name;

    @NotEmpty
    private String last_name;

    @NotEmpty
    private String date_of_birth;

    @NotEmpty
    @Pid
    private String pid;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String country;

    @NotEmpty
    private String city;

    @NotEmpty
    private String postal;

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public String getPid() {
        return pid;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getPostal() {
        return postal;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    @Override
    public String toString() {
        return "User{" + "first_name=" + first_name + ", last_name=" + last_name + ", date_of_birth=" + date_of_birth + ", pid=" + pid + ", email=" + email + ", country=" + country + ", city=" + city + ", postal=" + postal + '}';
    }
    
    
}
