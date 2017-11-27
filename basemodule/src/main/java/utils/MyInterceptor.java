package utils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 李英杰 on 2017/11/17.
 * Description：
 */

public class MyInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        Request accept = builder
                .addHeader("Content-Type", "application/json;charset=utf-8")
                .addHeader("Accept", "*/*")
                .build();
        return chain.proceed(accept);
    }
}
