# Дерева бинарного поиска
## Интерфейс Tree 
Содержит методы необходимые для взаимодействия с деревом, а именно добавления поиска и удаления элементов из дерева, наследует интерфейс Iterable – для реализации получения итератора и содержит ограничение параметра ключа: Comparable или число, необходимое для реализации бинарного дерева.

## Класс BTNode 
Узел дерева бинарного поиска, содержит ключ, значение и ссылки на дочерние левый и правый узлы.
## Класс BTree
Реализация дерева бинарного поиска, методы добавления поиска и удаления элементов, а также итератора **BTNIterator** для обхода дерева в ширину так как при данном обходе элементы следуют в порядке возрастания значения ключа.
Интерфейс взаимодействия с деревом бинарного поиска:
- fun add(key : K, value: V) - Добавление узла с ключом key и значением value
- fun remove(key : K) - Удаление узла с ключом key
- fun find(key : K) : BTNode<K, V>? - Поиск узла с ключом key
- fun dfs(operation: ((BTNode<K, V>) -> Unit)) - Обход дерева в глубину
    
## Класс тестирования BTreeTest
Класс тестирования BTreeTest – тистирование класса BTree, а именно его методов для добавления, поиска и удаления элементов, а также использования итератора. Реализованные тесты: 
- add - Тестирование метода добавления элемента
- remove - Тестирование метода удаление элемента по ключу
- find - Тестирование метода поиска элемента по ключу
- iterator - Тестирование итератора
