package com.bintang.nylngi.data

import com.google.gson.annotations.SerializedName

data class Tabungan(

	@field:SerializedName("tabungan")
	val tabungan: List<TabunganItem>,

	@field:SerializedName("code")
	val code: Int,

	@field:SerializedName("message")
	val message: String
)