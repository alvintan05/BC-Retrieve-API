package tan.com.alvin.basecode_crud_api.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Alvin Tandiardi on 06/12/2018.
 */
data class NewsModel(

        @SerializedName("author")
        var newsAuthor: String? = "",

        @SerializedName("title")
        var newsTitle: String? = "",

        @SerializedName("description")
        var newsDesc: String? = "",

        @SerializedName("url")
        var newsSourceUrl: String? = "",

        @SerializedName("urlToImage")
        var newsImageUrl: String? = "",

        @SerializedName("publishedAt")
        var newsPublishDateTime: String? = "",

        @SerializedName("content")
        var newsContent: String? = ""

)