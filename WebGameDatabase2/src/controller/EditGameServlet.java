package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GameInformation;

/**
 * Servlet implementation class EditGameServlet
 */
@WebServlet("/editGameServlet")
public class EditGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditGameServlet() {
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
		GameInformationHelper helper = new GameInformationHelper();
		
		String name = request.getParameter("name");
		int year = Integer.parseInt(request.getParameter("year"));
		String platforms = request.getParameter("platforms");
		String genres = request.getParameter("genres");
		int tempId = Integer.parseInt(request.getParameter("id"));
		
		GameInformation updateGame = helper.searchForItemById(tempId);
		updateGame.setName(name);
		updateGame.setYear(year);
		updateGame.setPlatforms(platforms);
		updateGame.setGenre(genres);
		
		helper.updateGame(updateGame);
		
		getServletContext().getRequestDispatcher("/viewAllGamesServlet").forward(request, response);
	}

}
