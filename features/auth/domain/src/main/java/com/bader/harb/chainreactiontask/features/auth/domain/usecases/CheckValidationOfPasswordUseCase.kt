package com.bader.harb.chainreactiontask.features.auth.domain.usecases

import androidx.fragment.app.Fragment
import com.bader.harb.chainreactiontask.features.auth.domain.R
import javax.inject.Inject

class CheckValidationOfPasswordUseCase @Inject constructor() {

    operator fun invoke(password: String?, currentFragment: Fragment): String {
        return when {
            password.isNullOrEmpty() -> {
                currentFragment.requireContext().getString(R.string.this_field_is_required)
            }

            password.length < 4 -> {
                currentFragment.requireContext().getString(R.string.password_must_be_length)
            }

            else -> {
                ""
            }
        }
    }
}