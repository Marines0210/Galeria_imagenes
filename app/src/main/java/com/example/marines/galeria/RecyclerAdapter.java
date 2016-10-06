package com.example.marines.galeria;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{

private  ArrayList<Menu> listamenu;
private  OnclickRecycler listener;

    //al definir interfaces permitimos la existencia de variables polimórficas y la invocación polimórfica de métodos

    public interface OnclickRecycler {
    void onClickitemRecycler(Menu v);
}

    //creamos nuestro contrcutor recivimos un arraylist tipomenu y nuesta varianle tico oncliReycler
    public RecyclerAdapter(ArrayList<Menu> lista, OnclickRecycler listener){
        listamenu =lista;
        this.listener=listener;
    }


    @Override
    //Adaptador


    public RecyclerAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    //Obtenemos nuestro xml de nuestro adaptador donde estan nuestro card view  y lo retornamos
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_adaptador,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override

    //holder poseedor y bind enlazador
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Menu menu = listamenu.get(position);
        holder.bind(menu,listener);
    }

    @Override
    public int getItemCount() {
        return listamenu.size();
    }
//vamos a crar nuestro viewholder el view holder para nuestro recycler
public static class MyViewHolder extends RecyclerView.ViewHolder{
    public ImageView imagen;
    private TextView titulo;


    //Creamos nuestro constructor del viewholder
    public MyViewHolder(View itemView) {
        super(itemView);
        imagen=(ImageView) itemView.findViewById(R.id.imagengaleria);
    }


    // Enlazador
    public void bind(final Menu menu, final OnclickRecycler listener) {

        //Utilizar glide para evitar que nuestro recycle al momento de seslizarlo se mueva lentamente por las imagenes
        Glide.with(imagen.getContext()).load(menu.getIdImagen()).into(imagen);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                listener.onClickitemRecycler(menu);
            }
        });
    }
}
}

