package com.grm.ah.cerberus.graphqlkotlinmysql.resolvers

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.grm.ah.cerberus.graphqlkotlinmysql.dao.entities.Claim
import com.grm.ah.cerberus.graphqlkotlinmysql.dao.entities.Payment
import com.grm.ah.cerberus.graphqlkotlinmysql.dao.repositories.ClaimRepositoryImpl
import com.grm.ah.cerberus.graphqlkotlinmysql.dao.repositories.PaymentRepositoryImpl
import org.springframework.stereotype.Component

@Component
class Query(
    private val claimRepositoryImpl: ClaimRepositoryImpl,
    private val paymentRepositoryImpl: PaymentRepositoryImpl
): GraphQLQueryResolver {
    fun getPaymentByNumber(num: String): List<Payment> {
        return paymentRepositoryImpl.getPaymentByNumber(num = num)
    }

    fun getPaymentByClaimId(claimId: String): List<Payment> {
        return paymentRepositoryImpl.getPaymentByClaimId(claimId)
    }

    fun getClaimById(id: String): List<Claim> {
        return claimRepositoryImpl.getClaimById(id = id)
    }
}