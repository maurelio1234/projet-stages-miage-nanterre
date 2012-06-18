package beans;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class ContratQuadriennal implements Serializable, Comparable<ContratQuadriennal>{
    /**
	 * 
	 */
	private static final long serialVersionUID = -7700219818451278165L;
	private int numeroContrat;
    private GregorianCalendar dateDebutContratQuadriennal;
    private String duree;
    private List<Formation> mesFormations = new ArrayList<Formation>();
	
	/**
	 * 
	 */
	public ContratQuadriennal() {
	}

	/**
	 * @param numeroContrat
	 * @param dateDebutContratQuadriennal
	 * @param duree
	 */
	public ContratQuadriennal(int numeroContrat, GregorianCalendar dateDebutContratQuadriennal, String duree) {
		this.numeroContrat = numeroContrat;
		this.dateDebutContratQuadriennal = dateDebutContratQuadriennal;
		this.duree = duree;
	}

	/**
	 * @param numeroContrat
	 */
	public ContratQuadriennal(int numeroContrat){
		this(numeroContrat, new GregorianCalendar(),"");
	}

	/**
	 * @return the numeroContrat
	 */
	public int getNumeroContrat() {
		return numeroContrat;
	}

	/**
	 * @param numeroContrat the numeroContrat to set
	 */
	public void setNumeroContrat(int numeroContrat) {
		this.numeroContrat = numeroContrat;
	}

	/**
	 * @return the dateDebutContratQuadriennal
	 */
	public GregorianCalendar getDateDebutContratQuadriennal() {
		return dateDebutContratQuadriennal;
	}

	/**
	 * @param dateDebutContratQuadriennal the dateDebutContratQuadriennal to set
	 */
	public void setDateDebutContratQuadriennal(
			GregorianCalendar dateDebutContratQuadriennal) {
		this.dateDebutContratQuadriennal = dateDebutContratQuadriennal;
	}

	/**
	 * @return the duree
	 */
	public String getDuree() {
		return duree;
	}

	/**
	 * @param duree the duree to set
	 */
	public void setDuree(String duree) {
		this.duree = duree;
	}

	/**
	 * @return the mesFormations
	 */
	public List<Formation> getMesFormations() {
		return mesFormations;
	}

	/**
	 * @param mesFormations the mesFormations to set
	 */
	public void setMesFormations(List<Formation> mesFormations) {
		this.mesFormations = mesFormations;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int compareTo(ContratQuadriennal o) {
		return this.getNumeroContrat()-o.getNumeroContrat();
	}

}
