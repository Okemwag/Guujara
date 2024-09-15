package com.okemwag.movies.di

import com.okemwag.movies.data.remote.MovieService
import com.okemwag.movies.data.remote.RemoteDataSource
import com.okemwag.movies.data.repository.MovieRepositoryImpl
import com.okemwag.movies.domain.repository.MovieRepository
import com.okemwag.movies.domain.usecase.GetMovieUseCase
import com.okemwag.movies.domain.usecase.GetMoviesUseCase
import com.okemwag.movies.util.provideDispatcher
import org.koin.dsl.module

private val dataModule = module {
    factory { RemoteDataSource(get(), get()) }
    factory { MovieService() }
}

private val utilityModule = module {
    factory { provideDispatcher() }
}

private val domainModule = module {
    single<MovieRepository> { MovieRepositoryImpl(get()) }
    factory { GetMoviesUseCase() }
    factory { GetMovieUseCase() }
}

private val sharedModules = listOf(domainModule, dataModule, utilityModule)

fun getSharedModules() = sharedModules












