/**
 * Copyright (c) 2018 Quincy Liang
 * Under the MIT license
 */

package com.github.deltaquincy.algorithms.graphs;

public abstract class AbstractUF {
  protected int[] id;
  protected int count;

  public AbstractUF(int N) {
    count = N;
    id = new int[N];
    for (int i = 0; i < N; i++) {
      id[i] = i;
    }
  }

  public int count() {
    return count;
  }

  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  public abstract int find(int p);
  public abstract void union(int p, int q);
}
