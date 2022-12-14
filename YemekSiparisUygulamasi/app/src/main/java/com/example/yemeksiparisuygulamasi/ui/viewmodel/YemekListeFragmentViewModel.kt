package com.example.yemeksiparisuygulamasi.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yemeksiparisuygulamasi.data.entity.Yemekler
import com.example.yemeksiparisuygulamasi.data.repo.YemeklerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class YemekListeFragmentViewModel @Inject constructor (var yrepo: YemeklerDaoRepository) : ViewModel() {
    var yemeklerListesi = MutableLiveData<List<Yemekler>>()

    init {
        yemekleriYukle()
        yemeklerListesi = yrepo.yemekleriGetir()
    }

    fun yemekleriYukle(){
        yrepo.tumYemekleriAl()
    }
}