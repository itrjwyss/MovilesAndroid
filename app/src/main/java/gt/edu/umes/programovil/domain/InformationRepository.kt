package gt.edu.umes.programovil.domain

import gt.edu.umes.programovil.data.InformationDao
import gt.edu.umes.programovil.data.InformationEntity

class InformationRepository(
    private val dao: InformationDao
) {

    val all = dao.findAll()

    suspend fun insert(informationEntity: InformationEntity) =
        dao.insert(informationEntity)
}
