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
 * Servlet implementation class Controle_AuthEtp
 */
@WebServlet("/Controle_AuthEtp")
public class Controle_AuthEtp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controle_AuthEtp() {
        super();
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

		String login=request.getParameter("login");
		String password=request.getParameter("mdp");
		
	
		EntrepriseDAO a = new EntrepriseDAO();
		
		RequestDispatcher disp;
		
		if(a.authEntreprise(login,password)){
			disp=getServletContext().getRequestDispatcher("/OffreStageConsult.jsp");
			disp.forward(request, response);
			}
		else {
			disp=getServletContext().getRequestDispatcher("/Login.jsp");
			disp.forward(request, response);	
			}
		
		
			
		}
		
}
		


