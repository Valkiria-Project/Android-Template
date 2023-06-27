package com.example.myapplication.ui.deviceauth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.deviceauth.usecases.GetDeviceAuthScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import timber.log.Timber

@HiltViewModel
class DeviceAuthViewModel @Inject constructor(
    private val getDeviceAuthScreen: GetDeviceAuthScreen
) : ViewModel() {

    private var fetchJob: Job? = null

    var uiState by mutableStateOf(DeviceAuthUiState())
        private set

    init {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch(Dispatchers.IO) {
            getDeviceAuthScreen.invoke("asd")
                .onSuccess { deviceAuthScreenModel ->
                    Timber.d("This is a success")
                    withContext(Dispatchers.Main) {
                        uiState = uiState.copy(deviceAuthScreenModel = deviceAuthScreenModel)
                    }
                }
                .onFailure { throwable ->
                    Timber.wtf(throwable, "This is a failure")
                }
        }
    }
}
