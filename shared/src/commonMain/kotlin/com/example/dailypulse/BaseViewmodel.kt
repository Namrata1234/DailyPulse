package com.example.dailypulse
import androidx.lifecycle.ViewModel


import kotlinx.coroutines.CoroutineScope

expect open class BaseViewModel() {

    val scope: CoroutineScope
}