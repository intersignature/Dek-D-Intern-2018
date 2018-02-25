package sirichai.dek_d_intern_2018.controller;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;

import java.util.List;

import sirichai.dek_d_intern_2018.ItemClickListener;
import sirichai.dek_d_intern_2018.R;
import sirichai.dek_d_intern_2018.ShowSpecificData;
import sirichai.dek_d_intern_2018.model.ListData;

/**
 * Created by atomiz on 22/2/2561.
 */

public class ListDataRecyclerAdapter extends RecyclerView.Adapter<ListDataRecyclerAdapter.ViewHolder> {

    private List<ListData> listDatas;
    private Context context;
    private TextView showJsonTv;
    private String changeLenghtOfMessage;
    public ListDataRecyclerAdapter(List<ListData> listDatas, Context context, TextView showJsonTv) {
        this.listDatas = listDatas;
        this.context = context;
        this.showJsonTv = showJsonTv;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_item, parent, false);

        updateJsonString();
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final ListData listData = listDatas.get(position);

        try {
            Picasso.with(context).load(listData.getImg()).placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(holder.logoImg);
        } catch (Exception e) {
            Log.e("LoadLogoInRecycler", e.toString());
        }
        holder.titleTv.setText(listData.getTitle());
        if (context.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            if (listData.getMessage().length() < 32) {
                holder.messageTv.setText(listData.getMessage());
            } else {
                changeLenghtOfMessage = listData.getMessage().substring(0, Math.min(listData.getMessage().length(), 29));
                holder.messageTv.setText(changeLenghtOfMessage + "...");
            }
        } else {
            if (listData.getMessage().length() < 59) {
                holder.messageTv.setText(listData.getMessage());
            } else {
                changeLenghtOfMessage = listData.getMessage().substring(0, Math.min(listData.getMessage().length(), 56));
                holder.messageTv.setText(changeLenghtOfMessage + "...");
            }
        }
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                if (isLongClick) {
                    removeItem(position);
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putString("specImgLink", listDatas.get(position).getImg());
                    bundle.putString("specTitle", listDatas.get(position).getTitle());
                    bundle.putString("specMessage", listDatas.get(position).getMessage());

                    ShowSpecificData showSpecificData = new ShowSpecificData();
                    showSpecificData.setArguments(bundle);

                    FragmentManager fragmentManager = ((Activity) context).getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frameContainerMain, showSpecificData);
                    fragmentTransaction.addToBackStack(null).commit();
                }
            }

            private void removeItem(int position) {
                listDatas.remove(position);
                notifyItemRemoved(position);
                notifyDataSetChanged();
                updateJsonString();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listDatas.size();
    }

    private void updateJsonString() {
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < listDatas.size(); i++) {
            jsonArray.put(listDatas.get(i).getJSONObject());
        }
        showJsonTv.setText(jsonArray.toString());
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        public ImageView logoImg;
        public TextView titleTv;
        public TextView messageTv;
        private ItemClickListener itemClickListener;

        public ViewHolder(View itemView) {
            super(itemView);

            logoImg = itemView.findViewById(R.id.logoImg);
            titleTv = itemView.findViewById(R.id.titleTv);
            messageTv = itemView.findViewById(R.id.messageTv);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition(), false);
        }

        @Override
        public boolean onLongClick(View v) {
            itemClickListener.onClick(v, getAdapterPosition(), true);
            return false;
        }

        public void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }
    }
}
