package integrationtest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        IT_StatusApi.class,
        IT_RegistrationApi.class
})
public class A_Suite {

    @BeforeClass
    public static void setUp() {
        Server.start();
    }

    @AfterClass
    public static void tearDown() {
        Server.stop();
    }
}
