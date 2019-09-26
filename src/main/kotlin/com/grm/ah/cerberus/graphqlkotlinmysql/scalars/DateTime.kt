package com.grm.ah.cerberus.graphqlkotlinmysql.scalars

import graphql.language.IntValue
import graphql.language.StringValue
import java.time.ZoneOffset
import java.time.Instant
import graphql.schema.Coercing
import graphql.schema.GraphQLScalarType
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Component
class DateTime: GraphQLScalarType("DateTime","Custom DateTime Scalar", object: Coercing<Any,String> {
    override fun serialize(input: Any): String {
        //serialize the DateTime into string on the way out
        println("Serializing $input as LocalDate")
        return input.toString();
    }

    override fun parseValue(input: Any): Any {
        return serialize(input);
    }

    override fun parseLiteral(input: Any): LocalDate? {
        val dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        println("Parsing $input")
        //parse the string values coming in
        return when (input) {
            is StringValue -> {
                println(LocalDate.parse(input.value,dateFormat))
                LocalDate.parse(input.value,dateFormat)
            }
            is IntValue -> Instant.ofEpochMilli(input.value.toLong()).atZone(ZoneOffset.UTC).toLocalDate()
            else -> null
        }
    }
})