package com.android.photogallery

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import com.android.photogallery.databinding.FragmentPhotoGalleryBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

private const val TAG = "PhotoGalleryFragment"

class PhotoGalleryFragment : Fragment() {
    private var _binding : FragmentPhotoGalleryBinding?= null
    private val binding
        get()= checkNotNull(_binding){
            "Cannot Access binding it is null. Please check if the view is visible"
        }

    private val photoGalleryViewModel : PhotoGalleryViewmodel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        _binding= FragmentPhotoGalleryBinding.inflate(inflater,container,false)
        binding.photoGrid.layoutManager=GridLayoutManager(context,3)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewLifecycleOwner.lifecycleScope.launch{
          viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.RESUMED){
              photoGalleryViewModel.galleryItems.collect{items ->
                  binding.photoGrid.adapter=PhotoListAdapter(items)
              }
          }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}