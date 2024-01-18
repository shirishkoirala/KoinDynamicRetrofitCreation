package np.com.shirishkoirala.koindynamicretrofitcreation

import android.app.Application
import np.com.shirishkoirala.koindynamicretrofitcreation.di.appModule
import np.com.shirishkoirala.koindynamicretrofitcreation.di.viewModelModule
import org.koin.core.context.GlobalContext.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(appModule + viewModelModule)
        }
    }
}