package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.OrderDetails;

/**
 * Servlet implementation class OrderNavigationServlet
 */
@WebServlet("/orderNavigationServlet")
public class OrderNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderNavigationServlet() {
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
		// TODO Auto-generated method stub
				OrderDetailsHelper odh = new OrderDetailsHelper();
				String act = request.getParameter("doThisToOrder");

				if (act == null) {
					// no button has been selected
					getServletContext().getRequestDispatcher("/viewAllOrdersServlet").forward(request, response);

				} else if (act.equals("delete")) {
					try {
						Integer tempId = Integer.parseInt(request.getParameter("id"));
						OrderDetails orderToDelete = odh.searchForOrderDetailsById(tempId);
						odh.deleteOrder(orderToDelete);

					} catch (NumberFormatException e) {
						System.out.println("Forgot to click a button");
					} finally {
						getServletContext().getRequestDispatcher("/viewAllOrdersServlet").forward(request, response);
					}

				} else if (act.equals("edit")) {
					try {
						Integer tempId = Integer.parseInt(request.getParameter("id"));
						OrderDetails orderToEdit = odh.searchForOrderDetailsById(tempId);
						request.setAttribute("orderToEdit", orderToEdit);
						request.setAttribute("month", orderToEdit.getOrderDate().getMonthValue());
						request.setAttribute("date", orderToEdit.getOrderDate().getDayOfMonth());
						request.setAttribute("year", orderToEdit.getOrderDate().getYear());
						GameInformationHelper daoForGames = new GameInformationHelper();
						
						request.setAttribute("allGames", daoForGames.showAllGames());
									
						if(daoForGames.showAllGames().isEmpty()){
								request.setAttribute("allGames", " ");
						}
						getServletContext().getRequestDispatcher("/edit-order.jsp").forward(request, response);
					} catch (NumberFormatException e) {
						getServletContext().getRequestDispatcher("/viewAllOrdersServlet").forward(request, response);
					} 

				} else if (act.equals("add")) {
					GameInformationHelper daoForGames = new GameInformationHelper();
					request.setAttribute("allGames", daoForGames.showAllGames());
					getServletContext().getRequestDispatcher("/new-order.jsp").forward(request, response);
				}
	}

}
