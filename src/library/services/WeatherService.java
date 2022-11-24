package library.services;

import com.google.gson.Gson;
import library.entities.CurrentWeather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherService {
    private final static String current_weather_api = "https://api.openweathermap.org/data/2.5/weather?q=Hanoi,vietnam&appid=09a71427c59d38d6a34f89b47d75975c&units=metric";

    public static String fetchContent(String uri) throws IOException {
        final int OK = 200;
        URL url = new URL(uri);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        if(connection.getResponseCode() == OK){
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return  response.toString();
        }
        return  null;
    }

    public static CurrentWeather getCurrentWeather(){
        try {
            String rs = fetchContent(current_weather_api);
            Gson gson = new Gson();
            return gson.fromJson(rs, CurrentWeather.class);
        }catch (Exception e){
            return null;
        }
    }

}
