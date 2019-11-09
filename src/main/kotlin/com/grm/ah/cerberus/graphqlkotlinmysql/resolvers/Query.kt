package com.grm.ah.cerberus.graphqlkotlinmysql.resolvers

import com.blydenburgh.kotlineverywhere.dao.entities.User
import com.blydenburgh.kotlineverywhere.dao.entities.toGender
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.grm.ah.cerberus.graphqlkotlinmysql.dao.repositories.PostRepository
import com.grm.ah.cerberus.graphqlkotlinmysql.dao.repositories.UserRepository
import com.grm.ah.cerberus.graphqlkotlinmysql.exception.QueryExceptionJava
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class Query(
    private val userRepo: UserRepository
) : GraphQLQueryResolver {
    fun getAllUsers(): List<User> {
        return userRepo.findAll().filterNotNull().toList()
    }

    fun getUser(id: Int, username: String?): User? {
        return if (username != null) {
            userRepo.findUserByUsername(username) ?: throw QueryExceptionJava(username)
        } else {
            userRepo.findByIdOrNull<User, Long>(id.toLong()) ?: throw QueryExceptionJava(username)
        }
    }
}

