package com.example.memo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(MemoEntity::class), version = 1)
abstract class MemoDatabase : RoomDatabase() {
    abstract fun memoDAO() : MemoDAO

    companion object {
        var INSTANCE : MemoDatabase? = null

        fun getInstance(context : Context) : MemoDatabase? {
            if(INSTANCE == null ){
                synchronized(MemoDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                    MemoDatabase::class.java, "memo.db")
                        .fallbackToDestructiveMigration()
                        .build()            //안드로이드 공식문서에서는 fallback 메서드와 synchonized 메서드에 대한 설명은 없음.
                }
            }
            return INSTANCE
        }


    }
}