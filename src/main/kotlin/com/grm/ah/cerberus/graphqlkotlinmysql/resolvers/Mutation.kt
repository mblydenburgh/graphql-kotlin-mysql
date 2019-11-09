package com.grm.ah.cerberus.graphqlkotlinmysql.resolvers

import com.blydenburgh.kotlineverywhere.dao.entities.User
import com.blydenburgh.kotlineverywhere.dao.entities.toGender
import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.grm.ah.cerberus.graphqlkotlinmysql.dao.repositories.PostRepository
import com.grm.ah.cerberus.graphqlkotlinmysql.dao.repositories.UserRepository
import org.springframework.stereotype.Component

@Component
class Mutation(
    private val userRepo: UserRepository
): GraphQLMutationResolver {

    fun createUser(username: String, age: Int, gender: String): User {
        val newUser = User(username = username, age = age, gender = gender[0].toGender())
        return userRepo.save(newUser)
    }

    fun deleteUser(id: Int) {
        return userRepo.deleteById(id.toLong())
    }
}
