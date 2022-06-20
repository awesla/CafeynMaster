package com.cafeyn.data.injection

import android.content.Context
import androidx.room.Room
import com.cafeyn.data.local.CafeynDataBase
import com.cafeyn.data.local.MyNewsCacheRepositoryImpl
import com.cafeyn.domain.annotation.CafeynDB
import com.cafeyn.domain.local.MyNewsCacheRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RoomDataBaseModule {

    @Provides
    fun provideMyNewsCacheRepository(@CafeynDB relaisColisDataBase: CafeynDataBase): MyNewsCacheRepository {
        return MyNewsCacheRepositoryImpl(relaisColisDataBase)
    }

    @Provides
    @CafeynDB
    fun provideCafeynDataBase(
        @ApplicationContext context: Context
    ): CafeynDataBase {
        return Room.databaseBuilder(
            context,
            CafeynDataBase::class.java, "cafeyn.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}