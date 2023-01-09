package dev.fhtw.oode.weatherapp.configurate;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Flow;

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
        public double latitude;
        public double longitude;
        public String type;
        public String name;
        public Object number;
        public Object postal_code;
        public Object street;
        public double confidence;
        public String region;
        public String region_code;
        public String county;
        public String locality;
        public String administrative_area;
        public String neighbourhood;
        public String country;
        public String country_code;
        public String continent;
        public String label;


        /*
        static class LocationSubscriber implements HttpResponse.BodySubscriber<Location>
        {
            final CompletableFuture<Location> bodyLC = new CompletableFuture<>();
            Flow.Subscription subscription;
            List<Location> responseData = new ArrayList<>();
            public CompletionStage<Location> getBody() {
                return bodyLC;
            }

            @Override
            public void onSubscribe(Flow.Subscription subscription) {
                this.subscription = subscription;
                subscription.request(1);
            }

            @Override
            public void onNext(List<Location> new_location) {
                responseData.addAll(new_location);
;            }

            @Override
            public void onError(Throwable throwable) {
                bodyLC.completeExceptionally(throwable);
            }

            @Override
            public void onComplete() {
                int size = responseData.stream().mapToInt(ByteBuffer::remaining).sum();
                byte[] ba = new byte[size];

            }
        }*/

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

                    List<Location> new_loc_list = new ArrayList<>();

                    client.sendAsync(request, location_bh)
                            .thenApply(HttpResponse::body)
                            .thenAccept(System.out::println)
                            .join();


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

    }
}
