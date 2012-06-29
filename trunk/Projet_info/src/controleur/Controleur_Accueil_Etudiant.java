package controleur;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EntrepriseDAO;
import dao.EtudiantDAO;

import beans.Entreprise;
import beans.Etudiant;

/**
 * Servlet implementation class ControleurEtp
 */
@WebServlet("/Controleur_Accueil_Etudiant")
public class Controleur_Accueil_Etudiant extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Controleur_Accueil_Etudiant() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	

		String login = request.getParameter("login");
		String mdp = request.getParameter("mdp");
		Etudiant etudiant;
		
		response.setContentType("text/html;charset=UTF-8");
		
			EtudiantDAO etudiantDAO = new EtudiantDAO();
			RequestDispatcher disp;
			int id_etudiant = etudiantDAO.AuthentificationEtudiant(login,mdp);
			if(id_etudiant!=0){
				etudiant = etudiantDAO.find(id_etudiant);
				request.setAttribute("etudiant", etudiant);
				disp=getServletContext().getRequestDispatcher("/accueil_etudiant.jsp?id_etudiant=" + etudiant.getNumeroEtudiant());
				disp.forward(request, response);
			} 
			else{  
					disp=getServletContext().getRequestDispatcher("/authentification_etudiant.jsp");
					disp.forward(request, response);
				}
			
		
		
	}
}

