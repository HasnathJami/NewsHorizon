package com.jsn.newshorizon.domain.usercases.app_entry

import com.jsn.newshorizon.domain.manager.LocalUserManager

class SaveAppEntry(private val localUserManager: LocalUserManager) {
    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}