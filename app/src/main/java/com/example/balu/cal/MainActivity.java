package com.example.balu.cal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.balu.cal.Model.LinkedList.LinkedHashMap;
import com.example.balu.cal.Model.LinkedList.DoubleLinkedList;
import com.example.balu.cal.Model.LinkedList.ReverseLinkedList;
import com.example.balu.cal.Model.LinkedList.SingleLinkedList;
import com.example.balu.cal.Model.alg.BSTWithRecursion;
import com.example.balu.cal.Model.problems.DP_Lis_Factorial;
import com.example.balu.cal.Model.problems.MatrixTraverals;
import com.example.balu.cal.Model.problems.RatMaze;
import com.example.balu.cal.Model.alg.Trie;
import com.example.balu.cal.Model.sorting.BubbleSort;
import com.example.balu.cal.Model.sorting.CountingSort;
import com.example.balu.cal.Model.sorting.Heap;
import com.example.balu.cal.Model.sorting.MergeSort;
import com.example.balu.cal.Model.sorting.QuickSort;
import com.example.balu.cal.Model.sorting.SelectionSort;
import com.example.balu.cal.Model.trees.AVL;
import com.example.balu.cal.Model.trees.BSTWithTraversals;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView tv_sortresult;
    private ArrayList<String> items = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        setListView();

    }

    private void setListView() {
        final ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        items.add("Merge");
        items.add("Quick");
        items.add("bubble");
        items.add("count");
        items.add("selection");
        items.add("heap");
        items.add("linked list");
        items.add("reverse linked list");
        items.add("double linked list");
        items.add("linked hash map");
        items.add("BSTWithTraversals");
        items.add("Trie");
        items.add("Rat Maze");
        items.add("BSTWithRecursion");
        items.add("DP_Lis_Factorial");
        items.add("Matrix Traversals");
        items.add("AVL");
        ListView listView = (ListView) findViewById(R.id.ll_gfg);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                doAction(items.get(position));
            }
        });
    }

    private void doAction(String action) {
        switch (action) {
            case "Merge":
                new MergeSort();
                break;
            case "Quick":
                new QuickSort();
                break;
            case "bubble":
                new BubbleSort();
                break;
            case "count":
                new CountingSort();
                break;
            case "selection":
                new SelectionSort();
                break;
            case "heap":
                new Heap();
                break;
            case "linked list":
                new SingleLinkedList();
                break;
            case "double linked list":
                new DoubleLinkedList();
                break;
            case "reverse linked list":
                new ReverseLinkedList();
                break;
            case "linked hash map":
                new LinkedHashMap();
                break;
            case "BSTWithTraversals":
                new BSTWithTraversals();
                break;
            case "Trie":
                new Trie();
                break;
            case "Rat Maze":
                RatMaze rat = new RatMaze();
                int maze[][] = {{1, 0, 0, 0},
                        {1, 1, 0, 1},
                        {0, 1, 0, 0},
                        {1, 1, 1, 1}
                };
                rat.solveMaze(maze);
                break;
            case "BSTWithRecursion":
                new BSTWithRecursion();
                break;
            case "DP_Lis_Factorial":
                new DP_Lis_Factorial();
                break;
            case "Matrix Traversals":
                new MatrixTraverals();
                break;
            case "AVL":
                new AVL();
                break;
        }
    }

}
