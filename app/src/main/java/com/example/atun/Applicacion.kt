package com.example.atun

import android.app.Application
import com.example.atun.data.AtunRojoDatabase

class Applicacion: Application() {
    val database: AtunRojoDatabase by lazy { AtunRojoDatabase.getDatabase(this) }
}