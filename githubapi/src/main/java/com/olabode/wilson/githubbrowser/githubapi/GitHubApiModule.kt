package com.olabode.wilson.githubbrowser.githubapi

import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.Call
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

/**
 *   Created by OLABODE WILSON on 8/24/20.
 */

@Module
object GitHubApiModule {

    @Provides
    @JvmStatic
    @Singleton
    fun provideOkHttp(): Call.Factory {
        return OkHttpClient.Builder().build()
    }

    @Provides
    @JvmStatic
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .build()
    }

    @Provides
    @JvmStatic
    @Singleton
    fun provideRetrofit(
        moshi: Moshi,
        callFactory: Call.Factory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .callFactory(callFactory)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    @JvmStatic
    @Singleton
    fun provideGitHubApi(retrofit: Retrofit): GitHubApi {
        return retrofit.create()
    }
}

