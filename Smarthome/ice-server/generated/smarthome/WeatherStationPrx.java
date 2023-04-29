//
// Copyright (c) ZeroC, Inc. All rights reserved.
//
//
// Ice version 3.7.9
//
// <auto-generated>
//
// Generated from file `devices.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package smarthome;

public interface WeatherStationPrx extends com.zeroc.Ice.ObjectPrx
{
    default Specs getSpecs()
    {
        return getSpecs(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default Specs getSpecs(java.util.Map<String, String> context)
    {
        return _iceI_getSpecsAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Specs> getSpecsAsync()
    {
        return _iceI_getSpecsAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Specs> getSpecsAsync(java.util.Map<String, String> context)
    {
        return _iceI_getSpecsAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Specs> _iceI_getSpecsAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Specs> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getSpecs", null, sync, null);
        f.invoke(true, context, null, null, istr -> {
                     Specs ret;
                     ret = Specs.ice_read(istr);
                     return ret;
                 });
        return f;
    }

    default Location getLocation()
    {
        return getLocation(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default Location getLocation(java.util.Map<String, String> context)
    {
        return _iceI_getLocationAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Location> getLocationAsync()
    {
        return _iceI_getLocationAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Location> getLocationAsync(java.util.Map<String, String> context)
    {
        return _iceI_getLocationAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Location> _iceI_getLocationAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Location> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getLocation", null, sync, null);
        f.invoke(true, context, null, null, istr -> {
                     Location ret;
                     ret = Location.ice_read(istr);
                     return ret;
                 });
        return f;
    }

    default double getAverageWeeklyInsideTemperature()
        throws Error
    {
        return getAverageWeeklyInsideTemperature(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default double getAverageWeeklyInsideTemperature(java.util.Map<String, String> context)
        throws Error
    {
        try
        {
            return _iceI_getAverageWeeklyInsideTemperatureAsync(context, true).waitForResponseOrUserEx();
        }
        catch(Error ex)
        {
            throw ex;
        }
        catch(com.zeroc.Ice.UserException ex)
        {
            throw new com.zeroc.Ice.UnknownUserException(ex.ice_id(), ex);
        }
    }

    default java.util.concurrent.CompletableFuture<java.lang.Double> getAverageWeeklyInsideTemperatureAsync()
    {
        return _iceI_getAverageWeeklyInsideTemperatureAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<java.lang.Double> getAverageWeeklyInsideTemperatureAsync(java.util.Map<String, String> context)
    {
        return _iceI_getAverageWeeklyInsideTemperatureAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<java.lang.Double> _iceI_getAverageWeeklyInsideTemperatureAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<java.lang.Double> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getAverageWeeklyInsideTemperature", null, sync, _iceE_getAverageWeeklyInsideTemperature);
        f.invoke(true, context, null, null, istr -> {
                     double ret;
                     ret = istr.readDouble();
                     return ret;
                 });
        return f;
    }

    /** @hidden */
    static final Class<?>[] _iceE_getAverageWeeklyInsideTemperature =
    {
        Error.class
    };

    default double getAverageWeeklyOutsideTemperature()
        throws Error
    {
        return getAverageWeeklyOutsideTemperature(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default double getAverageWeeklyOutsideTemperature(java.util.Map<String, String> context)
        throws Error
    {
        try
        {
            return _iceI_getAverageWeeklyOutsideTemperatureAsync(context, true).waitForResponseOrUserEx();
        }
        catch(Error ex)
        {
            throw ex;
        }
        catch(com.zeroc.Ice.UserException ex)
        {
            throw new com.zeroc.Ice.UnknownUserException(ex.ice_id(), ex);
        }
    }

    default java.util.concurrent.CompletableFuture<java.lang.Double> getAverageWeeklyOutsideTemperatureAsync()
    {
        return _iceI_getAverageWeeklyOutsideTemperatureAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<java.lang.Double> getAverageWeeklyOutsideTemperatureAsync(java.util.Map<String, String> context)
    {
        return _iceI_getAverageWeeklyOutsideTemperatureAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<java.lang.Double> _iceI_getAverageWeeklyOutsideTemperatureAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<java.lang.Double> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getAverageWeeklyOutsideTemperature", null, sync, _iceE_getAverageWeeklyOutsideTemperature);
        f.invoke(true, context, null, null, istr -> {
                     double ret;
                     ret = istr.readDouble();
                     return ret;
                 });
        return f;
    }

    /** @hidden */
    static final Class<?>[] _iceE_getAverageWeeklyOutsideTemperature =
    {
        Error.class
    };

    default double getInsideTemperature()
    {
        return getInsideTemperature(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default double getInsideTemperature(java.util.Map<String, String> context)
    {
        return _iceI_getInsideTemperatureAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<java.lang.Double> getInsideTemperatureAsync()
    {
        return _iceI_getInsideTemperatureAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<java.lang.Double> getInsideTemperatureAsync(java.util.Map<String, String> context)
    {
        return _iceI_getInsideTemperatureAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<java.lang.Double> _iceI_getInsideTemperatureAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<java.lang.Double> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getInsideTemperature", com.zeroc.Ice.OperationMode.Idempotent, sync, null);
        f.invoke(true, context, null, null, istr -> {
                     double ret;
                     ret = istr.readDouble();
                     return ret;
                 });
        return f;
    }

    default double getOutsideTemperature()
    {
        return getOutsideTemperature(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default double getOutsideTemperature(java.util.Map<String, String> context)
    {
        return _iceI_getOutsideTemperatureAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<java.lang.Double> getOutsideTemperatureAsync()
    {
        return _iceI_getOutsideTemperatureAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<java.lang.Double> getOutsideTemperatureAsync(java.util.Map<String, String> context)
    {
        return _iceI_getOutsideTemperatureAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<java.lang.Double> _iceI_getOutsideTemperatureAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<java.lang.Double> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getOutsideTemperature", com.zeroc.Ice.OperationMode.Idempotent, sync, null);
        f.invoke(true, context, null, null, istr -> {
                     double ret;
                     ret = istr.readDouble();
                     return ret;
                 });
        return f;
    }

    default double getPressure()
    {
        return getPressure(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default double getPressure(java.util.Map<String, String> context)
    {
        return _iceI_getPressureAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<java.lang.Double> getPressureAsync()
    {
        return _iceI_getPressureAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<java.lang.Double> getPressureAsync(java.util.Map<String, String> context)
    {
        return _iceI_getPressureAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<java.lang.Double> _iceI_getPressureAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<java.lang.Double> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getPressure", com.zeroc.Ice.OperationMode.Idempotent, sync, null);
        f.invoke(true, context, null, null, istr -> {
                     double ret;
                     ret = istr.readDouble();
                     return ret;
                 });
        return f;
    }

    default double getHumidity()
    {
        return getHumidity(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default double getHumidity(java.util.Map<String, String> context)
    {
        return _iceI_getHumidityAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<java.lang.Double> getHumidityAsync()
    {
        return _iceI_getHumidityAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<java.lang.Double> getHumidityAsync(java.util.Map<String, String> context)
    {
        return _iceI_getHumidityAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<java.lang.Double> _iceI_getHumidityAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<java.lang.Double> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getHumidity", com.zeroc.Ice.OperationMode.Idempotent, sync, null);
        f.invoke(true, context, null, null, istr -> {
                     double ret;
                     ret = istr.readDouble();
                     return ret;
                 });
        return f;
    }

    default double getWindSpeed()
    {
        return getWindSpeed(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default double getWindSpeed(java.util.Map<String, String> context)
    {
        return _iceI_getWindSpeedAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<java.lang.Double> getWindSpeedAsync()
    {
        return _iceI_getWindSpeedAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<java.lang.Double> getWindSpeedAsync(java.util.Map<String, String> context)
    {
        return _iceI_getWindSpeedAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<java.lang.Double> _iceI_getWindSpeedAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<java.lang.Double> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getWindSpeed", com.zeroc.Ice.OperationMode.Idempotent, sync, null);
        f.invoke(true, context, null, null, istr -> {
                     double ret;
                     ret = istr.readDouble();
                     return ret;
                 });
        return f;
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static WeatherStationPrx checkedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, ice_staticId(), WeatherStationPrx.class, _WeatherStationPrxI.class);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static WeatherStationPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, context, ice_staticId(), WeatherStationPrx.class, _WeatherStationPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static WeatherStationPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, ice_staticId(), WeatherStationPrx.class, _WeatherStationPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static WeatherStationPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, context, ice_staticId(), WeatherStationPrx.class, _WeatherStationPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @return A proxy for this type.
     **/
    static WeatherStationPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, WeatherStationPrx.class, _WeatherStationPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type.
     **/
    static WeatherStationPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, facet, WeatherStationPrx.class, _WeatherStationPrxI.class);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the per-proxy context.
     * @param newContext The context for the new proxy.
     * @return A proxy with the specified per-proxy context.
     **/
    @Override
    default WeatherStationPrx ice_context(java.util.Map<String, String> newContext)
    {
        return (WeatherStationPrx)_ice_context(newContext);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the adapter ID.
     * @param newAdapterId The adapter ID for the new proxy.
     * @return A proxy with the specified adapter ID.
     **/
    @Override
    default WeatherStationPrx ice_adapterId(String newAdapterId)
    {
        return (WeatherStationPrx)_ice_adapterId(newAdapterId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoints.
     * @param newEndpoints The endpoints for the new proxy.
     * @return A proxy with the specified endpoints.
     **/
    @Override
    default WeatherStationPrx ice_endpoints(com.zeroc.Ice.Endpoint[] newEndpoints)
    {
        return (WeatherStationPrx)_ice_endpoints(newEndpoints);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator cache timeout.
     * @param newTimeout The new locator cache timeout (in seconds).
     * @return A proxy with the specified locator cache timeout.
     **/
    @Override
    default WeatherStationPrx ice_locatorCacheTimeout(int newTimeout)
    {
        return (WeatherStationPrx)_ice_locatorCacheTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the invocation timeout.
     * @param newTimeout The new invocation timeout (in seconds).
     * @return A proxy with the specified invocation timeout.
     **/
    @Override
    default WeatherStationPrx ice_invocationTimeout(int newTimeout)
    {
        return (WeatherStationPrx)_ice_invocationTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for connection caching.
     * @param newCache <code>true</code> if the new proxy should cache connections; <code>false</code> otherwise.
     * @return A proxy with the specified caching policy.
     **/
    @Override
    default WeatherStationPrx ice_connectionCached(boolean newCache)
    {
        return (WeatherStationPrx)_ice_connectionCached(newCache);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoint selection policy.
     * @param newType The new endpoint selection policy.
     * @return A proxy with the specified endpoint selection policy.
     **/
    @Override
    default WeatherStationPrx ice_endpointSelection(com.zeroc.Ice.EndpointSelectionType newType)
    {
        return (WeatherStationPrx)_ice_endpointSelection(newType);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for how it selects endpoints.
     * @param b If <code>b</code> is <code>true</code>, only endpoints that use a secure transport are
     * used by the new proxy. If <code>b</code> is false, the returned proxy uses both secure and
     * insecure endpoints.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default WeatherStationPrx ice_secure(boolean b)
    {
        return (WeatherStationPrx)_ice_secure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the encoding used to marshal parameters.
     * @param e The encoding version to use to marshal request parameters.
     * @return A proxy with the specified encoding version.
     **/
    @Override
    default WeatherStationPrx ice_encodingVersion(com.zeroc.Ice.EncodingVersion e)
    {
        return (WeatherStationPrx)_ice_encodingVersion(e);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its endpoint selection policy.
     * @param b If <code>b</code> is <code>true</code>, the new proxy will use secure endpoints for invocations
     * and only use insecure endpoints if an invocation cannot be made via secure endpoints. If <code>b</code> is
     * <code>false</code>, the proxy prefers insecure endpoints to secure ones.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default WeatherStationPrx ice_preferSecure(boolean b)
    {
        return (WeatherStationPrx)_ice_preferSecure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the router.
     * @param router The router for the new proxy.
     * @return A proxy with the specified router.
     **/
    @Override
    default WeatherStationPrx ice_router(com.zeroc.Ice.RouterPrx router)
    {
        return (WeatherStationPrx)_ice_router(router);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator.
     * @param locator The locator for the new proxy.
     * @return A proxy with the specified locator.
     **/
    @Override
    default WeatherStationPrx ice_locator(com.zeroc.Ice.LocatorPrx locator)
    {
        return (WeatherStationPrx)_ice_locator(locator);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for collocation optimization.
     * @param b <code>true</code> if the new proxy enables collocation optimization; <code>false</code> otherwise.
     * @return A proxy with the specified collocation optimization.
     **/
    @Override
    default WeatherStationPrx ice_collocationOptimized(boolean b)
    {
        return (WeatherStationPrx)_ice_collocationOptimized(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses twoway invocations.
     * @return A proxy that uses twoway invocations.
     **/
    @Override
    default WeatherStationPrx ice_twoway()
    {
        return (WeatherStationPrx)_ice_twoway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses oneway invocations.
     * @return A proxy that uses oneway invocations.
     **/
    @Override
    default WeatherStationPrx ice_oneway()
    {
        return (WeatherStationPrx)_ice_oneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch oneway invocations.
     * @return A proxy that uses batch oneway invocations.
     **/
    @Override
    default WeatherStationPrx ice_batchOneway()
    {
        return (WeatherStationPrx)_ice_batchOneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses datagram invocations.
     * @return A proxy that uses datagram invocations.
     **/
    @Override
    default WeatherStationPrx ice_datagram()
    {
        return (WeatherStationPrx)_ice_datagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch datagram invocations.
     * @return A proxy that uses batch datagram invocations.
     **/
    @Override
    default WeatherStationPrx ice_batchDatagram()
    {
        return (WeatherStationPrx)_ice_batchDatagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, except for compression.
     * @param co <code>true</code> enables compression for the new proxy; <code>false</code> disables compression.
     * @return A proxy with the specified compression setting.
     **/
    @Override
    default WeatherStationPrx ice_compress(boolean co)
    {
        return (WeatherStationPrx)_ice_compress(co);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection timeout setting.
     * @param t The connection timeout for the proxy in milliseconds.
     * @return A proxy with the specified timeout.
     **/
    @Override
    default WeatherStationPrx ice_timeout(int t)
    {
        return (WeatherStationPrx)_ice_timeout(t);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection ID.
     * @param connectionId The connection ID for the new proxy. An empty string removes the connection ID.
     * @return A proxy with the specified connection ID.
     **/
    @Override
    default WeatherStationPrx ice_connectionId(String connectionId)
    {
        return (WeatherStationPrx)_ice_connectionId(connectionId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except it's a fixed proxy bound
     * the given connection.@param connection The fixed proxy connection.
     * @return A fixed proxy bound to the given connection.
     **/
    @Override
    default WeatherStationPrx ice_fixed(com.zeroc.Ice.Connection connection)
    {
        return (WeatherStationPrx)_ice_fixed(connection);
    }

    static String ice_staticId()
    {
        return "::smarthome::WeatherStation";
    }
}