package pe.graphica.appdemo.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import pe.graphica.appdemo.data.database.DemoDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    private const val DEMO_DATABASE_NAME = "demo_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, DemoDatabase::class.java, DEMO_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun providePokemonDao(db: DemoDatabase) = db.getPokemonDao()
}