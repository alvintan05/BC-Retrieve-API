package tan.com.alvin.basecode_crud_api

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.support.v4.onRefresh
import tan.com.alvin.basecode_crud_api.R.color.colorAccent
import tan.com.alvin.basecode_crud_api.adapter.RecyclerNewsAdapter
import tan.com.alvin.basecode_crud_api.api.ApiRepository
import tan.com.alvin.basecode_crud_api.model.NewsModel
import tan.com.alvin.basecode_crud_api.presenter.NewsPresenter
import tan.com.alvin.basecode_crud_api.util.invisible
import tan.com.alvin.basecode_crud_api.view.NewsView

class MainActivity : AppCompatActivity(), NewsView {

    private var newsList: MutableList<NewsModel> = mutableListOf()
    private var gson: Gson = Gson()
    private var request: ApiRepository = ApiRepository()

    private lateinit var presenter: NewsPresenter
    private lateinit var adapter: RecyclerNewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        swipe_refresh.setColorSchemeResources(colorAccent,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light)

        home_recycler_view.layoutManager = LinearLayoutManager(this)
        adapter = RecyclerNewsAdapter(newsList) {

        }
        home_recycler_view.adapter = adapter

        presenter = NewsPresenter(this, request, gson)
        presenter.getNewsList()

        swipe_refresh.onRefresh {
            presenter.getNewsList()
        }

    }

    override fun hideLoading() {
        progress_bar.invisible()
    }

    override fun showNewsList(data: List<NewsModel>) {
        swipe_refresh.isRefreshing = false
        newsList.clear()
        newsList.addAll(data)
        adapter.notifyDataSetChanged()
    }

}
