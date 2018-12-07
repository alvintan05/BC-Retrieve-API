package tan.com.alvin.basecode_crud_api.api

import java.net.URL

/**
 * Created by Alvin Tandiardi on 06/12/2018.
 */
class ApiRepository {

    fun doRequest(url: String) : String {
        return URL(url).readText()
    }

}