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

import beans.Entreprise;

/**
 * Servlet implementation class ControleurEtp
 */
@WebServlet("/ControleurEtp")
public class ControleurEtp extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ControleurEtp() {
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
	
		String nom = request.getParameter("Nom");
		String adresse = request.getParameter("Adresse");
		String telephone = request.getParameter("Telephone");
		String mail = request.getParameter("Mail");
		String login = request.getParameter("Login");
		String pwd = request.getParameter("Password");
		int    numeroEntreprise = 5 ;
		response.setContentType("text/html;charset=UTF-8");
		try {
			EntrepriseDAO entrepriseDAO = new EntrepriseDAO();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Entreprise etp=new Entreprise(numeroEntreprise,nom,adresse,telephone,mail,login,pwd);
		
		
		//RequestDispatcher disp=getServletContext().getRequestDispatcher("/test_reponse.jsp");
		
		//request.setAttribute("entreprise",etp);
		
		//disp.forward(request, response);
		
	}

}
