package com.example.marines.galeria;



import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.widget.DrawerLayout;
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

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class DialogFragmentComidas extends DialogFragment {
	Integer[]IDimagenes;
	Gallery gallery;
	ImageView imageView;
	View v ;
	TextView titulo;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		 v = inflater.inflate(R.layout.fragment_comidas, null);
		//Arreglo con el identificador del drawable
		IDimagenes = new Integer[]{R.drawable.crepa1, R.drawable.crepa2, R.drawable.crepa3,
				R.drawable.crepa4};

		titulo=(TextView) v.findViewById(R.id.titulo);
		//llamamos nuestra imagenview
		imageView=(ImageView)v.findViewById(R.id.image);

		//llamamos la galeria
		gallery=(Gallery)v.findViewById(R.id.gallery1);

		//Creamos un adaptador para la galeria
		gallery.setAdapter(new ImageAdapter());

		//funcion onclick en la galeria
		gallery.setOnItemClickListener(new OnItemClickListener(){
		public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {


			//al dar clic en la galeria la imagen se agregara al imageView
				titulo.setText("Crepa "+position);
				imageView.setImageResource(IDimagenes[position]);

		}
		
	});

		//Funcion onclik en la imagen
		imageView.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				try{
					//Al dar clic en la imagen se cerrara el DialogFragment
					dismiss();
				
				}catch(Exception e){
					
					e.printStackTrace();
					
				}
			}
		});

		return v;
	}

	//adaptador de imagen
	public class ImageAdapter extends BaseAdapter{

		private int itemBackground;
		public ImageAdapter(){


			//Este atributo es de android solo tenemos que mandarlo a llamar
			//Creamos un nuevo atributo para el fondo de los elementos de la galeria y  obtenemos el valor del atributo
		TypedArray a = getContext().obtainStyledAttributes(R.styleable.Galeria);

			//obtenemos el id del la galeria
		itemBackground = a.getResourceId(R.styleable.Galeria_android_galleryItemBackground,0);
		a.recycle();
			
			
		}


		public int getCount() {
			// TODO Auto-generated method stub

			//retornamos la cantidad de imagenes que tenemos en el arreglo
			return IDimagenes.length;
		}

		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {

			//Creamos un imagenview
			ImageView imageView= new ImageView(getContext());
			//para que se visualice completa la imagen
			imageView.setScaleType(ImageView.ScaleType.FIT_XY);

			//Esto nos servira para agregar las imagenes al imagenview de la galeria
			imageView.setImageResource(IDimagenes[position]);


			//esta es una manera para adaptar elementos que estamos creando en codigo
			//adaptar la imagen a la pantalla
			DisplayMetrics metrics = new DisplayMetrics();
			getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
			int width = metrics.widthPixels; // ancho absoluto en pixels
			int height = metrics.heightPixels; // alto absoluto en pixels

			int width2=width/2;
			int height2=height/5;


			imageView.setLayoutParams(new Gallery.LayoutParams(width2,height2));

			//agregamos el fondo que tendra el imagenview
			imageView.setBackgroundResource(itemBackground);

			//retornamos la imagen
			return imageView;
		}

		
	}
}
