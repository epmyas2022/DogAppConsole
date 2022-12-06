package Clases;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import com.google.gson.*;
import java.util.ArrayList;
import java.util.Iterator;



public class Ajax {

    public static final String Method_GET = "GET";
    public static final String Method_POST = "POST";

    private static Class Model;
    private static ArrayList<Object> ArrayModel = new ArrayList<Object>();

    private static String DataPost = "";

    public static void setDataPost(Object data) {
        var gson = new Gson();

        var json = gson.toJson(data);

        DataPost = json;

    }

    public static void SetModel(Class model) {
        Model = model;
    }

    public static void Fetch(String url, String Api_key, String Method) throws Exception {

        if (Method == "GET") {

            Gson gson = new Gson();
            JsonParser parser = new JsonParser();

            var response = RequestHttpGet(url, Api_key);

            JsonArray array = (JsonArray) parser.parse(response);

            Iterator<JsonElement> iteratorArray = array.iterator();

            while (iteratorArray.hasNext()) {
                var model = gson.fromJson(iteratorArray.next(), Model);

                ArrayModel.add(model);
            }
        }

        if (Method == "POST") {

            var response = RequestHttpPost(url, DataPost, Api_key);

            ArrayModel.add(response);
        }
    }

    public static ArrayList<Object> getResponse() {

        return ArrayModel;
    }

    public static void ClearModels() {
        ArrayModel.clear();
    }

    private static String RequestHttpGet(String url, String Api_Key) throws Exception {

        StringBuilder result = new StringBuilder();

        URL Url = new URL(url);

        HttpURLConnection connection = (HttpURLConnection) Url.openConnection();

        connection.setRequestMethod("GET");
        connection.setRequestProperty("X-Api-Key", Api_Key);
        connection.setRequestProperty("accept", "application/json");

        BufferedReader Buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        var line = "";

        while ((line = Buffer.readLine()) != null) {
            result.append(line);
        }

        Buffer.close();

        return result.toString();

    }

    private static String RequestHttpPost(String url, String data, String Api_Key) throws Exception {
 
        URL Url = new URL(url);
        HttpURLConnection  connection = (HttpURLConnection) Url.openConnection();
        connection.setRequestMethod("POST");
         connection.setRequestProperty("X-Api-Key",Api_Key);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);
        var output = connection.getOutputStream();
        output.write(data.getBytes());
        output.flush();
        output.close();
  
     return connection.getResponseMessage();
    }

}
