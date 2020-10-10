package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Customer;
import model.GameInformation;
import model.OrderDetails;

/**
 * Servlet implementation class CreateNewOrderServlet
 */
@WebServlet("/createNewOrderServlet")
public class CreateNewOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				GameInformationHelper gih = new GameInformationHelper();
				String orderName = request.getParameter("orderName");
				System.out.println("Order Name: "+ orderName);
				
				String month = request.getParameter("month");
				String day = request.getParameter("day");
				String year = request.getParameter("year");
				String customerName = request.getParameter("customerName");
				LocalDate ld;
				try {
					ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
				}catch(NumberFormatException ex) {
					ld = LocalDate.now();
				}
				
				String[] selectedGames = request.getParameterValues("allGamesToAdd");
				List<GameInformation> selectedGamesInList = new ArrayList<GameInformation>();
				
				for(int i = 0; i<selectedGames.length; i++) {
					System.out.println(selectedGames[i]);
					GameInformation c = gih.searchForItemById(Integer.parseInt(selectedGames[i]));
					selectedGamesInList.add(c);
					
				}
				
				Customer customer = new Customer(customerName);
				OrderDetails odt = new OrderDetails(orderName, ld, customer);
				odt.setListOfGames(selectedGamesInList);
				OrderDetailsHelper odh = new OrderDetailsHelper();
				odh.insertNewOrderDetails(odt);
				
				System.out.println("Success!");
				System.out.println(odt.toString());
				
				getServletContext().getRequestDispatcher("/viewAllOrdersServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
