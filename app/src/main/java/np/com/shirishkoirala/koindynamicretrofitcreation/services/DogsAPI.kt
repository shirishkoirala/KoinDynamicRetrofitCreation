package np.com.shirishkoirala.koindynamicretrofitcreation.services

import np.com.shirishkoirala.koindynamicretrofitcreation.dtos.DogsRandomImageDto
import retrofit2.http.GET

interface DogsAPI {
    @GET("breeds/image/random")
    suspend fun getRandomImage(): DogsRandomImageDto
}