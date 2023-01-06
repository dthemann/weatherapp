package dev.fhtw.oode.weatherapp;

import java.io.IOException;
import java.net.HttpRetryException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;

public class openWeather_API_request {
    private float location_lat;
    private float location_long;
    private String appid;
    private String excludes;
    private String units;
    private String language;


    public static void API_call() throws IOException, InterruptedException {

        try {
            String API_GET_String = "https://api.openweathermap.org/data/3.0/onecall?lat=48.20&lon=16.37&exclude=minutely,hourly,daily&units=metric&appid=60ab80322e514c07f3fa415b5dbd0848";

            try{
                URI testURI = new URI(API_GET_String);

                HttpClient client = HttpClient.newHttpClient();

                HttpRequest request = HttpRequest.newBuilder()
                        .uri(testURI)
                        .version(HttpClient.Version.HTTP_2)
                        .timeout(Duration.of(10, SECONDS))
                        .GET()
                        .build();

                client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                        .thenApply(HttpResponse::body)
                        .thenAccept(System.out::println)
                        .join();

            } catch (URISyntaxException e)
            {
                System.out.println("Get fucked!");
            }

            //HttpResponse<String> responseBody = client.send(request, HttpResponse.BodyHandlers.ofString());
            //System.out.println(responseBody.body());
        }
        catch(Exception e)
        {

        }
    }

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
