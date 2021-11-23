public class BST {
    /* Class containing left
       and right child of current node
     * and key value*/
    class Node
    {
        String key;
        Node left, right;

        public Node(String item)
        {
            key = item;
            left = right = null;
        }
    }

    // Root of BST
    Node root;

    // Constructor
   BST()
    {
        root = null;
    }

    // This method mainly calls insertRec()
    void insert(String key)
    {
        root = insertRec(root, key);
    }

    /* A recursive function to
       insert a new key in BST */
    Node insertRec(Node root, String key) {
        //tree is empty
        if (root == null) {
            root = new Node(key);
            return root;
        }
        //traverse the tree
        if (key.compareTo(root.key) < 0)     //insert in the left subtree
            root.left =insertRec(root.left, key);
        else if (key.compareTo(root.key) > 0)    //insert in the right subtree
            root.right = insertRec(root.right, key);
        // return pointer
        return root;
    }

    // This method mainly calls InorderRec()
    void inorder()
    {
        System.out.println("---------------------------");
        System.out.println("BST: ");
        inorderRec(root);
        System.out.println("---------------------------");
    }

    // A utility function to
    // do inorder traversal of BST
    void inorderRec(Node root)
    {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key + " ");
            inorderRec(root.right);
        }
    }

    boolean search(String key)
    {
        Node node1=search_recurisve(root,key);
        if(node1!=null)
            return true;
        else
            return false;
    }

    Node search_recurisve(Node root,String key)
    {
        if(root==null || root.key.equals(key))
            return root;

        if(root.key.compareTo(key)>=0)
            return search_recurisve(root.left,key);
        return  search_recurisve(root.right,key);
    }
    // Driver Code

}
