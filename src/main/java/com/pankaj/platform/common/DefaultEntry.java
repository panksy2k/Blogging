package com.pankaj.platform.common;

import java.util.Map;

/**
 * Created by pankajpardasani on 14/09/2016.
 */

public class DefaultEntry<K, V> implements Map.Entry<K, V> {
    private final K key;
    private final V value;

    public DefaultEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        throw new UnsupportedOperationException("read-only");
    }
}