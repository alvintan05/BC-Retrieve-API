package tan.com.alvin.basecode_crud_api.util

import kotlinx.coroutines.experimental.android.UI
import kotlin.coroutines.experimental.CoroutineContext

/**
 * Created by Alvin Tandiardi on 06/12/2018.
 */
open class CoroutineContextProvider {
    open val main: CoroutineContext by lazy { UI }
}