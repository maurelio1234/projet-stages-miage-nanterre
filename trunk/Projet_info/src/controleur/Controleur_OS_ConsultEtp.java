package controleur;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Entreprise;
import beans.OffreDeStage;

import dao.OffreDeStageDAO;

/**
 * Servlet implementation class Controleur_OS_ConsultEtp
 */
@WebServlet("/Controleur_OS_ConsultEtp")
public class Controleur_OS_ConsultEtp extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private OffreDeStage ods = new OffreDeStage();
    private OffreDeStageDAO odsDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controleur_OS_ConsultEtp() {
    	odsDAO.load();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Récupération de la liste des offres de l'entreprise
		HttpSession session = request.getSession(true);
		Entreprise entr = (Entreprise) session.getAttribute("entr");
		String param = request.getParameter("idOffre");
		int numO = Integer.parseInt(param);
		
		OffreDeStage ods = new OffreDeStage();
		ods = entr.getMesOffres().get(numO);
		
		/*try {
			odsDAO = new OffreDeStageDAO();
			ods = odsDAO.find(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		
		session.setAttribute("offrestage",ods);
		RequestDispatcher disp=getServletContext().getRequestDispatcher("/OffreStageConsult.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Récupération de la liste des offres de l'entreprise
//		HttpSession session = request.getSession(true);
//		Entreprise entr = (Entreprise) session.getAttribute("entr");
//		String param = request.getParameter("idOffre");
//		int numO = Integer.parseInt(param);
//		
//		OffreDeStage ods = new OffreDeStage();
//		ods = entr.getMesOffres().get(numO);
//		
//		/*try {
//			odsDAO = new OffreDeStageDAO();
//			ods = odsDAO.find(1);
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}*/
//		
//		session.setAttribute("offrestage",ods);
//		RequestDispatcher disp=getServletContext().getRequestDispatcher("/OffreStageConsult.jsp");
//		disp.forward(request, response);
		
	}


}
