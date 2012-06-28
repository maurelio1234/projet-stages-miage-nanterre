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
import Manager.ManagerNoteEtudiant;
import beans.Etudiant;

/**
 * Servlet implementation class ControleurNoteEtudiant
 */
@WebServlet("/ControleurNoteEtudiant")
public class Controleur_Gestion_Notes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controleur_Gestion_Notes() {
		super();
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
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

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
			etudiant = etudiantDAO.find(Integer.parseInt(request
					.getParameter("id_etudiant")));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("etudiant", etudiant);
		request.setAttribute("NoteFinal", ManagerNoteEtudiant.noteFinal(etudiant));
		request.setAttribute("hSemestre", ManagerNoteEtudiant.gethSemestre());
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/NotesFinalEtudiant.jsp?id_etudiant="+ etudiant.getNumeroEtudiant());
		disp.forward(request, response);

	}

}
