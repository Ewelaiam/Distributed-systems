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

public class Location implements java.lang.Cloneable,
                                 java.io.Serializable
{
    public double latitude;

    public double longitude;

    public Location()
    {
    }

    public Location(double latitude, double longitude)
    {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public boolean equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        Location r = null;
        if(rhs instanceof Location)
        {
            r = (Location)rhs;
        }

        if(r != null)
        {
            if(this.latitude != r.latitude)
            {
                return false;
            }
            if(this.longitude != r.longitude)
            {
                return false;
            }

            return true;
        }

        return false;
    }

    public int hashCode()
    {
        int h_ = 5381;
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, "::smarthome::Location");
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, latitude);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, longitude);
        return h_;
    }

    public Location clone()
    {
        Location c = null;
        try
        {
            c = (Location)super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return c;
    }

    public void ice_writeMembers(com.zeroc.Ice.OutputStream ostr)
    {
        ostr.writeDouble(this.latitude);
        ostr.writeDouble(this.longitude);
    }

    public void ice_readMembers(com.zeroc.Ice.InputStream istr)
    {
        this.latitude = istr.readDouble();
        this.longitude = istr.readDouble();
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, Location v)
    {
        if(v == null)
        {
            _nullMarshalValue.ice_writeMembers(ostr);
        }
        else
        {
            v.ice_writeMembers(ostr);
        }
    }

    static public Location ice_read(com.zeroc.Ice.InputStream istr)
    {
        Location v = new Location();
        v.ice_readMembers(istr);
        return v;
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, java.util.Optional<Location> v)
    {
        if(v != null && v.isPresent())
        {
            ice_write(ostr, tag, v.get());
        }
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, Location v)
    {
        if(ostr.writeOptional(tag, com.zeroc.Ice.OptionalFormat.VSize))
        {
            ostr.writeSize(16);
            ice_write(ostr, v);
        }
    }

    static public java.util.Optional<Location> ice_read(com.zeroc.Ice.InputStream istr, int tag)
    {
        if(istr.readOptional(tag, com.zeroc.Ice.OptionalFormat.VSize))
        {
            istr.skipSize();
            return java.util.Optional.of(Location.ice_read(istr));
        }
        else
        {
            return java.util.Optional.empty();
        }
    }

    private static final Location _nullMarshalValue = new Location();

    /** @hidden */
    public static final long serialVersionUID = -157383815248036109L;
}
