package dev.fhtw.oode.weatherapp.configurate;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.SECONDS;

public class Location {

    double locationLatitude;
    double locationLongitude;
    String locationName;

    public List<Location> get_locationsList(String location_searchTerm)
    {
        List<Location> foundLocations = new ArrayList<Location>();

        try {
            String API_GET_String = "http://api.positionstack.com/v1/forward?access_key=e5ad9d29388ca616373e64d03e97deae&query=Königsbrunn";

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

        }
        catch(Exception e)
        {

        }
        return foundLocations;
    }

    public Location() {

    }

    public double getLocationLatitude() {
        return locationLatitude;
    }

    public void setLocationLatitude(double locationLatitude) {
        this.locationLatitude = locationLatitude;
    }

    public double getLocationLongitude() {
        return locationLongitude;
    }

    public void setLocationLongitude(double locationLongitude) {
        this.locationLongitude = locationLongitude;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}




