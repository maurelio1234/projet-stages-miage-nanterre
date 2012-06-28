package controleur;


import java.io.IOException;
import java.sql.SQLException;
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
	GregorianCalendar date1, date2;
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
		
		HttpSession session = request.getSession(true);
		Entreprise entr = (Entreprise) session.getAttribute("entr");
				
		OffreDeStage ods = new OffreDeStage();
		Jours jr = new Jours();

		//Recupération de l'entreprise
		ods.setMonEntreprise(entr);
		
		//Récupération des données d'offre de stage
		ods.setNumeroOffreDeStage(0);
		ods.setDescriptionPoste(request.getParameter("description"));
		ods.setEtatOffre("initialisé");
		
		//Récupération de la date en calendar
		try {
			//date1 = OffreDeStageDAO.stringToCalendar(request.getParameter("dateDebut"));
			//date2 = OffreDeStageDAO.stringToCalendar(request.getParameter("dateFin"));
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Tests
		date1 = new GregorianCalendar();
		date2 = new GregorianCalendar();
		
		jr.setDateDuJour(date1);
		jr.setDateDuJour(date2);
		ods.setDateDebutStage(jr);
		ods.setDateFinStage(jr);
		
		//Enregistrement de l'offre dans la base
		try {
			OffreDeStageDAO odsDAO = new OffreDeStageDAO();
			odsDAO.create(ods);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//response.setContentType("text/html;charset=UTF-8");
		request.setAttribute("Offre", ods);
		RequestDispatcher disp=	getServletContext().getRequestDispatcher("/gestion_offres_entreprise.jsp");
		disp.forward(request, response);
		
	}

}
