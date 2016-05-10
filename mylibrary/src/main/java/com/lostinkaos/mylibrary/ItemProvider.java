package com.lostinkaos.mylibrary;

import com.lostinkaos.mylibrary.Model.Items;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by fasal-kaos on 5/9/2016.
 */
public class ItemProvider {

    public static List<Items> parse(String rssFeed) {
        List<Items> list = new ArrayList<>();
        Random r = new Random();
        // random number of item but at least 5
        Integer number = r.nextInt(10) + 5;
        for (int i = 0; i < number; i++) {
            // create sample data
            String s = String.valueOf(r.nextInt(1000));
            Items item = new Items("Summary " + s, "Description " + s);
            list.add(item);
        }
        return list;
    }
}
