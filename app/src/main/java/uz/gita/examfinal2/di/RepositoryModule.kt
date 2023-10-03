package uz.gita.examfinal2.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.examfinal2.domain.repository.AppRepository
import uz.gita.examfinal2.domain.repository.AuthRepository
import uz.gita.examfinal2.domain.repository.impl.AppRepositoryImpl
import uz.gita.examfinal2.domain.repository.impl.AuthRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @[Binds Singleton]
    fun bindAppRepository(impl: AppRepositoryImpl): AppRepository

    @[Binds Singleton]
    fun bindAuthRepository(impl: AuthRepositoryImpl): AuthRepository

}