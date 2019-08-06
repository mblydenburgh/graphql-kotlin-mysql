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
    fun getAllPayments(): List<Payment>{
        return paymentRepositoryImpl.getAllPayments()
    }

    fun getPaymentByNumber(num: String): List<Payment> {
        return paymentRepositoryImpl.getPaymentByNumber(num = num)
    }

    fun getPaymentsByClaimId(claimId: String): List<Payment?> {
        return paymentRepositoryImpl.getPaymentsByClaimId(claimId)
    }

    fun getAllClaims(): List<Claim> {
        return claimRepositoryImpl.getAllClaims()
    }

    fun getClaimById(id: String): Claim? {
        return claimRepositoryImpl.getClaimById(id = id)
    }
}