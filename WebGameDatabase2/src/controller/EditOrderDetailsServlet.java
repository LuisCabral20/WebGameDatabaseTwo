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
 * Servlet implementation class EditOrderDetailsServlet
 */
@WebServlet("/editOrderDetailsServlet")
public class EditOrderDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditOrderDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderDetailsHelper odh = new OrderDetailsHelper();
		GameInformationHelper gih = new GameInformationHelper();
		CustomerHelper ch = new CustomerHelper();
		
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		OrderDetails orderToUpdate = odh.searchForOrderDetailsById(tempId);

		String newOrderName = request.getParameter("orderName");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		
		String customerName = request.getParameter("customerName");

		Customer newCustomer = ch.findCustomer(customerName);

		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}

		try {
			String[] selectedGames = request.getParameterValues("allGamesToAdd");
			List<GameInformation> selectedgamesInOrder = new ArrayList<GameInformation>();

			for (int i = 0; i < selectedGames.length; i++) {
				System.out.println(selectedGames[i]);
				GameInformation c = gih.searchForItemById(Integer.parseInt(selectedGames[i]));
				selectedgamesInOrder.add(c);

			}
			orderToUpdate.setListOfGames(selectedgamesInOrder);
		} catch (NullPointerException ex) {
			List<GameInformation> selectedgamesInOrder = new ArrayList<GameInformation>();
			orderToUpdate.setListOfGames(selectedgamesInOrder);
		}

		orderToUpdate.setOrderName(newOrderName);
		orderToUpdate.setOrderDate(ld);
		orderToUpdate.setCustomer(newCustomer);
		odh.updateOrder(orderToUpdate);
		getServletContext().getRequestDispatcher("/viewAllOrdersServlet").forward(request, response);
	}

}
