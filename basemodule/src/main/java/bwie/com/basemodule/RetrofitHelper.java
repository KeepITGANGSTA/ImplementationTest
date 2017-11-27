package bwie.com.basemodule;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 李英杰 on 2017/11/14.
 * Description：
 */

public class RetrofitHelper {

    private static String baseUrl;
    private Retrofit retrofit;
    private RetrofitHelper (){
        retrofit=new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static class RetrofitHolder{
        static RetrofitHelper retrofitHelper=new RetrofitHelper();
    }
    public static RetrofitHelper getRetrofitHelper(String baseUrl){
        RetrofitHelper.baseUrl=baseUrl;
        return RetrofitHolder.retrofitHelper;
    }

    public <T>T getApiService(Class<T> tClass){
        return retrofit.create(tClass);
    }

}
