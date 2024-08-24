package gt.edu.umes.programovil.presentation.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import gt.edu.umes.programovil.domain.InformationRepository

class ListViewModel(
    application: Application,
    informationRepository: InformationRepository
): AndroidViewModel(application) {

    val all = informationRepository.all
}
