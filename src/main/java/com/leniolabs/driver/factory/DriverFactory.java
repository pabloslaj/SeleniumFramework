package com.leniolabs.driver.factory;

import com.leniolabs.driver.IWebDriver;
import com.leniolabs.driver.LocalWebDriverImpl;
import com.leniolabs.enums.RunMode;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class DriverFactory {

    private DriverFactory() {
    }

    private static Map<RunMode, Supplier<IWebDriver>> WEB = new EnumMap<>(RunMode.class);

    static {
        WEB.put(RunMode.LOCAL, LocalWebDriverImpl::new);
    }

    public static IWebDriver getDriver(RunMode runModeType) {
        return WEB.get(runModeType).get();
    }

}
