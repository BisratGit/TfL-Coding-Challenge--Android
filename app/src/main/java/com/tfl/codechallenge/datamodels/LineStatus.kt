package com.tfl.codechallenge.datamodels


import com.google.gson.annotations.SerializedName

data class LineStatus(
    @SerializedName("created") val created: String?,
    @SerializedName("id") val id: Int?,
    @SerializedName("statusSeverity") val statusSeverity: Int?,
    @SerializedName("statusSeverityDescription") val statusSeverityDescription: String?,
    @SerializedName("\$type") val type: String?,
    @SerializedName("validityPeriods") val validityPeriods: List<Any?>?
)