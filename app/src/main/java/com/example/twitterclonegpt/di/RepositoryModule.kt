package com.example.twitterclonegpt.di

import com.example.twitterclonegpt.data.ChatRepository
import com.example.twitterclonegpt.data.ChatRepositoryContract
import com.example.twitterclonegpt.data.TrendingPostsRepository
import com.example.twitterclonegpt.data.TrendingPostsRepositoryContract
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideTrendingPostsRepository(repository: TrendingPostsRepository): TrendingPostsRepositoryContract = repository

    @Provides
    @Singleton
    fun provideChatRepository(repository: ChatRepository): ChatRepositoryContract = repository


    // TODO: Uncomment when you need to make calls for random images
//    @Provides
//    @Singleton
//    fun provideHttpClient(): OkHttpClient =
//        OkHttpClient.Builder()
//            .addInterceptor(
//                HttpLoggingInterceptor()
//                    .setLevel(HttpLoggingInterceptor.Level.BODY)
//            )
//            .build()
//
//    @Provides
//    @Singleton
//    fun provideRetrofit(httpClient: OkHttpClient): Retrofit =
//        Retrofit.Builder().baseUrl(BASE_URL)
//            .client(httpClient)
//            .addConverterFactory(
//                GsonConverterFactory.create()
//            )
//            .build()
//
//    @Provides
//    @Singleton
//    fun provideApi(retrofit: Retrofit): MoviesAPI = retrofit.create(MoviesAPI::class.java)
}