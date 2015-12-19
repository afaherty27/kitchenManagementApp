package com.kitchenApp.database.dataAccess;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Test suite for classes in com.kitchenApp.database.dataAccess package
 * @author afaherty
 * @version 1.0 on 12/18/2015
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    RecipeDaoTest.class,
    UserDaoTest.class,
    UserRoleDaoTest.class
})
public class DataAccessPackageTestSuite {
}
