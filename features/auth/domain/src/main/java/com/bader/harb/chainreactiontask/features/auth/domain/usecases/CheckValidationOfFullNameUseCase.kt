package com.bader.harb.chainreactiontask.features.auth.domain.usecases

import androidx.fragment.app.Fragment
import com.bader.harb.chainreactiontask.features.auth.domain.R
import javax.inject.Inject

class CheckValidationOfFullNameUseCase @Inject constructor() {

    operator fun invoke(fullName: String?, currentFragment: Fragment): String {
        return checkFullNameValidation(fullName, currentFragment)
    }

    private fun checkFullNameValidation(fullName: String?, currentFragment: Fragment): String {
        return when {

            fullName.isNullOrEmpty() -> {
                currentFragment.requireContext().getString(R.string.this_field_is_required)
            }

            else -> {
                ""
            }
        }
    }
}