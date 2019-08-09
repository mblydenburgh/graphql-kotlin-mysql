package com.grm.ah.cerberus.graphqlkotlinmysql.resolvers

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.grm.ah.cerberus.graphqlkotlinmysql.dao.entities.Claim
import com.grm.ah.cerberus.graphqlkotlinmysql.dao.entities.Payment
import com.grm.ah.cerberus.graphqlkotlinmysql.dao.repositories.ClaimRepositoryImpl
import com.grm.ah.cerberus.graphqlkotlinmysql.dao.repositories.PaymentRepositoryImpl
import com.grm.ah.cerberus.graphqlkotlinmysql.exception.QueryExceptionJava
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
        val paymentsList = paymentRepositoryImpl.getPaymentByNumber(num = num)
        return if (paymentsList.isEmpty()) {
            throw QueryExceptionJava(num)
        } else paymentsList
    }

    fun getPaymentsByClaimId(claimId: String): List<Payment?>? {
        val paymentsList = paymentRepositoryImpl.getPaymentsByClaimId(claimId)
        return if (paymentsList.isEmpty()) {
            throw QueryExceptionJava(claimId)
        } else paymentsList
    }

    fun getAllClaims(): List<Claim> {
        return claimRepositoryImpl.getAllClaims()
    }

    fun getClaimById(id: String): Claim? {
        return claimRepositoryImpl.getClaimById(id = id) ?: throw QueryExceptionJava(id)
    }
}