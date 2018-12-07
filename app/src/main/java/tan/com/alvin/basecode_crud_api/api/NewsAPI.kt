package tan.com.alvin.basecode_crud_api.api

import tan.com.alvin.basecode_crud_api.BuildConfig

/**
 * Created by Alvin Tandiardi on 06/12/2018.
 */
object NewsAPI {

    fun getTopHeadline(): String {
        return BuildConfig.BASE_URL + "v2/top-headlines?country=id" + "&apikey=${BuildConfig.API_KEY}"
    }

}
