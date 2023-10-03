package uz.gita.examfinal2.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.gita.examfinal2.domain.usecase.*
import uz.gita.examfinal2.domain.usecase.impl.*

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun loginUseCase(impl: LoginUseCaseImpl): LoginUseCase

    @Binds
    fun signInUseCase(impl: SignInUseCaseImpl): SignInUseCase

    @Binds
    fun signUpUseCase(impl: SignUpUseCaseImpl): SignUpUseCase

    @Binds
    fun createProfileUseCase(impl: CreateProfileUseCaseImpl): CreateProfileUseCase

    @Binds
    fun createProfilePinUseCase(impl: CreateProfilePinUseCaseImpl): CreateProfilePinUseCase

    @Binds
    fun forgotUseCase(impl: ForgotUseCaseImpl): ForgotUseCase

    @Binds
    fun forgotVerifyUsecase(impl: ForgotVerifyUsecaseImpl): ForgotVerifyUsecase

    @Binds
    fun forgotNewPasswordUseCase(impl: ForgotNewPasswordUseCaseImpl): ForgotNewPasswordUseCase

    @Binds
    fun homeUseCase(impl: HomeUseCaseImpl): HomeUseCase



}