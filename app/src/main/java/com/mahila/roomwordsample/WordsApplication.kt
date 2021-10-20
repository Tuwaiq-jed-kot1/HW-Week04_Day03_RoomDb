package com.mahila.roomwordsample

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class WordsApplication {
    class WordsApplication : android.app.Application() {
        val applicationScope = CoroutineScope(SupervisorJob())


        val database by lazy { WordRoomDatabase.getDatabase(this, applicationScope) }
        val repository by lazy { WordRepository(database.wordDao()) }
    }