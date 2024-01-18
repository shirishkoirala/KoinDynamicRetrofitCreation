package np.com.shirishkoirala.koindynamicretrofitcreation.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import np.com.shirishkoirala.koindynamicretrofitcreation.repositories.MainRepository

class MainViewModel(
    private val mainRepository: MainRepository
) : ViewModel() {
    val isLoading = MutableLiveData<Boolean>()
    val imageUrl = MutableLiveData<String>()

    fun getRandomDogImage() {
        isLoading.postValue(true)
        viewModelScope.launch {
            mainRepository.getRandomDogImage().collect {
                isLoading.postValue(false)
                imageUrl.postValue(it)
            }
        }
    }
}