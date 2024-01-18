package np.com.shirishkoirala.koindynamicretrofitcreation.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import com.bumptech.glide.Glide
import np.com.shirishkoirala.koindynamicretrofitcreation.databinding.ActivityMainBinding
import np.com.shirishkoirala.koindynamicretrofitcreation.repositories.CatsRepository
import np.com.shirishkoirala.koindynamicretrofitcreation.services.CatsAPI
import np.com.shirishkoirala.koindynamicretrofitcreation.util.Constants
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getRandomDogImage()
        viewModel.isLoading.observe(this) {
            if (it) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }
        }
        viewModel.imageUrl.observe(this) {
            Glide.with(baseContext).load(it).into(binding.imageView)
        }

        binding.loadCatImageButton.setOnClickListener {
            loadKoinModules(module {
                single<Retrofit>(named("cat_retrofit")) {
                    Retrofit.Builder().baseUrl(
                        Constants.catsBaseUrl
                    ).addConverterFactory(GsonConverterFactory.create(get())).build()
                }

                single<CatsAPI> { get<Retrofit>(named("cat_retrofit")).create(CatsAPI::class.java) }

                single<CatsRepository> {
                    CatsRepository(get())
                }
            }).run {
                startActivity(Intent(this@MainActivity, CatsActivity::class.java))
            }

        }

        binding.loadDogImageButton.setOnClickListener {
            viewModel.getRandomDogImage()
        }
    }
}