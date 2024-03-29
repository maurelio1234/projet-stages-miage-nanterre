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
 * Servlet implementation class Controle_InsEtp
 */
@WebServlet("/Controle_InsEtp")
public class Controle_InsEtp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controle_InsEtp() {
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
		
		String nom = request.getParameter("Nom");
		String adresse = request.getParameter("Adresse");
		String telephone = request.getParameter("Telephone");
		String mail = request.getParameter("Mail");
		String login = request.getParameter("Login");
		String pwd = request.getParameter("Password");
		response.setContentType("text/html;charset=UTF-8");
		
		Entreprise etp=new Entreprise(0,nom,telephone,mail,adresse,login,pwd);
		
		EntrepriseDAO a = new EntrepriseDAO();
		a.create(etp);
		
		RequestDispatcher disp=getServletContext().getRequestDispatcher("/OffreStageCrea.jsp");
		disp.forward(request, response);
		

	}

}
