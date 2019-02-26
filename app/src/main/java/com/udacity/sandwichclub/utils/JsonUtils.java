package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {
        JSONObject data= new JSONObject(json);
        JSONObject name = data.getJSONObject("name");
        String mainName = name.getString("mainName");
        List<String> alsoKnownAs = name.getJSONArray("alsoKnownAs");
        String placeOfOrigin = data.getString("placeOfOrigin");
        String description = data.getString("description");
        String image = data.getString("image");
        List<String> ingredients = data.getJSONArray("ingredients");
        Sandwich sandwich = new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
        return sandwich;
    }
}
