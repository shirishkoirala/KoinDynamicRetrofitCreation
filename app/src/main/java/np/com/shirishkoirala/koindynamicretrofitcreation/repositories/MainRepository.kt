package np.com.shirishkoirala.koindynamicretrofitcreation.repositories

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import np.com.shirishkoirala.koindynamicretrofitcreation.services.DogsAPI

class MainRepository(private val dogsAPI: DogsAPI) {
    fun getRandomDogImage(): Flow<String> = flow {
        emit(dogsAPI.getRandomImage().message)
    }
}