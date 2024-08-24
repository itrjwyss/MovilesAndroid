package gt.edu.umes.programovil.domain

sealed class DomainResult {
    data object Loading : DomainResult()
    data class Error(val message: String) : DomainResult()
    data class Message(val message: String) : DomainResult()
}
