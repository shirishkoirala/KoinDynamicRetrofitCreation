package np.com.shirishkoirala.koindynamicretrofitcreation.di

import np.com.shirishkoirala.koindynamicretrofitcreation.repositories.MainRepository
import np.com.shirishkoirala.koindynamicretrofitcreation.ui.CatsViewModel
import np.com.shirishkoirala.koindynamicretrofitcreation.ui.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MainViewModel(get())
    }

    single { MainRepository(get()) }
}