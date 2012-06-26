package controleur;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Etudiant;
import dao.EtudiantDAO;

public class Controleur_Accueil_Etudiant {

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
	}
	
	public void doPost(HttpServletRequest request) throws ServletException, IOException, SQLException {
		Etudiant etudiant=new Etudiant();
		//etudiant.setNumeroEtudiant(request.getParameter("numero_etudiant");

		//RequestDispatcher disp=getServletContext().getRequestDispatcher("/accueil_etudiant.jsp");
	}
		
}
