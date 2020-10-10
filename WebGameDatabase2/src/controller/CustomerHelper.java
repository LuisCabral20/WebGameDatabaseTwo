package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Customer;

public class CustomerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebGameDatabase");

	public void insertCustomer(Customer li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}

	public List<Customer> showAllCustomers() {
		EntityManager em = emfactory.createEntityManager();
		List<Customer> allCustomers = em.createQuery("SELECT c FROM Customer c").getResultList();
		return allCustomers;
	}

	public Customer findCustomer(String nameToLookUp) {

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Customer> typedQuery = em.createQuery("select cu from Customer cu where cu.customerName = :selectedName",
				Customer.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		Customer foundCustomer;
		try {
			foundCustomer = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundCustomer = new Customer(nameToLookUp);
		}
		em.close();

		return foundCustomer;
	}
}