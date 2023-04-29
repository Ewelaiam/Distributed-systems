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

public interface AudioPrx extends com.zeroc.Ice.ObjectPrx
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

    default int getCurrentVolume()
        throws Error
    {
        return getCurrentVolume(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default int getCurrentVolume(java.util.Map<String, String> context)
        throws Error
    {
        try
        {
            return _iceI_getCurrentVolumeAsync(context, true).waitForResponseOrUserEx();
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

    default java.util.concurrent.CompletableFuture<java.lang.Integer> getCurrentVolumeAsync()
    {
        return _iceI_getCurrentVolumeAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<java.lang.Integer> getCurrentVolumeAsync(java.util.Map<String, String> context)
    {
        return _iceI_getCurrentVolumeAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<java.lang.Integer> _iceI_getCurrentVolumeAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<java.lang.Integer> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getCurrentVolume", com.zeroc.Ice.OperationMode.Idempotent, sync, _iceE_getCurrentVolume);
        f.invoke(true, context, null, null, istr -> {
                     int ret;
                     ret = istr.readInt();
                     return ret;
                 });
        return f;
    }

    /** @hidden */
    static final Class<?>[] _iceE_getCurrentVolume =
    {
        Error.class
    };

    default void turnUp()
        throws Error
    {
        turnUp(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void turnUp(java.util.Map<String, String> context)
        throws Error
    {
        try
        {
            _iceI_turnUpAsync(context, true).waitForResponseOrUserEx();
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

    default java.util.concurrent.CompletableFuture<Void> turnUpAsync()
    {
        return _iceI_turnUpAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> turnUpAsync(java.util.Map<String, String> context)
    {
        return _iceI_turnUpAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_turnUpAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "turnUp", null, sync, _iceE_turnUp);
        f.invoke(true, context, null, null, null);
        return f;
    }

    /** @hidden */
    static final Class<?>[] _iceE_turnUp =
    {
        Error.class
    };

    default void turnDown()
        throws Error
    {
        turnDown(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void turnDown(java.util.Map<String, String> context)
        throws Error
    {
        try
        {
            _iceI_turnDownAsync(context, true).waitForResponseOrUserEx();
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

    default java.util.concurrent.CompletableFuture<Void> turnDownAsync()
    {
        return _iceI_turnDownAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> turnDownAsync(java.util.Map<String, String> context)
    {
        return _iceI_turnDownAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_turnDownAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "turnDown", null, sync, _iceE_turnDown);
        f.invoke(true, context, null, null, null);
        return f;
    }

    /** @hidden */
    static final Class<?>[] _iceE_turnDown =
    {
        Error.class
    };

    default void turnOn()
    {
        turnOn(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void turnOn(java.util.Map<String, String> context)
    {
        _iceI_turnOnAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Void> turnOnAsync()
    {
        return _iceI_turnOnAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> turnOnAsync(java.util.Map<String, String> context)
    {
        return _iceI_turnOnAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_turnOnAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "turnOn", null, sync, null);
        f.invoke(false, context, null, null, null);
        return f;
    }

    default void turnOff()
    {
        turnOff(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void turnOff(java.util.Map<String, String> context)
    {
        _iceI_turnOffAsync(context, true).waitForResponse();
    }

    default java.util.concurrent.CompletableFuture<Void> turnOffAsync()
    {
        return _iceI_turnOffAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> turnOffAsync(java.util.Map<String, String> context)
    {
        return _iceI_turnOffAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_turnOffAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "turnOff", null, sync, null);
        f.invoke(false, context, null, null, null);
        return f;
    }

    default void startTrack()
        throws Error
    {
        startTrack(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void startTrack(java.util.Map<String, String> context)
        throws Error
    {
        try
        {
            _iceI_startTrackAsync(context, true).waitForResponseOrUserEx();
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

    default java.util.concurrent.CompletableFuture<Void> startTrackAsync()
    {
        return _iceI_startTrackAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> startTrackAsync(java.util.Map<String, String> context)
    {
        return _iceI_startTrackAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_startTrackAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "startTrack", null, sync, _iceE_startTrack);
        f.invoke(true, context, null, null, null);
        return f;
    }

    /** @hidden */
    static final Class<?>[] _iceE_startTrack =
    {
        Error.class
    };

    default String getTrackName()
        throws Error
    {
        return getTrackName(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default String getTrackName(java.util.Map<String, String> context)
        throws Error
    {
        try
        {
            return _iceI_getTrackNameAsync(context, true).waitForResponseOrUserEx();
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

    default java.util.concurrent.CompletableFuture<java.lang.String> getTrackNameAsync()
    {
        return _iceI_getTrackNameAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<java.lang.String> getTrackNameAsync(java.util.Map<String, String> context)
    {
        return _iceI_getTrackNameAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<java.lang.String> _iceI_getTrackNameAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<java.lang.String> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "getTrackName", null, sync, _iceE_getTrackName);
        f.invoke(true, context, null, null, istr -> {
                     String ret;
                     ret = istr.readString();
                     return ret;
                 });
        return f;
    }

    /** @hidden */
    static final Class<?>[] _iceE_getTrackName =
    {
        Error.class
    };

    default void stopTrack()
        throws Error
    {
        stopTrack(com.zeroc.Ice.ObjectPrx.noExplicitContext);
    }

    default void stopTrack(java.util.Map<String, String> context)
        throws Error
    {
        try
        {
            _iceI_stopTrackAsync(context, true).waitForResponseOrUserEx();
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

    default java.util.concurrent.CompletableFuture<Void> stopTrackAsync()
    {
        return _iceI_stopTrackAsync(com.zeroc.Ice.ObjectPrx.noExplicitContext, false);
    }

    default java.util.concurrent.CompletableFuture<Void> stopTrackAsync(java.util.Map<String, String> context)
    {
        return _iceI_stopTrackAsync(context, false);
    }

    /**
     * @hidden
     * @param context -
     * @param sync -
     * @return -
     **/
    default com.zeroc.IceInternal.OutgoingAsync<Void> _iceI_stopTrackAsync(java.util.Map<String, String> context, boolean sync)
    {
        com.zeroc.IceInternal.OutgoingAsync<Void> f = new com.zeroc.IceInternal.OutgoingAsync<>(this, "stopTrack", null, sync, _iceE_stopTrack);
        f.invoke(true, context, null, null, null);
        return f;
    }

    /** @hidden */
    static final Class<?>[] _iceE_stopTrack =
    {
        Error.class
    };

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static AudioPrx checkedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, ice_staticId(), AudioPrx.class, _AudioPrxI.class);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static AudioPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, context, ice_staticId(), AudioPrx.class, _AudioPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static AudioPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, ice_staticId(), AudioPrx.class, _AudioPrxI.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @param context The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    static AudioPrx checkedCast(com.zeroc.Ice.ObjectPrx obj, String facet, java.util.Map<String, String> context)
    {
        return com.zeroc.Ice.ObjectPrx._checkedCast(obj, facet, context, ice_staticId(), AudioPrx.class, _AudioPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @return A proxy for this type.
     **/
    static AudioPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, AudioPrx.class, _AudioPrxI.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param obj The untyped proxy.
     * @param facet The name of the desired facet.
     * @return A proxy for this type.
     **/
    static AudioPrx uncheckedCast(com.zeroc.Ice.ObjectPrx obj, String facet)
    {
        return com.zeroc.Ice.ObjectPrx._uncheckedCast(obj, facet, AudioPrx.class, _AudioPrxI.class);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the per-proxy context.
     * @param newContext The context for the new proxy.
     * @return A proxy with the specified per-proxy context.
     **/
    @Override
    default AudioPrx ice_context(java.util.Map<String, String> newContext)
    {
        return (AudioPrx)_ice_context(newContext);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the adapter ID.
     * @param newAdapterId The adapter ID for the new proxy.
     * @return A proxy with the specified adapter ID.
     **/
    @Override
    default AudioPrx ice_adapterId(String newAdapterId)
    {
        return (AudioPrx)_ice_adapterId(newAdapterId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoints.
     * @param newEndpoints The endpoints for the new proxy.
     * @return A proxy with the specified endpoints.
     **/
    @Override
    default AudioPrx ice_endpoints(com.zeroc.Ice.Endpoint[] newEndpoints)
    {
        return (AudioPrx)_ice_endpoints(newEndpoints);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator cache timeout.
     * @param newTimeout The new locator cache timeout (in seconds).
     * @return A proxy with the specified locator cache timeout.
     **/
    @Override
    default AudioPrx ice_locatorCacheTimeout(int newTimeout)
    {
        return (AudioPrx)_ice_locatorCacheTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the invocation timeout.
     * @param newTimeout The new invocation timeout (in seconds).
     * @return A proxy with the specified invocation timeout.
     **/
    @Override
    default AudioPrx ice_invocationTimeout(int newTimeout)
    {
        return (AudioPrx)_ice_invocationTimeout(newTimeout);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for connection caching.
     * @param newCache <code>true</code> if the new proxy should cache connections; <code>false</code> otherwise.
     * @return A proxy with the specified caching policy.
     **/
    @Override
    default AudioPrx ice_connectionCached(boolean newCache)
    {
        return (AudioPrx)_ice_connectionCached(newCache);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the endpoint selection policy.
     * @param newType The new endpoint selection policy.
     * @return A proxy with the specified endpoint selection policy.
     **/
    @Override
    default AudioPrx ice_endpointSelection(com.zeroc.Ice.EndpointSelectionType newType)
    {
        return (AudioPrx)_ice_endpointSelection(newType);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for how it selects endpoints.
     * @param b If <code>b</code> is <code>true</code>, only endpoints that use a secure transport are
     * used by the new proxy. If <code>b</code> is false, the returned proxy uses both secure and
     * insecure endpoints.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default AudioPrx ice_secure(boolean b)
    {
        return (AudioPrx)_ice_secure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the encoding used to marshal parameters.
     * @param e The encoding version to use to marshal request parameters.
     * @return A proxy with the specified encoding version.
     **/
    @Override
    default AudioPrx ice_encodingVersion(com.zeroc.Ice.EncodingVersion e)
    {
        return (AudioPrx)_ice_encodingVersion(e);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its endpoint selection policy.
     * @param b If <code>b</code> is <code>true</code>, the new proxy will use secure endpoints for invocations
     * and only use insecure endpoints if an invocation cannot be made via secure endpoints. If <code>b</code> is
     * <code>false</code>, the proxy prefers insecure endpoints to secure ones.
     * @return A proxy with the specified selection policy.
     **/
    @Override
    default AudioPrx ice_preferSecure(boolean b)
    {
        return (AudioPrx)_ice_preferSecure(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the router.
     * @param router The router for the new proxy.
     * @return A proxy with the specified router.
     **/
    @Override
    default AudioPrx ice_router(com.zeroc.Ice.RouterPrx router)
    {
        return (AudioPrx)_ice_router(router);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for the locator.
     * @param locator The locator for the new proxy.
     * @return A proxy with the specified locator.
     **/
    @Override
    default AudioPrx ice_locator(com.zeroc.Ice.LocatorPrx locator)
    {
        return (AudioPrx)_ice_locator(locator);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for collocation optimization.
     * @param b <code>true</code> if the new proxy enables collocation optimization; <code>false</code> otherwise.
     * @return A proxy with the specified collocation optimization.
     **/
    @Override
    default AudioPrx ice_collocationOptimized(boolean b)
    {
        return (AudioPrx)_ice_collocationOptimized(b);
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses twoway invocations.
     * @return A proxy that uses twoway invocations.
     **/
    @Override
    default AudioPrx ice_twoway()
    {
        return (AudioPrx)_ice_twoway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses oneway invocations.
     * @return A proxy that uses oneway invocations.
     **/
    @Override
    default AudioPrx ice_oneway()
    {
        return (AudioPrx)_ice_oneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch oneway invocations.
     * @return A proxy that uses batch oneway invocations.
     **/
    @Override
    default AudioPrx ice_batchOneway()
    {
        return (AudioPrx)_ice_batchOneway();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses datagram invocations.
     * @return A proxy that uses datagram invocations.
     **/
    @Override
    default AudioPrx ice_datagram()
    {
        return (AudioPrx)_ice_datagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, but uses batch datagram invocations.
     * @return A proxy that uses batch datagram invocations.
     **/
    @Override
    default AudioPrx ice_batchDatagram()
    {
        return (AudioPrx)_ice_batchDatagram();
    }

    /**
     * Returns a proxy that is identical to this proxy, except for compression.
     * @param co <code>true</code> enables compression for the new proxy; <code>false</code> disables compression.
     * @return A proxy with the specified compression setting.
     **/
    @Override
    default AudioPrx ice_compress(boolean co)
    {
        return (AudioPrx)_ice_compress(co);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection timeout setting.
     * @param t The connection timeout for the proxy in milliseconds.
     * @return A proxy with the specified timeout.
     **/
    @Override
    default AudioPrx ice_timeout(int t)
    {
        return (AudioPrx)_ice_timeout(t);
    }

    /**
     * Returns a proxy that is identical to this proxy, except for its connection ID.
     * @param connectionId The connection ID for the new proxy. An empty string removes the connection ID.
     * @return A proxy with the specified connection ID.
     **/
    @Override
    default AudioPrx ice_connectionId(String connectionId)
    {
        return (AudioPrx)_ice_connectionId(connectionId);
    }

    /**
     * Returns a proxy that is identical to this proxy, except it's a fixed proxy bound
     * the given connection.@param connection The fixed proxy connection.
     * @return A fixed proxy bound to the given connection.
     **/
    @Override
    default AudioPrx ice_fixed(com.zeroc.Ice.Connection connection)
    {
        return (AudioPrx)_ice_fixed(connection);
    }

    static String ice_staticId()
    {
        return "::smarthome::Audio";
    }
}