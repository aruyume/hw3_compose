package com.example.hw3_compose.data.serviceLocator

import com.example.hw3_compose.BuildConfig
import com.example.hw3_compose.data.api.CharacterApiService
import com.example.hw3_compose.data.api.EpisodeApiService
import com.example.hw3_compose.data.api.LocationApiService
import com.example.hw3_compose.data.repository.CharactersRepository
import com.example.hw3_compose.data.repository.EpisodesRepository
import com.example.hw3_compose.data.repository.LocationsRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    single { provideOkHttpClient() }
    single { provideRetrofit(get()) }

    single { get<Retrofit>().create(CharacterApiService::class.java) }
    single { get<Retrofit>().create(LocationApiService::class.java) }
    single { get<Retrofit>().create(EpisodeApiService::class.java) }

    single { CharactersRepository(get()) }
    single { LocationsRepository(get()) }
    single { EpisodesRepository(get()) }
}

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.MINUTES)
        .writeTimeout(1, TimeUnit.MINUTES)
        .readTimeout(1, TimeUnit.MINUTES)
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
}