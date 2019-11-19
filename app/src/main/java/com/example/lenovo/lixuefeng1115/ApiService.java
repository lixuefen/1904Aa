package com.example.lenovo.lixuefeng1115;

import com.example.lenovo.lixuefeng1115.beans.ZhiHuBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String URL = "http://news-at.zhihu.com/";
    @GET("api/4/news/hot")
    Observable<ZhiHuBean> getZhiHu();
}
