package com.bader.harb.chainreactiontask.features.auth.presentation.register

import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import com.bader.harb.chainreactiontask.core.storage.preferences.Prefs
import com.bader.harb.chainreactiontask.features.auth.domain.usecases.CheckValidationOfDateOfBirthUseCase
import com.bader.harb.chainreactiontask.features.auth.domain.usecases.CheckValidationOfEmailUseCase
import com.bader.harb.chainreactiontask.features.auth.domain.usecases.CheckValidationOfFullNameUseCase
import com.bader.harb.chainreactiontask.features.auth.domain.usecases.CheckValidationOfPasswordUseCase
import com.bader.harb.chainreactiontask.features.auth.domain.usecases.CheckValidationOfPhoneNumberUseCase
import com.bader.harb.chainreactiontask.features.auth.domain.usecases.NavToHomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val prefs: Prefs,
    private val checkValidationOfEmailUseCase: CheckValidationOfEmailUseCase,
    private val checkValidationOfPasswordUseCase: CheckValidationOfPasswordUseCase,
    private val checkValidationOfPhoneNumberUseCase: CheckValidationOfPhoneNumberUseCase,
    private val checkValidationOfFullNameUseCase: CheckValidationOfFullNameUseCase,
    private val checkValidationOfDateOfBirthUseCase: CheckValidationOfDateOfBirthUseCase,
    private val navToHomeUseCase: NavToHomeUseCase,
) : ViewModel(), LifecycleObserver {


    fun getEmailErrorValidation(email: String?, currentFragment: Fragment): String {
        return checkValidationOfEmailUseCase(email = email, currentFragment)
    }

    fun getPhoneNumberErrorValidation(phoneNumber: String?, currentFragment: Fragment): String {
        return checkValidationOfPhoneNumberUseCase(phoneNumber = phoneNumber, currentFragment)
    }

    fun getFullNameErrorValidation(fullName: String?, currentFragment: Fragment): String {
        return checkValidationOfFullNameUseCase(fullName = fullName, currentFragment)
    }

    fun getDateOfBirthErrorValidation(dateOfBirth: String?, currentFragment: Fragment): String {
        return checkValidationOfDateOfBirthUseCase(dateOfBirth = dateOfBirth, currentFragment)
    }

    fun getPasswordErrorValidation(password: String?, currentFragment: Fragment): String {
        return checkValidationOfPasswordUseCase(password = password, currentFragment)
    }

    private fun saveUserDataToPreferences(
        fullName: String,
        email: String,
        phoneNumber: String,
        dateOfBirth: String
    ) {
        prefs.fullName = fullName
        prefs.email = email
        prefs.phoneNumber = phoneNumber
        prefs.dateOfBirth = dateOfBirth
        prefs.accessToken = "access_token_new_user"
    }

    private fun navigateToHomeScreen(
        currentFragment: Fragment,
    ) {
        navToHomeUseCase(currentFragment = currentFragment)
    }

    fun createAccount(
        fullName: String,
        email: String,
        phoneNumber: String,
        dateOfBirth: String,
        currentFragment: Fragment
    ) {
        saveUserDataToPreferences(fullName, email, phoneNumber, dateOfBirth)
        navigateToHomeScreen(currentFragment)
    }
}