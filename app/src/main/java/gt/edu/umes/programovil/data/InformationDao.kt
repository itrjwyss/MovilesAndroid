package gt.edu.umes.programovil.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import gt.edu.umes.programovil.data.DatabaseConstants.SQL_SELECT_ALL
import kotlinx.coroutines.flow.Flow

@Dao
interface InformationDao {

    @Query("$SQL_SELECT_ALL $INFORMATION_TABLE_NAME")
    fun findAll(): List<InformationEntity>

    @Insert
    suspend fun insert(informationEntity: InformationEntity): Long?
}
