package inClass;
public class binarySearchTree
{
    int data;
    binarySearchTree parent;
    binarySearchTree left;
    binarySearchTree right;

    public binarySearchTree(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public binarySearchTree()
    {
    }
}

