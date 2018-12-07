package tan.com.alvin.basecode_crud_api.view

import tan.com.alvin.basecode_crud_api.model.NewsModel

/**
 * Created by Alvin Tandiardi on 06/12/2018.
 */
interface NewsView {
    fun hideLoading()
    fun showNewsList(data: List<NewsModel>)
}