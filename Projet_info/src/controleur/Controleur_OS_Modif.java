package controleur;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.OffreDeStage;
import dao.OffreDeStageDAO;

/**
 * Servlet implementation class Controleur_OS_Modif
 */
@WebServlet("/Controleur_OS_Modif")
public class Controleur_OS_Modif extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controleur_OS_Modif() {
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
//		int identifiant = Integer.parseInt(request.getParameter("id"));
		OffreDeStageDAO odsDAO;
		try {
			odsDAO = new OffreDeStageDAO();
			OffreDeStage ods = new OffreDeStage();
//			ods = odsDAO.find(identifiant);
			ods = odsDAO.update(1);
			
			RequestDispatcher disp=getServletContext().getRequestDispatcher("/OffreStageModif.jsp");
			request.setAttribute("offrestage",ods);
			disp.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}

}
