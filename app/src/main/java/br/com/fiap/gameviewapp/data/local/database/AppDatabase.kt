package br.com.fiap.gameviewapp.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap.gameviewapp.data.local.dao.ReviewDao
import br.com.fiap.gameviewapp.data.local.entity.ReviewEntity

@Database(entities = [ReviewEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun reviewDao(): ReviewDao

    companion object {
        private lateinit var instance: AppDatabase

        fun getDatabase(context: Context): AppDatabase {
            if (!::instance.isInitialized) {
                instance = Room
                    .databaseBuilder(
                        context = context,
                        klass = AppDatabase::class.java,
                        name = "reviews"
                    )
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }
    }

}