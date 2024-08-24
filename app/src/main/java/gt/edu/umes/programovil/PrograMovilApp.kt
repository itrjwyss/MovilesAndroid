package gt.edu.umes.programovil

import android.app.Application
import gt.edu.umes.programovil.di.dataModule
import gt.edu.umes.programovil.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PrograMovilApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@PrograMovilApp)
            modules(
                dataModule,
                presentationModule
            )
        }
    }
}
