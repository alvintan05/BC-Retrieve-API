package tan.com.alvin.basecode_crud_api.presenter

import com.google.gson.Gson
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg
import tan.com.alvin.basecode_crud_api.api.ApiRepository
import tan.com.alvin.basecode_crud_api.api.NewsAPI
import tan.com.alvin.basecode_crud_api.model.NewsModelResponse
import tan.com.alvin.basecode_crud_api.util.CoroutineContextProvider
import tan.com.alvin.basecode_crud_api.view.NewsView

/**
 * Created by Alvin Tandiardi on 06/12/2018.
 */
class NewsPresenter(private val view: NewsView,
                    private val apiRepository: ApiRepository,
                    private val gson: Gson,
                    private val context: CoroutineContextProvider = CoroutineContextProvider()) {

    fun getNewsList() {
        async(context.main) {
            val data = bg {
                gson.fromJson(apiRepository.doRequest(NewsAPI.getTopHeadline()), NewsModelResponse::class.java)
            }
            view.showNewsList(data.await().articles)
            view.hideLoading()
        }
    }

}