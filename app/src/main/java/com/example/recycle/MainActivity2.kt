package com.example.recycle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.recycle.databinding.ActivityMain2Binding
import com.example.recycle.databinding.ToolbarLayoutBinding
import java.util.*

class MainActivity2 : AppCompatActivity() {
    var binding: ActivityMain2Binding? = null
    private var toolBarBing: ToolbarLayoutBinding? = null
    private var crimes: ArrayList<Crime>? = null
    var currentIndex = 0
    private var adapter: CrimeAdapter? = null
    private var currentCrime: Crime? = null
    var date: String? = null
    private val launcher = registerForActivityResult(
        StartActivityForResult()
    ) {
        // changeDate(result);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding!!.root)
        toolBarBing = ToolbarLayoutBinding.bind(binding!!.root)
        setSupportActionBar(toolBarBing!!.toolbar)
        calendar = Calendar.getInstance()
        calendar!!.set(2000, 1, 1)
        date = calendar!!.time.toString()
        initDate()
        binding!!.recyclerview.layoutManager = LinearLayoutManager(this)
        binding!!.recyclerview.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        adapter = CrimeAdapter(crimes)
        adapter!!.setOnClickListener { view ->
            val viewHolder = view.tag as CrimeAdapter.ViewHolder
            currentIndex = viewHolder.adapterPosition
            adapter!!.setCurrentIndex(currentIndex)
            currentCrime = crimes!![currentIndex]
            val intent = Intent(this@MainActivity2, MainActivity::class.java)
            val bundle = Bundle()
            bundle.putSerializable("Crime", currentCrime)
            intent.putExtras(bundle)
            launcher.launch(intent)
        }
        binding!!.recyclerview.adapter = adapter
    }

    private fun initDate() {
        crimes = ArrayList()
        for (i in 0..4) {
            val crime = Crime("Crime$i", true, "Crime$i", date)
            crimes!!.add(crime)
        }
        for (i in 0..3) {
            val crime = Crime("Crime$i", false, "Crime$i", date)
            crimes!!.add(crime)
        }
    }

    companion object {
        var calendar: Calendar? = null
    }
}