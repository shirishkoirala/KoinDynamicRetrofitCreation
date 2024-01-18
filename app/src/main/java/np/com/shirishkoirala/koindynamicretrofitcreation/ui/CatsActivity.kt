package np.com.shirishkoirala.koindynamicretrofitcreation.ui

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import com.bumptech.glide.Glide
import np.com.shirishkoirala.koindynamicretrofitcreation.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CatsActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: CatsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getRandomCatImage()
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
            viewModel.getRandomCatImage()
        }

        binding.loadDogImageButton.setOnClickListener {
            finish()
        }
    }
}