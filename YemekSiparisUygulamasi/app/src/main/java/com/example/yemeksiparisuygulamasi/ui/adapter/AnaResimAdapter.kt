package com.example.yemeksiparisuygulamasi.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.yemeksiparisuygulamasi.R
import com.example.yemeksiparisuygulamasi.data.entity.AnaResimler
import com.example.yemeksiparisuygulamasi.databinding.AnaResimCardTasarimBinding
import com.example.yemeksiparisuygulamasi.util.gecisYap

class AnaResimAdapter (var mContext: Context, var anaResimListesi:List<AnaResimler>)
    : RecyclerView.Adapter<AnaResimAdapter.AnaResimCardTasarimTutucu>() {

    inner class AnaResimCardTasarimTutucu(tasarim:AnaResimCardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root){
        var tasarim:AnaResimCardTasarimBinding
        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnaResimCardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim : AnaResimCardTasarimBinding = DataBindingUtil.inflate(layoutInflater,R.layout.ana_resim_card_tasarim,parent,false)
        return AnaResimCardTasarimTutucu(tasarim)
    }
    override fun onBindViewHolder(holder: AnaResimCardTasarimTutucu, position: Int) {
        val anaResim = anaResimListesi.get(position)
        val t = holder.tasarim
        t.imageViewAnaResim.setImageResource(mContext.resources.getIdentifier(anaResim.resimAdi,"drawable",mContext.packageName))
        t.anaResimCardView.setOnClickListener {
            Navigation.gecisYap(it,R.id.yemekListeGecis)
        }
    }
    override fun getItemCount(): Int {
        return anaResimListesi.size
    }
}