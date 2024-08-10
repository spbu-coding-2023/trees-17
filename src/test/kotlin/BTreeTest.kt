import org.example.BTree
import org.example.main
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class BTreeTest {
    private fun countNodes(tree : BTree<Int, String>) : Int {
        var count = 0
        for (n in tree)
            count++
        return count
    }

    private fun fillMixed(tree : BTree<Int, String>) {
        tree.add(4, "four")
        tree.add(2, "two")
        tree.add(1, "one")
        tree.add(3, "three")
        tree.add(5, "five")
        tree.add(6, "six")
        tree.add(7, "seven")
    }

    private fun fillMixed2(tree : BTree<Int, String>) {
        tree.add(6, "four")
        tree.add(2, "two")
        tree.add(1, "one")
        tree.add(4, "four")
        tree.add(3, "three")
        tree.add(5, "five")
        tree.add(7, "seven")
    }

    private fun fillOnlyRightChild(tree : BTree<Int, String>) {
        tree.add(1, "one")
        tree.add(2, "two")
        tree.add(3, "three")
    }

    private fun fillOnlyLeftChild(tree : BTree<Int, String>) {
        tree.add(3, "three")
        tree.add(2, "two")
        tree.add(1, "one")
    }

    @Test
    fun addOneElement() {
        val tree = BTree<Int, String>()
        tree.add(1, "one")
        assertEquals(1, countNodes(tree))
        val n = tree.find(1)
        assertEquals(1, n?.key)
        assertEquals("one", n?.value)
    }

    @Test
    fun addDecreasingSequence() {
        val tree = BTree<Int, String>()
        tree.add(5, "five")
        tree.add(4, "four")
        tree.add(3, "three")
        assertEquals(3, countNodes(tree))
        val n1 = tree.find(3)
        assertEquals(3, n1?.key)
        assertEquals("three", n1?.value)
        val n2 = tree.find(4)
        assertEquals(4, n2?.key)
        assertEquals("four", n2?.value)
        val n3 = tree.find(5)
        assertEquals(5, n3?.key)
        assertEquals("five", n3?.value)
    }

    @Test
    fun addIncreasingSequence() {
        val tree = BTree<Int, String>()
        tree.add(1, "one")
        tree.add(2, "two")
        tree.add(3, "three")
        assertEquals(3, countNodes(tree))
        val n1 = tree.find(1)
        assertEquals(1, n1?.key)
        assertEquals("one", n1?.value)
        val n2 = tree.find(2)
        assertEquals(n2?.key, 2)
        assertEquals("two", n2?.value)
        val n3 = tree.find(3)
        assertEquals(3, n3?.key)
        assertEquals("three", n3?.value)
    }

    @Test
    fun addMixedSequence() {
        val tree = BTree<Int, String>()
        fillMixed(tree)
        assertEquals(7, countNodes(tree))
        for (n in tree)
            assertEquals(n.key, n.key)
    }

    @Test
    fun addDuplicateKeys() {
        val tree = BTree<Int, String>()
        tree.add(1, "qwe")
        assertThrows(Exception::class.java) {
            tree.add(1, "gdy")
        }
    }

    @Test
    fun mainTest() {
        main()
    }
}
