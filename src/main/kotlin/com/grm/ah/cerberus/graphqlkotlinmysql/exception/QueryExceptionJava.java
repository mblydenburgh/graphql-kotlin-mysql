package com.grm.ah.cerberus.graphqlkotlinmysql.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class QueryExceptionJava extends RuntimeException implements GraphQLError {
    private String input;

    public QueryExceptionJava(String input) {
        this.input = input;
    }

    @Override
    public String getMessage() {
        return "Error querying with parameter: [" + input + "]";
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.ValidationError;
    }

    @Override
    public Map<String, Object> getExtensions() {
        return Collections.singletonMap("input", input);
    }
}
