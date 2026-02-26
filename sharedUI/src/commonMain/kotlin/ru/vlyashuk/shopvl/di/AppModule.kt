package ru.vlyashuk.shopvl.di

import com.russhwolf.settings.Settings
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module
import ru.vlyashuk.shopvl.data.datasource.remote.ProductsApiService
import ru.vlyashuk.shopvl.data.repository.ProductsRepositoryImpl
import ru.vlyashuk.shopvl.domain.repository.ProductsRepository
import ru.vlyashuk.shopvl.domain.usecase.GetProductsUseCase
import ru.vlyashuk.shopvl.presentation.LanguageViewModel
import ru.vlyashuk.shopvl.presentation.ProductsViewModel
import ru.vlyashuk.shopvl.utils.SettingsFactory

val appModule = module {

    // API Services
    single<ProductsApiService> {
        ProductsApiService(get())
    }

    // Repositories
    single<ProductsRepository> {
        ProductsRepositoryImpl(get())
    }

    // UseCases
    single<GetProductsUseCase> {
        GetProductsUseCase(get(), get())
    }

    // Settings
    single { SettingsFactory() }
    single<Settings> { get<SettingsFactory>().create() }

    // ViewModels
    viewModel {
        ProductsViewModel(get())
    }
    viewModel {
        LanguageViewModel(get())
    }
}

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            platformModule,
            networkModule,
            appModule
        )
    }
}