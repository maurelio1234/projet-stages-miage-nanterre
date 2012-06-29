package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.List;

import beans.ConventionStage;
import beans.Entreprise;
import beans.Jours;
import beans.OffreDeStage;

public class EntrepriseDAO extends DAO<Entreprise> {
	public static String TABLE = "ENTREPRISE";

	private String FIND_ENTREPRISE = "SELECT * FROM ENTREPRISE WHERE NO_ENTREPRISE =";
	private String CREATE_ENTREPRISE = "INSERT INTO Entreprise values (";
	private String DELETE_ENTREPRISE = "DELETE FROM Entreprise WHERE no_entreprise=";
	private String UPDATE_ENTREPRISE = "UPDATE Entreprise SET ";
	private String LIST_ENTREPRISE = "SELECT * FROM ENTREPRISE";
	private String LIST_OFFRESTAGE = "SELECT * FROM OFFRE_STAGE WHERE NO_ENTREPRISE =";

	private Hashtable<String, String> identifEnt = new Hashtable<String, String>();
	private ArrayList<Entreprise> listEntreprise = new ArrayList<Entreprise>();

	// table = new hashtable();

	public EntrepriseDAO() {
		try {
			Statement st = this.connect.createStatement();

			Entreprise ent = new Entreprise();
			ResultSet rs = st.executeQuery(LIST_ENTREPRISE);
				while (rs.next()) {
					ent.setNumeroEntreprise(rs.getInt("NO_ENTREPRISE"));
					ent.setNom(rs.getString("NOM_ENTREPRISE"));
					ent.setTelephone(rs.getString("TELEPHONE_ENTREPRISE"));
					ent.setMail(rs.getString("MAIL_ENTREPRISE"));
					ent.setLogin(rs.getString("LOGIN_ENTREPRISE"));
					ent.setPassword(rs.getString("MDP_ENTREPRISE"));
					identifEnt.put(rs.getString("LOGIN_ENTREPRISE"),
							rs.getString("MDP_ENTREPRISE"));

				listEntreprise.add(ent);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<OffreDeStage> ChargerOffreEnt(Entreprise ent) {
		List<OffreDeStage> listeOffre = new ArrayList<OffreDeStage>();
		try {
			Statement request = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = request.executeQuery(LIST_OFFRESTAGE
					+ ent.getNumeroEntreprise());

			while (rs.next()) {
				OffreDeStage ods = new OffreDeStage();
				ConventionStage cvst = new ConventionStage();
				Jours jr = new Jours();

				ods.setDescriptionPoste(rs.getString("DESCRIPTION_OFFRE"));
				ods.setEtatOffre(rs.getString("ETAT_OFFRE"));
				ods.setNumeroOffreDeStage(rs.getInt("NO_OFFRE"));
				ods.setMonEntreprise(ent);
				ods.setMaConvention(cvst);

				// date
				GregorianCalendar jourDebut = dateFromOracleToJava(rs
						.getDate("DATE_DEBUT_STAGE"));
				jr.setDateDuJour(jourDebut);
				ods.setDateDebutStage(jr);

				GregorianCalendar jourFin = dateFromOracleToJava(rs
						.getDate("DATE_FIN_STAGE"));
				jr.setDateDuJour(jourFin);
				ods.setDateDebutStage(jr);
				listeOffre.add(ods);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeOffre;
	}


	@Override
	public Entreprise create(Entreprise entr) {
		try {
			Statement request = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = request.executeQuery(CREATE_ENTREPRISE
					+ entr.getNumeroEntreprise() + "," + "'" + entr.getNom()
					+ "'" + "," + "'" + entr.getTelephone() + "'" + "," + "'"
					+ entr.getMail() + "'" + "," + "'" + entr.getLogin() + "'"
					+ "," + "'" + entr.getPassword() + "'" + ")");

			while (rs.next()) {
				entr.setNumeroEntreprise(rs.getInt("NO_ENTREPRISE"));
				entr.setNom(rs.getString("NOM_ENTREPRISE"));
				entr.setTelephone(rs.getString("TELEPHONE_ENTREPRISE"));
				entr.setMail(rs.getString("MAIL_ENTREPRISE"));
				entr.setLogin(rs.getString("LOGIN_ENTREPRISE"));
				entr.setPassword(rs.getString("MDP_ENTREPRISE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entr;
	}

	@Override
	public void delete(Entreprise entr) {
		// TODO Auto-generated method stub
		try {
			Statement request = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			request.executeQuery(DELETE_ENTREPRISE + entr.getNumeroEntreprise());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Entreprise update(Entreprise entr) {
		try {
			Statement request = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = request.executeQuery(UPDATE_ENTREPRISE
					+ entr.getNumeroEntreprise());
			while (rs.next()) {
				entr.setNumeroEntreprise(rs.getInt("NO_ENTREPRISE"));
				entr.setNom(rs.getString("NOM_ENTREPRISE"));
				entr.setTelephone(rs.getString("TELEPHONE_ENTREPRISE"));
				entr.setMail(rs.getString("MAIL_ENTREPRISE"));
				entr.setLogin(rs.getString("LOGIN_ENTREPRISE"));
				entr.setPassword(rs.getString("MDP_ENTREPRISE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entr;
	}

	@Override
	public Entreprise find(int numEntreprise) {
		// TODO Auto-generated method stub
		Entreprise ent = new Entreprise();
		try {
			Statement request = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = request
					.executeQuery(FIND_ENTREPRISE + numEntreprise);

			while (rs.next()) {
				ent.setNumeroEntreprise(rs.getInt("NO_ENTREPRISE"));
				ent.setNom(rs.getString("NOM_ENTREPRISE"));
				ent.setTelephone(rs.getString("TELEPHONE_ENTREPRISE"));
				ent.setMail(rs.getString("MAIL_ENTREPRISE"));
				ent.setLogin(rs.getString("LOGIN_ENTREPRISE"));
				ent.setPassword(rs.getString("MDP_ENTREPRISE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ent;
	}

	@Override
	public List<Entreprise> findAll() {
		try {
			List<Entreprise> listEntreprise = new ArrayList<Entreprise>();
			Entreprise ent = new Entreprise();
			Statement request = this.connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = request.executeQuery(LIST_ENTREPRISE);
			while (rs.next()) {
				ent.setNumeroEntreprise(rs.getInt("NO_ENTREPRISE"));
				ent.setNom(rs.getString("NOM_ENTREPRISE"));
				ent.setTelephone(rs.getString("TELEPHONE_ENTREPRISE"));
				ent.setMail(rs.getString("MAIL_ENTREPRISE"));
				ent.setLogin(rs.getString("LOGIN_ENTREPRISE"));
				ent.setPassword(rs.getString("MDP_ENTREPRISE"));

				listEntreprise.add(ent);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listEntreprise;
	}

	public boolean authEntreprise(String login, String password) {

		if (this.identifEnt.containsKey(login) == false) {
			return false;
		} else {
			if (identifEnt.get(login).equals(password)) {
				return true;
			} else {
				return false;
			}
		}

		// /if(identifEnt.get(login).equals(password)){
		// return true;
		// }
		// return false;
	}

}
