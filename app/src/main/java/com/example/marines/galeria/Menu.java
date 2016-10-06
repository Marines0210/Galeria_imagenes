package com.example.marines.galeria;

import java.util.ArrayList;

/**
 * Created by Marines on 13/09/2016.
 */
public class Menu {
    public int idImagen;
    public String titulo;

    public Menu(){
        idImagen=0;
        titulo="";

    }

    public Menu(int idImagen, String titulo){
        this.idImagen=idImagen;
        this.titulo=titulo;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public ArrayList<Menu> listamenu(){
        Menu menu;
        ArrayList<Menu> lista = new ArrayList<Menu>();
        Integer[] IDimagenes= new Integer[]{R.drawable.crepa1, R.drawable.crepa2, R.drawable.crepa3,R.drawable.crepa4};
        String [] titulo=new String[]{"Frambuesa", "Fresa", "Kiwi","Durazno"};

        try {
            for (int i = 0; i <IDimagenes.length; i++) {
                int imagen = IDimagenes[i];
                String titulos = titulo[i];
                menu = new Menu(imagen, titulos);
                lista.add(menu);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return lista;
    }

}
