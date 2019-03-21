package pl.dlewandowski;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class ApiConsumer {
    private static String API_URL = "https://datamaster-aliexpress-v1.p.rapidapi.com/search.category?currency=USD&id=0&lang=EN";
    private static String API_KEY = "f8cb50fa95mshdce83b3c6df17cep17b6a6jsned77f8b8fe26";


    public static void consumeApi() {
        try {
            HttpResponse<JsonNode> response = Unirest.put(API_URL)
                    .header("X-RapidAPI-Key", API_KEY)
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .asJson();
            System.out.println(response.getBody());
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

}
