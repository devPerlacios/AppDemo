package pe.graphica.appdemo.ui.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import pe.graphica.appdemo.domain.model.PokemonItem

internal class DiffUtilCallback<ITEM> : DiffUtil.ItemCallback<ITEM>() {

    override fun areItemsTheSame(oldItem: ITEM & Any, newItem: ITEM & Any): Boolean {
        return when {
            oldItem is PokemonItem && newItem is PokemonItem -> oldItem.name == newItem.name
            else -> oldItem === newItem
        }
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: ITEM & Any, newItem: ITEM & Any): Boolean {
        return when {
            oldItem is PokemonItem && newItem is PokemonItem -> oldItem == newItem
            else -> oldItem.hashCode() == newItem.hashCode()
        }
    }
}
