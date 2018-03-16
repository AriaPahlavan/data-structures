// Aria Pahlavan on March 15 2018

public class PercolationSimulation {
    private final WeightedQuickUnion wqu;
    private final boolean[] status;
    private final int size;
    private final int N;

    public PercolationSimulation(int N) {
        this.N = N;
        this.size = (N*N)+2;
        this.wqu = new WeightedQuickUnion(size);
        this.status = new boolean[size];

        for (int i = 1; i < (status.length-1); i++) {
            status[i] = false;
        }

        status[0] = status[size-1] = true;

        for (int i = 1; i <= N; i++) {
            wqu.unionOf(0, i);
            wqu.unionOf(size-1, size-1-i);
        }
    }

    private void validate(int i) {
        if (i <= 0 || i >= size-1) {
            throw new IllegalArgumentException("Invalid argument: " + i
                                               + ", must be within range " +
                                               '[' + 1 + ", " + (size-2) + ']');
        }
    }

    public boolean isPerculated() {
        return wqu.isConnected(0, size-1);
    }


    private void connectionWithLeftOf(int i) {
        if (i-1 < 1) { // ignoring the virtual top site
            return;
        }

        if (status[i-1]) {
            wqu.unionOf(i, i-1);
        }
    }

    private void connectionWithTopOf(int i) {
        if (i-N < 1) { // ignoring the virtual bottom site
            return;
        }

        if (status[i-N]) {
            wqu.unionOf(i, i - N);
        }
    }

    private void connectionWithRightOf(int i) {
        if (i+1 > size-2) { // ignoring the virtual bottom site
            return;
        }

        if (status[i+1]) {
            wqu.unionOf(i, i + 1);
        }
    }

    private void connectionWithBottomOf(int i) {
        if (i+N > size-2) { // ignoring the virtual bottom site
            return;
        }

        if (status[i+N]) {
            wqu.unionOf(i, i + N);
        }
    }


    public void openSiteAt(int i) {
        validate(i);
        if (status[i]) return;

        status[i] = true;
        connectionWithTopOf(i);
        connectionWithRightOf(i);
        connectionWithBottomOf(i);
        connectionWithLeftOf(i);
    }
}
