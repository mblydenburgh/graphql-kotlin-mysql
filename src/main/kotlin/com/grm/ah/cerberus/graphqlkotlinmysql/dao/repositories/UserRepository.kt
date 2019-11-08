package com.grm.ah.cerberus.graphqlkotlinmysql.dao.repositories

import com.blydenburgh.kotlineverywhere.dao.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User,Long> {

}