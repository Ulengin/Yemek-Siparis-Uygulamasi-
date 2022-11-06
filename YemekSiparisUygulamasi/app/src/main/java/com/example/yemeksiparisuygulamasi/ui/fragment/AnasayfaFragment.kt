package com.example.yemeksiparisuygulamasi.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.yemeksiparisuygulamasi.R
import com.example.yemeksiparisuygulamasi.data.entity.AnaResimler
import com.example.yemeksiparisuygulamasi.databinding.FragmentAnasayfaBinding
import com.example.yemeksiparisuygulamasi.ui.adapter.AnaResimAdapter
import com.example.yemeksiparisuygulamasi.util.gecisYap


class AnasayfaFragment : Fragment() {
    private lateinit var tasarim : FragmentAnasayfaBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = FragmentAnasayfaBinding.inflate(inflater, container, false)

        tasarim.recyclerView.layoutManager = StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL)

        val AnaResimListe = ArrayList<AnaResimler>()
        val r1 = AnaResimler(1,"cv1")
        val r2 = AnaResimler(2,"cv2")
        AnaResimListe.add(r1)
        AnaResimListe.add(r2)

        val adapter = AnaResimAdapter(requireContext(),AnaResimListe)
        tasarim.recyclerView.adapter = adapter

        return tasarim.root
    }
}