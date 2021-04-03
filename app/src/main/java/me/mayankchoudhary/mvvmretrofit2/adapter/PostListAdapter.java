package me.mayankchoudhary.mvvmretrofit2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import me.mayankchoudhary.mvvmretrofit2.R;
import me.mayankchoudhary.mvvmretrofit2.model.PostModel;

public class PostListAdapter extends RecyclerView.Adapter<PostListAdapter.ViewHolder> {

    private Context context;
    private List<PostModel> postList;

    public PostListAdapter(Context context, List<PostModel> postList) {
        this.context = context;
        this.postList = postList;
    }

    public void setPostList(List<PostModel> postList) {
        this.postList = postList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PostListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.post_item_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostListAdapter.ViewHolder holder, int position) {
        holder.title.setText(this.postList.get(position).getName());
        Glide.with(context).load(postList.get(position)
                .getImage()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        if(this.postList !=null) {
            return this.postList.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.post_title);
            image = itemView.findViewById(R.id.post_image);
        }
    }
}
