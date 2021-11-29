package com.example.last.data.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.last.data.user.GithubUser
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

@Dao
interface GithubUserDao {

    @Query("SELECT * FROM github_users")
    fun getUsers(): Observable<List<GithubUser>>

    @Query("SELECT * FROM github_users WHERE login LIKE :login LIMIT 1")
    fun getUserByLogin(login: String): Observable<GithubUser>

    @Insert(onConflict = REPLACE)
    fun retain(users: List<GithubUser>): Completable

    @Insert(onConflict = REPLACE)
    fun retain(user: GithubUser): Completable

}