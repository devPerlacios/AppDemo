package pe.graphica.appdemo.ui.pokemon

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import pe.graphica.appdemo.core.ex.compose
import pe.graphica.appdemo.databinding.FragmentPokemonBinding
import pe.graphica.appdemo.databinding.ItemPokemonBinding
import pe.graphica.appdemo.di.GlideApp
import pe.graphica.appdemo.domain.model.PokemonItem
import pe.graphica.appdemo.ui.adapter.OneAdapter

@AndroidEntryPoint
class PokemonFragment : Fragment() {

    private val pokemonViewModel by viewModels<PokemonViewModel>()
    private lateinit var storageAdapter: OneAdapter<PokemonItem, ItemPokemonBinding>

    private var _binding: FragmentPokemonBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initList()
        initUIState()
    }

    private fun initList() {
        storageAdapter = binding.rvPokemon.compose(
            ItemPokemonBinding::inflate,
            onBind = { item: PokemonItem, _ ->
                tvName.text = item.name
                GlideApp.with(requireContext()).load(item.url).diskCacheStrategy(DiskCacheStrategy.ALL).into(ivUrl)
            },
        )

        binding.rvPokemon.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = storageAdapter
        }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                pokemonViewModel.uiState.collect {
                    storageAdapter.submitList(it.list)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}