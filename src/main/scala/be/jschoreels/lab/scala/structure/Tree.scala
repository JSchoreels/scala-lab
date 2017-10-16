package be.jschoreels.lab.scala.structure

abstract class Tree;

case class Node[T](value: T, left: Tree, right: Tree) extends Tree;

object Empty extends Tree;

object TreeWalker {

    def depthFirst(tree: Tree, emptyNodeSymbol: String = ""): String = {
        tree match {
            case Empty => emptyNodeSymbol;
            case Node(value, left, right) => value + depthFirst(left, emptyNodeSymbol = emptyNodeSymbol) + depthFirst(right, emptyNodeSymbol = emptyNodeSymbol)
        }
    }

}

object TreePrinter {


    def print(tree: Tree): Unit = {

        def iter(currentNode: Tree, depthLevel: Int): Unit = {
            currentNode match {
                case Node(value, left, right) => {
                    iter(left, depthLevel + 1);
                    println(" " * depthLevel + value.toString)
                    iter(right, depthLevel + 1);
                }
                case _ => println(" " * depthLevel + "x");
            }
        }

        iter(tree, 0)
    }

}