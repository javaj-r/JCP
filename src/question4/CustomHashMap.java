package question4;

import java.util.*;

/**
 * @author javid
 * Created on 2/7/2022
 */
public class CustomHashMap<K, V> implements Map<K, V> {

    private final Set<Node<K, V>> entrySet = new HashSet<>();
    private final Set<K> keySet = new HashSet<>();

    @Override
    public int size() {
        return entrySet.size();
    }

    @Override
    public boolean isEmpty() {
        return entrySet.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return keySet.contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        for (Node<K, V> node : entrySet) {
            if (Objects.equals(node.value, value))
                return true;
        }
        return false;
    }

    @Override
    public V get(Object key) {
        for (Node<K, V> node : entrySet) {
            if (Objects.equals(node.key, key)) {
                return node.value;
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        if (keySet.contains(key)) {
            for (Node<K, V> node : entrySet) {
                if (Objects.equals(node.key, key)) {
                    node.setValue(value);
                    return node.value;
                }
            }
        } else if (keySet.add(key)) {
            entrySet.add(new Node<>(key, value));
            return value;
        }
        return null;
    }

    @Override
    public V remove(Object key) {
        if (keySet.remove(key)) {
            Iterator<Node<K, V>> iterator = entrySet.iterator();
            while (iterator.hasNext()) {
                Node<K, V> node = iterator.next();
                if (Objects.equals(node.key, key)) {
                    V value = node.value;
                    iterator.remove();
                    return value;
                }
            }
        }

        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Entry<? extends K, ? extends V> e : m.entrySet()) {
            put(e.getKey(), e.getValue());
        }
    }

    @Override
    public void clear() {
        keySet.clear();
        entrySet.clear();
    }

    @Override
    public Set<K> keySet() {
        return new HashSet<>(keySet);
    }

    @Override
    public Collection<V> values() {
        List<V> valueList = new ArrayList<>();
        for (Node<K, V> node : entrySet) {
            valueList.add(node.value);
        }
        return valueList;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return new HashSet<>(entrySet);
    }

    @Override
    public String toString() {
        return "CustomHashMap"
               + entrySet;
    }

    static class Node<K, V> implements Map.Entry<K, V> {
        final K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public final K getKey() {
            return key;
        }

        @Override
        public final V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            this.value = value;
            return value;
        }

        @Override
        public final String toString() {
            return "[" + key + "=" + value + ']';
        }

        @Override
        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        @Override
        public final boolean equals(Object o) {
            if (o == this)
                return true;

            return o instanceof Map.Entry<?, ?> e
                   && Objects.equals(key, e.getKey())
                   && Objects.equals(value, e.getValue());
        }
    }
}
