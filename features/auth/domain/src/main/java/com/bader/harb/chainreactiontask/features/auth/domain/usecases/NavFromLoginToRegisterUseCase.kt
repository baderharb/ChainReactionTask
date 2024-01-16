package com.bader.harb.chainreactiontask.features.auth.domain.usecases

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bader.harb.chainreactiontask.core.navigation.R
import javax.inject.Inject

class NavFromLoginToRegisterUseCase @Inject constructor() {

    operator fun invoke(currentFragment: Fragment) {
        currentFragment.findNavController().navigate(R.id.navigation_fragment_register)
    }
}
