package com.e.birdbook;
import java.sql.*;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class DBAcessor {
    public static Results access(Request query) throws Exception {
        //connects code to bird.db
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:bird.db");
        Statement stat = conn.createStatement();

        //initialize return class, returning dictionary, and search values
        Results ret = new BirdInfoResults();
        List<String> l = query.getRequestedFields();
        Dictionary d = new Hashtable();
        String v = query.getSearchValue();
        String f = query.getSearchField();

        //begins parsing database
        ResultSet rs = stat.executeQuery("select * from birds;");

        boolean found = false;

        if(v.equals("all")){
            //used for grabbing data from all birds
            while (rs.next()){
                BirdInfoResults bir = new BirdInfoResults(); //creates a new BirdInfoResults to go into dictionary
                Dictionary d2 = new Hashtable(); //creates a dictionary to go in bir
                String n = rs.getString("name"); //grabs the name for use in d2 lookups
                //begin loading requested fields for every bird
                for (String q : l){
                    d2.put(q, rs.getString(q));
                }
                //stash d2 into bir
                bir.setResults(d2);
                //stash bir into returning top level dictionary
                d.put(n, bir);
            }
        }
        else {
            while (rs.next() && !found) {
                if (v.equals(rs.getString(f))) { //checks if searchValue matches the value of corresponding searchField
                    d.put(f, v); //puts successful match into dictionary
                    //begin loading in requestedFields values into dictionary
                    for (String q : l){
                        //loads in field from list l and corresponding value found in <birds> entry
                        d.put(q, rs.getString(q));
                    }
                    found = true;
                }
            }
        }
        rs.close();
        conn.close();
        ret.setResults(d);

        //returns BirdInfoResults class
        return ret;
    }
}
