package com.jsn.newshorizon.di

import android.content.Context
import androidx.room.Room
import com.jsn.newshorizon.data.local.NewsDao
import com.jsn.newshorizon.data.local.NewsDatabase
import com.jsn.newshorizon.data.local.NewsTypeConverter
import com.jsn.newshorizon.data.manager.LocalUserManagerImpl
import com.jsn.newshorizon.data.remote.NewsApi
import com.jsn.newshorizon.data.repository.NewsRepositoryImpl
import com.jsn.newshorizon.domain.manager.LocalUserManager
import com.jsn.newshorizon.domain.repository.NewsRepository
import com.jsn.newshorizon.domain.usercases.app_entry.AppEntryUseCases
import com.jsn.newshorizon.domain.usercases.app_entry.ReadAppEntry
import com.jsn.newshorizon.domain.usercases.app_entry.SaveAppEntry
import com.jsn.newshorizon.domain.usercases.news.DeleteArticle
import com.jsn.newshorizon.domain.usercases.news.GetNews
import com.jsn.newshorizon.domain.usercases.news.NewsUseCases
import com.jsn.newshorizon.domain.usercases.news.SearchNews
import com.jsn.newshorizon.domain.usercases.news.SelectArticle
import com.jsn.newshorizon.domain.usercases.news.SelectArticles
import com.jsn.newshorizon.domain.usercases.news.UpsertArticle
import com.jsn.newshorizon.util.Constants
import com.jsn.newshorizon.util.Constants.NEWS_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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


    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    @Singleton
    fun providesNewsApi(retrofit: Retrofit): NewsApi {
        return retrofit.create(
            NewsApi::class.java
        )
    }

    @Provides
    @Singleton
    fun provideNewsRepository(newsApi: NewsApi, newsDao: NewsDao): NewsRepository = NewsRepositoryImpl(newsApi, newsDao)

    @Provides
    @Singleton
    fun provideNewsUseCases(newsRepository: NewsRepository): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository),
            upsertArticle = UpsertArticle(newsRepository),
            deleteArticle = DeleteArticle(newsRepository),
            selectArticles = SelectArticles(newsRepository),
            selectArticle = SelectArticle(newsRepository)

        )
    }

    @Provides
    @Singleton
    fun providesNewsDatabase(@ApplicationContext context: Context): NewsDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = NewsDatabase::class.java,
            name = NEWS_DATABASE_NAME
        ).addTypeConverter(NewsTypeConverter())
            .fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun providesNewsDao(newsDatabase: NewsDatabase) = newsDatabase.newsDao
}