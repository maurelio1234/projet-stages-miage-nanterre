package controleur;



import java.io.IOException;
import java.sql.SQLException;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EtudiantDAO;

import beans.Etudiant;
import beans.Promotion;


/**
 * Servlet implementation class ControleurEtudiant
 */
@WebServlet("/Controleur_Info_Etudiant")
public class Controleur_Info_Etudiant extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Controleur_Info_Etudiant() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EtudiantDAO etudiantDAO = null;
		response.setContentType("text/html;charset=UTF-8");
		try {
			etudiantDAO = new EtudiantDAO();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Etudiant etudiant = new Etudiant();
		try {
			etudiant = etudiantDAO.find(Integer.parseInt(request.getParameter("id_etudiant")));
		}
		catch (NumberFormatException e) {
			e.printStackTrace();
		}
		request.setAttribute("etudiant", etudiant);
		RequestDispatcher disp=getServletContext().getRequestDispatcher("/information_etudiant.jsp");
		disp.forward(request, response);
	}

	
	/**
	 * @throws SQLException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request) throws ServletException, IOException, SQLException {
	}
}
