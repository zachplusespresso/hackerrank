import java.util.Scanner;

public class Solution {

    static class Node {
        int key;
        int value;
        Node left;
        Node right;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        void updateKey() {
            key = 1 + (left != null ? left.key : 0) + (right != null ? right.key : 0);
        }

        private static Node zig(Node parent, Node node) {
            if (parent != null) {
                if (node == parent.left) {
                    parent.left = node.right;
                    node.right = parent;
                } else if (node == parent.right) {
                    parent.right = node.left;
                    node.left = parent;
                } else {
                    throw new IllegalStateException();
                }
                parent.updateKey();
                node.updateKey();
            }
            return node;
        }

        static Node insert(Node parent, int key, int value) {
            if (parent == null) {
                parent = new Node(key, value);
            } else {
                Node node;
                if (key < parent.key) {
                    node = parent.left = insert(parent.left, key, value);
                } else {
                    node = parent.right = insert(parent.right, key, value);
                }
                parent = zig(parent, node);
            }
            return parent;
        }

        static Node findAndZig(Node parent, int key) {
            if (parent == null) {
                return null;
            } else {
                assert key <= parent.key;
                int parentKey = 1 + (parent.left != null ? parent.left.key : 0);
                if (key < parentKey) {
                    parent.left = findAndZig(parent.left, key);
                    return zig(parent, parent.left);
                } else if (key > parentKey) {
                    parent.right = findAndZig(parent.right, key - parentKey);
                    return zig(parent, parent.right);
                } else {
                    return parent;
                }
            }
        }

        static Node[] split(Node root, int key) {
            if (root == null) {
                return new Node[] {null, null};
            } else {
                if (1 <= key && key <= root.key) {
                    root = findAndZig(root, key);
                    if (root == null) {
                        return new Node[0];
                    } else {
                        Node left = root.left;
                        root.left = null;
                        if (left != null) {
                            root.key -= left.key;
                        }
                        return new Node[]{left, root};
                    }
                } else if (key == root.key + 1) {
                    return new Node[] {root, null};
                } else {
                    throw new IllegalArgumentException();
                }
            }
        }

        static Node[] split(Node root, int key1, int key2) {
            key1 = Math.min(key1, key2);
            key2 = Math.max(key1, key2);
            Node[] nodes = split(root, key2);
            Node node1 = nodes[1];
            nodes = split(nodes[0], key1);
            return new Node[] {nodes[0], nodes[1], node1};
        }

        @SuppressWarnings("ConstantConditions")
        static Node merge(Node root1, Node root2) {
            if (root1 == null) {
                return root2;
            }
            if (root2 == null) {
                return root1;
            }
            root1 = findAndZig(root1, root1.key);
            root1.right = root2;
            root1.key += root2.key;
            return root1;
        }

        static Node merge(Node root1, Node root2, Node root3) {
            return merge(merge(root1, root2), root3);
        }

        static Node find(Node parent, int key) {
            if (parent == null) {
                return null;
            } else {
                assert key <= parent.key;
                int parentKey = 1 + (parent.left != null ? parent.left.key : 0);
                if (key < parentKey) {
                    return find(parent.left, key);
                } else if (key > parentKey) {
                    return find(parent.right, key - parentKey);
                } else {
                    return parent;
                }
            }
        }

        @Override
        public String toString() {
            return (left != null ? left.toString() : "") + value + " " + (right != null ? right.toString() : "");
        }
    }

    @SuppressWarnings("ConstantConditions")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        Node root = null;
        for (int n = 1; n <= N; n++) {
            root = Node.insert(root, n, scanner.nextInt());
        }
        if (root != null) {
            for (int m = 0; m < M; m++) {
                int type = scanner.nextInt();
                int i = scanner.nextInt();
                int j = scanner.nextInt();
                Node[] roots = Node.split(root, i, j + 1);
                switch (type) {
                    case 1:
                        root = Node.merge(roots[1], roots[0], roots[2]);
                        break;
                    case 2:
                        root = Node.merge(roots[0], roots[2], roots[1]);
                }
            }
            System.out.println(Math.abs(Node.find(root, 1).value - Node.find(root, N).value));
            System.out.println(root);
        }
    }

}
