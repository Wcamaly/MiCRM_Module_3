package com.next.micrm_module_3.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.next.micrm_module_3.R;
import com.next.micrm_module_3.model.ModelEntidadList;

/**
 * This class is to store data adapter
 */
public class EntidadViewHolder extends RecyclerView.ViewHolder {
    private final TextView title;
    public EntidadViewHolder(View itemView) {
        super(itemView);
        this.title = (TextView) itemView.findViewById(R.id.title);
    }
    public void bind(ModelEntidadList model){
       title.setText(model.getText());
    }
}
