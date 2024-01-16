package com.bader.harb.chainreactiontask.features.auth.domain.usecases

import androidx.fragment.app.Fragment
import com.bader.harb.chainreactiontask.features.auth.domain.R
import javax.inject.Inject

class CheckValidationOfPhoneNumberUseCase @Inject constructor() {

    operator fun invoke(phoneNumber: String?, currentFragment: Fragment): String {
        return checkPhoneNumberValidation(phoneNumber, currentFragment)
    }

    private fun checkPhoneNumberValidation(
        phoneNumber: String?,
        currentFragment: Fragment
    ): String {
        return when {

            phoneNumber.isNullOrEmpty() -> {
                currentFragment.requireContext().getString(R.string.this_field_is_required)
            }

            phoneNumber.length != 10 -> {
                currentFragment.requireContext().getString(R.string.phone_must_be_length)
            }

            else -> {
                ""
            }
        }
    }
}