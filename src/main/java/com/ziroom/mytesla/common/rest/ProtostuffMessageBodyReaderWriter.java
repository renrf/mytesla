package com.ziroom.mytesla.common.rest;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.Message;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * Message body reader and writer for protostuff message format.
 *
 */
@Provider
@Produces("application/x-protostuff")
@Consumes("application/x-protostuff")
public class ProtostuffMessageBodyReaderWriter implements
        MessageBodyReader<Object>, MessageBodyWriter<Object> {

    @Override
    public boolean isWriteable(Class<?> type, Type genericType,
                               Annotation[] annotations, MediaType mediaType) {
        return isProtostuff(type);
    }

    private boolean isProtostuff(Class<?> type) {
        if (Message.class.isAssignableFrom(type)) {
            return true;
        }
        try {
            RuntimeSchema.getSchema(type);
        } catch (Throwable e) {
            return false;
        }
        return true;
    }

    @Override
    public long getSize(Object t, Class<?> type, Type genericType,
                        Annotation[] annotations, MediaType mediaType) {
        // Protostuff doesnot provide any mechanism, so -1 which indicates
        // streaming.
        return -1;
    }

    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void writeTo(Object t, Class<?> type, Type genericType,
                        Annotation[] annotations, MediaType mediaType,
                        MultivaluedMap<String, Object> httpHeaders,
                        OutputStream entityStream) throws IOException {
        Schema schema = RuntimeSchema.getSchema(t.getClass());
        ProtostuffIOUtil.writeTo(entityStream, t, schema,
                LinkedBuffer.allocate(getBufferSize()));
    }

    @Override
    public boolean isReadable(Class<?> type, Type genericType,
                              Annotation[] annotations, MediaType mediaType) {
        return isProtostuff(type);
    }

    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Object readFrom(Class<Object> type, Type genericType,
                           Annotation[] annotations, MediaType mediaType,
                           MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
            throws IOException {
        Schema schema = RuntimeSchema.getSchema(type);
        Object message = schema.newMessage();
        ProtostuffIOUtil.mergeFrom(entityStream, message, schema);
        return message;
    }

    protected int getBufferSize() {
        return LinkedBuffer.DEFAULT_BUFFER_SIZE;
    }

}

