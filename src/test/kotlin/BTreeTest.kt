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
    fun mainTest() {
        main()
    }
}
