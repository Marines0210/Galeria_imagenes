package com.example.marines.galeria;



import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Marines on 13/09/2016.
 */


@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class DialogFragmentComidas extends DialogFragment {
	RecyclerView RecyclerGaleria;
	ImageView imageView;
	View v;
	TextView titulo;
	RecyclerView.Adapter adaptador;
	private ArrayList<Menu> listaMenu;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		v = inflater.inflate(R.layout.fragment_comidas, null);

		titulo = (TextView) v.findViewById(R.id.titulo);
		//llamamos nuestra imagenview
		imageView = (ImageView) v.findViewById(R.id.image);
		titulo.setText("Postres");
		RecyclerGaleria = (RecyclerView) v.findViewById(R.id.galeria);
		//Funcion onclik en la imagen
		imageView.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				try {
					//Al dar clic en la imagen se cerrara el DialogFragment
					dismiss();
				} catch (Exception e) {

					e.printStackTrace();
				}
			}
		});

		//para crear nuestro diseño personalizado le agregamos a nuestro recyclerlinearlayoutmanager de manera horizontal
		//True es para que se muestre en el ultimo item agregado en el recicler y false es para que se muestre en el primer item
		RecyclerGaleria.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));

		//Obtenemos la lista del menu
		listaMenu=new Menu().listamenu();

		if (listaMenu != null) {
			//Creamos nuestro adaptador
			adaptador = new RecyclerAdapter(listaMenu,new RecyclerAdapter.OnclickRecycler() {
				@Override
				public void onClickitemRecycler(Menu v) {
					//glide como dije anteriormente para evitar que se alente al mostrar la imagen
					Glide.with(getContext()).load(v.getIdImagen()).into(imageView);
					titulo.setText(v.getTitulo());
				}
			});
		}
		//Agregamos el adaptador
		RecyclerGaleria.setAdapter(adaptador);
		return v;
	}
}
