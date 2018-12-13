package com.udacity.sandwichclub.utils;

import android.content.Context;
import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json){

        //sandwich object is null to start
        Sandwich sandwich = null;

        /**
         * create our key pairings here and parse the json in the strings res file.  The key pairings I care about are
         */

        final
        String NAME = "name";
        String MAIN_NAME="mainName";
        String ALSO_KNOWN_AS="alsoKnownAs";
        String PLACE_OF_ORIGIN="placeOfOrigin";
        String DESCRIPTION ="description";
        String IMAGE="image";
        String INGREDIENTS="ingredients";

        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject nameObject = jsonObject.getJSONObject("name");
            String mainName = nameObject.getString("mainName");
            JSONArray alsoKnownAs = nameObject.getJSONArray("alsoKnownAs");
            ArrayList<String> alsoKnownAsList = new ArrayList<>();
            //loop through the alsoKnownAs object and add the strings to the list
            int holder = 0;
            while(holder <alsoKnownAs.length())
            {
                alsoKnownAsList.add(alsoKnownAs.getString(holder));
                holder += 1;
            }
            String placeOfOrigin = nameObject.getString("placeOfOrigin");
            String description = nameObject.getString("description");
            String image = nameObject.getString("image");
            JSONArray ingredients = nameObject.getJSONArray("ingredients");
            ArrayList<String> ingredientsList = new ArrayList<>();
            //loop through the ingredients object and add the strings to the list
            holder = 0;
            while(holder <ingredients.length())
            {
                alsoKnownAsList.add(ingredients.getString(holder));
                holder += 1;
            }

            return new Sandwich(mainName, alsoKnownAsList, placeOfOrigin, description, image, ingredientsList);

        } catch(JSONException e) {
            Log.d (TAG, "AN ERROR OCCURED WHILE PARSING");
            e.printStackTrace();
        }
        return null;
    }
}
