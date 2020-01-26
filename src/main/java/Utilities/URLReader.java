package Utilities;

import java.net.*;
import java.io.*;

public class URLReader {
    public static void main(String[] args) throws Exception {
        //URL url = new URL("https://hr-testcases-us-east-1.s3.amazonaws.com/8027/input08.txt?AWSAccessKeyId=AKIAJ4WZFDFQTZRGO3QA&Expires=1579990992&Signature=1wxb%2F72%2Bh1uWfcPCb1iOq7bVgoM%3D&response-content-type=text%2Fplain");
        //String result = downloadWebPage(url);
        //System.out.println(result);

        //URL url = new URL("https://hr-testcases-us-east-1.s3.amazonaws.com/8027/input08.txt?AWSAccessKeyId=AKIAJ4WZFDFQTZRGO3QA&Expires=1579990992&Signature=1wxb%2F72%2Bh1uWfcPCb1iOq7bVgoM%3D&response-content-type=text%2Fplain");
        URL url = new URL("https://hr-testcases-us-east-1.s3.amazonaws.com/8027/");
        HttpURLConnection urlcon = (HttpURLConnection) url.openConnection();
        urlcon.addRequestProperty("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
        System.setProperty("http.agent", "Chrome");
        BufferedReader reader = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null)
        {
            sb.append(line + "\n");
        }
        System.out.println(sb.toString());

        /*String url = "https://hr-testcases-us-east-1.s3.amazonaws.com/8027/input08.txt?AWSAccessKeyId=AKIAJ4WZFDFQTZRGO3QA&Expires=1579990992&Signature=1wxb%2F72%2Bh1uWfcPCb1iOq7bVgoM%3D&response-content-type=text%2Fplain";
        System.setProperty("http.agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.123 Safari/537.36");
        URL oracle = new URL(url);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();*/
    }

    /*private static String downloadWebPage(URL url) throws IOException {
        StringBuilder result = new StringBuilder();
        String line;

        // add user agent
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.123 Safari/537.36");
        System.setProperty("http.agent", "Chrome");
        urlConnection.setReadTimeout(5000);
        urlConnection.setConnectTimeout(5000);

        try (InputStream is = new URL(url).openStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {

            while ((line = br.readLine()) != null) {
                result.append(line);
            }

        }

        return result.toString();

    }*/
}