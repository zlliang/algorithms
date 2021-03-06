/**
 * Copyright (c) 2018 quincy Liang
 * Under the MIT license
 */

package com.github.deltaquincy.algorithms.graphs;

import java.util.ArrayList;

import com.github.deltaquincy.algorithms.collections.Bag;

public class Graph {
  private final int vertex;
  private int edge;
  private ArrayList<Bag<Integer>> connection;

  public Graph(int v) {
    this.vertex = v;
    this.edge = 0;
    connection = new ArrayList<Bag<Integer>>(v);
    for (int i = 0; i < v; i++) {
      connection.add(new Bag<Integer>());
    }
  }

  public int vertex() {
    return vertex;
  }

  public int edge() {
    return edge;
  }

  public void addEdge(int v, int w) {
    connection.get(v).add(w);
    connection.get(w).add(v);
    edge++;
  }

  public Iterable<Integer> connections(int v) {  // 抽象等级选了 Iterable 而不是 Bag
    return connection.get(v);
  }

  public String toString() {
    String s = vertex + " vertices, " + edge + " edges\n";
    for (int v = 0; v < vertex; v++) {
      s += v + ": ";
      for (int w : this.connections(v)) {
        s += w + " ";
      }
      s += "\n";
    }
    return s;
  }
}
