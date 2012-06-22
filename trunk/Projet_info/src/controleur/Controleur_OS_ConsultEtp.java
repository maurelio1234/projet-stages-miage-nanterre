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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controleur_OS_ConsultEtp() {
        super();
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
		
		OffreDeStage ods = new OffreDeStage();
//		int identifiant = Integer.parseInt(request.getParameter("id"));
		OffreDeStageDAO odsDAO;
		try {
			odsDAO = new OffreDeStageDAO();
			odsDAO.load();
//			ods = odsDAO.find(identifiant);
			ods = odsDAO.find(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			HttpSession session = request.getSession(true);
			
			RequestDispatcher disp=getServletContext().getRequestDispatcher("/OffreStageConsult.jsp");
			session.setAttribute("offrestage",ods);
			disp.forward(request, response);
		
	}


}
