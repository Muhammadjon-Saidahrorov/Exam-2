package uz.gita.examfinal2.presentation.ui.homescreen.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.examfinal2.R
import uz.gita.examfinal2.data.model.TextData
import uz.gita.examfinal2.databinding.ScreenForgotBinding
import uz.gita.examfinal2.databinding.ScreenHomeBinding
import uz.gita.examfinal2.presentation.adapter.TextAdapter
import uz.gita.examfinal2.presentation.viewmodel.ForgotViewModel
import uz.gita.examfinal2.presentation.viewmodel.HomeViewModel
import uz.gita.examfinal2.presentation.viewmodel.impl.ForgotViewModelImpl
import uz.gita.examfinal2.presentation.viewmodel.impl.HomeViewModelImpl

@AndroidEntryPoint
class HomeScreen : Fragment(R.layout.screen_home) {
    private val binding by viewBinding(ScreenHomeBinding::bind)
    private val viewModel: HomeViewModel by viewModels<HomeViewModelImpl>()
    private val adapter = TextAdapter()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            imageSlider.setImageList(listImage)

            recycler.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            recycler.adapter = adapter

            adapter.submitList(listString)

        }

        viewModel.fullName.observe(viewLifecycleOwner, fullNameObserver)
    }

    private val fullNameObserver = Observer<String> {
        binding.txtName.text = it
    }

    private val listImage = arrayListOf(
        SlideModel(R.drawable.img_d1, ScaleTypes.FIT),
        SlideModel(R.drawable.img_d2, ScaleTypes.FIT),
        SlideModel(R.drawable.img_d3, ScaleTypes.FIT)
    )

    private val listString = arrayListOf(
        TextData("All", true),
        TextData("General", false),
        TextData("Dentist", false),
        TextData("Nutritionist", false)
    )


}