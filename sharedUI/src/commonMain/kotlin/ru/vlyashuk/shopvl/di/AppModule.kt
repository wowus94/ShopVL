package ru.vlyashuk.shopvl.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module
import ru.vlyashuk.shopvl.domain.usecase.GetProductsUseCase

val appModule = module {

    // Repositories
    /*single<ProductsRepository> {
      // TODO
    }*/

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
