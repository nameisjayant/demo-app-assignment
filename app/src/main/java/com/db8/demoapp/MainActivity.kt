package com.db8.demoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.db8.demoapp.data.adapter.HomeAdapter
import com.db8.demoapp.data.model.Home
import com.db8.demoapp.data.ui.HomeViewModel
import com.db8.demoapp.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var homeAdapter: HomeAdapter
    private val viewmodel: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        lifecycleScope.launchWhenStarted {
            viewmodel.result.collect {
                homeAdapter.submitList(it.workDetails.availableProducts)
                Log.d("main", "${it.workDetails.availableProducts[0].price}")
                binding.progressBar.visibility = View.GONE
                binding.recyclerView.visibility = View.VISIBLE
            }
        }

    }

    private fun initRecyclerView() {
        homeAdapter = HomeAdapter(this)
        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = homeAdapter
        }
    }
}