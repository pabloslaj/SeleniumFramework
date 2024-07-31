package com.pls.driver.factory;

import com.pls.driver.IWebDriver;
import com.pls.driver.LocalWebDriverImpl;
import com.pls.enums.RunMode;

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
