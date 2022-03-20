package Ecommerce.ECommerce.backend.Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Table(name="customers")
public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer customer_id;

    @Column(name="Name")
    private String Name;

    @Column (name="email")
    private String email;

    @Column(name = "password")
    private String password;
   
    @Column(name="address")
    private String address;

    @Column(name="country")
    private String country;
   
    @JsonIgnore
    @OneToMany(mappedBy = "customer",
            fetch = FetchType.LAZY)
    private List<Order> orders;



}
