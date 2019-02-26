package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {
        JSONObject data= new JSONObject(json);
        JSONObject name = data.getJSONObject("name");
        String mainName = name.getString("mainName");
        List<String> alsoKnownAs = new ArrayList<String>();
        JSONArray akas = name.getJSONArray("alsoKnownAs");
        for (int i=0;i<akas.length();i++) {
            alsoKnownAs.add(akas.getString(i));
        }
        String placeOfOrigin = data.getString("placeOfOrigin");
        String description = data.getString("description");
        String image = data.getString("image");
        List<String> ingredients = new ArrayList<String>();
        JSONArray ingr = data.getJSONArray("ingredients");
        for (int j=0;j<ingr.length();j++) {
            ingredients.add(ingr.getString(j));
        }
        Sandwich sandwich = new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
        return sandwich;
    }
}
