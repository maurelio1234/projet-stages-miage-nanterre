package controleur;

import java.io.IOException;
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

import dao.EntrepriseDAO;
import dao.FormationDAO;

/**
 * Servlet implementation class Controleur_Promotion
 */
@WebServlet("/Controleur_Promotion")

public class Controleur_Promotion extends HttpServlet {
	private FormationDAO form;
	private List<Formation> Forma = new ArrayList<Formation>();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controleur_Promotion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		form = new FormationDAO();
		Forma=form.findAll();
		HttpSession session = request.getSession(true);
		session.setAttribute("Forma", Forma);	
		RequestDispatcher disp=getServletContext().getRequestDispatcher("/gestion_promotion.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
