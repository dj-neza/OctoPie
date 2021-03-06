package com.example.neza.octopie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class MyAdapter extends BaseAdapter {
    private Context context;
    private final String[] octoValues;

    public MyAdapter(Context context, String[] octoValues) {
        this.context = context;
        this.octoValues = octoValues;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = new View(context);

            gridView = inflater.inflate(R.layout.octo, null);

            // set value into textview
            TextView textView = (TextView) gridView
                    .findViewById(R.id.grid_item_label);
            textView.setText(octoValues[position]);

            // set image based on selected text
            ImageView imageView = (ImageView) gridView
                    .findViewById(R.id.grid_item_image);

            String octo = octoValues[position];

            if (octo.equals("Fit")) {
                imageView.setImageResource(R.drawable.octo02);
            } else if (octo.equals("Vegan")) {
                imageView.setImageResource(R.drawable.octo03);
            } else if (octo.equals("Allergies")){
                imageView.setImageResource(R.drawable.octo04);
            } else if (octo.equals("Gluten-free")) {
                imageView.setImageResource(R.drawable.octo05);
            }

        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }

    @Override
    public int getCount() {
        return octoValues.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}
