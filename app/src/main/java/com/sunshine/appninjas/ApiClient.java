package com.sunshine.appninjas;

import android.util.Log;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.RequestParams;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.jjoe64.graphview.series.DataPoint;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import okhttp3.Headers;

public class ApiClient {

    static final String host="https://power.larc.nasa.gov/api/temporal/monthly/point?";

    static final String host_weekly="https://power.larc.nasa.gov/api/temporal/daily/point?";




    //https://power.larc.nasa.gov/api/temporal/monthly/point?
    // parameters=ALLSKY_SFC_SW_DWN&
    // community=RE&
    // longitude=-111.9216&
    // latitude=33.4099&
    // format=JSON&
    // start=2019&end=2020
    //String latitude,String longitude,String granularity,String startDate,String endDate
    RequestParams GetParams(Double longitude, Double latitude, int start_month, int start_year, int end_month, int end_year)
    {
        RequestParams params = new RequestParams();
        System.out.println(Double.toString(longitude).length());
        System.out.println(Double.toString(latitude).length());

        System.out.println(Double.toString(longitude));
        System.out.println(Double.toString(latitude));

        String lat = Double.toString(longitude).substring(0, 3);
        String longi = Double.toString(longitude).substring(0, 3);
        System.out.println("lat"+Double.toString(longitude));
        System.out.println("long"+longitude);
        System.out.println("lat"+start_year);
        System.out.println("lat"+end_year);
        params.put("parameters", "ALLSKY_SFC_SW_DWN");
        params.put("community", "RE");
        params.put("longitude",lat);
        params.put("latitude",longi);
        params.put("format","JSON");
        params.put("start",Integer.toString(start_year));
        params.put("end",Integer.toString(end_year));
        return params;
    }

}

