package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import beans.EC;


public class ECDAO extends DAO<EC>{
	
private Statement st;

	public ECDAO() throws SQLException{
		Connection cx = DriverManager.getConnection("jdbc:oracle:thin:@miage03.dmiage.u-paris10.fr:1521:MIAGE", "jonatzee", "jonathan");
		 st =(Statement) cx.createStatement();
	}

	public float calculMoyenneEC(EC ec, int NumeroEtudiant, GregorianCalendar datedebut, GregorianCalendar datefin){
		
		float moyenne =  0;
		float coef = 0;
		for (int i = 0; i < ec.getMesExamens().size() ; i ++){
	        try {	           
	            ResultSet rs = st.executeQuery("Select ev.note from Evaluation ev, Examen e Where ev.NO_EXAMEN = '"+ ec.getMesExamens().get(i).getNumeroExamen() +
	            			"' and ev.NO_EXAMEN = e.NO_EXAMEN and e.DATE_EXAMEN between " + datedebut + "And" +datefin + ";"); 

	            
	            while(rs.next()){
	            	float note = rs.getFloat("NOTE");
	            	if (note >= 0){
	            		moyenne +=note * ec.getMesExamens().get(i).getCoefficient();
	            		 coef += ec.getMesExamens().get(i).getCoefficient();
	            	}
	            	else if (note == -2){ // -2 = Absence non justifiée donc on prends en compte le coef
	            		 coef += ec.getMesExamens().get(i).getCoefficient();
	            	}
	            }

	            rs.close();
	            st.close();
	   
	           
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } 
		}
		try {
			return (moyenne / coef);
		}catch (ArithmeticException e) {
			return 0;
		}

	}

	@Override
	public void create(EC obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(EC obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(EC obj) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EC find(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<EC> getList() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
