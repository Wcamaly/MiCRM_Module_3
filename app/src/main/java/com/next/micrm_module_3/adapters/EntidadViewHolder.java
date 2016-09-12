package com.next.micrm_module_3.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.View;
import android.widget.TextView;

import com.next.micrm_module_3.R;
import com.next.micrm_module_3.model.ModelEntidadList;
import com.next.micrm_module_3.view.interfaces.LongClickListener;

/**
 * This class is to store data adapter
 */
public class EntidadViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnCreateContextMenuListener {
    private final TextView title;
    LongClickListener longClickListener;
    public EntidadViewHolder(View itemView) {
        super(itemView);
        this.title = (TextView) itemView.findViewById(R.id.title);
        itemView.setOnLongClickListener(this);
        itemView.setOnCreateContextMenuListener(this);
    }
    public void bind(ModelEntidadList model){
       title.setText(model.getText());
    }
    public void setOnLongClickListener(LongClickListener lc){
        this.longClickListener =lc;
    }

    @Override
    public boolean onLongClick(View v) {
        this.longClickListener.onItemLongClick(getLayoutPosition());
        return false;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Seleccione Acción");
        menu.add(0,v.getId(),0,"Cambiar");
        menu.add(0,v.getId(),0,"Eliminar");
    }
}
