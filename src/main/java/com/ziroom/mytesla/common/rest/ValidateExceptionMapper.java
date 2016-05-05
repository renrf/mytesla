package com.ziroom.mytesla.common.rest;

import com.google.gson.Gson;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by jian on 1/12/16.
 */
public class ValidateExceptionMapper implements ExceptionMapper<ConstraintViolationException>
{
    @Override
    public Response toResponse(ConstraintViolationException exception) {
        Set<ConstraintViolation<?>> cvs = exception.getConstraintViolations();
        Map<String, String> msgMap = new HashMap<>();
        for (ConstraintViolation<?> cv : cvs) {
            msgMap.put(cv.getPropertyPath().toString(), cv.getMessage());
        }
        return Response.status(400).entity(new Gson().toJson(msgMap)).build();
    }
}
