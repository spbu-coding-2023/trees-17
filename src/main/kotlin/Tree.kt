package org.example

interface Tree<K, V> : Iterable<BTNode<K, V>> where K : Comparable<K>, K : Number {
    fun add(k : K, value: V)
    fun remove(k : K)
    fun find(k : K) : BTNode<K, V>?
}
