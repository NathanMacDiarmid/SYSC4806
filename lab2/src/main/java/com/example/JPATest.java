package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPATest {

    public void performJPA() {
	
		/* Buddies persisted first */
        BuddyInfo buddy1 = new BuddyInfo();
        buddy1.setName("Bob Dylan");
        buddy1.setNumber("123456789");
		buddy1.setID(1);

        BuddyInfo buddy2 = new BuddyInfo();
        buddy2.setName("Dylan Bob");
        buddy2.setNumber("987654321");
		buddy2.setID(2);

		ArrayList<BuddyInfo> buddies = new ArrayList<BuddyInfo>();
		buddies.add(buddy1);
		buddies.add(buddy2);

        AddressBook book = new AddressBook();
		book.setBookID(1);
		book.setBuddies(buddies);

		/* Buddies persisted inside AddressBook */
		BuddyInfo buddy3 = new BuddyInfo();
        buddy3.setName("Elvis Presley");
        buddy3.setNumber("123456789");
		buddy3.setID(3);

        BuddyInfo buddy4 = new BuddyInfo();
        buddy4.setName("Presley Elvis");
        buddy4.setNumber("987654321");
		buddy4.setID(4);

		ArrayList<BuddyInfo> buddies2 = new ArrayList<BuddyInfo>();
		buddies2.add(buddy3);
		buddies2.add(buddy4);

        AddressBook book2 = new AddressBook();
		book2.setBookID(2);
		book2.setBuddies(buddies2);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");

		EntityManager em = emf.createEntityManager();

		// Creating a new transaction
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		// Persisting the product entity objects
		em.persist(buddy1);
		em.persist(buddy2);
        em.persist(book);

		tx.commit();

		// Querying the contents of the database using JPQL query
		Query q = em.createQuery("SELECT b FROM BuddyInfo b");
        Query q2 = em.createQuery("SELECT l FROM AddressBook l");

		@SuppressWarnings("unchecked")
		List<BuddyInfo> results = q.getResultList();
        List<AddressBook> buddyBook = q2.getResultList();
		
		System.out.println();
		System.out.println("List of buddies\n----------------");

		for (BuddyInfo p : results) {

			System.out.println(p.getID() + " " + p.getName() + " " + p.getNumber());
		}

		System.out.println();
		System.out.println("List of buddies from AddressBook\n----------------");
		for (AddressBook a : buddyBook) {
			System.out.println(a.getBuddies().get(0).getID() + " " + a.getBuddies().get(0).getName() + " " + a.getBuddies().get(0).getNumber());
			System.out.println(a.getBuddies().get(1).getID() + " " + a.getBuddies().get(1).getName() + " " + a.getBuddies().get(1).getNumber());
		}

		tx.begin();

		// Persisting the product entity objects
		em.persist(book2);

		tx.commit();

		Query q3 = em.createQuery("SELECT l FROM AddressBook l");
		List<AddressBook> buddyBook2 = q3.getResultList();

		System.out.println();
		System.out.println("List of buddies from AddressBook w/ Buddies persisted after\n----------------");
		for (AddressBook a : buddyBook2) {
			System.out.println(a.getBuddies().get(0).getID() + " " + a.getBuddies().get(0).getName() + " " + a.getBuddies().get(0).getNumber());
			System.out.println(a.getBuddies().get(1).getID() + " " + a.getBuddies().get(1).getName() + " " + a.getBuddies().get(1).getNumber());
		}

		// Closing connection
		em.close();

		emf.close();
    }
}