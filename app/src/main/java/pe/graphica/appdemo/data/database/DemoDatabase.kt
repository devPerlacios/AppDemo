package pe.graphica.appdemo.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import pe.graphica.appdemo.data.database.dao.PokemonDao
import pe.graphica.appdemo.data.database.entities.PokemonEntity

@Database(entities = [PokemonEntity::class], version = 1)
abstract class DemoDatabase: RoomDatabase() {
    abstract fun getPokemonDao() : PokemonDao
}