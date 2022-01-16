package org.pg4200.ex06;

import org.pg4200.les06.hash.MyHashMap;
import org.pg4200.les06.hash.MyHashMapTestTemplate;

public class HashMapLinearProbeTest extends MyHashMapTestTemplate {
    @Override
    protected <K, V> MyHashMap<K, V> getInstance() {
        return new HashMapLinearProbe<>();
    }
}
