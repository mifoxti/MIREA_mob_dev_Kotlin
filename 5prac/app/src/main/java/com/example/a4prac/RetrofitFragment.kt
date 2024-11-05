package com.example.a4prac

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.a4prac.databinding.FragmentRetrofitBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.ext.android.inject
import retrofit2.Retrofit
import kotlin.random.Random

class RetrofitFragment : Fragment() {
    private lateinit var binding: FragmentRetrofitBinding
    private val postsDao: PostsDAO by inject() // Внедрение PostsDAO
    private val productApi: MainApi by inject() // Внедрение API

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRetrofitBinding.inflate(inflater, container, false)

        binding.toDtbBtn.setOnClickListener {
            findNavController().navigate(R.id.action_retrofitFragment_to_dataBaseFragment)
        }

        binding.showDataBtn.setOnClickListener {
            // Генерируем случайный ID поста от 1 до 100
            val randomPostId = Random.nextInt(1, 101)

            viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
                val posts = productApi.getPostById(randomPostId)
                postsDao.insertPosts(posts)
                withContext(Dispatchers.Main) {
                    binding.showData.text = posts.title
                }
            }
        }

        return binding.root
    }
}
