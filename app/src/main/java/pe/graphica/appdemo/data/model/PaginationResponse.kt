package pe.graphica.appdemo.data.model

import com.google.gson.annotations.SerializedName

data class PaginationResponse<T>(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: Any,
    val results: List<T>
)