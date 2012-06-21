package dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.List;
import java.util.Date;

import beans.ConventionStage;
import beans.Entreprise;
import beans.Jours;
import beans.OffreDeStage;


public class EntrepriseDAO extends DAO<Entreprise>{
	
	private String FIND_ENTREPRISE = "SELECT * FROM ENTREPRISE WHERE NO_ENTREPRISE =";
	private String CREATE_ENTREPRISE = "INSERT INTO Entreprise values (";
	private String DELETE_ENTREPRISE = "DELETE FROM Entreprise WHERE no_entreprise=";
	private String UPDATE_ENTREPRISE = "UPDATE Entreprise SET ";
	private String LIST_ENTREPRISE = "SELECT * FROM ENTREPRISE";
	private String LIST_OFFRESTAGE = "SELECT * FROM ENTREPRISE OFFRE_STAGE WHERE NO_ENTREPRISE =";
	
	
	private Statement st;
	
	private Hashtable<String,String> identifEnt = new Hashtable();
	private ArrayList<Entreprise> listEntreprise = new ArrayList();
	
	//table = new hashtable();
		
	public EntrepriseDAO() throws SQLException {
        Connection cx=DriverManager.getConnection("jdbc:oracle:thin:@miage03.dmiage.u-paris10.fr:"
                                                + "1521:MIAGE","nadiop","finadiop");
        st=cx.createStatement();
        
		Entreprise ent = new Entreprise();
		ResultSet rs = st.executeQuery(LIST_ENTREPRISE);
		for(int i=0; i<rs.getFetchSize(); i++){
			while(rs.next()){
				ent.setNumeroEntreprise(rs.getInt("NO_ENTREPRISE")); 
                ent.setNom(rs.getString("NOM_ENTREPRISE"));
                ent.setTelephone(rs.getString("TELEPHONE_ENTREPRISE"));
                ent.setMail(rs.getString("MAIL_ENTREPRISE"));
                ent.setLogin(rs.getString("LOGIN_ENTREPRISE"));
                ent.setPassword(rs.getString("MDP_ENTREPRISE"));
                identifEnt.put(rs.getString("LOGIN_ENTREPRISE"),rs.getString("MDP_ENTREPRISE"));
                
			}
			listEntreprise.add(ent);
		}
	}
	
	
public List<OffreDeStage> ChargerOffreEnt(Entreprise ent) throws SQLException{
		
        ResultSet rs = st.executeQuery(LIST_OFFRESTAGE + ent.getNumeroEntreprise());

        List<OffreDeStage> listeOffre = new ArrayList<OffreDeStage>();
        OffreDeStage ods = new OffreDeStage();
        ConventionStage cvst = new ConventionStage();
        Jours jr = new Jours();
        
        for(int i=0; i<rs.getFetchSize(); i++){
			while(rs.next()){
				ods.setDescriptionPoste(rs.getString("DESCRIPTION_OFFRE"));
				ods.setEtatOffre(rs.getString("ETAT_OFFRE"));
				ods.setNumeroOffreDeStage(rs.getInt("NO_OFFRE"));
				ods.setMonEntreprise(ent);
				ods.setMaConvention(cvst);
				
				//date
				GregorianCalendar jourDebut = asCalendar(rs.getDate("DATE_DEBUT_STAGE"));
				jr.setDateDuJour(jourDebut);
				ods.setDateDebutStage(jr);
				
				GregorianCalendar jourFin = asCalendar(rs.getDate("DATE_FIN_STAGE"));
				jr.setDateDuJour(jourFin);
				ods.setDateDebutStage(jr);	
			}
			listeOffre.add(ods);
		}
        return listeOffre;        
	}

	
	public static GregorianCalendar asCalendar(Date date) {
		GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
		cal.setTime(date);
		return cal;
	}
	
	public static GregorianCalendar stringToCalendar(String sDate) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = sdf.parse(sDate);
        return asCalendar(date);
	}
	
    public static void load() {
        // TODO code application logic here
        /**Chargement du driver JDBC=Etape1*/
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }
        catch(Exception ex){
            System.err.println("Erreur lors du chargement du driver");
            System.exit(1);
        }
                
    }

	@Override
	public void create(Entreprise entr) throws SQLException {
		// TODO Auto-generated method stub
		st.executeQuery(CREATE_ENTREPRISE + entr.getNumeroEntreprise() + "," +"'"+ entr.getNom() +"'"+ "," +"'"+ entr.getTelephone()+"'" + "," 
		+ "'"+entr.getMail()+"'" + "," + "'"+entr.getLogin() +"'"+ "," + "'"+entr.getPassword()+"'"+")");
		
	}

	@Override
	public void delete(Entreprise entr) throws SQLException {
		// TODO Auto-generated method stub
		st.executeQuery(DELETE_ENTREPRISE + entr.getNumeroEntreprise());
	}

	@Override
	public void update(Entreprise entr) throws SQLException {
		// TODO Auto-generated method stub
		st.executeQuery(UPDATE_ENTREPRISE + entr.getNumeroEntreprise());
	}

	@Override
	public Entreprise find(int numEntreprise) throws SQLException {
		// TODO Auto-generated method stub
		Entreprise ent = new Entreprise();
		ResultSet rs = st.executeQuery(FIND_ENTREPRISE + numEntreprise);
		while(rs.next()){
			ent.setNumeroEntreprise(rs.getInt("NO_ENTREPRISE")); 
            ent.setNom(rs.getString("NOM_ENTREPRISE"));
            ent.setTelephone(rs.getString("TELEPHONE_ENTREPRISE"));
            ent.setMail(rs.getString("MAIL_ENTREPRISE"));
            ent.setLogin(rs.getString("LOGIN_ENTREPRISE"));
            ent.setPassword(rs.getString("MDP_ENTREPRISE"));
		}
		return ent;
	}

	
	public ArrayList<Entreprise> getList() throws SQLException {
		List<Entreprise> listEntreprise = new ArrayList<Entreprise>();
		Entreprise ent = new Entreprise();
		ResultSet rs = st.executeQuery(LIST_ENTREPRISE);
		for(int i=0; i<rs.getFetchSize(); i++){
			while(rs.next()){
				ent.setNumeroEntreprise(rs.getInt("NO_ENTREPRISE")); 
                ent.setNom(rs.getString("NOM_ENTREPRISE"));
                ent.setTelephone(rs.getString("TELEPHONE_ENTREPRISE"));
                ent.setMail(rs.getString("MAIL_ENTREPRISE"));
                ent.setLogin(rs.getString("LOGIN_ENTREPRISE"));
                ent.setPassword(rs.getString("MDP_ENTREPRISE"));
                
			}
			listEntreprise.add(ent);
		}
		return (ArrayList<Entreprise>) listEntreprise;
	}
	
	public boolean AuthEntreprise(String login, String password){
		
		if(this.identifEnt.containsKey(login)==false){
			return false;
		}
		else{
			if(identifEnt.get(login).equals(password)){
				return true;
			}
			else{
				return false;
			}
		}

				///if(identifEnt.get(login).equals(password)){
				//	return true;
				//}
				//return false;	
	}
	

}
