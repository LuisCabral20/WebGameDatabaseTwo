import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.CustomerHelper;
import controller.GameInformationHelper;
import controller.OrderDetailsHelper;
import model.Customer;
import model.GameInformation;
import model.OrderDetails;

public class OrderTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//OrderDetailsHelper odh = new OrderDetailsHelper();
		//CustomerHelper ch = new CustomerHelper();
		//Customer jim = new Customer("Jim");
		
		//GameInformation farCry = new GameInformation("Far Cry", 2020, "All", "Shooter");
		//GameInformation zelda = new GameInformation("Zelda", 2006, "GameCube", "Adventure");
		
		//List<GameInformation> jimsItems = new ArrayList<GameInformation>();
		//jimsItems.add(farCry);
		//jimsItems.add(zelda);
		
		//OrderDetails jimsOrder = new OrderDetails("Jim's order", LocalDate.now(), jim);
		//jimsOrder.setListOfItems(jimsItems);
		
		//odh.insertNewOrderDetails(jimsOrder);
		
		
		//List<OrderDetails> allOrders = odh.getOrders();
		//for(OrderDetails a : allOrders) {
		//	System.out.println(a.toString());
		//}
		
		System.out.println(GameInformationHelper.class.getProtectionDomain().getCodeSource().getLocation());
		System.out.println(System.getProperty("GameInformation.classpath"));
	}

}
