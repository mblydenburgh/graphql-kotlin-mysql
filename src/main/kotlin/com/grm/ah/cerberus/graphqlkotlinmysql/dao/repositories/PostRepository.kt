package com.grm.ah.cerberus.graphqlkotlinmysql.dao.repositories

import com.blydenburgh.kotlineverywhere.dao.entities.Post
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PostRepository: JpaRepository<Post,Long> {
    fun findPostsByUsername(username: String): List<Post>?
}