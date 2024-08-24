package gt.edu.umes.programovil.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import gt.edu.umes.programovil.data.DatabaseConstants.SQL_COLUMN
import gt.edu.umes.programovil.data.DatabaseConstants.SQL_TABLE

private const val BASE_NAME = "information_"
const val INFORMATION_TABLE_NAME = "${BASE_NAME}${SQL_TABLE}"
const val INFORMATION_COLUMN_NAME_ID = "${SQL_COLUMN}${BASE_NAME}id"
const val INFORMATION_COLUMN_NAME_DESCRIPTION = "${SQL_COLUMN}${BASE_NAME}desc"
const val INFORMATION_COLUMN_NAME_PATH = "${SQL_COLUMN}${BASE_NAME}path"

@Entity(tableName = INFORMATION_TABLE_NAME)
data class InformationEntity(
    @ColumnInfo(name = INFORMATION_COLUMN_NAME_DESCRIPTION)
    val description: String,
    @ColumnInfo(name = INFORMATION_COLUMN_NAME_PATH)
    val path: String
) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = INFORMATION_COLUMN_NAME_ID)
    var id: Long = 0
}
