package com.dc.myecom.di

import android.content.Context
import androidx.activity.ComponentActivity
import androidx.room.Room
import com.dc.myecom.data.UserDao
import com.dc.myecom.data.UserDatabse
import com.dc.myecom.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @InstallIn(SingletonComponent::class)
    @Module
    class DatabaseModule {
        @Provides
        fun provideUserDao(userDatabase: UserDatabse): UserDao {
            return userDatabase.userDao()
        }
    }

    @Singleton
    @Provides
    fun provideUserDatabase(
        @ApplicationContext appContext: Context
    ): UserDatabse {
        return Room.databaseBuilder(
                appContext.applicationContext,
                UserDatabse::class.java,
                "user_database"
            ).build()

    }
}