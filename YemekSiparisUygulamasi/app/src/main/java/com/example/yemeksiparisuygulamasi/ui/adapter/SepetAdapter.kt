package com.example.yemeksiparisuygulamasi.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.yemeksiparisuygulamasi.R
import com.example.yemeksiparisuygulamasi.data.entity.Sepet
import com.example.yemeksiparisuygulamasi.databinding.SepetYemekCardTasarimBinding
import com.example.yemeksiparisuygulamasi.ui.viewmodel.SepetFragmentViewModel
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso

class SepetAdapter (var mContext:Context,
                    var sepetListesi:List<Sepet>,
                    var viewModel:SepetFragmentViewModel):RecyclerView.Adapter<SepetAdapter.SepetYemekCardTasarimTutucu>(){

    inner class SepetYemekCardTasarimTutucu(tasarim:SepetYemekCardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root){
        var tasarim:SepetYemekCardTasarimBinding
        init {
            this.tasarim = tasarim
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SepetYemekCardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim : SepetYemekCardTasarimBinding = DataBindingUtil.inflate(layoutInflater, R.layout.sepet_yemek_card_tasarim, parent, false)
        return SepetYemekCardTasarimTutucu(tasarim)

    }

    override fun onBindViewHolder(holder: SepetYemekCardTasarimTutucu, position: Int) {
        val sepet = sepetListesi.get(position)
        val t = holder.tasarim
        t.textViewSepetYemekAd.text = "${sepet.yemek_adi}"
        t.textViewSepetFiyat.text = "${sepet.yemek_fiyat * sepet.yemek_siparis_adet} ₺"
        t.textViewSepetAdet.text = "${sepet.yemek_siparis_adet}"

        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${sepet.yemek_resim_adi}"
        Picasso.get().load(url).into(t.imageViewSepetYemek)

        t.imageViewSilButton.setOnClickListener {
            Snackbar.make(it,"${sepet.yemek_adi} sepetten çıkarılsın mı?", Snackbar.LENGTH_LONG)
                .setAction("EVET"){
                    viewModel.sil(sepet.sepet_yemek_id,sepet.kullanici_adi)
                }.show()
        }

        t.buttonSepetAzalt.setOnClickListener {
            if(sepet.yemek_siparis_adet>1){
                sepet.yemek_siparis_adet--
                t.textViewSepetAdet.text = "${sepet.yemek_siparis_adet}"
                t.textViewSepetFiyat.text = "${sepet.yemek_siparis_adet * sepet.yemek_fiyat} ₺"
            }
        }

        t.buttonSepetArttir.setOnClickListener {
            sepet.yemek_siparis_adet++
            t.textViewSepetAdet.text = "${sepet.yemek_siparis_adet}"
            t.textViewSepetFiyat.text = "${sepet.yemek_siparis_adet * sepet.yemek_fiyat} ₺"
        }

    }

    override fun getItemCount(): Int {
        return sepetListesi.size
    }
}