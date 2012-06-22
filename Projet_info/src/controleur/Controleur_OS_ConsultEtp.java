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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int identifiant = Integer.parseInt(request.getParameter("id"));
		
		try {
			odsDAO = new OffreDeStageDAO();
//			ods = odsDAO.find(identifiant);
			ods = odsDAO.find(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession(true);
		
		session.setAttribute("offrestage",ods);
		RequestDispatcher disp=getServletContext().getRequestDispatcher("/OffreStageConsult.jsp");
		disp.forward(request, response);
		
	}


}
