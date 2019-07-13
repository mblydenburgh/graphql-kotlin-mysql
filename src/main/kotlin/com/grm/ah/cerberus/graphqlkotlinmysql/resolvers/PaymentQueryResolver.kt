package com.grm.ah.cerberus.graphqlkotlinmysql.resolvers

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.grm.ah.cerberus.graphqlkotlinmysql.dao.entities.Payment
import com.grm.ah.cerberus.graphqlkotlinmysql.dao.repositories.PaymentRepositoryImpl
import org.springframework.stereotype.Component

@Component
class PaymentQueryResolver(private val paymentRepositoryImpl: PaymentRepositoryImpl): GraphQLQueryResolver {
    fun getPaymentByNumber(num: String): List<Payment>{
        return paymentRepositoryImpl.getPaymentByNumber(num = num)
    }
}