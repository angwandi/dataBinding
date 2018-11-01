

package com.example.android.databinding.basicsample.data

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import android.databinding.ObservableInt
import com.example.android.databinding.basicsample.data.Popularity.NORMAL

/**
 * A VM for [com.example.android.databinding.basicsample.ui.SolutionActivity].
 */
class SimpleViewModelSolution : ViewModel() {
    val name = "Grace"
    val lastName = "Hopper"
    val likes = ObservableInt()
    val popularity = ObservableField<Popularity>(NORMAL)

    /**
     * Increments the number of likes.
     */
    fun onLike() {
        likes.set(likes.get() + 1)

        popularity.set(likes.get().let {
            when {
                it > 9 -> Popularity.STAR
                it > 4 -> Popularity.POPULAR
                else -> Popularity.NORMAL
            }
        })
    }
}
