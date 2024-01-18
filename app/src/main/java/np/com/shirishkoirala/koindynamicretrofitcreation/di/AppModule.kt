package np.com.shirishkoirala.koindynamicretrofitcreation.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import np.com.shirishkoirala.koindynamicretrofitcreation.services.DogsAPI
import np.com.shirishkoirala.koindynamicretrofitcreation.util.Constants
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single<Gson> { GsonBuilder().create() }

    single<Retrofit> {
        Retrofit.Builder().baseUrl(
            Constants.dogsBaseUrl
        ).addConverterFactory(GsonConverterFactory.create(get())).build()
    }

    single<DogsAPI> { get<Retrofit>().create(DogsAPI::class.java) }
}