package ru.vlyashuk.shopvl.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module
import ru.vlyashuk.shopvl.data.datasource.remote.ProductsApiService
import ru.vlyashuk.shopvl.data.repository.ProductsRepositoryImpl
import ru.vlyashuk.shopvl.domain.repository.ProductsRepository
import ru.vlyashuk.shopvl.domain.usecase.GetProductsUseCase

val appModule = module {

    // API Services
    single<ProductsApiService> {
        ProductsApiService(get())
    }

    // Repositories
    single<ProductsRepository> {
        ProductsRepositoryImpl(get ())
    }

    // UseCases
    single<GetProductsUseCase> {
        GetProductsUseCase(get())
    }
}

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            appModule,
            networkModule,
            platformModule
        )
    }
}
