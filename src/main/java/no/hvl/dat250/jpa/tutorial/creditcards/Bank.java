package no.hvl.dat250.jpa.tutorial.creditcards;

import jakarta.persistence.*;
import java.util.Collection;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
    @OneToMany(mappedBy = "owningBank")
    private Collection<CreditCard> ownedCards;

    public String getName() {
        return name;
    }

    public Collection<CreditCard> getOwnedCards() {
        return ownedCards;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwnedCards(Collection<CreditCard> ownedCards) {
        this.ownedCards = ownedCards;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
}

