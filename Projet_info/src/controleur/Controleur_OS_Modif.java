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

import beans.Entreprise;
import beans.Jours;
import beans.OffreDeStage;
import dao.DAO;
import dao.EntrepriseDAO;
import dao.OffreDeStageDAO;

/**
 * Servlet implementation class Controleur_OS_Modif
 */
@WebServlet("/Controleur_OS_Modif")
public class Controleur_OS_Modif extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<OffreDeStage> listeOffre = new ArrayList<OffreDeStage>();
	GregorianCalendar date1, date2;
    private EntrepriseDAO entDAO;
    private OffreDeStageDAO odsDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controleur_OS_Modif() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Entreprise entr = (Entreprise) session.getAttribute("entr");
		OffreDeStage ods = (OffreDeStage) session.getAttribute("offre");
		OffreDeStage ods1 = new OffreDeStage();
		Jours jr1 = new Jours();
		Jours jr2 = new Jours();
		
		System.out.println("Controleur Modif : " + ods.getDescriptionPoste());
		date1 = new GregorianCalendar();
		date2 = new GregorianCalendar();
		
		try {
			odsDAO = new OffreDeStageDAO();
			ods.setDescriptionPoste(request.getParameter("description"));
			date1 = DAO.ConvertirDate(request.getParameter("dateDebut"));
			date2 = DAO.ConvertirDate(request.getParameter("dateFin"));
			jr1.setDateDuJour(date1);
			ods.setDateDebutStage(jr1);
			jr2.setDateDuJour(date2);
			ods.setDateFinStage(jr2);			
			
			ods1 = odsDAO.update(ods);
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
		
		System.out.println("Controleur Modif : " + ods1.getDescriptionPoste());
		
		request.setAttribute("entr", entr);
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/gestion_offres_entreprise.jsp");
		disp.forward(request, response);
		
	}
}


