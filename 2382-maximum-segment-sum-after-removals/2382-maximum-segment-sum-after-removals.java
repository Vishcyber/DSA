class Solution {

    class Node {
        long total;
        long prefix;
        long suffix;
        long best;
        boolean allPositive;
    }

    Node[] tree;
    int[] arr;

    public long[] maximumSegmentSum(int[] nums, int[] removeQueries) {
        int n = nums.length;
        arr = nums.clone();

        tree = new Node[4 * n];
        for (int i = 0; i < tree.length; i++)
            tree[i] = new Node();

        build(1, 0, n - 1);

        long[] ans = new long[n];

        for (int i = 0; i < n; i++) {
            update(1, 0, n - 1, removeQueries[i]);
            ans[i] = tree[1].best;
        }

        return ans;
    }

    void build(int node, int l, int r) {
        if (l == r) {
            if (arr[l] > 0) {
                tree[node].total = arr[l];
                tree[node].prefix = arr[l];
                tree[node].suffix = arr[l];
                tree[node].best = arr[l];
                tree[node].allPositive = true;
            }
            return;
        }

        int mid = (l + r) / 2;
        build(node * 2, l, mid);
        build(node * 2 + 1, mid + 1, r);

        merge(node);
    }

    void update(int node, int l, int r, int idx) {
        if (l == r) {
            tree[node].total = 0;
            tree[node].prefix = 0;
            tree[node].suffix = 0;
            tree[node].best = 0;
            tree[node].allPositive = false;
            return;
        }

        int mid = (l + r) / 2;

        if (idx <= mid)
            update(node * 2, l, mid, idx);
        else
            update(node * 2 + 1, mid + 1, r, idx);

        merge(node);
    }

    void merge(int node) {
        Node left = tree[node * 2];
        Node right = tree[node * 2 + 1];
        Node cur = tree[node];

        cur.total = left.total + right.total;

        cur.allPositive = left.allPositive && right.allPositive;

        cur.prefix = left.prefix;
        if (left.allPositive)
            cur.prefix = left.total + right.prefix;

        cur.suffix = right.suffix;
        if (right.allPositive)
            cur.suffix = right.total + left.suffix;

        cur.best = Math.max(left.best, right.best);

        if (left.suffix > 0 && right.prefix > 0)
            cur.best = Math.max(cur.best, left.suffix + right.prefix);
    }
}