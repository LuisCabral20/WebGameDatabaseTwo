package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="order_details")
public class OrderDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ORDER_ID")
	private int id;
	@Column(name="ORDER_NAME")
	private String orderName;
	@Column(name="ORDER_DATE")
	private LocalDate orderDate;
	@ManyToOne (cascade=CascadeType.PERSIST)
	@JoinColumn(name="CUSTOMER_ID")
	private Customer customer;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable
	  (
	      name="games_on_list",
	      joinColumns={ @JoinColumn(name="ORDER_ID", referencedColumnName="ORDER_ID") },
	      inverseJoinColumns={ @JoinColumn(name="GAME_ID", referencedColumnName="ID", unique=true) }
	  )
    private List<GameInformation> listOfGames;

	
	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public OrderDetails(int id, String orderName, LocalDate orderDate, Customer customer, List<GameInformation> listOfGames) {
		super();
		this.id = id;
		this.orderName = orderName;
		this.orderDate = orderDate;
		this.customer = customer;
		this.listOfGames = listOfGames;
	}

	public OrderDetails(String orderName, LocalDate orderDate, Customer customer, List<GameInformation> listOfGames) {
		super();
		this.orderName = orderName;
		this.orderDate = orderDate;
		this.customer = customer;
		this.listOfGames = listOfGames;
	}

	public OrderDetails(String orderName, LocalDate orderDate, Customer customer) {
		super();
		this.orderName = orderName;
		this.orderDate = orderDate;
		this.customer = customer;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String listName) {
		this.orderName = listName;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate tripDate) {
		this.orderDate = tripDate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public List<GameInformation> getListOfGames() {
		return listOfGames;
	}


	public void setListOfGames(List<GameInformation> listOfGames) {
		this.listOfGames = listOfGames;
	}

	@Override
	public String toString() {
		return "Game Order: [id=" + id + ", OrderName=" + orderName + ", OrderDate=" + orderDate + ", Customer="
				+ customer + ", listOfGames=" + listOfGames.toString() + "]";
	}
	
}