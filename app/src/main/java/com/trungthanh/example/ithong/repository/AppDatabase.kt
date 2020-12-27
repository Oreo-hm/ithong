package com.trungthanh.example.ithong.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities =
[Bookmark::class, BookmarkType::class,Keyword::class , KeywordDetail::class, Law::class,
    NoticeBoard::class,NoticeBoardType::class, TransportType::class, Violation::class, ViolationGroup::class,
    ViolationRelation::class
]
    ,
    version = 2
)

abstract class AppDatabase : RoomDatabase(){
    abstract fun bookMarkDao(): BookmarkDao
    abstract fun bookMarkTypeDao(): BookmarkTypeDao
    abstract fun keyWordDao(): KeywordDao
    abstract fun keyWordDetailDao(): KeywordDetailDao
    abstract fun lawDao(): LawDao
    abstract fun noticeBoardDao(): NoticeBoardDao
    abstract fun noticeBoardTypeDao(): NoticeBoardTypeDao
    abstract fun transportTypeDao(): TransportTypeDao
    abstract fun violationDao(): ViolationDao
    abstract fun violationGroupDao(): ViolationGroupDao
    abstract fun violationRelationDao(): ViolationRelationDao

    companion object{
        @Volatile
        private var INSTANCE : AppDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): AppDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java, "testdatabase2"
                )
                    .createFromAsset("giao_thong.db")
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance

                instance
            }
        }

        private class AppDatabaseCallBack(
            private val scope: CoroutineScope, val context: Context
        ): RoomDatabase.Callback(){
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                    }
                }
            }
        }

    }
}