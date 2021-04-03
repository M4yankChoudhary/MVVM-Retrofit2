package me.mayankchoudhary.mvvmretrofit2.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import me.mayankchoudhary.mvvmretrofit2.model.PostModel;
import me.mayankchoudhary.mvvmretrofit2.network.APIService;
import me.mayankchoudhary.mvvmretrofit2.network.RetroInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsListViewModel extends ViewModel {

    private MutableLiveData<List<PostModel>> postList;

    public PostsListViewModel() {
        postList = new MutableLiveData<>();
    }

    public MutableLiveData<List<PostModel>> getPostListObserver() {
        return postList;
    }

    public void makeApiCall() {
        APIService apiService = RetroInstance.getRetrofitClient()
                .create(APIService.class);

        Call<List<PostModel>> call = apiService.getPostList();

        call.enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                postList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                postList.postValue(null);

            }
        });

    }
}
