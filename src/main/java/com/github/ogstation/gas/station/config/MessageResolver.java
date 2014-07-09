package com.github.ogstation.gas.station.config;

public interface MessageResolver
{
    String getMessage(String code);

    String getMessage(String code, Object[] params);
}
