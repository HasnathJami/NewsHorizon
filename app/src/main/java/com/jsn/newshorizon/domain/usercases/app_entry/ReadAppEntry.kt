package com.jsn.newshorizon.domain.usercases.app_entry

import com.jsn.newshorizon.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(private val localUserManager: LocalUserManager) {
     operator fun invoke(): Flow<Boolean> {
        return localUserManager.readAppEntry()
    }
}