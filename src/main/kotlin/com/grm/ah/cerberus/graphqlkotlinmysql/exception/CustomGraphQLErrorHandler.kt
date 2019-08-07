//package com.grm.ah.cerberus.graphqlkotlinmysql.exception
//
//import graphql.GraphQLError
//import graphql.servlet.GenericGraphQLError
//import graphql.servlet.GraphQLErrorHandler
//import org.springframework.stereotype.Component
//
//@Component
//class CustomGraphQLErrorHandler: GraphQLErrorHandler {
//    override fun processErrors(errors: MutableList<GraphQLError>?): MutableList<GenericGraphQLError> {
//        return errors?.map { GenericGraphQLError(it.message) } ?. toMutableList() ?: mutableListOf()
//    }
//}