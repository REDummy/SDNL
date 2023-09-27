public class Tree {
    private TreeNode root;
    private int size;

    public Tree(){
        this.root = null;
        this.size = 0;
    }

    public TreeNode insert(int data){
        if (root==null){
            root= new TreeNode(data);

        }else {
            TreeNode bantuNode = new TreeNode(data);
            TreeNode ini=root;
            while (true){
                if (ini)
            }
        }
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
