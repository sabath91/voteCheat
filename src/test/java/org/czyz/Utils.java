package org.czyz;

import static org.junit.jupiter.api.Assertions.fail;

public class Utils {

    public static final String DESTINATION_URL = "https://www.portalsamorzadowy.pl/wybory-2018/kandydat/bogdan-czyz,84720,7.html";

    private static final int SLEEP_PERIOD_IN_MILLISECONDS = 3000;

    public static void sleepABit() {
        try {
            Thread.sleep(SLEEP_PERIOD_IN_MILLISECONDS);
        } catch (InterruptedException e) {
            fail("Sleeping interrupted");
        }
    }
}


