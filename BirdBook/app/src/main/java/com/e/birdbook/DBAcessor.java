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
    @RequiresApi(api = Build.VERSION_CODES.O_MR1)
    public static Results access(Request query, Context c) throws Exception {
        //connects code to bird.db
        System.out.println("DEBUG: CHECKPOINT 0");
        /*
        Class.forName("org.sqlite.JDBC");
        System.out.println("db Path: " + c.getDatabasePath("databases\\bird.db").getAbsolutePath());
        String path = c.getDatabasePath("databases\\bird.db").getAbsolutePath();
        Properties config = new Properties();
        config.setProperty("open_mode", "1");

        Connection conn = DriverManager.getConnection("jdbc:sqlite:\\data\\user\\0\\com.e.birdbook\\databases\\bird.db", config);
        Statement stat = conn.createStatement();
         */
        DBHelper dbh = new DBHelper(c);
        System.out.println("Does this exist:" + c.getDatabasePath("bird.db").exists());

        SQLiteDatabase bird = dbh.getReadableDatabase();



        System.out.println("DEBUG: CHECKPOINT 1");

        //initialize return class, returning dictionary, and search values
        Results ret = new BirdInfoResults();
        List<String> l = query.getRequestedFields();
        Dictionary d = new Hashtable();
        String v = query.getSearchValue();
        String f = query.getSearchField();

        System.out.println("DEBUG: CHECKPOINT 2");

        //begins parsing database
        Cursor cs = bird.rawQuery("select * from birds", null);

        boolean found = false;

        if(query.getType() == Request.TYPE.BIRDLIST){
            //used for grabbing data from all birds
            System.out.println("DEBUG: CORRECT SECTION");
            for (cs.moveToFirst(); !cs.isAfterLast(); cs.moveToNext()){
                BirdInfoResults bir = new BirdInfoResults(); //creates a new BirdInfoResults to go into dictionary
                Dictionary d2 = new Hashtable(); //creates a dictionary to go in bir
                for (String q : l){
                    System.out.println("Query: " + q);
                    d2.put(q, cs.getString(cs.getColumnIndex(q))); //fills in specified fields of that particular bird
                }
                bir.setResults(d2); //places dictionary into inner BirdInfoResults
                d.put(cs.getString(0), bir); //places into primary Dictionary with format <birdname, BirdInfoResults>
            }
        }
        else {
            System.out.println("DEBUG: INCORRECT SECTION");
            cs.moveToFirst();
            while (cs.moveToNext() && !found) {
                if (cs.getString(cs.getColumnIndex(f)).equals(v)) { //checks if searchValue matches the value of corresponding searchField
                    d.put(f, v); //puts successful match into dictionary
                    //begin loading in requestedFields values into dictionary
                    for (String q : l){
                        //loads in field from list l and corresponding value found in <birds> entry
                        d.put(q, cs.getString(cs.getColumnIndex(q)));
                    }
                    found = true;
                }
            }
        }
        cs.close();
        //conn.close();
        ret.setResults(d);

        //returns BirdInfoResults class
        return ret;
    }

}
