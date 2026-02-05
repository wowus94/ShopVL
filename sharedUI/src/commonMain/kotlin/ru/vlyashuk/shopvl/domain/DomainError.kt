package ru.vlyashuk.shopvl.domain

 sealed class DomainError: RuntimeException() {
     data object Network : DomainError()
     data object NotFound : DomainError()
     data object Unknown : DomainError()
}