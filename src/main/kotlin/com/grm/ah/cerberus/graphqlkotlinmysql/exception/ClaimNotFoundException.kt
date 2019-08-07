//package com.grm.ah.cerberus.graphqlkotlinmysql.exception
//
//import graphql.ErrorType
//import graphql.GraphQLError
////import graphql.GraphQLError
//import graphql.language.SourceLocation
//
//import java.util.Collections
//
//class ClaimNotFoundException(private val claimId: String, val message: String) : RuntimeException(), GraphQLError {
//
//    override fun getMessage(): String {
//        return "Could not find claim with id: [$claimId]"
//    }
//
//    override fun getLocations(): List<SourceLocation>? {
//        return null
//    }
//
//    override fun getErrorType(): ErrorType {
//        return ErrorType.ValidationError
//    }
//
//    override fun getExtensions(): Map<String, Any> {
//        return Collections.singletonMap("claimId", claimId)
//    }
//}
