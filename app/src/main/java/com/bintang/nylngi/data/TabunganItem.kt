package com.bintang.nylngi.data

import com.google.gson.annotations.SerializedName

data class TabunganItem(

	@field:SerializedName("jenisTabungan")
	val jenisTabungan: String,

	@field:SerializedName("catatan")
	val catatan: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("tanggal")
	val tanggal: String,

	@field:SerializedName("id_user")
	val idUser: String,

	@field:SerializedName("debit")
	val debit: String,

	@field:SerializedName("kredit")
	val kredit: String
)