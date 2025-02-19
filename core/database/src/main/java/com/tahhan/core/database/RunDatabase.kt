package com.tahhan.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tahhan.core.database.dao.RunDao
import com.tahhan.core.database.dao.RunPendingSyncDao
import com.tahhan.core.database.entity.DeletedRunSyncEntity
import com.tahhan.core.database.entity.RunEntity
import com.tahhan.core.database.entity.RunPendingSyncEntity

@Database(
    entities = [
        RunEntity::class,
        RunPendingSyncEntity::class,
        DeletedRunSyncEntity::class
    ],
    version = 1
)
abstract class RunDatabase : RoomDatabase() {

    abstract val runDao: RunDao
    abstract val runPendingSyncDao: RunPendingSyncDao
}