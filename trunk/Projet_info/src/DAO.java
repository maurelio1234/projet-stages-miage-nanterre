import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class DAO<T> {
        
        protected Connection connect = null;
        
        /**
         * Constructeur
         * @param conn
         */
        public DAO(Connection conn){
                this.connect = conn;
        }
        
        /**
         * Méthode de création
         * @param obj
         * @return
         */
        public abstract void create(T obj) throws SQLException;
        /**
         * Méthode pour effacer
         * @param obj
         * @return
         */
        public abstract void delete(T obj)throws SQLException;
        /**
         * Méthode de mise à jour
         * @param obj
         * @return
         */
        public abstract void update(T obj) throws SQLException;
        /**
         * Méthode de recherche des informations
         * @param id
         * @return
         */
        public abstract T find(int id) throws SQLException;
        
        public abstract ArrayList<T> getList() throws SQLException; 
}