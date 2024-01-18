package pe.graphica.appdemo.core.ex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import pe.graphica.appdemo.ui.adapter.OneAdapter

fun <ITEM : Any, VB : ViewBinding> RecyclerView.compose(
    layout: (LayoutInflater, ViewGroup?, Boolean) -> VB,
    onBind: VB.(ITEM, Int) -> Unit,
    itemClick: ITEM.(View) -> Unit = {}
): OneAdapter<ITEM, VB> {
    return OneAdapter(layout, onBind, itemClick).also { adapter = it }
}