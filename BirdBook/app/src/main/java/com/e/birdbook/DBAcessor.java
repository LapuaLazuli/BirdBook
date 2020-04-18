package com.e.birdbook;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class DBAcessor {
    private static SQLiteDatabase birdDatabase;
    private static Results ret;
    private static List<String> requestedFieldsList;
    private static Dictionary outerDictionary;
    private static String searchValue;
    private static String searchField;

    @RequiresApi(api = Build.VERSION_CODES.O_MR1)
    public static Results access(Request query, Context c){

        //initialize fields
        initialize(query, c);

        //evaluate request type and grab info from db
        Cursor cs = birdDatabase.rawQuery("select * from birds", null);
        cs.moveToFirst();
        while (!cs.isAfterLast()){
            System.out.println(cs.getString(10));
            cs.moveToNext();
        }
        checkQueryTypeAndInitiateParsing(query, cs);
        cs.close();
        ret.setResults(outerDictionary);

        //returns BirdInfoResults class
        return ret;
    }

    private static void initialize(Request query, Context c){
        //connects code to bird_v2.db
        DBHelper dbh = new DBHelper(c);
        birdDatabase = dbh.getReadableDatabase();

        //initialize return class, returning dictionary, and search values
        ret = new BirdInfoResults();
        requestedFieldsList = query.getRequestedFields();
        outerDictionary = new Hashtable();
        searchValue = query.getSearchValue();
        searchField = query.getSearchField();
    }

    private static void checkQueryTypeAndInitiateParsing(Request query, Cursor cs){
        if (query.getType() == Request.TYPE.BIRD){
            ret.setType(Results.TYPE.BIRD);
            grabInfoForBird(cs);
        }
        else {
            ret.setType(Results.TYPE.BIRDLIST);
            grabInfoForBirdList(cs);
        }
    }

    private static void grabInfoForBirdList(Cursor cs){
        //used for grabbing data from all birds
        for (cs.moveToFirst(); !cs.isAfterLast(); cs.moveToNext()){
            outerDictionary.put(cs.getString(0), cs.getString(11)); //places into primary Dictionary with format <birdname, BirdInfoResults>
        }
    }

    private static void grabInfoForBird(Cursor cs){
        boolean found = false;
        cs.moveToFirst();
        while (!cs.isAfterLast() && !found) {
            if (cs.getString(cs.getColumnIndex(searchField)).equals(searchValue)) { //checks if searchValue matches the value of corresponding searchField
                outerDictionary.put(searchField, searchValue); //puts successful match into dictionary
                //begin loading in requestedFields values into dictionary
                for (String q : requestedFieldsList){
                    //loads in field from list l and corresponding value found in <birds> entry
                    outerDictionary.put(q, cs.getString(cs.getColumnIndex(q)));
                }
                found = true;
            }
            cs.moveToNext();
        }
    }

}
