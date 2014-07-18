package com.github.ogstation.gas.station.helper;

public final class RestURIConstants
{
    // GlobalErrorHandlerController
    public static final String BAD_REQUEST_ERROR = "/api/error/400";
    public static final String UNAUTHORIZED_ERROR = "/api/error/401";
    public static final String FORBIDDEN_ERROR = "/api/error/403";
    public static final String NOT_FOUND_ERROR = "/api/error/404";
    public static final String METHOD_NOT_ALLOWED_ERROR = "/api/error/405";
    public static final String UNSUPPRTED_MEDIA_TYPE_ERROR = "/api/error/415";
    public static final String INTERNAL_ERROR = "/api/error/500";

    // GasStationController
    public static final String CREATE_STATION = "/api/stations";
    public static final String GET_ALL_STATION = "/api/stations";
    public static final String GET_STATION = "/api/stations/{id}";
    public static final String SEARCH_STATION = "/api/stations/search";
    public static final String UPDATE_STATION = "/api/stations/{id}";
    public static final String DELETE_STATION = "/api/stations/{id}";

    private RestURIConstants()
    {
    }
}
