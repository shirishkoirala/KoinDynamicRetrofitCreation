package np.com.shirishkoirala.koindynamicretrofitcreation.repositories

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import np.com.shirishkoirala.koindynamicretrofitcreation.services.CatsAPI


class CatsRepository(private val catsAPI: CatsAPI) {
    fun getRandomCatImage(): Flow<Bitmap> = flow {
        val response = catsAPI.getRandomImage()
        val bmp = BitmapFactory.decodeStream(response.body()?.byteStream())
        emit(bmp)
        Log.e("Cat Response", "getRandomCatImage: ${response.code()}")
    }
}