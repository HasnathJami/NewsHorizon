package com.jsn.newshorizon.di

import android.content.Context
import com.jsn.newshorizon.data.manager.LocalUserManagerImpl
import com.jsn.newshorizon.domain.manager.LocalUserManager
import com.jsn.newshorizon.domain.usercases.AppEntryUseCases
import com.jsn.newshorizon.domain.usercases.ReadAppEntry
import com.jsn.newshorizon.domain.usercases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideLocalUserManager(@ApplicationContext context: Context): LocalUserManager =
        LocalUserManagerImpl(context)

//    @Provides
//    @Singleton
//    fun provideLocalUserManager(application: NewsApplication): LocalUserManager =
//        LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )
}