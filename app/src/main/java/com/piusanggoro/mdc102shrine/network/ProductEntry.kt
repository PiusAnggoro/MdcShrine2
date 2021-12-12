package com.piusanggoro.mdc102shrine.network

import android.content.res.Resources
import com.piusanggoro.mdc102shrine.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.util.*

class ProductEntry(val title: String,val url: String, val price: String) {

    companion object {
        fun initProductEntryList(resources: Resources): List<ProductEntry> {
            val inputStream = resources.openRawResource(R.raw.products)
            val jsonProductsString = inputStream.bufferedReader().use(BufferedReader::readText)
            val gson = Gson()
            val productListType = object : TypeToken<ArrayList<ProductEntry>>() {}.type
            return gson.fromJson(jsonProductsString, productListType)
        }
    }
}