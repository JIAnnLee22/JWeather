package com.jiannlee22.jweather.di

import android.content.Context
import com.jiannlee22.jweather.utils.ToastUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ToastModule {

    @Provides
    fun provideToastUtil(@ApplicationContext context: Context): ToastUtil {
        return ToastUtil(context)
    }

}