package org.pg4200.ex06;

import org.pg4200.les06.hash.MyHashMap;

import java.lang.reflect.Array;

public class HashMapLinearProbe<K, V> implements MyHashMap<K, V> {

    private class Entry {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int M = 997;
    private int size = 0;

    private final Entry[] data = (Entry[]) Array.newInstance(Entry.class, M);

    @Override
    public void put(K key, V value) {
        int index = index(key);

        if (data[index] == null) {
            data[index] = new Entry(key, value);
            size++;
        } else {
            data[index].value = value;
        }
    }

    private int index(K key) {
        int positiveHash = key.hashCode() & 0x7f_ff_ff_ff;
        return positiveHash % M;
    }

    @Override
    public void delete(K key) throws NullPointerException {
        if (key == null) throw new NullPointerException();

        int index = index(key);

        if (data[index].value != null) {
            data[index].key = null;
            data[index].value = null;
            size--;
        }

        else {
            throw new NullPointerException("No such element");
        }
    }

    @Override
    public V get(K key) {

        if (key == null) throw new NullPointerException();

        int index = index(key);

        try {
            if (data[index].value != null) {
                return data[index].value;
            } else {
                return null;
            }
        }

        catch (NullPointerException npe) {
            return null;
        }

    }

    @Override
    public int size() {
        return size;
    }
}
