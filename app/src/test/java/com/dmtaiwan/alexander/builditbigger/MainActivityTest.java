package com.dmtaiwan.alexander.builditbigger;

import junit.framework.TestCase;

/**
 * Created by Alexander on 7/16/2015.
 */
public class MainActivityTest extends TestCase {


    public void testGetJoke() throws Exception {
        MainActivity mainActivity = new MainActivity();
        String joke = mainActivity.getJoke();
        assertNotNull(joke);
    }
}