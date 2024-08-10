package org.example

class BTree<K, V> : Tree<K, V> where K : Comparable<K>, K : Number  {
    private inner class BTNIterator(root: BTNode<K, V>?)
        : Iterator<BTNode<K, V>> {
        private var ns = ArrayDeque<BTNode<K, V>>()

        init {
            collect(root)
        }

        override fun hasNext(): Boolean {
            return !ns.isEmpty()
        }

        override fun next(): BTNode<K, V> {
            val node = ns.removeLast()
            collect(node.right)
            return node
        }

        private fun collect(r : BTNode<K, V>?) {
            var n = r
            while (n != null) {
                ns.add(n)
                n = n.left
            }
        }
    }

    private var root : BTNode<K, V>? = null

    private fun insertNode(r : BTNode<K, V>?, n : BTNode<K, V>) : BTNode<K, V>{
        if (r == null)
            return n
        if (n.key < r.key)
            r.left = insertNode(r.left, n)
        else if (n.key > r.key)
            r.right = insertNode(r.right, n)
        else
            throw Exception("Key is already exists in tree!")
        return r
    }

    private fun removeNode(r : BTNode<K, V>?, k : K) : BTNode<K, V>? {
        if (r == null)
            return null
        if (k < r.key)
            r.left = removeNode(r.left, k)
        else if (k > r.key)
            r.right = removeNode(r.right, k)
        else {
            if (r.left == null)
                return r.right
            if (r.right == null)
                return r.left
            var current = r.right!!
            while (current.left != null)
                current = current.left!!
            r.key = current.key
            r.value = current.value
            r.right = removeNode(r.right, current.key)
        }
        return r
    }

    private fun findNode(r : BTNode<K, V>?, k : K) : BTNode<K, V>? {
        if (r == null)
            return null
        if (k < r.key)
            return findNode(r.left, k)
        else if (k > r.key)
            return findNode(r.right, k)
        return r
    }

    override fun add(k : K, value: V) {
        root = insertNode(root, BTNode(k, value))
    }

    override fun remove(k : K) {
        removeNode(root, k)
    }
    override fun find(k : K) : BTNode<K, V>? {
        return findNode(root, k)
    }

    override fun iterator(): Iterator<BTNode<K, V>> {
        return BTNIterator(root)
    }
}
