package com.ambulance.volley;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class DataManager {
    private final Context context;
    String url="";
    private String DataRequest = "http://192.168.1.101:8080";

    public DataManager(Context context){
        this.context=context;
    }

    public void getResults(DataCallback callback) {
        url = DataRequest + "/readusertype";
        DataRequest dataRequest = new DataRequest(context);
        JSONObject data = new JSONObject();
        JSONArray searchdata = new JSONArray();
        try {
            data.put("", "");
            searchdata.put(data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        dataRequest.getjsonOjectpost(url, searchdata, callback);

    }
    public void sendToken(String token, DataCallback callback) {
        url = DataRequest + "/addfcm";
        DataRequest dataRequest = new DataRequest(context);
        JSONObject data = new JSONObject();

        try {
            data.put("fcm_token", token);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        dataRequest.getjsonOjectpost(url, data, callback);

    }

}
