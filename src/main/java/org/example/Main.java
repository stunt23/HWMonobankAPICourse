package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;


public class Main
{
    public static void main( String[] args ) throws IOException {
        showTheCourse(840, 980);// where 840 is code for UAH, 890 - is code for USD
    }
    public static void showTheCourse(int firstCode, int secondCode) throws IOException{
        String monobankEndpointCourse = "https://api.monobank.ua/bank/currency";
        URL url = new URL(monobankEndpointCourse);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        InputStream is = conn.getInputStream();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int r;
        while((r = is.read()) != -1){
            bos.write(r);
        }
        byte [] responseByte = bos.toByteArray();
        String allCourses = new String(responseByte, StandardCharsets.UTF_8);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        CurrencyPairCourse[] allPairs = gson.fromJson(allCourses, CurrencyPairCourse[].class);

        CurrencyPairCourse seekingPair = null;
        for (int i = 0; i < allPairs.length; i++) {
            if(allPairs[i].getCurrencyCodeA() == firstCode &&  allPairs[i].getCurrencyCodeB() == secondCode){
                seekingPair = allPairs[i];
            }
        }
        System.out.println("UAH/USD Course:");
        System.out.println(String.format("BUY %.3f ₴ : %.3f ₴ SELL ", seekingPair.getRateBuy(), seekingPair.getRateSell()));
    }
}
