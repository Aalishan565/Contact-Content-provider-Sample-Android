package com.contactpoc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by aalishan on 3/3/16.
 */
public class ContactAdapter extends BaseAdapter {
    private ArrayList contactName;
    private ArrayList contactNumber;
    private Context context;
    LayoutInflater inflater;

    public ContactAdapter(Context ctx, ArrayList contactName, ArrayList contactNumber) {
        this.context = ctx;
        this.contactName = contactName;
        this.contactNumber = contactNumber;
        inflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return contactName.size();
    }

    @Override
    public Object getItem(int position) {
        return contactName.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.row_items_contact, null);
            holder.name = (TextView) view.findViewById(R.id.tv_name);
            holder.phoneNo = (TextView) view
                    .findViewById(R.id.tv_phone_number);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.name.setText(contactName.get(position).toString());
        holder.phoneNo.setText(contactNumber.get(position).toString());

        return view;
    }


    public class ViewHolder {
        TextView name;
        TextView phoneNo;


    }
}
