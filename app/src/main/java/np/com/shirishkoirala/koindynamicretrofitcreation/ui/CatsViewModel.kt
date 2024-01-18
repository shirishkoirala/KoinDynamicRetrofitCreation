package np.com.shirishkoirala.koindynamicretrofitcreation.ui

import android.graphics.Bitmap
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import np.com.shirishkoirala.koindynamicretrofitcreation.repositories.CatsRepository

class CatsViewModel(private val catsRepository: CatsRepository) : ViewModel() {
    val isLoading = MutableLiveData<Boolean>()
    val imageUrl = MutableLiveData<Bitmap>()

    fun getRandomCatImage() {
        isLoading.postValue(true)
        viewModelScope.launch {
            catsRepository.getRandomCatImage().collect {
                isLoading.postValue(false)
                imageUrl.postValue(it)
            }
        }
    }
}