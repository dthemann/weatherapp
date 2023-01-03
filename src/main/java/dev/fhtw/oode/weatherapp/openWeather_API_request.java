package dev.fhtw.oode.weatherapp;

public class openWeather_API_request {
    private float location_lat;
    private float location_long;
    private String appid;
    private String excludes;
    private String units;
    private String language;


    public openWeather_API_request(float location_lat, float location_long, String appid) {
        this.location_lat = location_lat;
        this.location_long = location_long;
        this.appid = appid;
    }

    public float getLocation_lat() {
        return location_lat;
    }

    public void setLocation_lat(float location_lat) {
        this.location_lat = location_lat;
    }

    public float getLocation_long() {
        return location_long;
    }

    public void setLocation_long(float location_long) {
        this.location_long = location_long;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getExcludes() {
        return excludes;
    }

    public void setExcludes(String excludes) {
        this.excludes = excludes;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "openWeather_API_request{" +
                "location_lat=" + location_lat +
                ", location_long=" + location_long +
                ", appid='" + appid + '\'' +
                ", excludes='" + excludes + '\'' +
                ", units='" + units + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
