package com.grm.ah.cerberus.graphqlkotlinmysql.resolvers

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.grm.ah.cerberus.graphqlkotlinmysql.dao.entities.Claim
import com.grm.ah.cerberus.graphqlkotlinmysql.dao.repositories.ClaimRepositoryImpl
import org.springframework.stereotype.Component

@Component
class ClaimQueryResolver(private val claimRepositoryImpl: ClaimRepositoryImpl): GraphQLQueryResolver {
    fun getClaimById(id: String): List<Claim> {
        return claimRepositoryImpl.getClaimById(id = id)
    }
}