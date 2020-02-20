package com.example.retrofitimageloading;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.ViewHolder> {
    private List<Post> postList;
    private Context context;

    public CustomerAdapter(List<Post> postList, Context context) {
        this.postList = postList;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerAdapter.ViewHolder holder, int position) {
        Post post = postList.get(position);
        holder.albumIdTv.setText(post.getAlbumId());
        holder.idTv.setText(post.getId());
        holder.titleTv.setText(post.getTitle());

        Picasso.get().load(post.getUrl()).into(holder.urlImage);
        Picasso.get().load(post.getThumbnailUrl()).into(holder.thumbnailUrl);

   }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView albumIdTv, idTv, titleTv;
        ImageView urlImage, thumbnailUrl;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            albumIdTv = itemView.findViewById(R.id.albumId);
            idTv = itemView.findViewById(R.id.id);
            titleTv = itemView.findViewById(R.id.title);
            urlImage = itemView.findViewById(R.id.urlImg);
            thumbnailUrl = itemView.findViewById(R.id.thumbnailUrlImg);
        }
    }
}
