package np.com.shirishkoirala.koindynamicretrofitcreation.services

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET

interface CatsAPI {
    @GET("cat")
    suspend fun getRandomImage(): Response<ResponseBody>
}