package com.example.atun.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AtunRojoDao {

    @Query(
        """
        SELECT * FROM atun_rojo 
        ORDER BY id   
        """
    )
    fun getAll(): Flow<List<AtunRojo>>

    @Query("SELECT * FROM atun_rojo WHERE id = :id")
    fun getById(id: Int): Flow<AtunRojo?>
}