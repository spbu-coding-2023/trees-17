package org.example

fun main() {
    val tree = BTree<Int, String>()
    tree.add(6, "six")
    tree.add(2, "two")
    tree.add(1, "one")
    tree.add(4, "four")
    tree.add(3, "three")
    tree.add(5, "five")
    tree.add(8, "eight")
    tree.add(7, "seven")

    print("Binary tree dfs: ")
    tree.dfs { n -> print("${n.key}:${n.value} ") }
    println()

    print("Binary tree bfs: ")
    tree.bfs { n -> print("${n.key}:${n.value} ") }
    println()

    print("Binary tree iteration: ")
    for (n in tree)
        print("${n.key}:${n.value} ")
    println()

    val node = tree.find(4)!!
    println("Find key = 4: '${node.value}'")

    print("Remove key = 2: ")
    tree.remove(2)
    for (n in tree)
        print("${n.key}:${n.value} ")

    tree.dfs()
    tree.bfs()

    val tree2 = BTree<Int, String>()

    tree2.dfs()
    tree2.bfs()
    tree2.find(1)
    tree2.remove(1)
    tree.find(2)
    tree.find(3)
    tree.find(4)
    tree.find(5)
    tree.remove(8)
    try {
        tree.add(1, "qwe")
    } catch (ex: Exception) {
        println(ex)
    }
}
