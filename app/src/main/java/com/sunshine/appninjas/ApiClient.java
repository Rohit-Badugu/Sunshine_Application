package com.sunshine.appninjas;

import android.util.Log;

import com.android.volley.Header;
import com.android.volley.Response;
import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.RequestParams;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import okhttp3.Headers;

public class ApiClient {

    private static final String host="https://power.larc.nasa.gov/api/temporal/monthly/point?";


    //https://power.larc.nasa.gov/api/temporal/monthly/point?
    // parameters=ALLSKY_SFC_SW_DWN&
    // community=RE&
    // longitude=-111.9216&
    // latitude=33.4099&
    // format=JSON&
    // start=2019&end=2020
    //String latitude,String longitude,String granularity,String startDate,String endDate
    void GetJson()
    {
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put("parameters", "ALLSKY_SFC_SW_DWN");
        params.put("community", "RE");
        params.put("longitude","-111.9216");
        params.put("latitude","33.4099");
        params.put("format","JSON");
        params.put("start","2019");
        params.put("end","2020");
        client.get(host, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {

                Log.i("JSON OUTPUT SUCCESS",json.toString());
                Gson gson = new GsonBuilder().create();
                // Define Response class to correspond to the JSON response returned
                //gson.fromJson(json.toString(), Response.class);


            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                Log.e("JSON OUTPUT FAILURE",headers.toString());

            }

        });
    }

}

