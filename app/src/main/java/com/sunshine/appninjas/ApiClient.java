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


    //https://power.larc.nasa.gov/api/temporal/monthly/point?
    // parameters=ALLSKY_SFC_SW_DWN&
    // community=RE&
    // longitude=-111.9216&
    // latitude=33.4099&
    // format=JSON&
    // start=2019&end=2020
    //String latitude,String longitude,String granularity,String startDate,String endDate
    RequestParams GetParams()
    {
        RequestParams params = new RequestParams();
        params.put("parameters", "ALLSKY_SFC_SW_DWN");
        params.put("community", "RE");
        params.put("longitude","-111.9216");
        params.put("latitude","33.4099");
        params.put("format","JSON");
        params.put("start","2019");
        params.put("end","2020");
        return params;
    }

}

