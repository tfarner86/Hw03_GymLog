package com.example.hw03_gymlog.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.hw03_gymlog.database.Entities.GymLog;

import java.util.List;

@Dao
public interface GymLogDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(GymLog gymLog);

    @Query("Select * from " + GymLogDatabase.gymLogTable + " ORDER BY date DESC")
    List<GymLog> getAllRecords();

    @Query("Select * from " + GymLogDatabase.gymLogTable + " WHERE userId = :userId ORDER BY date DESC")
    LiveData<List<GymLog>> getAllLogsByUserId(int userId);

    @Query("Select * from " + GymLogDatabase.gymLogTable + " WHERE userId = :loggedInUserId ORDER BY date DESC")
    List<GymLog> getRecordsByUserId(int loggedInUserId);
}
