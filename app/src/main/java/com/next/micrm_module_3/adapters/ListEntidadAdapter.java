package com.next.micrm_module_3.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.next.micrm_module_3.R;
import com.next.micrm_module_3.model.ModelEntidadList;
import com.next.micrm_module_3.model.interfaces.Entidad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wcamaly on 06/07/2016.
 */
public class ListEntidadAdapter  extends RecyclerView.Adapter<EntidadViewHolder> {
    private Context context;
    private List<ModelEntidadList> list;
    private View.OnClickListener listener;

    public ListEntidadAdapter(Context context, List<ModelEntidadList> list, View.OnClickListener listener) {
        this.context = context;
        this.list = new ArrayList<>(list);
        this.listener = listener;
    }

    @Override
    public EntidadViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.acitivity_list_item_separator, parent, false);
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

    public void setList(List<ModelEntidadList> l) {
        list = new ArrayList<>(l);
    }

    public ModelEntidadList removeItem(int position) {
        final ModelEntidadList model = list.remove(position);
        notifyItemRemoved(position);
        return model;
    }

    public void addItem(int position, ModelEntidadList model) {
        list.add(position, model);
        notifyItemInserted(position);
    }

    public void moveItem(int fromPosition, int toPosition) {
        final ModelEntidadList model = list.remove(fromPosition);
        list.add(toPosition, model);
        notifyItemMoved(fromPosition, toPosition);
    }

    public void animateTo(List<ModelEntidadList> models) {
        applyAndAnimateRemovals(models);
        applyAndAnimateAdditions(models);
        applyAndAnimateMovedItems(models);
    }

    private void applyAndAnimateRemovals(List<ModelEntidadList> newModels) {
        for (int i = list.size() - 1; i >= 0; i--) {
            final ModelEntidadList model = list.get(i);
            if (!newModels.contains(model)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<ModelEntidadList> newModels) {
        for (int i = 0, count = newModels.size(); i < count; i++) {
            final ModelEntidadList model = newModels.get(i);
            if (!list.contains(model)) {
                addItem(i, model);
            }
        }
    }

    private void applyAndAnimateMovedItems(List<ModelEntidadList> newModels) {
        for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
            final ModelEntidadList model = newModels.get(toPosition);
            final int fromPosition = list.indexOf(model);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }

    }
}