
package models;


public class CountryInfo {

    private long _id;
    private String iso2;
    private String iso3;
    private long lat;
    private long _long;
    private String flag;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CountryInfo() {
    }

    /**
     * 
     * @param flag
     * @param _long
     * @param id
     * @param iso2
     * @param lat
     * @param iso3
     */
    public CountryInfo(long id, String iso2, String iso3, long lat, long _long, String flag) {
        super();
        this._id = id;
        this.iso2 = iso2;
        this.iso3 = iso3;
        this.lat = lat;
        this._long = _long;
        this.flag = flag;
    }

    public long getId() {
        return _id;
    }

    public void setId(long id) {
        this._id = id;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    public long getLat() {
        return lat;
    }

    public void setLat(long lat) {
        this.lat = lat;
    }

    public long getLong() {
        return _long;
    }

    public void setLong(long _long) {
        this._long = _long;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

	@Override
	public String toString() {
		return "CountryInfo [id=" + _id + ", iso2=" + iso2 + ", iso3=" + iso3 + ", lat=" + lat + ", _long=" + _long
				+ ", flag=" + flag + "]";
	}

    
}
