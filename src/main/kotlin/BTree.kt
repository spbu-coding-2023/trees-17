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
    override fun add(k: K, value: V) {
        TODO("Not yet implemented")
    }

    override fun remove(k: K) {
        TODO("Not yet implemented")
    }

    override fun find(k: K): BTNode<K, V>? {
        TODO("Not yet implemented")
    }

    override fun iterator(): Iterator<BTNode<K, V>> {
        return BTNIterator(root)
    }
}
