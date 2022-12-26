package com.bintang.nylngi.data

import com.google.gson.annotations.SerializedName

data class UserItem(

	@field:SerializedName("password")
	val password: String,

	@field:SerializedName("nama")
	val nama: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("email")
	val email: String
)