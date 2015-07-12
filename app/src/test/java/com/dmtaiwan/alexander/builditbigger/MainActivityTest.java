package com.dmtaiwan.alexander.builditbigger;

import junit.framework.TestCase;

/**
 * Created by Alexander on 7/12/2015.
 */
public class MainActivityTest extends TestCase {

    public void testTestString() throws Exception {
        MainActivity mainActivity = new MainActivity();
        assert mainActivity.resultString()== null;
    }
}