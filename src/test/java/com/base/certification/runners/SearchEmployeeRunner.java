package com.base.certification.runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;

@Suite
@IncludeEngines("cucumber")
@ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "src/test/resources/features/pim/search_employee.feature")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.base.certification.stepdefinitions")
public class SearchEmployeeRunner {
}