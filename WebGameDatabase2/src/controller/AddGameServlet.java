package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GameInformation;

/**
 * Servlet implementation class AddGameServlet
 */
@WebServlet("/addGameServlet")
public class AddGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		int year = Integer.parseInt(request.getParameter("year"));
		String platforms = request.getParameter("platforms");
		String genres = request.getParameter("genres");
		
		GameInformation newGame = new GameInformation(name, year, platforms, genres);
		GameInformationHelper helper = new GameInformationHelper();
		helper.insertGame(newGame);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
