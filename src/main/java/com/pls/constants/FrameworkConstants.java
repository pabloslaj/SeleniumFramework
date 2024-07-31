package com.pls.constants;

import static com.pls.config.factory.ConfigFactory.getConfig;

public final class FrameworkConstants {

    private static final int EXPLICIT_WAIT = 30;
    private static final String CONFIG_FILE_PATH = System.getProperty("user.dir") + "/src/test/resources/config/config.properties";
    private static final String EXTENT_REPORT_FOLDER_PATH = System.getProperty("user.dir") + "/extent-test-output/";
    private static final String EXCEL_PATH = getConfig().sheetPath();
    private static final String RUN_MANAGER_SHEET = "RUNMANAGER";
    private static final String ITERATION_DATA_SHEET = "DATA";
    private static String extentReportFilePath = "";

    private FrameworkConstants() {
    }

    public static String getConfigFilePath() {
        return CONFIG_FILE_PATH;
    }

    public static String getExcelPath() {
        return EXCEL_PATH;
    }

    public static String getRunManagerSheet() {
        return RUN_MANAGER_SHEET;
    }

    public static String getIterationDataSheet() {
        return ITERATION_DATA_SHEET;
    }

    public static String getExtentReportFilePath() {
        if (extentReportFilePath.isEmpty()) {
            extentReportFilePath = createReportPath();
        }
        return extentReportFilePath;
    }

    private static String createReportPath() {
        return EXTENT_REPORT_FOLDER_PATH;
    }

    public static int getExplicitWait() {
        return EXPLICIT_WAIT;
    }

}
