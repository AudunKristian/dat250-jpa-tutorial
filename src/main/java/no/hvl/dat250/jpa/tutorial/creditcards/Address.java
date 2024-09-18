package no.hvl.dat250.jpa.tutorial.creditcards;

import java.util.Collection;
import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private Integer number;
    
    @ManyToMany(mappedBy = "addresses")
    private Collection<Customer> owners;

    public String getStreet() {
        return street;
    }

    public Integer getNumber() {
        return number;
    }

    public Collection<Customer> getOwners() {
        return owners;
    }

    public Long getId() {
        return id;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setOwners(Collection<Customer> owners) {
        this.owners = owners;
    }

    public void setId(Long id) {
        this.id = id;
    }

}

