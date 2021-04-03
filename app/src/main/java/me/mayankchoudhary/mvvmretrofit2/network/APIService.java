package me.mayankchoudhary.mvvmretrofit2.network;

import java.util.List;

import me.mayankchoudhary.mvvmretrofit2.model.PostModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("posts")
    Call<List<PostModel>> getPostList();
}
