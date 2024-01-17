package pe.graphica.appdemo.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import pe.graphica.appdemo.domain.model.PokemonItem

@Entity(tableName = "pokemon_table")
data class PokemonEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id : Int = 0,
    @ColumnInfo(name = "name") val name : String,
    @ColumnInfo(name = "url") val url : String,
)

fun PokemonItem.toDatabase() = PokemonEntity(name = name, url =  url)