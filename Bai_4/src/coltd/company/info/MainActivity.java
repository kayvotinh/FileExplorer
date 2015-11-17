package coltd.company.info;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity implements OnItemClickListener,OnClickListener{
	private TextView parrent;
	private ListView listView;
	private MyAdapter adapter;
	private ArrayList<MyFile> data;
	
    @SuppressLint("SdCardPath") @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parrent = (TextView) findViewById(R.id.txtRoot);
        listView = (ListView) findViewById(R.id.listFile);
        parrent.setOnClickListener(this);
        data = new ArrayList<MyFile>();
        String youFilePath = Environment.getExternalStorageDirectory().toString();
        getData(youFilePath);
        adapter = new MyAdapter(this, R.layout.item_file, data);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

	private void getData(String path) {
		if(!path.equals("/")){
			parrent.setCompoundDrawablesWithIntrinsicBounds(R.drawable.back, 0, 0, 0);
		}else{
			parrent.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
		}
		parrent.setText(path);
		data.clear();
		File file = new File(path);
		File[] list=file.listFiles();
		MyFile f;
		if(list!=null){
			for(File i:list){
				f = new  MyFile();
				f.setName(i.getName());
				f.setPath(i.getAbsolutePath());
				if(i.isFile()){
					f.setKind(1);
				}else{
					f.setKind(0);
				}
				data.add(f);
				Collections.sort(data);
			}
		}
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		getData(data.get(arg2).getPath());
		adapter.notifyDataSetChanged();
	}

	@Override
	public void onClick(View v) {
		if(v.getId()==R.id.txtRoot){
			File f = null;
			f = new File(parrent.getText().toString());
			String path = f.getParentFile()+"";
			if(path.equals("null")){
				return;
			}
			getData(path);
			adapter.notifyDataSetChanged();
	}
}}
