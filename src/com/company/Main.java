package com.company;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static HttpURLConnection connection = null;

    public static void main(String[] args) throws IOException {
        String envSentence = System.getenv("SENTENCE");
        String envWebhookURL = System.getenv("WEBHOOKURL");
        String reverseString = reverseString(envSentence);
        connection = getConnection(envWebhookURL);
        postRequest(reverseString, connection);
        // write your code here
    }

    public static String reverseString(String sentence){
        String newString = new StringBuilder(sentence).reverse().toString();
        return newString;
    }

    public static HttpURLConnection getConnection(String webhookUrl) throws IOException {
        System.out.println("Establishing connection...");
        URL url = new URL(webhookUrl);
        HttpURLConnection httpURLConnection =  (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpURLConnection.setDoOutput(true);
        System.out.println("Connection set.");

        return httpURLConnection;

    }

    public static void postRequest(String sentence, HttpURLConnection httpURLConnection) throws IOException {
        //Send request
        System.out.println("Writing bytes...");
        DataOutputStream stream = new DataOutputStream(httpURLConnection.getOutputStream());
        stream.writeBytes(sentence);
        stream.close();

        //Get Response
        InputStream is = httpURLConnection.getInputStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
        String line;
        while ((line = rd.readLine()) != null) {
            response.append(line);
            response.append('\r');
        }
        rd.close();
        System.out.println("Request successfully sent.");
    }
}
