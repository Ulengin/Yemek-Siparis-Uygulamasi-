package com.example.yemeksiparisuygulamasi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.yemeksiparisuygulamasi.R
import com.example.yemeksiparisuygulamasi.databinding.FragmentOdemeBinding
import com.example.yemeksiparisuygulamasi.util.gecisYap


class OdemeFragment : Fragment() {
    private lateinit var tasarim : FragmentOdemeBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim  = DataBindingUtil.inflate(inflater,R.layout.fragment_odeme, container, false)

        tasarim.imageButtonGeri.setOnClickListener {
            activity?.onBackPressed()
        }

        tasarim.buttonOnayla.setOnClickListener {
            Navigation.gecisYap(it,R.id.odemeBasiriliGecis)
        }

        return tasarim.root
    }

}