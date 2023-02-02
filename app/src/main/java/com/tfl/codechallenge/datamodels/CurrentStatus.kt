package com.tfl.codechallenge.datamodels


import com.google.gson.annotations.SerializedName

data class CurrentStatus(
    @SerializedName("created") val created: String?,
    @SerializedName("crowding") val crowding: Crowding?,
    @SerializedName("disruptions") val disruptions: List<Any?>?,
    @SerializedName("id") val id: String?,
    @SerializedName("lineStatuses") val lineStatuses: List<LineStatus?>?,
    @SerializedName("modeName") val modeName: String?,
    @SerializedName("modified") val modified: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("routeSections") val routeSections: List<Any?>?,
    @SerializedName("serviceTypes") val serviceTypes: List<ServiceType?>?,
    @SerializedName("\$type") val type: String?
)