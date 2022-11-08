package com.oldspeccy.composetest

import android.app.Application
import com.oldspeccy.composetest.model.DemoDatabase
import com.oldspeccy.composetest.model.DemoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class DemoApplication:Application() {

    // No need to cancel this scope as it'll be torn down with the process
    val applicationScope = CoroutineScope(SupervisorJob())

    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    public val database by lazy { DemoDatabase.getInstance(this) }
    val repository by lazy { DemoRepository(database.dataItemDao()) }
}