package com.example.myapplication.di

import com.example.myapplication.BuildConfig
import com.example.myapplication.data.myscreen.remote.MyScreenApi
import com.example.myapplication.data.myscreen.remote.model.BodyRowResponse
import com.example.myapplication.data.myscreen.remote.model.CrossSellingResponse
import com.example.myapplication.data.myscreen.remote.model.MessageResponse
import com.example.myapplication.data.myscreen.remote.model.SectionResponse
import com.example.myapplication.data.remote.model.LabelResponse
import com.example.myapplication.data.remote.model.TextFieldResponse
import com.example.myapplication.domain.deviceauth.model.BodyRowTypeModel
import com.example.myapplication.domain.deviceauth.model.KeyboardType
import com.example.myapplication.domain.myscreen.model.BodyRowType
import com.example.myapplication.domain.myscreen.model.ScreenType
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.EnumJsonAdapter
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

import com.example.myapplication.data.remote.model.BodyRowResponse as BodyRowResponse2

@Module
@InstallIn(SingletonComponent::class)
object MyApplicationNetworkModule {

    @Singleton
    @Provides
    fun providesMoshi(): Moshi = Moshi.Builder()
        .add(
            ScreenType::class.java, EnumJsonAdapter.create(ScreenType::class.java)
                .withUnknownFallback(ScreenType.PROCESSING)
        )
        .add(
            BodyRowType::class.java, EnumJsonAdapter.create(BodyRowType::class.java)
                .withUnknownFallback(null)
        )
        .add(
            KeyboardType::class.java, EnumJsonAdapter.create(KeyboardType::class.java)
                .withUnknownFallback(KeyboardType.TEXT)
        )
        .add(
            PolymorphicJsonAdapterFactory.of(BodyRowResponse::class.java, "type")
                .withSubtype(CrossSellingResponse::class.java, BodyRowType.CROSS_SELLING.name)
                .withSubtype(MessageResponse::class.java, BodyRowType.MESSAGE.name)
                .withSubtype(SectionResponse::class.java, BodyRowType.SECTION.name)
        )
        .add(
            BodyRowTypeModel::class.java, EnumJsonAdapter.create(BodyRowTypeModel::class.java)
                .withUnknownFallback(null)
        )
        .add(
            PolymorphicJsonAdapterFactory.of(BodyRowResponse2::class.java, "type")
                .withSubtype(LabelResponse::class.java, BodyRowTypeModel.LABEL.name)
                .withSubtype(TextFieldResponse::class.java, BodyRowTypeModel.TEXT_FIELD.name)
        )
        .add(KotlinJsonAdapterFactory())
        .build()

    @Singleton
    @Provides
    internal fun providesLoggingInterceptor(): HttpLoggingInterceptor? = when {
        BuildConfig.DEBUG -> {
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        }

        else -> null
    }

    @Singleton
    @Provides
    internal fun providesOkHttpClientBuilder(
        loggingInterceptor: HttpLoggingInterceptor?
    ): OkHttpClient.Builder = OkHttpClient.Builder().apply {
        connectTimeout(15_000L, TimeUnit.MILLISECONDS)
        readTimeout(15_000L, TimeUnit.MILLISECONDS)
        writeTimeout(15_000L, TimeUnit.MILLISECONDS)
        loggingInterceptor?.also { addInterceptor(it) }
    }

    @Singleton
    @Provides
    internal fun providesOkHttpClient(
        builder: OkHttpClient.Builder,
    ): OkHttpClient = with(builder) {
        build()
    }

    @Provides
    @Singleton
    internal fun providesRetrofit(
        moshi: Moshi,
        okHttpClient: OkHttpClient
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl("http://34.123.136.71:8080/")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    @Provides
    internal fun providesMyApplicationApi(retrofit: Retrofit): MyScreenApi =
        retrofit.create(MyScreenApi::class.java)
}
