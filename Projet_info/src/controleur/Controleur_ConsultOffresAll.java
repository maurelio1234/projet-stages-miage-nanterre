package controleur;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Formation;
import beans.OffreDeStage;

import dao.FormationDAO;
import dao.OffreDeStageDAO;



/**
 * Servlet implementation class Controleur_ConsultOffresAll
 */
@WebServlet("/Controleur_ConsultOffresAll")
public class Controleur_ConsultOffresAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OffreDeStageDAO ODS;
	private List<OffreDeStage> ODSV = new ArrayList<OffreDeStage>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controleur_ConsultOffresAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ODS = new OffreDeStageDAO();
		ODSV=ODS.FindOffresValides();
		System.out.print(ODSV.size());
		HttpSession session = request.getSession(true);
		session.setAttribute("OffreValide", ODSV);	
		RequestDispatcher disp=getServletContext().getRequestDispatcher("/ConsultOffreAll.jsp");
		disp.forward(request, response);
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
