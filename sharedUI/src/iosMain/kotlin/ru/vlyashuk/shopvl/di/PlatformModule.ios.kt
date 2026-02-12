package ru.vlyashuk.shopvl.di

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin
import org.koin.core.module.Module
import org.koin.dsl.module
import ru.vlyashuk.shopvl.NetworkConnectivityManager

actual val platformModule: Module = module {
    single<HttpClientEngine> {
        Darwin.create()
    }

    single<NetworkConnectivityManager> {
        NetworkConnectivityManager()
    }
}