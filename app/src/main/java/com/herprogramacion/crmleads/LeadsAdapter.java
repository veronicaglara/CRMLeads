package com.herprogramacion.crmleads;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Adaptador de leads
 */
public class LeadsAdapter extends ArrayAdapter<Lead> {
    public LeadsAdapter(Context context, List<Lead> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtener inflater.
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewHolder holder;

        // ¿Ya se infló este view?
        if (null == convertView) {
            //Si no existe, entonces inflarlo con image_list_view.xml
            convertView = inflater.inflate(
                    R.layout.list_item_lead,
                    parent,
                    false);

            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.tv_name);
            holder.fechaIni = (TextView) convertView.findViewById(R.id.tv_fechaIni);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Lead actual.
        Lead lead = getItem(position);

        // Setup.
        holder.name.setText(lead.getName());
        holder.fechaIni.setText(lead.getfechaIni());
        return convertView;
    }

    static class ViewHolder {

        TextView name;
        TextView fechaIni;

    }
}
