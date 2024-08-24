package gt.edu.umes.programovil.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    version = 1,
    exportSchema = false,
    entities = [InformationEntity::class]
)
abstract class AppRoomDatabase: RoomDatabase() {

    abstract fun informationDao(): InformationDao

    companion object {
        fun getDatabase(context: Context) = Room.databaseBuilder(
            context = context,
            klass = AppRoomDatabase::class.java,
            name = "program_movil_database"
        ).build()
    }
}
