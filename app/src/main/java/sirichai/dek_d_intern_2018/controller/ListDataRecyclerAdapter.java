package sirichai.dek_d_intern_2018.controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import sirichai.dek_d_intern_2018.R;
import sirichai.dek_d_intern_2018.model.ListData;

/**
 * Created by atomiz on 22/2/2561.
 */

public class ListDataRecyclerAdapter extends RecyclerView.Adapter<ListDataRecyclerAdapter.ViewHolder> {

    private List<ListData> listDatas;
    private Context context;

    public ListDataRecyclerAdapter(List<ListData> listDatas, Context context) {
        this.listDatas = listDatas;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ListData listData = listDatas.get(position);

        Picasso.with(context).load(listData.getImg()).placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(holder.logoImg);
        holder.titleTv.setText(listData.getTitle());
        holder.messageTv.setText(listData.getMessage());
    }

    @Override
    public int getItemCount() {
        return listDatas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView logoImg;
        public TextView titleTv;
        public TextView messageTv;

        public ViewHolder(View itemView) {
            super(itemView);

            logoImg = itemView.findViewById(R.id.logoImg);
            titleTv = itemView.findViewById(R.id.titleTv);
            messageTv = itemView.findViewById(R.id.messageTv);
        }
    }
}
