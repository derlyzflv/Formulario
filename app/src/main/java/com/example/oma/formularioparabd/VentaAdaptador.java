package com.example.oma.formularioparabd;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VentaAdaptador extends RecyclerView.Adapter<VentaAdaptador.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView codigo,nombre,fecha,producto,cantidad,total;
        ImageView fotoicono;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            codigo=itemView.findViewById(R.id.idcodigo);
            nombre=itemView.findViewById(R.id.idnombre);
            fecha=itemView.findViewById(R.id.idfecha);
            producto=itemView.findViewById(R.id.idproducto);
            cantidad=itemView.findViewById(R.id.idcantidad);
            total=itemView.findViewById(R.id.idtotal);
            fotoicono=itemView.findViewById(R.id.imgIcono);
        }
    }
    public List<VentaModelo> ventalista;

    public VentaAdaptador(List<VentaModelo> ventalista) {
        this.ventalista = ventalista;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_venta,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.codigo.setText(ventalista.get(position).getCodigo());
        holder.nombre.setText(ventalista.get(position).getNombre());
        holder.codigo.setText(ventalista.get(position).getCodigo());
        holder.fecha.setText(ventalista.get(position).getFecha());
        holder.producto.setText(ventalista.get(position).getProducto());
        holder.cantidad.setText(ventalista.get(position).getCantidad());
        holder.total.setText(ventalista.get(position).getTotal());

    }

    @Override
    public int getItemCount() {
        return ventalista.size();
    }
}
