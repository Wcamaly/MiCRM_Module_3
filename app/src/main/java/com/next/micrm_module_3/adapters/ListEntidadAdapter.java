package com.next.micrm_module_3.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.next.micrm_module_3.R;
import com.next.micrm_module_3.model.interfaces.Entidad;

import java.util.List;

/**
 * Created by wcamaly on 06/07/2016.
 */
public class ListEntidadAdapter  extends RecyclerView.Adapter<EntidadViewHolder>{
    private Context context;
    private List<String> list;
    private View.OnClickListener listener;
    public ListEntidadAdapter(Context context, List<String> list,View.OnClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @Override
    public EntidadViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.acitivity_list_item_separator,parent,false);
        itemView.setOnClickListener(listener);

        return new EntidadViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(EntidadViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
