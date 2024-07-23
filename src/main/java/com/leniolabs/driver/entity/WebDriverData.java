package com.leniolabs.driver.entity;

import com.leniolabs.enums.BrowserRemoteModeType;
import com.leniolabs.enums.BrowserType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class WebDriverData {

    private BrowserType browserType;
    private BrowserRemoteModeType browserRemoteModeType;

}