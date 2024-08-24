package gt.edu.umes.programovil.di

import gt.edu.umes.programovil.presentation.insert.InsertFormViewModel
import gt.edu.umes.programovil.presentation.list.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel {
        InsertFormViewModel(
            application = get(),
            informationRepository = get()
        )
    }
    viewModel {
        ListViewModel(
            application = get(),
            informationRepository = get()
        )
    }
}
