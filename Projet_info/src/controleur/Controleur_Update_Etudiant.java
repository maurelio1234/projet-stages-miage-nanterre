package controleur;



import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CandidatDAO;
import dao.EtudiantDAO;
import beans.Candidat;
import beans.Etudiant;


/**
 * Servlet implementation class ControleurEtudiant
 */
@WebServlet("/Controleur_Update_Etudiant")
public class Controleur_Update_Etudiant extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Controleur_Update_Etudiant() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EtudiantDAO etudiantDAO = null;
	
			etudiantDAO = new EtudiantDAO();
		
			// TODO Auto-generated catch block
		
		Etudiant etudiant;
		etudiant = etudiantDAO.find(Integer.parseInt(request.getParameter("id_etudiant")));
		System.out.println(etudiant);
		System.out.println(request.getParameter("id_candidat"));
		etudiant.getMonCandidat().setAdresse(request.getParameter("adresse"));
		etudiant.getMonCandidat().setTelephone(request.getParameter("telephone"));
		etudiant.getMonCandidat().setMail(request.getParameter("mail"));
		response.setContentType("text/html;charset=UTF-8");
		etudiant = etudiantDAO.update(etudiant);
		request.setAttribute("etudiant", etudiant);
		RequestDispatcher disp=getServletContext().getRequestDispatcher("/accueil_etudiant.jsp");
		disp.forward(request, response);
	}
}
