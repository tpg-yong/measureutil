/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tpg.measuretool;

import java.lang.reflect.Method;

/**
 * A utility to measure the time taken of method(s) of a class.
 *
 */
public class MeasureUtil {

    /**
     * Measures the time taken for a {@code method} of a {@code clazz}.
     *
     * @param clazz targeted {@code Class} to be tested
     * @param method targeted {@code method} of {@code clazz} to be tested
     * @return time taken in millisesconds
     */
    public static long measure(Class clazz, String method) {
        try {
            Object object = clazz.newInstance();
            Method m = clazz.getDeclaredMethod(method); // assume method dont have parameter
            long start = System.currentTimeMillis();
            m.invoke(object);
            return System.currentTimeMillis() - start;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0l;
    }

    public static void main(String[] args) {
        System.out.println("Time taken: " + MeasureUtil.measure(Test.class, "test") + "ms");
    }
}
