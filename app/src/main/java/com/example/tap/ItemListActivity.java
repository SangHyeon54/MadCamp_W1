package com.example.tap;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ItemListActivity extends AppCompatActivity {

    final ArrayList<String> items = new ArrayList<String>() ;

    ArrayAdapter<String> adapter;

    ListView listview;
    private InputMethodManager imm; //keyboard

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_listview);

        imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE); //keyboard

        Intent intent = getIntent();
        items.add("한식"); items.add("중국집"); items.add("치킨"); items.add("분식"); items.add("족발보쌈");
        items.add("쌀국수"); items.add("버거"); items.add("피자"); items.add("덮밥"); items.add("일식");
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, items) ;
        listview=(ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);
        listview.setChoiceMode(listview.CHOICE_MODE_MULTIPLE);


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                // get TextView's Text.
                String strText = (String) parent.getItemAtPosition(position);
                // TODO : use strText
            }
        });



    }
    public void mOnClick(View v) {
        EditText ed = (EditText) findViewById(R.id.newitem);
        SparseBooleanArray sbArray=listview.getCheckedItemPositions();
        //선택된 아이템의 위치를 알려주는 배열
        switch (v.getId()) {

            // ADD 버튼 클릭시
            case R.id.btnAdd:
                if (items.size()>=10){
                    ed.setText(null);
                    Toast toast10=Toast.makeText(this.getApplicationContext(),"10개 이상은 안돼요. 선택지를 줄여봐요 :)",Toast.LENGTH_LONG);
                    toast10.show();
                    imm.hideSoftInputFromWindow(ed.getWindowToken(), 0);
                }
                else{
                    String text = ed.getText().toString();        // EditText에 입력된 문자열값을 얻기

                    if (!text.isEmpty()) {                        // 입력된 text 문자열이 비어있지 않으면
                        items.add(text);                          // items 리스트에 입력된 문자열 추가
                        ed.setText("");                           // EditText 입력란 초기화
                        adapter.notifyDataSetChanged();           // 리스트 목록 갱신
                    }
                }
                break;

            // DELETE 버튼 클릭시
            case R.id.btnDelete:
                Log.d("ItemListActivity",sbArray.toString());
                if (sbArray.size()!=0){
                    for (int i=listview.getCount()-1;i>=0;i--){
                        if (sbArray.get(i)){
                            items.remove(i);
                        }
                    }
                    listview.clearChoices();
                    adapter.notifyDataSetChanged();
                }
                break;

            //go roulettet 버튼 클릭시
            case R.id.btnGo:
                if (items.size()<2){
                    Toast toast2=Toast.makeText(this.getApplicationContext(),"적어도 2개의 선택지가 필요합니다.",Toast.LENGTH_LONG);
                    toast2.show();
                    imm.showSoftInput(ed, 0);
                } else{
                Intent intent = new Intent(getApplicationContext(), RouletActivity.class);
                intent.putExtra("menu_items", items);
                startActivity(intent);
                }
        }
    }

}

