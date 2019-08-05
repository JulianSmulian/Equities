package equities.com.myapplication;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static equities.com.myapplication.Constructor_App_Variables.masternode_feedItems;

/**
 * Created by Julian Dinkins on 4/25/2018.
 */

public class Fragment_Masternodes extends Fragment {
    TextView stock, crypto;
    private RecyclerView masternode_items;
    Adapter_Masternodes_Feed masternodes_adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_masternodes, container, false);
        masternode_items= rootView.findViewById(R.id.masternode_items);
        masternode_items.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        masternodes_adapter=new Adapter_Masternodes_Feed(getActivity(),masternode_feedItems);
        masternode_items.setAdapter(masternodes_adapter);
        TextView crypto= (TextView)rootView.findViewById(R.id.crypto);
        Typeface custom_font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/Oregon.ttf");

        //stock.setTypeface(custom_font);
        crypto.setTypeface(custom_font);
        //stock.setPaintFlags(stock.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        crypto.setPaintFlags(crypto.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

        return rootView;

    }
    public void getNewData(){
        new ASYNCUpdate().execute();

    }
    public class ASYNCUpdate extends AsyncTask<Integer, Integer, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        @Override
        protected String doInBackground(Integer... integers) {
            Service_Main_Equities sme =new Service_Main_Equities();
            sme.clearMasterNodesData();
            sme.get_masternodes();
            return null;
        }
        @Override
        protected void onPostExecute(String result) {
            masternode_items.removeAllViewsInLayout();
            masternodes_adapter.notifyDataSetChanged();
            masternodes_adapter=new Adapter_Masternodes_Feed(getActivity(),masternode_feedItems);
            masternode_items.setAdapter(masternodes_adapter);

        }
    }
}


