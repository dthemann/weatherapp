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

public class Configuration {

    Location def_location;
    APIKeys def_APIKeys;

    public static class APIKeys
    {
        /***
         * The API Keys are stored in a class as static string variables to ease
         * the expansion of the application for additional APIs from other services.
         * Moreover, when removing the "static" from the variables instantces of the
         * APIKeys class can be created to handle multiple APIs at the same time.
         */
        private static String OpenWeatherAPIKey = "XXX";
        private static String PositionStackAPIKey = "e5ad9d29388ca616373e64d03e97deae";

        /***
         * Checks weather the OpenWeather API Key is valid, i.e. if data can be retrieved with the entered OpenWeather API Key
         * @param openWeatherAPIKey
         * the API key as string to be validated
         * @return
         * Returns true in case a sample date set has been derived successfully from the OpenWeatherMap API otherwise false;
         */
        public boolean check_OWAPIKey(String openWeatherAPIKey)
        {
            return true;
        }

        /***
         * Checks weather the Position Stack API Key is valid, i.e. can be used to retrieve data
         * @param positionStackAPIKey
         * The API key as a string to be validated
         * @return
         * Returns true in case a sample date set has been derived successfully from the Position Stack API otherwise false
         */
        public boolean check_PSAPIKey(String positionStackAPIKey)
        {
            return true;
        }

        public APIKeys() {
        }
        public APIKeys(String openWeatherAPIKey, String positionStackAPIKey) {
            OpenWeatherAPIKey = openWeatherAPIKey;
            PositionStackAPIKey = positionStackAPIKey;
        }

        public String getOpenWeatherAPIKey() {
            return OpenWeatherAPIKey;
        }

        public void setOpenWeatherAPIKey(String openWeatherAPIKey) {
            OpenWeatherAPIKey = openWeatherAPIKey;
        }

        public String getPositionStackAPIKey() {
            return PositionStackAPIKey;
        }

        public void setPositionStackAPIKey(String positionStackAPIKey) {
            PositionStackAPIKey = positionStackAPIKey;
        }
    }

    public static class Location {

        double locationLatitude;
        double locationLongitude;
        String locationName;
        String locationLabel;

        public List<Location> get_locationsList(String location_searchTerm)
        {
            try {

                List<Location> foundLocations = new ArrayList<Location>();

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

        public String getLocationLabel() {
            return locationLabel;
        }

        public void setLocationLabel(String locationLabel) {
            this.locationLabel = locationLabel;
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
}
