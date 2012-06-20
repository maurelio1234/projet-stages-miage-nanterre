package controleur;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = request.getParameter("Nom");
		String adresse = request.getParameter("Adresse");
		String telephone = request.getParameter("Telephone");
		String mail = request.getParameter("Mail");
		String login = request.getParameter("Login");
		String pwd = request.getParameter("Password");
		int    numeroEntreprise = 5 ;
		response.setContentType("text/html;charset=UTF-8");
	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request) throws ServletException, IOException {
		Etudiant etudiant=new Etudiant();
		
		
		
		
		//RequestDispatcher disp=getServletContext().getRequestDispatcher("/test_reponse.jsp");
		
		//request.setAttribute("entreprise",etp);
		
		//disp.forward(request, response);
		
	}

}
