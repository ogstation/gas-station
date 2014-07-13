package com.github.ogstation.gas.station.controller;

import com.github.ogstation.gas.station.config.MessageResolver;
import com.github.ogstation.gas.station.domain.error.GlobalRestError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.github.ogstation.gas.station.helper.MessageCodes.GLOBAL_ERROR_400;
import static com.github.ogstation.gas.station.helper.MessageCodes.GLOBAL_ERROR_401;
import static com.github.ogstation.gas.station.helper.MessageCodes.GLOBAL_ERROR_403;
import static com.github.ogstation.gas.station.helper.MessageCodes.GLOBAL_ERROR_404;
import static com.github.ogstation.gas.station.helper.MessageCodes.GLOBAL_ERROR_405;
import static com.github.ogstation.gas.station.helper.MessageCodes.GLOBAL_ERROR_415;
import static com.github.ogstation.gas.station.helper.MessageCodes.GLOBAL_ERROR_500;
import static com.github.ogstation.gas.station.helper.RestURIConstants.BAD_REQUEST_ERROR;
import static com.github.ogstation.gas.station.helper.RestURIConstants.FORBIDDEN_ERROR;
import static com.github.ogstation.gas.station.helper.RestURIConstants.INTERNAL_ERROR;
import static com.github.ogstation.gas.station.helper.RestURIConstants.METHOD_NOT_ALLOWED_ERROR;
import static com.github.ogstation.gas.station.helper.RestURIConstants.NOT_FOUND_ERROR;
import static com.github.ogstation.gas.station.helper.RestURIConstants.UNAUTHORIZED_ERROR;
import static com.github.ogstation.gas.station.helper.RestURIConstants.UNSUPPRTED_MEDIA_TYPE_ERROR;

@RestController
public class GlobalErrorHandlerController
{
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalErrorHandlerController.class);
    private static final String BAD_REQUEST = "400";
    private static final String UNAUTHORIZED = "401";
    private static final String FORBIDDEN = "403";
    private static final String NOT_FOUND = "404";
    private static final String METHOD_NOT_ALLOWED = "405";
    private static final String UNSUPPRTED_MEDIA_TYPE = "415";
    private static final String INTERNAL = "500";

    @Autowired
    private MessageResolver messageResolver;

    @RequestMapping(BAD_REQUEST_ERROR)
    public GlobalRestError handle400Error()
    {
        return new GlobalRestError(BAD_REQUEST, messageResolver.getMessage(GLOBAL_ERROR_400));
    }

    @RequestMapping(UNAUTHORIZED_ERROR)
    public GlobalRestError handle401Error()
    {
        return new GlobalRestError(UNAUTHORIZED, messageResolver.getMessage(GLOBAL_ERROR_401));
    }

    @RequestMapping(FORBIDDEN_ERROR)
    public GlobalRestError handle403Error()
    {
        return new GlobalRestError(FORBIDDEN, messageResolver.getMessage(GLOBAL_ERROR_403));
    }

    @RequestMapping(NOT_FOUND_ERROR)
    public GlobalRestError handle404Error()
    {
        return new GlobalRestError(NOT_FOUND, messageResolver.getMessage(GLOBAL_ERROR_404));
    }

    @RequestMapping(METHOD_NOT_ALLOWED_ERROR)
    public GlobalRestError handle405Error()
    {
        return new GlobalRestError(METHOD_NOT_ALLOWED, messageResolver.getMessage(GLOBAL_ERROR_405));
    }

    @RequestMapping(UNSUPPRTED_MEDIA_TYPE_ERROR)
    public GlobalRestError handle415Error()
    {
        return new GlobalRestError(UNSUPPRTED_MEDIA_TYPE, messageResolver.getMessage(GLOBAL_ERROR_415));
    }

    @RequestMapping(INTERNAL_ERROR)
    public GlobalRestError handle500Error()
    {
        LOGGER.debug("500 internal error");
        return new GlobalRestError(INTERNAL, messageResolver.getMessage(GLOBAL_ERROR_500));
    }
}
