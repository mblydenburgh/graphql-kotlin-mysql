package com.grm.ah.cerberus.graphqlkotlinmysql.scalars

import graphql.language.IntValue
import graphql.language.StringValue
import java.time.ZoneOffset
import java.time.Instant
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import graphql.schema.Coercing
import graphql.schema.GraphQLScalarType
import org.springframework.stereotype.Component
import java.util.*

@Component
class DateTime: GraphQLScalarType("DateTime","Custom DateTime Scalar", object: Coercing<Any,String> {
    override fun serialize(input: Any): String {
        //serialize the ZonedDateTime into string on the way out
        return (input as ZonedDateTime).format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }

    override fun parseValue(input: Any): Any {
        return serialize(input);
    }

    override fun parseLiteral(input: Any): ZonedDateTime? {
        //parse the string values coming in
        return when (input) {
            is StringValue -> ZonedDateTime.parse(input.value)
            is IntValue -> Instant.ofEpochMilli(input.value.toLong()).atZone(ZoneOffset.UTC)
            else -> null
        }
    }
})

//    var DateTime = GraphQLScalarType("DateTime","Custom DateTime Scalar", object: Coercing<Any,String>{
//
//        override fun serialize(input: Any): String {
//            //serialize the ZonedDateTime into string on the way out
//            return (input as ZonedDateTime).format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
//        }
//
//        override fun parseValue(input: Any): Any {
//            return serialize(input);
//        }
//
//        override fun parseLiteral(input: Any): ZonedDateTime? {
//            //parse the string values coming in
//            return when (input) {
//                is StringValue -> ZonedDateTime.parse(input.value)
//                is IntValue -> Instant.ofEpochMilli(input.value.toLong()).atZone(ZoneOffset.UTC)
//                else -> null
//            }
//        }
//    })
//}