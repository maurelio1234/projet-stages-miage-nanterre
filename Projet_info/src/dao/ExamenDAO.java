package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import beans.Examen;
import beans.Jours;
import beans.Note;

public class ExamenDAO extends DAO<Examen> {

	private String FIND_EXAMEN = "SELECT * FROM Examen WHERE NO_EXAMEN =";
	private String FIND_LIST_EXAMEN = "SELECT * FROM EXAMEN e, EC ec WHERE ec.NO_EC = e.NO_EC AND ec.NO_UE = ec.NO_UE AND e.NO_FORMATION = ec.NO_FORMATION";
	private Statement st;

	@Override
	public Examen create(Examen obj) {

		Connection cx;
		try {
			cx = DriverManager
					.getConnection("jdbc:oracle:thin:@miage03.dmiage.u-paris10.fr:"
							+ "1521:MIAGE", "waabdou", "apprentis2010pw");
			st = cx.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return obj;
	}

	@Override
	public void delete(Examen obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public Examen update(Examen obj) {
		return obj;
		// TODO Auto-generated method stub

	}

	@Override
	public Examen find(int NO_EXAMEN) {
		// TODO Auto-generated method stub

		Examen e = new Examen();
		Jours j = new Jours();
		try {
		ResultSet rs = st.executeQuery(FIND_EXAMEN + NO_EXAMEN);
			while (rs.next()) {
				e.setNumeroExamen(rs.getInt("NO_EXAMEN"));
				e.setCoefficient(rs.getInt("COEF_EXAMEN"));
				j.setDateDuJour(dateFromOracleToJava(rs.getDate("DATE_EXAMEN")));
				e.setDate(j);
				e.setHoraire(dateFromOracleToJava(rs.getDate("HORAIRE_EXAMEN")));
				e.setLibelle(rs.getString("LIBELLE_EXAMEN"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return e;
	}

	public ArrayList<Examen> getList() throws SQLException {
		ArrayList<Examen> l = new ArrayList<Examen>();
		ResultSet rs = st.executeQuery(FIND_LIST_EXAMEN);
		for(int i=0; i<rs.getFetchSize(); i++){
			while (rs.next()) {
				
			}
		}
		return l;
	}

}
