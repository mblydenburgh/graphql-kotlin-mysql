package com.grm.ah.cerberus.graphqlkotlinmysql.resolvers

import com.blydenburgh.kotlineverywhere.dao.entities.Post
import com.blydenburgh.kotlineverywhere.dao.entities.User
import com.coxautodev.graphql.tools.GraphQLResolver
import com.grm.ah.cerberus.graphqlkotlinmysql.dao.repositories.PostRepository
import com.grm.ah.cerberus.graphqlkotlinmysql.exception.QueryExceptionJava
import org.springframework.stereotype.Component

@Component
class UserResolver(private val postRepo: PostRepository): GraphQLResolver<User> {
    fun posts(user: User, username: String?): List<Post>? {
        return if (username != null) {
            postRepo.findPostsByUsername(username) ?: throw QueryExceptionJava(username)
        } else {
            postRepo.findPostsByUsername(user.username) ?: throw QueryExceptionJava(user.username)
        }
    }
}

