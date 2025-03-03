package com.example;
import java.util.Scanner;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;  // Import for JSONObject


public class WeatherApp {

    public static void main(String[] args) {
        // Get your API Key from OpenWeatherMap and replace with your actual API key.
        String apiKey = "dff57e935c6225bb8abdcf424856b566";  // Replace with your actual API Key from OpenWeatherMap

        // Get city name from the user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the city name: ");
        String city = scanner.nextLine();

        // Call the method to get weather data
        getWeather(city, apiKey);
    }

    public static void getWeather(String city, String apiKey) {
        try {
            // Create HttpClient
            HttpClient client = HttpClient.newHttpClient();

            // Construct the URL for the API request
            String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&units=metric";
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlString))
                    .build();

            // Send the request
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Print the raw API response for debugging
            System.out.println("Raw API Response: " + response.body());

            // Parse the response JSON
            JSONObject jsonResponse = new JSONObject(response.body());

            // Check if the response is an error (e.g., city not found)
            if (jsonResponse.has("cod") && jsonResponse.getInt("cod") != 200) {
                System.out.println("Error: " + jsonResponse.getString("message"));
                return;
            }

            // Extract and print the weather details
            String cityName = jsonResponse.getString("name");
            double temperature = jsonResponse.getJSONObject("main").getDouble("temp");
            int humidity = jsonResponse.getJSONObject("main").getInt("humidity");
            String description = jsonResponse.getJSONArray("weather").getJSONObject(0).getString("description");

            // Print out the weather information
            System.out.println("Weather in " + cityName + ":");
            System.out.println("Temperature: " + temperature + "°C");
            System.out.println("Humidity: " + humidity + "%");
            System.out.println("Description: " + description);
            System.out.println("Wind Speed: " + jsonResponse.getJSONObject("wind").getDouble("speed") + " m/s");
            System.out.println("Pressure: " + jsonResponse.getJSONObject("main").getInt("pressure") + " hPa");
            System.out.println("Visibility: " + jsonResponse.getInt("visibility") / 1000 + " km");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
