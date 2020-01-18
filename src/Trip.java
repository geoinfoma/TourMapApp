
/**
 * @author geoinfomat
 */
public class Trip {

    private int id;
    private String placeOfTrip;
    private String latitude;
    private String longitude;
    private String description;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the placeOfTrip
     */
    public String getPlaceOfTrip() {
        return placeOfTrip;
    }

    /**
     * @param placeOfTrip the placeOfTrip to set
     */
    public void setPlaceOfTrip(String placeOfTrip) {
        this.placeOfTrip = placeOfTrip;
    }

    /**
     * @return the latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
