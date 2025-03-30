package com.example.data.di

import android.content.Context
import com.example.data.WhiteLabelConfigUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Singleton
    @Provides
    fun provideWhiteLabelConfigData(@ApplicationContext context: Context,
                                    @IoDispatcher dispatcher: CoroutineDispatcher
    ) =
        WhiteLabelConfigUtil(context, dispatcher)
}