# Weather App in Java

This is a simple Weather App built using Java. It fetches current weather data from the OpenWeatherMap API based on the city entered by the user.

## Features:
- Fetches real-time weather data for any city.
- Displays temperature, humidity, weather description, wind speed, pressure, and visibility.
- Uses OpenWeatherMap API to get weather information.

## Installation:
1. Clone the repository:
    ```bash
    git clone https://github.com/ShahabNawaz/Weather-App---Java.git
    ```
2. Navigate to the project directory:
    ```bash
    cd Weather-App---Java
    ```
3. Build the project using Maven:
    ```bash
    mvn clean install
    ```
4. Run the WeatherApp:
    ```bash
    java -cp target/classes com.example.WeatherApp
    ```

5. Replace the API key in `WeatherApp.java` with your own key from OpenWeatherMap.

## API Key:
To use the app, you need to get your own API key from [OpenWeatherMap](https://openweathermap.org/api) and replace the `apiKey` variable in `WeatherApp.java` with your key.

## Technologies Used:
- Java 17
- OpenWeatherMap API
- HttpClient (Java 11+)
- Maven (for dependency management)

## Contributing:
1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Commit your changes (`git commit -m 'Add feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Create a pull request.

## License:
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
