package coltd.company.info;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends ArrayAdapter<MyFile>{
	private Activity context;
	private int layout;
	private ArrayList<MyFile> data;
	public MyAdapter(Activity context, int layout, ArrayList<MyFile> data) {
		super(context, layout, data);
		this.context = context;
		this.layout = layout;
		this.data = data;
	}
@SuppressLint("ViewHolder")
@Override
public View getView(int position, View convertView, ViewGroup parent) {
	LayoutInflater inflater = context.getLayoutInflater();
	convertView = inflater.inflate(layout, null);
	if(data.size()>0){
		final ImageView imageView = (ImageView)convertView.findViewById(R.id.imageView1);
		final TextView file = (TextView) convertView.findViewById(R.id.txtName);
		final MyFile myFile = data.get(position);
		file.setText(myFile.getName());
		if(myFile.getKind()==0){
			imageView.setImageResource(R.drawable.folder);
		}else{
			imageView.setImageResource(R.drawable.files);
		}
		
	}
	return convertView;
}
	

}
