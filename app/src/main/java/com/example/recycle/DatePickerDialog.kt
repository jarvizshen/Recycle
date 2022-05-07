package com.example.recycle

import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.recycle.databinding.DialogDatePickerBinding

/**
 * A simple [Fragment] subclass.
 * Use the [DatePickerDialog.newInstance] factory method to
 * create an instance of this fragment.
 */
class DatePickerDialog : Fragment() {
    var binding: DialogDatePickerBinding? = null
    var date: String? = null
    private var mParam1: String? = null
    private var mParam2: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        //   binding=DialogDatePickerBinding.inflate(infla)
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments!!.getString(ARG_PARAM1)
            mParam2 = arguments!!.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogDatePickerBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        return binding!!.root
    }

    companion object {
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"
        fun newInstance(param1: String?, param2: String?): DatePickerDialog {
            val fragment = DatePickerDialog()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}