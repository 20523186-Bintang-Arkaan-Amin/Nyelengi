package com.bintang.nylngi.data

import com.google.gson.annotations.SerializedName
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

class NetworkConfig {
    // set interceptor
    fun getInterceptor() : OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        return  okHttpClient
    }
    fun getRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://10.110.82.13/nyèlèngi/")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    fun getService() = getRetrofit().create(Users::class.java)
    fun getServiceCeleng() = getRetrofit().create(Tabungans::class.java)

}
interface Users {

    @FormUrlEncoded
    @POST("register.php")
    fun Registerasi(
        @Field("email")  userUid: String?,
        @Field("password")  password : String
    ): Call<User>

    @FormUrlEncoded
    @POST("login.php")
    fun Login(
        @Field("email")  userUid: String?,
        @Field("password")  password : String
    ): Call<User>

}

interface Tabungans{

    @FormUrlEncoded
    @POST("addTabungan.php")
    fun addTabungan(
        @Field("debit")  debit: String?,
        @Field("kredit")  kredit: String?,
        @Field("catatan")  catatan : String,
        @Field("tanggal")  tanggal: String?,
        @Field("jenisTabungan")  jenisTabungan: String?,
        @Field("id_user")  id_user : Int
    ): Call<Tabungan>

    @FormUrlEncoded
    @POST("getTabungan.php")
    fun getTabungan(
        @Field("id_user")  id_user: Int?,
        @Field("jenisTabungan")  jenisTabungan: String
    ): Call<Tabungan>

    @FormUrlEncoded
    @POST("totalCelengan.php")
    fun totalTabungan(
        @Field("id_user")  id_user: Int?
    ): Call<Tabungan>


}