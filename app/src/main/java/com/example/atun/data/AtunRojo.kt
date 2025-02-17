package com.example.atun.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "atun_rojo")
data class AtunRojo (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val nombre: String,
    val parteCuerpo: String,
    val descripcion: String,
)