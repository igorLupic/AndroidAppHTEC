package adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import activities.ItemDetailsActivity;
import models.ItemModel;
import com.example.igor.androidapplicationh.R;
import com.squareup.picasso.Picasso;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {

    private List<ItemModel> itemModelList;
    Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mDescription, mTitle;
        public ImageView mImage;


        public MyViewHolder(View view) {
            super(view);
            mImage = view.findViewById(R.id.image);
            mDescription = view.findViewById(R.id.description);
            mTitle = view.findViewById(R.id.title);
        }
    }

    public ItemAdapter(List<ItemModel> itemModelList, Context context) {
        this.itemModelList = itemModelList;
        this.mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_layout, parent, false);
        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final ItemModel itemModel = itemModelList.get(position);
        Picasso.get().load(itemModel.getmImage()).into(holder.mImage);
        holder.mTitle.setText(itemModel.getmTitle());
        holder.mDescription.setText(itemModel.getmDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ItemDetailsActivity.class);
                intent.putExtra("itemObject",itemModel);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemModelList.size();
    }
}