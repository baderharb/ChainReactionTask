package com.bader.harb.chainreactiontask.features.auth.domain.usecases

import androidx.fragment.app.Fragment
import com.bader.harb.chainreactiontask.features.auth.domain.R
import javax.inject.Inject

class CheckValidationOfDateOfBirthUseCase @Inject constructor() {

    operator fun invoke(dateOfBirth: String?, currentFragment: Fragment): String {
        return checkDateOfBirthValidation(dateOfBirth, currentFragment)
    }

    private fun checkDateOfBirthValidation(
        dateOfBirth: String?,
        currentFragment: Fragment
    ): String {
        return when {

            dateOfBirth.isNullOrEmpty() -> {
                currentFragment.requireContext().getString(R.string.this_field_is_required)
            }

            else -> {
                ""
            }
        }
    }
}