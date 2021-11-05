package org.acme;

import io.quarkus.cache.CacheInvalidateAll;
import io.quarkus.cache.CacheResult;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/test-cache")
@ApplicationScoped
public class GreetingResource {

    private int invocations1;
    private int invocations2;

    @GET
    @Path("/method1")
    @CacheResult(cacheName = "cache1")
    public Integer method1() {
        return ++invocations1;
    }

    @GET
    @Path("/method2")
    @CacheResult(cacheName = "cache2")
    public Integer method2() {
        return ++invocations2;
    }

    @DELETE
    @CacheInvalidateAll(cacheName = "cache1")
    @CacheInvalidateAll(cacheName = "cache2")
    public void invalidateAll() {
    }
}
