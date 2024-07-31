package com.pls.config.factory;

import com.pls.config.ReportsConfig;
import org.aeonbits.owner.ConfigCache;

public final class ReportFactory {

    private ReportFactory() {
    }
    public static ReportsConfig getConfig() {
        return ConfigCache.getOrCreate(ReportsConfig.class);
    }
}

