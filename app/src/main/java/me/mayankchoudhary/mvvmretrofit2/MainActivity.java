package me.mayankchoudhary.mvvmretrofit2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import me.mayankchoudhary.mvvmretrofit2.adapter.PostListAdapter;
import me.mayankchoudhary.mvvmretrofit2.model.PostModel;
import me.mayankchoudhary.mvvmretrofit2.viewmodel.PostsListViewModel;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PostListAdapter adapter;
    private List<PostModel> postList;
    private PostsListViewModel postsListViewModel;
    private TextView noResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        noResults = findViewById(R.id.noResults);

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new GridLayoutManager(this, 2);
        adapter = new PostListAdapter(this, postList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        postsListViewModel = ViewModelProviders.of(this).get(PostsListViewModel.class);
        postsListViewModel.getPostListObserver().observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                if(postModels != null){
                    postList = postModels;
                    adapter.setPostList(postModels);
                    noResults.setVisibility(View.GONE);
                } else {
                    noResults.setVisibility(View.VISIBLE);
                }
            }
        });

        postsListViewModel.makeApiCall();
    }
}