package gt.edu.umes.programovil.presentation.insert

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import gt.edu.umes.programovil.data.InformationEntity
import gt.edu.umes.programovil.domain.DomainResult
import gt.edu.umes.programovil.domain.InformationRepository
import kotlinx.coroutines.launch

class InsertFormViewModel(
    application: Application,
    private val informationRepository: InformationRepository
): AndroidViewModel(application) {

    var domainState = MutableLiveData<DomainResult>()

    fun insertInformation(
        description: String,
        path: String
    ) = viewModelScope.launch {
        domainState.value = DomainResult.Loading

        val id = informationRepository.insert(
            InformationEntity(
                description = description,
                path = path
            )
        )

        domainState.value = if (id != null && id > 0) {
            DomainResult.Message(
                message = "Información ingresada con éxito"
            )
        } else {
            DomainResult.Error(
                message = "Ha ocurrido un error al tratar de ingresar al información"
            )
        }
    }
}
