package controleur;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EtudiantDAO;

import beans.Etudiant;

/**
 * Servlet implementation class ControleurEtudiant
 */
@WebServlet("/ControleurEtudiant")
public class ControleurEtudiant extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public ControleurEtudiant() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String mdp = request.getParameter("mdp");
		response.setContentType("text/html;charset=UTF-8");
		RequestDispatcher disp;
		try {
			EtudiantDAO etu = new EtudiantDAO();

			if (etu.AuthEtu(login, mdp)) {
				disp = getServletContext()
						.getRequestDispatcher("/accueileleve.jsp");
				disp.forward(request, response);
			} else {

				disp = getServletContext().getRequestDispatcher(
						"/Login.jsp");
				disp.forward(request, response);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// RequestDispatcher
		// disp=getServletContext().getRequestDispatcher("/test_reponse.jsp");

		// request.setAttribute("entreprise",etp);

		// disp.forward(request, response);

	}

}
