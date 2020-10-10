package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.OrderDetails;

public class OrderDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebGameDatabase");

	public void insertNewOrderDetails(OrderDetails s) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
		em.close();
	}

	public List<OrderDetails> getOrders() {
		EntityManager em = emfactory.createEntityManager();
		List<OrderDetails> allDetails = em.createQuery("SELECT d FROM OrderDetails d").getResultList();
		return allDetails;
	}

	public void deleteOrder(OrderDetails toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<OrderDetails> typedQuery = em
				.createQuery("select detail from OrderDetails detail where detail.id = :selectedId", OrderDetails.class);
		// Substitute parameter
		typedQuery.setParameter("selectedId", toDelete.getId());

		// Only get one
		typedQuery.setMaxResults(1);

		// save to new order
		OrderDetails result = typedQuery.getSingleResult();

		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();

	}

	public OrderDetails searchForOrderDetailsById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		OrderDetails found = em.find(OrderDetails.class, tempId);
		em.close();
		return found;
	}

	public void updateOrder(OrderDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}