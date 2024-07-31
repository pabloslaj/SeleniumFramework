package com.pls.config;

import com.pls.config.converters.StringToRemoteModeBrowserType;
import com.pls.config.converters.StringToRunMode;
import com.pls.config.converters.StringToURLConverter;
import com.pls.enums.RunMode;
import com.pls.config.converters.StringToBooleanConverter;
import com.pls.enums.BrowserRemoteModeType;
import org.aeonbits.owner.Config;

import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:${user.dir}/src/test/resources/config/config.properties",
        "file:${user.dir}/src/test/resources/config/env/qa-config.properties",
        "file:${user.dir}/src/test/resources/config/env/dev-config.properties",
        "file:${user.dir}/src/test/resources/config/env/preprod-config.properties"
})
public interface FrameworkConfig extends Config {

    @Key("environment")
    @DefaultValue("qa")
    String environment();

    @Key("${environment}.url")
    String webUrl();

    @Key("${environment}.apiDomain")
    String apiDomain();

    @Key("${environment}.emailValidationPath")
    String emailValidationPath();

    @Key("remoteMode")
    @ConverterClass(StringToRemoteModeBrowserType.class)
    BrowserRemoteModeType browserRemoteMode();

    @DefaultValue("LOCAL")
    @Key("runMode")
    @ConverterClass(StringToRunMode.class)
    RunMode runMode();

    @Key("seleniumGridUrl")
    @ConverterClass(StringToURLConverter.class)
    URL seleniumGridURL();

    @Key("retryFailedTests")
    @ConverterClass(StringToBooleanConverter.class)
    Boolean retryFailedTests();

    @Key("${environment}.sheetPath")
    String sheetPath();
}
