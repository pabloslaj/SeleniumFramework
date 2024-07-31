package com.pls.config.converters;

import com.pls.enums.BrowserRemoteModeType;
import org.aeonbits.owner.Converter;
import java.lang.reflect.Method;

public class StringToRemoteModeBrowserType implements Converter<BrowserRemoteModeType> {

    @Override
    public BrowserRemoteModeType convert(Method method, String remoteMode) {
        return BrowserRemoteModeType.valueOf(remoteMode.toUpperCase());
    }
}
