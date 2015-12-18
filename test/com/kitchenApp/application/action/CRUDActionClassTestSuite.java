package com.kitchenApp.application.action;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Test Suite for CRUD action classes
 * @author afaherty
 * @version 1.0 on 12/17/2015
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        AddUserActionTest.class,
        UpdateUserActionTest.class
})
public class CRUDActionClassTestSuite {}