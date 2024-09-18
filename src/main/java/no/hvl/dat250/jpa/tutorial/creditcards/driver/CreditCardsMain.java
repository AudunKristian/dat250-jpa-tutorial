package no.hvl.dat250.jpa.tutorial.creditcards.driver;

import no.hvl.dat250.jpa.tutorial.creditcards.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CreditCardsMain {

    static final String PERSISTENCE_UNIT_NAME = "jpa-tutorial";

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        createObjects(em);
        em.getTransaction().commit();
        em.close();
    }

    private static void createObjects(EntityManager em) {
        // Create a bank
        Bank bank = new Bank();
        bank.setName("Pengebank");
        em.persist(bank);

        // Create a pincode
        Pincode pincode = new Pincode();
        pincode.setCode("123");
        pincode.setCount(1);
        em.persist(pincode);

        // Create two credit cards
        CreditCard firstCard = new CreditCard();
        firstCard.setNumber(12345);
        firstCard.setBalance(-5000);
        firstCard.setCreditLimit(-10000);
        firstCard.setPincode(pincode);
        firstCard.setOwningBank(bank);
        em.persist(firstCard);

        CreditCard secondCard = new CreditCard();
        secondCard.setNumber(123);
        secondCard.setBalance(1);
        secondCard.setCreditLimit(2000);
        secondCard.setPincode(pincode);
        secondCard.setOwningBank(bank);
        em.persist(secondCard);

        // Create an address
        Address address = new Address();
        address.setStreet("Inndalsveien");
        address.setNumber(28);
        em.persist(address);

        // Create a customer
        Customer customer = new Customer();
        customer.setName("Max Mustermann");
        customer.getAddresses().add(address);  // Add address to customer
        customer.getCreditCards().add(firstCard);  // Add first card to customer
        customer.getCreditCards().add(secondCard);  // Add second card to customer
        em.persist(customer);

        // Link address to customer
        address.getOwners().add(customer);
        em.persist(address);  // Ensure bi-directional link is persisted
    }
}
