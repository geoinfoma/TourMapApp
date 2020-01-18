
import java.sql.ResultSet;

/**
 * @author geoinfomat
 */
public class ServiceImpl implements ServiceInterface {

    @Override
    public void add(LoginApp.DB db, String PlaceOfTrip, String Latitude, String Longitude, String Description) {
        try {
            String queryString = "SELECT MAX (ID) ID FROM Trip";
            ResultSet rs1 = db.statement.executeQuery(queryString);
            rs1.next();
            int help = 0;
            if (rs1.getString("ID") == null) {
                help = 1;
            } else {
                help = Integer.parseInt(rs1.getString("ID")) + 1;
            }
            queryString = "INSERT INTO Trip (ID, PlaceOfTrip, Latitude, Longitude, Description) VALUES("
                    + help + ",'"
                    + PlaceOfTrip + "', '"
                    + Latitude + "', '"
                    + Longitude + "', '"
                    + Description + "')";
            db.statement.executeUpdate(queryString);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(LoginApp.DB db, int id, String PlaceOfTrip, String Latitude, String Longitude, String Description) {
        try {
            String queryString = "UPDATE Trip SET ID = "
                    + id + ", PlaceOfTrip ='"
                    + PlaceOfTrip + "', Latitude='"
                    + Latitude + "', Longitude='"
                    + Longitude + "', Description= '"
                    + Description + "' WHERE ID= "
                    + id + "";
            db.statement.executeUpdate(queryString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(LoginApp.DB db, String catchMe) {
        try {
            String queryString = "DELETE FROM Trip WHERE ID=" + catchMe;
            db.statement.executeUpdate(queryString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
