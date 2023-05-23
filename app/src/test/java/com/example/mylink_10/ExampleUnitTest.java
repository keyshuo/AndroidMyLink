package com.example.mylink_10;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.mylink_10.util.HttpRequestUtil;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testSend() throws MalformedURLException {
        String get = HttpRequestUtil.sendHttpRequest("GET", null, "https://www.baidu.com");
        System.out.println(get);
    }
}