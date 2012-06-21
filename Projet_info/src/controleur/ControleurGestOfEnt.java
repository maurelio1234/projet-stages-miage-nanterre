package controleur;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.EntrepriseDAO;
import dao.OffreDeStageDAO;

import beans.Entreprise;
import beans.OffreDeStage;

/**
 * Servlet implementation class ControleuCreaOS
 */
@WebServlet("/ControleurGestOfEnt")
public class ControleurGestOfEnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntrepriseDAO entDAO;
	private List<OffreDeStage> listeOffre = new ArrayList<OffreDeStage>();

    /**
     * Default constructor. 
     */
    public ControleurGestOfEnt() {
        // TODO Auto-generated constructor stub
    	entDAO.load();
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
		//response.setContentType("text/html;charset=UTF-8");
		
		//Création du DAO et du beans pour l'entreprise 
		Entreprise ent = new Entreprise();
		
		//Test sur une entreprise fictive
		
		try {
			entDAO = new EntrepriseDAO();
			ent = entDAO.find(1);			
			listeOffre = entDAO.ChargerOffreEnt(ent);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//Récupération de la liste des offres de l'entreprise
		HttpSession session = request.getSession(true);
				
		//Recupération des données de l'entreprise pour la servlet suivante
		//session.setAttribute("EntrepDAO", entDAO);
		session.setAttribute("listeOffreE", listeOffre);
		session.setAttribute("entr", ent);
				
		RequestDispatcher disp=	getServletContext().getRequestDispatcher("/gestion_offres_entreprise.jsp");
		disp.forward(request, response);
		
	}

}
