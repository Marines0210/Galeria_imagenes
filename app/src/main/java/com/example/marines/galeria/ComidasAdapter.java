package com.example.marines.galeria;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Marines on 13/09/2016.
 */
public class ComidasAdapter extends ArrayAdapter<Comidas> {
    Context context;
    int layoutResourceId;
    Comidas data[]=null;


    public ComidasAdapter(Context context, int layoutResourceId,Comidas[] data) {
        super(context, layoutResourceId,data);

        this.context=context;
        this.layoutResourceId=layoutResourceId;
        this.data=data;
    }


    public View getView(int position, View converView, ViewGroup parent){

        View row=converView;
        ComidasHolder holder=null;

        if(row==null){
            LayoutInflater inflater=((Activity)context).getLayoutInflater();
            row=inflater.inflate(layoutResourceId,parent,false);

            holder=new ComidasHolder();
            holder.imagen=(ImageView)row.findViewById(R.id.imagen);
            holder.texto=(TextView)row.findViewById(R.id.tv);
            row.setTag(holder);

        }else{

            holder=(ComidasHolder)row.getTag();
        }

        Comidas comidas=data[position];
        holder.texto.setText(comidas.title);
        holder.imagen.setImageResource(comidas.icon);


                return row;
    }


    static class ComidasHolder{
        ImageView imagen;
        TextView texto;

    }

}
