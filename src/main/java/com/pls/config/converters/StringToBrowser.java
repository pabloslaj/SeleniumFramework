package com.pls.config.converters;

import com.pls.enums.BrowserType;
import org.aeonbits.owner.Converter;
import java.lang.reflect.Method;

public class StringToBrowser implements Converter<BrowserType> {

    @Override
    public BrowserType convert(Method method, String browserName) {
        return BrowserType.valueOf(browserName.toUpperCase());
    }
}
