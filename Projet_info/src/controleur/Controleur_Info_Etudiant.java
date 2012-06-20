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
@WebServlet("/ControleurEtudiant")
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
	}

	
	/**
	 * @throws SQLException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request) throws ServletException, IOException, SQLException {
		Etudiant etudiant=new Etudiant();
		etudiant.setNumeroEtudiant(Integer.parseInt(request.getParameter("numero_etudiant")));
		etudiant.getMonCandidat().setNom(request.getParameter("nom"));
		etudiant.getMonCandidat().setPrenom(request.getParameter("prenom"));
		etudiant.getMonCandidat().setAdresse(request.getParameter("adresse"));
		etudiant.getMonCandidat().setTelephone(request.getParameter("telephone"));
		//etudiant.getMonCandidat().setDateNaissance(request.getParameter("date_naissance"));
		etudiant.getMonCandidat().setMail(request.getParameter("mail"));
		etudiant.getMonCandidat().setLogin(request.getParameter("login"));
		
		EtudiantDAO etudiantDAO = new EtudiantDAO();
		etudiantDAO.update(etudiant);

		RequestDispatcher disp=getServletContext().getRequestDispatcher("/accueil_etudiant.jsp");
		
		//disp.forward(request, response);
		
	}

}
