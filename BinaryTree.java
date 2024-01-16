public class BinaryTree<ContentType> {

    private class BTNode {
        private ContentType content;
        private BinaryTree<ContentType> left, right;

        private BTNode(ContentType pContent) {
            this.content = pContent;
            left = new BinaryTree<ContentType>();
            right = new BinaryTree<ContentType>();
        }
    }

    private BTNode node;

    public BinaryTree() {
        this.node = null;
    }

    public BinaryTree(ContentType pContent) {
        if (pContent != null) {
            this.node = new BTNode(pContent);
        } else {
            this.node = null;
        }
    }

    public BinaryTree(ContentType pContent, BinaryTree<ContentType> pLeftTree, BinaryTree<ContentType> pRightTree) {
        if (pContent != null) {
            this.node = new BTNode(pContent);
            if (pLeftTree != null) {
                this.node.left = pLeftTree;
            } else {
                this.node.left = new BinaryTree<ContentType>();
            }
            if (pRightTree != null) {
                this.node.right = pRightTree;
            } else {
                this.node.right = new BinaryTree<ContentType>();
            }
        } else {
            this.node = null;
        }
    }

    public boolean isEmpty() {
        return this.node == null;
    }

    public void setContent(ContentType pContent) {
        if (pContent != null) {
            if (this.isEmpty()) {
                node = new BTNode(pContent);
                this.node.left = new BinaryTree<ContentType>();
                this.node.right = new BinaryTree<ContentType>();
            }
            this.node.content = pContent;
        }
    }

    public ContentType getContent() {
        if (this.isEmpty()) {
            return null;
        } else {
            return this.node.content;
        }
    }

    public void setLeftTree(BinaryTree<ContentType> pTree) {
        if (!this.isEmpty() && pTree != null) {
            this.node.left = pTree;
        }
    }

    public void setRightTree(BinaryTree<ContentType> pTree) {
        if (!this.isEmpty() && pTree != null) {
            this.node.right = pTree;
        }
    }

    public BinaryTree<ContentType> getLeftTree() {
        if (!this.isEmpty()) {
            return this.node.left;
        } else {
            return null;
        }
    }

    public BinaryTree<ContentType> getRightTree() {
        if (!this.isEmpty()) {
            return this.node.right;
        } else {
            return null;
        }
    }
}
