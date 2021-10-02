package com.sunshine.appninjas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.RequestParams;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import okhttp3.Headers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String apiKey = getString(R.string.api_key);

        if (!Places.isInitialized()) {
            Places.initialize(getApplicationContext(), apiKey);
        }
        PlacesClient placesClient = Places.createClient(this);

        ApiClient apiclient=new ApiClient();
        RequestParams requestParams = apiclient.GetParams();
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(ApiClient.host, requestParams, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json) {

                Log.i("JSON OUTPUT SUCCESS",json.toString());

                JSONObject jsonObject= json.jsonObject;
                try {
                    JSONObject propertiesObj = jsonObject.getJSONObject("properties");
                    JSONObject parametersObj= propertiesObj.getJSONObject("parameter");
                    JSONObject allskyObj=parametersObj.getJSONObject("ALLSKY_SFC_SW_DWN");
                    //System.out.println(allskyObj.length());

                    Iterator<String> keysIterator=allskyObj.keys();
                    ArrayList<String> keyslist=new ArrayList<>();


                    while(keysIterator.hasNext())
                    {   String date=keysIterator.next();
                        //String date_formatted=ParseDate(date);

                        keyslist.add(date);
                    }
                    System.out.println((keyslist.size()));
                    DataPoint[] dp = new DataPoint[keyslist.size()];
                    HashMap<Date,Double> map=new HashMap<Date, Double>();
                    ArrayList<Double>avgList=new ArrayList<>();
                    for(int i=0;i<keyslist.size();i++)
                    {

                        String key= keyslist.get(i);
                        Date date1= null;
                        try {
                            date1 = new SimpleDateFormat("yyyyMM").parse(key);
                            Double value=Double.parseDouble(allskyObj.getString(key));
                            dp[i]=new DataPoint(date1,value);
                            map.put(date1,value);

                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }

                    GraphView graph = (GraphView) findViewById(R.id.graph);
                    graph.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.HORIZONTAL);


                    LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(dp);
                    graph.addSeries(series);
                    graph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(getApplicationContext()));
                    graph.getGridLabelRenderer().setNumHorizontalLabels(3); // only 4 because of the space

// set manual x bounds to have nice steps
                  //  graph.getViewport().setMinX(d1.getTime());
                    //graph.getViewport().setMaxX(d3.getTime());
                    graph.getViewport().setXAxisBoundsManual(true);


// as we use dates as labels, the human rounding to nice readable numbers
// is not necessary
                    graph.getGridLabelRenderer().setHumanRounding(false);
                    for (Map.Entry<Date,Double> entry : map.entrySet()) {
                        System.out.println(entry.getKey()+" : "+entry.getValue());
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                Log.e("JSON OUTPUT FAILURE",headers.toString());

            }

        });

        AutocompleteSupportFragment autocompleteFragment = (AutocompleteSupportFragment)
                getSupportFragmentManager().findFragmentById(R.id.autocomplete_fragment);

        autocompleteFragment.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME));

        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.
                Log.i("Location", "Place: " + place.getName() + ", " + place.getId());
            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                Log.i("Location", "An error occurred: " + status);
            }
        });
    }

    private String ParseDate( String date)
    {
        String year=date.substring(0,4);
        String year_formatted=year.substring(2);
        String month=date.substring(4);
        String formatted=month+"/"+year_formatted;
        return formatted;
    }
    }

