package com.example.hasanzian.vcard;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hasanZian on 09-03-2018.
 */

public class Adaptor extends ArrayAdapter<ListDataModel> {


    public Adaptor(@NonNull Context context,  @NonNull List<ListDataModel> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        ListDataModel currentPostion =getItem(position);
        TextView titleTv = (TextView)listItemView.findViewById(R.id.title_main);
        TextView titleSubTv = (TextView)listItemView.findViewById(R.id.title_sub);
        ImageView icon = (ImageView)listItemView.findViewById(R.id.icon);
        titleTv.setText(currentPostion.getmTitle());
        titleSubTv.setText(currentPostion.getmSubTitle());
        icon.setImageResource(currentPostion.getmIcon());





        return  listItemView;

    }
}
