package com.lostinkaos.createlibrary;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.lostinkaos.mylibrary.ItemProvider;
import com.lostinkaos.mylibrary.Model.Items;

import java.util.List;

/**
 * Created by fasal-kaos on 5/9/2016.
 */
public class MyListFragment extends Fragment {

    private OnItemSelectedListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listoverview,
                container, false);
        Button button = (Button) view.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail("fake");
            }
        });
        return view;
    }

    public interface OnItemSelectedListener {
        public void onRssItemSelected(String link);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnItemSelectedListener) {
            listener = (OnItemSelectedListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement MyListFragment.OnItemSelectedListener");
        }
    }

    // triggers update of the details fragment
    public void updateDetail(String uri) {
        // create fake data
      //  String newTime = String.valueOf(System.currentTimeMillis());
        // send data to activity
       // listener.onRssItemSelected(newTime);

        List<Items> list = ItemProvider.parse("http://www.vogella.com/article.rss");
        String text = String.valueOf(list.toString());
        listener.onRssItemSelected(text);
    }
}

