package com.vamediabox.vamediaboxapp.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.vamediabox.vamediaboxapp.R;
import com.vamediabox.vamediaboxapp.utilities.Message;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * Created by HP 101 on 9/12/2017.
 */
public class MessageAdapter extends BaseAdapter {

    private List<Message> mMessages;
    private Context context;

    Calendar currnetDateTime = Calendar.getInstance();
    SimpleDateFormat df = new SimpleDateFormat("HH:mm a");
    String  currentTime = df.format(currnetDateTime.getTime());

    public MessageAdapter(Context context, List<Message> messages) {
        mMessages = messages;

    }


    @Override
    public int getCount() {
        return mMessages.size();
    }

    @Override
    public Object getItem(int i) {
        return mMessages.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Message m = mMessages.get(i);

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (mMessages.get(i).isSelf()) {
            // message belongs to you, so load the right aligned layout
            view = mInflater.inflate(R.layout.list_item_message_right,
                    null);
        } else {
            // message belongs to other person, load the left aligned layout
            view = mInflater.inflate(R.layout.list_item_message_left,
                    null);
        }
       TextView mDateView = (TextView) view.findViewById(R.id.lblDate);

       TextView mMessageView = (TextView) view.findViewById(R.id.txtMessage);

        mDateView.setText(currentTime);
        mMessageView.setText(m.getMessage());

        return view;


    }


    public int notifyDataSetChanged(int i) {
        int size = mMessages.size();
        return size;
    }
}


