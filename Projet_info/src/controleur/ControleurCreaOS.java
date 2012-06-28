package controleur;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import dao.EntrepriseDAO;
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
	private List<OffreDeStage> listeOffre = new ArrayList<OffreDeStage>();
    private EntrepriseDAO entDAO;
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
		Jours jr1 = new Jours();
		Jours jr2 = new Jours();

		//Recupération de l'entreprise
		ods.setMonEntreprise(entr);
		
		//Récupération des données d'offre de stage
		//ods.setNumeroOffreDeStage(0);
		ods.setDescriptionPoste(request.getParameter("description"));
		ods.setEtatOffre("initialisé");
		
		//Tests
		date1 = new GregorianCalendar();
		date2 = new GregorianCalendar();
		try {
			date1 = DAO.ConvertirDate(request.getParameter("dateDebut"));
			date2 = DAO.ConvertirDate(request.getParameter("dateFin"));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		jr1.setDateDuJour(date1);
		ods.setDateDebutStage(jr1);
		jr2.setDateDuJour(date2);
		ods.setDateFinStage(jr2);
		
		//Enregistrement de l'offre dans la base
		try {
			OffreDeStageDAO odsDAO = new OffreDeStageDAO();
			odsDAO.create(ods);
			entDAO = new EntrepriseDAO();			
			listeOffre = entDAO.ChargerOffreEnt(entr);
			entr.setMesOffres(listeOffre);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//response.setContentType("text/html;charset=UTF-8");
		request.setAttribute("entr", entr);
		RequestDispatcher disp=	getServletContext().getRequestDispatcher("/gestion_offres_entreprise.jsp");
		disp.forward(request, response);
		
	}

}
