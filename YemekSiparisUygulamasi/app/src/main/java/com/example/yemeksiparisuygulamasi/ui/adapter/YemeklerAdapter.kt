package com.example.yemeksiparisuygulamasi.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.yemeksiparisuygulamasi.R
import com.example.yemeksiparisuygulamasi.data.entity.Yemekler
import com.example.yemeksiparisuygulamasi.databinding.YemekListCardTasarimBinding
import com.example.yemeksiparisuygulamasi.ui.fragment.YemekListeFragmentDirections
import com.example.yemeksiparisuygulamasi.ui.viewmodel.YemekListeFragmentViewModel
import com.example.yemeksiparisuygulamasi.util.gecisYap
import com.squareup.picasso.Picasso

class YemeklerAdapter(var mContext: Context,
                      var yemeklerListesi:List<Yemekler>,
                      var viewModel: YemekListeFragmentViewModel
) : RecyclerView.Adapter<YemeklerAdapter.YemekListCardTasarimTutucu>() {

    inner class YemekListCardTasarimTutucu(tasarim:YemekListCardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root){
        var tasarim:YemekListCardTasarimBinding
        init {
            this.tasarim = tasarim
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YemekListCardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim:YemekListCardTasarimBinding = DataBindingUtil.inflate(layoutInflater, R.layout.yemek_list_card_tasarim,parent,false)
        return YemekListCardTasarimTutucu(tasarim)
    }
    override fun onBindViewHolder(holder: YemekListCardTasarimTutucu, position: Int) {
        val yemek = yemeklerListesi.get(position)
        val t = holder.tasarim
        t.textViewYemekAd.text = "${yemek.yemek_adi}"
        t.textViewYemekFiyat.text = "${yemek.yemek_fiyat} ₺"

        t.yemekCard.setOnClickListener {
            val gecis = YemekListeFragmentDirections.yemekDetayGecis(yemek = yemek)
            Navigation.gecisYap(it,gecis)
        }

        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${yemek.yemek_resim_adi}"
        Picasso.get().load(url).into(t.imageViewYemek)
    }

    override fun getItemCount(): Int {
        return yemeklerListesi.size
    }

}