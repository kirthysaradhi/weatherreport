/*******************************************************************************
 * Project Weather Report
 * Copyright (c) 2019 Infodrive
 * All rights reserved.
 *******************************************************************************/
/**
 * 
 */
package com.infodrive.weather.boot;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * The Class ThreadStore.
 */
public class ThreadStore {

    /**
     * The Class ThreadStoreLocal.
     *
     * @param <K> the key type
     */
    private abstract static class ThreadStoreLocal<K> extends ThreadLocal<K> {

        /**
         * Gets the copy of context map.
         *
         * @return the copy of context map
         */
        public abstract K getCopyOfContextMap();
    }

    /** The Constant STORE. */
    private static final ThreadStoreLocal<Map<Object, Object>> STORE = new ThreadStoreLocal<Map<Object, Object>>() {

        /** The local map. */
        private Map<Object, Object> localMap = new HashMap<>();

        /*
         * (non-Javadoc)
         * 
         * @see java.lang.ThreadLocal#initialValue()
         */
        @Override
        protected Map<Object, Object> initialValue() {
            Map<Object, Object> localMap = new HashMap<>();
            // Initializing thread store with map
            return localMap;
        }

        /**
         * Gets the copy of context map.
         *
         * @return the copy of context map
         */
        @Override
        public Map<Object, Object> getCopyOfContextMap() {
            // TODO: find a way to retrieve the map from the thread
            return Collections.unmodifiableMap(localMap);
        }
    };

    /**
     * Gets the object from the store.
     *
     * @param key the key
     * @return the object
     */
    public static Object get(Object key) {
        return STORE.get().get(key);
    }

    /**
     * Put an object into the Store.
     *
     * @param key the key
     * @param value the value
     * @return the object
     */
    public static Object put(Object key, Object value) {
        return STORE.get().put(key, value);
    }

    /**
     * Removes the object from the Store.
     *
     * @param key the key
     * @return the object
     */
    public static Object remove(Object key) {
        return STORE.get().remove(key);
    }

    /**
     * Gets the copy of context map.
     *
     * @return the copy of context map
     */
    public static Map<Object, Object> getCopyOfContextMap() {
        return STORE.getCopyOfContextMap();
    }

    /**
     * Clears the Store.
     */
    public static void clear() {
        // Clearing Store
        STORE.get().clear();
        STORE.remove();
    }
}
