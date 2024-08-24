package gt.edu.umes.programovil.presentation.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import gt.edu.umes.programovil.data.InformationEntity
import gt.edu.umes.programovil.domain.InformationRepository
import kotlinx.coroutines.launch

class ListViewModel(
    application: Application,
    private val informationRepository: InformationRepository
): AndroidViewModel(application) {

    val all = MutableLiveData<List<InformationEntity>>()

    fun loadData() = viewModelScope.launch {
        all.value = informationRepository.findAll()
    }
}
