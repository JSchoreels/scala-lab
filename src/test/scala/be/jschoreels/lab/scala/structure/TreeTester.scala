package be.jschoreels.lab.scala.structure

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TreeTester extends FunSuite {

    test("Create empty Tree") {
        val tree = Empty
        assert(tree === Empty)
    }

    test("Create Tree with simple node") {
        val node = Node(1, Empty, Empty)
        assert(node.value === 1)
        assert(node.left === Empty)
        assert(node.right === Empty)

    }

    test("Create complete 2-layer tree") {

        val left = Node(2,
            Empty,
            Empty)

        val right = Node(3,
            Empty,
            Empty)

        val tree = Node[Int](1, left, right);

        assert(tree.value === 1)
        assert(tree.left === left)
        assert(tree.right === right)
    }

}

@RunWith(classOf[JUnitRunner])
class TreeWalkerTest extends FunSuite {

    test("Walk through a tree with depth first") {
        val tree = Node[Int](1,
            Node(2,
                Empty,
                Node(4,
                    Node(5,
                        Empty,
                        Empty),
                    Empty)),
            Node(3,
                Empty,
                Empty));

        assert(TreeWalker.depthFirst(tree) === "12453")
        assert(TreeWalker.depthFirst(tree, emptyNodeSymbol = "x") === "12x45xxx3xx")
    }
}

@RunWith(classOf[JUnitRunner])
class TreePrinterTest extends FunSuite {

    test("Print a Tree") {
        val tree = Node[Int](1,
            Node(2,
                Empty,
                Node(4,
                    Node(5,
                        Empty,
                        Empty),
                    Empty)),
            Node(3,
                Empty,
                Empty));


        TreePrinter.print(tree);
    }

}
