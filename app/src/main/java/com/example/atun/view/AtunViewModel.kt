package com.example.atun.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.atun.data.AtunRojo
import com.example.atun.data.AtunRojoDatabase
import kotlinx.coroutines.flow.Flow

class AtunViewModel(application: Application) : AndroidViewModel(application) {
    private val atunDao = AtunRojoDatabase.getDatabase(application).atunRojoDao()

    val atunList: Flow<List<AtunRojo>> = atunDao.getAll()

    fun getAtunById(id: Int): Flow<AtunRojo?> {
        return atunDao.getById(id)
    }
}


