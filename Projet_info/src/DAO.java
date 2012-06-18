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
         * M�thode de cr�ation
         * @param obj
         * @return
         */
        public abstract void create(T obj) throws SQLException;
        /**
         * M�thode pour effacer
         * @param obj
         * @return
         */
        public abstract void delete(T obj)throws SQLException;
        /**
         * M�thode de mise � jour
         * @param obj
         * @return
         */
        public abstract void update(T obj) throws SQLException;
        /**
         * M�thode de recherche des informations
         * @param id
         * @return
         */
        public abstract T find(int id) throws SQLException;
        
        public abstract ArrayList<T> getList() throws SQLException; 
}