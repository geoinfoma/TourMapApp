
/*
 * @author geoinfomat
 */
public interface ServiceInterface {

    public void add(LoginApp.DB db, String PlaceOfTrip, String Latitude, String Longitude, String Description);

    public void edit(LoginApp.DB db, int ID, String PlaceOfTrip, String Latitude, String Longitude, String Description);

    public void delete(LoginApp.DB db, String catchMe);

}
