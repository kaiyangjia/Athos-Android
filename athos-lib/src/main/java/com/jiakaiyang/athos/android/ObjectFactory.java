package com.jiakaiyang.athos.android;

import android.util.Log;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by jia on 2017/10/10.
 */

public class ObjectFactory {
    private static final String TAG = "ObjectFactory";

    public Object createObject(Class targetClass, Object[] args) {
        // TODO: 2017/10/11 check params

        int length = args.length;
        Class[] paramsTypes = new Class[length];
        for (int i = 0; i < length; i++) {
            paramsTypes[i] = args[i].getClass();
        }

        try {
            Constructor constructor = targetClass.getDeclaredConstructor(paramsTypes);
            return constructor.newInstance(args);
        } catch (NoSuchMethodException e) {
            Log.e(TAG, "createObject NoSuchMethodException error: " + e.getMessage());
        } catch (IllegalAccessException e) {
            Log.e(TAG, "createObject IllegalAccessException error: " + e.getMessage());
        } catch (InstantiationException e) {
            Log.e(TAG, "createObject InstantiationException error: " + e.getMessage());
        } catch (InvocationTargetException e) {
            Log.e(TAG, "createObject InvocationTargetException error: " + e.getMessage());
        }

        return null;
    }
}
