package com.grm.ah.cerberus.graphqlkotlinmysql.resolvers

import com.coxautodev.graphql.tools.GraphQLResolver
import com.grm.ah.cerberus.graphqlkotlinmysql.dao.entities.Claim
import com.grm.ah.cerberus.graphqlkotlinmysql.dao.entities.Payment
import com.grm.ah.cerberus.graphqlkotlinmysql.dao.repositories.PaymentRepositoryImpl
import org.springframework.stereotype.Component

@Component
class ClaimResolver(private val paymentRepositoryImpl: PaymentRepositoryImpl): GraphQLResolver<Claim> {
    fun payments(claimId: String): List<Payment> = paymentRepositoryImpl.getPaymentByClaimId(claimId)
}