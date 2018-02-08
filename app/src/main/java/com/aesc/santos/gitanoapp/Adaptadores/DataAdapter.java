package com.aesc.santos.gitanoapp.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aesc.santos.gitanoapp.Entidades.AndroidVersion;
import com.aesc.santos.gitanoapp.Entidades.ProductosVo;
import com.aesc.santos.gitanoapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Android on 2/5/2018.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ProductosViewHolder> implements View.OnClickListener {

    private ArrayList<AndroidVersion> android_versions;
    private Context context;
    private View.OnClickListener listener;

    public DataAdapter(Context context, ArrayList<AndroidVersion> android_versions) {
        this.context = context;
        this.android_versions = android_versions;
    }


    @Override
    public ProductosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem, parent, false);
        view.setOnClickListener(this);
        return new ProductosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductosViewHolder holder, int position) {
        holder.txtDescripcion.setText(android_versions.get(position).getAndroid_version_name());
        //--------------------------Libreria PICASSO para imagenes-------------------------------------------------
        Picasso.with(context).load(android_versions.get(position).getAndroid_image_url()).fit().error(R.mipmap.ic_launcher).into(holder.foto);
//-----------------------------------------------------------------------------------------------------------

    }

    @Override
    public int getItemCount() {
        return android_versions.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onClick(view);
        }
    }

    public class ProductosViewHolder extends RecyclerView.ViewHolder {

        TextView txtNombre, txtDescripcion;
        ImageView foto;

        public ProductosViewHolder(View itemView) {
            super(itemView);

            txtNombre = itemView.findViewById(R.id.tvNombre);
            txtDescripcion = itemView.findViewById(R.id.tvDescripcion);
            foto = itemView.findViewById(R.id.idImage);
        }
    }
}
