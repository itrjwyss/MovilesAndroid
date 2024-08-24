package gt.edu.umes.programovil.di

import gt.edu.umes.programovil.data.AppRoomDatabase
import gt.edu.umes.programovil.domain.InformationRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    single { AppRoomDatabase.getDatabase(androidContext()) }
    single { InformationRepository(get<AppRoomDatabase>().informationDao()) }
}
