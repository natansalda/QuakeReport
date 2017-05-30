package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private int mColorResourceId;

    public EarthquakeAdapter(Context context, ArrayList<Earthquake> quakes, int colorResourceId) {
        super(context, 0, quakes);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the object located at this position in the list
        Earthquake newEarthquake = getItem(position);

        TextView magTextView = (TextView) listItemView.findViewById(R.id.mag);
        magTextView.setText(newEarthquake.getMagnitude());

        TextView placeTextView = (TextView) listItemView.findViewById(R.id.place);
        placeTextView.setText(newEarthquake.getPlace());

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        dateTextView.setText(newEarthquake.getDate());

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.list_item);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);
        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}