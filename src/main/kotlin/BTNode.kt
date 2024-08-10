package org.example

class BTNode<K, V>(
    var key: K, var value: V,
    var left: BTNode<K, V>? = null,
    var right: BTNode<K, V>? = null
)
        where K : Comparable<K>, K : Number
