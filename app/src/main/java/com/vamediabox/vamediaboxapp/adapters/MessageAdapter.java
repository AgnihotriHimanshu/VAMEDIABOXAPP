package com.vamediabox.vamediaboxapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.vamediabox.vamediaboxapp.R;
import com.vamediabox.vamediaboxapp.utilities.Message;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;



public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {
    public static final int USER1 = 0;
    public static final int USER2 = 1;
    private List<Message> mMessages;
    private String mUsername;
    public boolean isUser1 = true;







    public MessageAdapter(Context context, List<Message> messages ) {

        mMessages = messages;



    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout = -1;
        switch (viewType) {
        case Message.TYPE_MESSAGE:
            layout = R.layout.item_message;
            break;
//            case Message.TYPE_LOG:
//                layout = R.layout.item_log;
//                break;
            case Message.TYPE_ACTION:
                layout = R.layout.item_action;
                break;
        }


        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(layout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Message message = mMessages.get(position);
           mUsername = message.getUsername();
        if(mUsername == "ME"){
           viewHolder.setMessage(message.getMessage());
        }
        else {
            viewHolder.setOtherMessage(message.getMessage());
        }
//         viewHolder.setUsername(message.getUsername());
    }

    @Override
    public int getItemCount() {
        return mMessages.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mMessages.get(position).getType();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mUsernameView;
        private TextView mMessageView;
        private TextView mOtherMessageView;
        private TextView mTime;
        private TextView mTime1;
        boolean isUser1 = true;

        public String username;


        public ViewHolder(View itemView) {
            super(itemView);

            Calendar currnetDateTime = Calendar.getInstance();
            SimpleDateFormat df = new SimpleDateFormat("HH:mm a");
            String  currentTime = df.format(currnetDateTime.getTime());


            mUsernameView = (TextView) itemView.findViewById(R.id.username);
            mMessageView =  (TextView) itemView.findViewById(R.id.message);
            mOtherMessageView = (TextView) itemView.findViewById(R.id.txtOther);

//            mTime =(TextView) itemView.findViewById(R.id.lblDate);
//
//            mTime.setText(currentTime);
//
//            mTime1 =(TextView) itemView.findViewById(R.id.lblMyDate);
//
//                mTime1.setText(currentTime);
        }
        public void setMessage(String message) {
            if (null == mMessageView ) return;
            mMessageView.setText(message);
            mOtherMessageView.setVisibility(View.GONE);
        }

        public void setOtherMessage(String message) {
            if (null == mOtherMessageView ) return;
            mOtherMessageView.setText(message);
            mMessageView.setVisibility(View.GONE);
        }


        }

//        public void setUsername(String username) {
//            if (null == mUsernameView) return;
//            mUsernameView.setText(username);
//            ;
//        }

        }




