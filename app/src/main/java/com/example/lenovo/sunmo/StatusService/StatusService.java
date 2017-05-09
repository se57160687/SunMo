package com.example.lenovo.sunmo.StatusService;

import  com.example.lenovo.sunmo.StatusService.StatusDAO.SendQuick;
import  com.example.lenovo.sunmo.StatusService.StatusDAO.StatusDAO;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by ADMIN on 20/4/2560.
 */

public interface StatusService {
    @POST("phpmyadmin/sql.php?server=1&db=tsp_accdb&table=ac_bankaccount&pos=0&token=10c40ac292be2b1cdee4d44508e33e8e")
    Call<StatusDAO> getAdminData();

    @FormUrlEncoded
    @POST("phpmyadmin/sql.php?server=1&db=tsp_accdb&table=ac_bankaccount&pos=0&token=10c40ac292be2b1cdee4d44508e33e8e")
    Call<SendQuick> sendData(@Field("rq_id") String id, @Field("rq_subject") String name);
}
