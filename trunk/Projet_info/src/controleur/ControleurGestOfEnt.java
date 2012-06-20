package controleur;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EntrepriseDAO;

import beans.Entreprise;

/**
 * Servlet implementation class ControleuCreaOS
 */
@WebServlet("/ControleurGestOfEnt")
public class ControleurGestOfEnt extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ControleurGestOfEnt() {
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
		//Création du DAO pour l'entreprise
		EntrepriseDAO entDAO = new EntrepriseDAO();
		Entreprise ent = new Entreprise();
		
		//Test sur une entreprise fictive
		ent = entDAO.find(1);
		
		
		//Récupération de la liste des offres de l'entreprise
		HttpSession session = request.getSession(true);
		
		//Recupération de l'entreprise
		
		
		
		response.setContentType("text/html;charset=UTF-8");
		request.setAttribute("ListeOffreEnt", ods);
		RequestDispatcher disp=	getServletContext().getRequestDispatcher("/gestion_offres_entreprise.jsp");
		disp.forward(request, response);
		
	
		
	}

}
