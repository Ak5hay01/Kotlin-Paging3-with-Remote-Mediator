package com.example.kotlinpaging3

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kotlinpaging3.db.QuoteDao
import com.example.kotlinpaging3.db.RemoteKeysDao
import com.example.kotlinpaging3.models.QuoteRemoteKeys
import com.example.kotlinpaging3.models.Result

@Database(entities = [Result::class, QuoteRemoteKeys::class], version = 1)
abstract class QuoteDatabase: RoomDatabase() {

    abstract fun quoteDao():QuoteDao
    abstract fun remoteKeysDao():RemoteKeysDao
}