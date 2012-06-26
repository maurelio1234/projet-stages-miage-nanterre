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

import beans.OffreDeStage;
import dao.OffreDeStageDAO;

/**
 * Servlet implementation class Controleur_OS_Modif
 */
@WebServlet("/Controleur_OS_Modif")
public class Controleur_OS_Modif extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private OffreDeStage ods = new OffreDeStage();
    private OffreDeStageDAO odsDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controleur_OS_Modif() {
        odsDAO.load();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		OffreDeStage ods = new OffreDeStage();
		ods = (OffreDeStage) session.getAttribute("offre");
		
		try {
			odsDAO = new OffreDeStageDAO();
			
			odsDAO.update(ods);
			
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("Offre", ods);
		RequestDispatcher disp = getServletContext().getRequestDispatcher("/OffreStageModif.jsp");
		disp.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int identifiant = Integer.parseInt(request.getParameter("id"));
		
		try {
			odsDAO = new OffreDeStageDAO();
			
//			ods = odsDAO.find(identifiant);
			odsDAO.update(ods);
			
			request.setAttribute("offrestage",ods);
			RequestDispatcher disp=getServletContext().getRequestDispatcher("/OffreStageModif.jsp");
			
			disp.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}


