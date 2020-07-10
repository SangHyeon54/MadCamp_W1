package com.example.tap;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.internal.ContextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_1#newInstance} factory method to
 * create an instance of this fragment.
 */


public class Fragment_1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView mRecyclerView;
    private ContactAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<ContactData> mMyData;

    public Fragment_1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_1 newInstance(String param1, String param2) {
        Fragment_1 fragment = new Fragment_1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        /*
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_1);

        this.InitializeData();

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        */
        super.onCreate(savedInstanceState);

        /*
        ContactAdapter mAdapter = new ContactAdapter(mMyData);

        mAdapter.setOnItemClickListner(new ContactAdapter.OnItemClickListner() {
                    @Override
                    public void onItemClick(View v, int pos) {
                        //ContactData item = mAdapter.getItem(pos);
                        Toast.makeText(getActivity(), "click", Toast.LENGTH_LONG).show();
                    }
                }
                );
        */

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        initDataset();

        View view = inflater.inflate(R.layout.fragment_1, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.scrollToPosition(0);
        mAdapter = new ContactAdapter(mMyData);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mAdapter.setOnItemClickListner(new ContactAdapter.OnItemClickListner() {
            @Override
            public void onItemClick(View v, int pos) {
                ContactData item = mAdapter.getItem(pos);
                //Toast.makeText(getActivity(), "click", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getActivity(), Contact_Clicked.class);
                intent.putExtra("name", item.getName());
                intent.putExtra("number", item.getNumber());
                intent.putExtra("image", item.getImage());

                startActivity(intent);
            }
        }
        );

        return view;
    }

    private void initDataset() {
        mMyData = new ArrayList<ContactData>();
        String temp = "image1";

        mMyData.add(new ContactData(getResources().getIdentifier(temp, "drawable", getActivity().getPackageName()), "이상현", "010-1234-5678"));
        mMyData.add(new ContactData(R.drawable.image1, "RALLYIST (5/50)",  "010-1234-5678"));
        mMyData.add(new ContactData(R.drawable.image1, "TEST (10/30)",  "010-1234-5678"));

        AssetManager assetManager= getContext().getAssets();

        try {
            InputStream is= assetManager.open("jsons/Contact.json");
            InputStreamReader isr= new InputStreamReader(is);
            BufferedReader reader= new BufferedReader(isr);

            StringBuffer buffer= new StringBuffer();
            String line= reader.readLine();
            while (line!=null){
                buffer.append(line+"\n");
                line=reader.readLine();
            }

            String jsonData= buffer.toString();

            JSONArray jsonArray= new JSONArray(jsonData);

            String s="";

            for(int i=0; i<jsonArray.length();i++){
                JSONObject jo=jsonArray.getJSONObject(i);

                String name= jo.getString("name");
                String number= jo.getString("contact");
                mMyData.add(new ContactData(R.drawable.image1, name,  number));
            }

        } catch (IOException e) {e.printStackTrace();}
        catch (JSONException e) {e.printStackTrace(); }

    }
}