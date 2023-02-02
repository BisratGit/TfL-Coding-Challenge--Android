package com.tfl.codechallenge.datamodels


import com.google.gson.annotations.SerializedName

data class ServiceType(
    @SerializedName("name") val name: String?,
    @SerializedName("\$type") val type: String?,
    @SerializedName("uri") val uri: String?
)