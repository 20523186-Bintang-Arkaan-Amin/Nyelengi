package com.bintang.nylngi.data

import com.google.gson.annotations.SerializedName

data class User(

	@field:SerializedName("code")
	val code: Int,

	@field:SerializedName("message")
	val message: String,

	@field:SerializedName("user")
	val user: List<UserItem>
)