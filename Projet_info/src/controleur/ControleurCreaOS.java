package controleur;


import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OffreDeStageDAO;

import beans.Entreprise;
import beans.Jours;
import beans.OffreDeStage;

/**
 * Servlet implementation class ControleuCreaOS
 */
@WebServlet("/ControleurCreaOS")
public class ControleurCreaOS extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GregorianCalendar date;
    /**
     * Default constructor. 
     */
    public ControleurCreaOS() {
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
		
		OffreDeStageDAO odsDAO = new OffreDeStageDAO();
		OffreDeStage ods = new OffreDeStage();
		Jours jr = new Jours();
		
		//Récupération de la date en calendar
		date = OffreDeStageDAO.stringToCalendar(request.getParameter("dateDebut"));
		jr.setDateDuJour(date);
		ods.setDateDebutStage(jr);
		date = OffreDeStageDAO.stringToCalendar(request.getParameter("dateFin"));
		jr.setDateDuJour(date);
		ods.setDateFinStage(jr);
		
		//Récupération des données d'offre de stage
		ods.setNumeroOffreDeStage(0);
		ods.setDescriptionPoste(request.getParameter("description"));
		ods.setEtatOffre("initialisé");
		
		
		//Recupération de l'entreprise
		HttpSession s=request.getSession();
		ods.setMonEntreprise(entr);
		
		
		
		response.setContentType("text/html;charset=UTF-8");
		request.setAttribute("ListeOffreEnt", ods);
		RequestDispatcher disp=	getServletContext().getRequestDispatcher("/gestion_offres_entreprise.jsp");
		disp.forward(request, response);
		
	
		
	}

}
