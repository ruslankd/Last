package com.example.last.data.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.last.data.repository.GithubRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable

@Dao
interface GithubRepositoryDao {

    @Query("SELECT * FROM github_repositories WHERE login LIKE :login")
    fun getRepositoriesByLogin(login: String): Observable<List<GithubRepository>>

    @Query("SELECT * FROM github_repositories WHERE (login LIKE :login) AND (name LIKE :reposName)")
    fun getRepositoryByLoginAndName(login: String, reposName: String): Observable<GithubRepository>

    @Insert(onConflict = REPLACE)
    fun retain(repositories: List<GithubRepository>): Completable

    @Insert(onConflict = REPLACE)
    fun retain(repository: GithubRepository): Completable
}