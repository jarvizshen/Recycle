package com.example.recycle

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.widget.CalendarView.OnDateChangeListener
import android.widget.CalendarView
import com.example.recycle.SetMyTime.DateCallback
import android.view.WindowManager
import com.example.recycle.Crime
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.app.AppCompatActivity
import com.example.recycle.SetMyTime
import com.example.recycle.BlankFragment
import androidx.fragment.app.FragmentResultListener
import com.example.recycle.CrimeAdapter
import androidx.activity.result.ActivityResultLauncher
import android.content.Intent
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.activity.result.ActivityResultCallback
import androidx.fragment.app.DialogFragment
import com.example.recycle.MainActivity2
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.recycle.MainActivity
import com.example.recycle.databinding.DialogDatePickerBinding
import java.lang.ClassCastException
import java.util.*

class SetMyTime : DialogFragment() {
    private var binding: DialogDatePickerBinding? = null
    var date: String? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogDatePickerBinding.inflate(inflater, container, false)
        binding!!.Date.setOnDateChangeListener { calendarView, i, i1, i2 ->
            val calendar = Calendar.getInstance()
            calendar[i, i1] = i2
            date = calendar.time.toString()
        }
        binding!!.btnQueren.setOnClickListener {
            callback!!.getDate(date)
            val bundle = Bundle()
            bundle.putString("Time", date)
            parentFragmentManager.setFragmentResult("key", bundle)
            dismiss()
        }
        binding!!.btnQuxiao.setOnClickListener { dismiss() }
        return binding!!.root
    }

    private var callback: DateCallback? = null

    interface DateCallback {
        fun getDate(date: String?)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is DateCallback) {
            callback = context
        } else {
            throw ClassCastException(context.toString() + "未实现")
        }
    }

    override fun onStart() {
        val attributes = requireDialog().window!!.attributes
        attributes.width = ViewGroup.LayoutParams.MATCH_PARENT
        requireDialog().window!!.attributes = attributes
        super.onStart()
    }
}