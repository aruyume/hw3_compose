package com.example.hw3_compose.data.serviceLocator

import androidx.room.Room
import com.example.hw3_compose.BuildConfig
import com.example.hw3_compose.data.api.CharacterApiService
import com.example.hw3_compose.data.api.EpisodeApiService
import com.example.hw3_compose.data.api.LocationApiService
import com.example.hw3_compose.data.db.AppDatabase
import com.example.hw3_compose.data.repository.CharactersRepository
import com.example.hw3_compose.data.repository.EpisodesRepository
import com.example.hw3_compose.data.repository.FavoriteCharactersRepository
import com.example.hw3_compose.data.repository.LocationsRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    //retrofit
    single { provideOkHttpClient() }
    single { provideRetrofit(get()) }

    //room
    single { Room.databaseBuilder(get(), AppDatabase::class.java, "app_database").build() }
    single { get<AppDatabase>().favoriteCharacterDao() }

    //api
    single { get<Retrofit>().create(CharacterApiService::class.java) }
    single { get<Retrofit>().create(LocationApiService::class.java) }
    single { get<Retrofit>().create(EpisodeApiService::class.java) }

    //repo
    single { CharactersRepository(get()) }
    single { LocationsRepository(get()) }
    single { EpisodesRepository(get()) }
    single { FavoriteCharactersRepository(get()) }
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