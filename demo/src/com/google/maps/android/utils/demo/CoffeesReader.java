package com.google.maps.android.utils.demo;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.utils.demo.model.MyItem;
import com.google.maps.android.utils.demo.model.Person;

public class CoffeesReader {

    /*
     * This matches only once in whole input,
     * so Scanner.next returns whole InputStream as a String.
     * http://stackoverflow.com/a/5445161/2183804
     */
    private static final String REGEX_INPUT_BOUNDARY_BEGINNING = "\\A";

    public List<Person> read(InputStream inputStream) throws JSONException {
        List<Person> items = new ArrayList<Person>();
        String json = new Scanner(inputStream).useDelimiter(REGEX_INPUT_BOUNDARY_BEGINNING).next();
        JSONArray array = new JSONArray(json);
        for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(i);
            double lat = object.getDouble("lat");
            double lng = object.getDouble("lng");
            items.add(new Person(new LatLng(lat, lng), "Starbucks", R.drawable.pin_poi_coffee));
        }
        return items;
    }
}
