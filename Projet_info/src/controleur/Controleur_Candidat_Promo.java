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

import beans.Candidat;
import beans.Formation;
import dao.CandidatDAO;
import dao.FormationDAO;

/**
 * Servlet implementation class Controleur_Candidat_Promo
 */
@WebServlet("/Controleur_Candidat_Promo")
public class Controleur_Candidat_Promo extends HttpServlet {
	private CandidatDAO candi;
	private List<Candidat> lstcandi = new ArrayList<Candidat>();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controleur_Candidat_Promo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//int id =Integer.parseInt(request.getParameter("aaa"));
		
		candi = new CandidatDAO();
		lstcandi=candi.findAllByPromo(1);
		HttpSession session = request.getSession(true);
		
		session.setAttribute("lstcandi", lstcandi);	
		RequestDispatcher disp=getServletContext().getRequestDispatcher("/affichage_lst_etudiant.jsp");
		disp.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
