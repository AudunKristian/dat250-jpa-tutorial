package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;

@Entity
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer number;
    private Integer balance;
    private Integer creditLimit;

    @ManyToOne
    @JoinColumn(name = "customer_id")  // This links the CreditCard to the Customer via the foreign key 'customer_id'
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "pincode_id")  // This links the CreditCard to the Pincode
    private Pincode pincode;

    @ManyToOne  // Define the ManyToOne relationship
    @JoinColumn(name = "bank_id")  // This defines the foreign key column in the CreditCard table
    private Bank owningBank;

    // Getters and Setters for other fields

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Integer creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Pincode getPincode() {
        return pincode;
    }

    public void setPincode(Pincode pincode) {
        this.pincode = pincode;
    }

    public Bank getOwningBank() {
        return owningBank;
    }

    public void setOwningBank(Bank owningBank) {
        this.owningBank = owningBank;
    }
}
