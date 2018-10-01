package airhawk.com.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;

import static airhawk.com.myapplication.Constructor_App_Variables.graph_change;
import static airhawk.com.myapplication.Constructor_App_Variables.graph_date;
import static airhawk.com.myapplication.Constructor_App_Variables.graph_high;
import static airhawk.com.myapplication.Constructor_App_Variables.graph_volume;
import static airhawk.com.myapplication.Constructor_App_Variables.stocktwits_feedItems;

public class Fragment_stockVScrypto extends Fragment {
GraphView graph_view;

    public Fragment_stockVScrypto() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_stock_vs_crypto, container, false);
        graph_view=rootView.findViewById(R.id.graph_view);
        final Integer integer = 7;
        Adapter_Graph_Points ab_list = new Adapter_Graph_Points(getContext(),integer, graph_high,graph_change, graph_volume, graph_date);
        return rootView;
    }
}
