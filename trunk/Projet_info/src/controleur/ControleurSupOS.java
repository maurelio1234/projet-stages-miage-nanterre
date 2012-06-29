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

import dao.EntrepriseDAO;
import dao.OffreDeStageDAO;

import beans.Entreprise;
import beans.Jours;
import beans.OffreDeStage;

/**
 * Servlet implementation class ControleuCreaOS
 */
@WebServlet("/ControleurSupOS")
public class ControleurSupOS extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<OffreDeStage> listeOffre = new ArrayList<OffreDeStage>();
    /**
     * Default constructor. 
     */
    public ControleurSupOS() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(true);
		//Récupération des données en sessions
		Entreprise entr = new Entreprise();
		entr = (Entreprise) session.getAttribute("entr");
		OffreDeStage ods = new OffreDeStage();

	    String param = request.getParameter("idOffre");
		int numO = Integer.parseInt(param);
	    ods=entr.getMesOffres().get(numO);

		try {
			EntrepriseDAO entDAO = new EntrepriseDAO();
			OffreDeStageDAO odsDAO = new OffreDeStageDAO();
			odsDAO.delete(ods);		
			listeOffre = entDAO.ChargerOffreEnt(entr);
			entr.setMesOffres(listeOffre);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		entr.setMesOffres(listeOffre);
		
		request.setAttribute("entr", entr);
		RequestDispatcher disp=	getServletContext().getRequestDispatcher("/gestion_offres_entreprise.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
	}

}
