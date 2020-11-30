package com.wildcrafts.android.wildcrafts;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by arvind on 10/28/2015.
 */
public class mainAdapter extends RecyclerView.Adapter<mainAdapter.myViewHolder>{

    private LayoutInflater inflater;
    List<data> appleData = Collections.emptyList();

    public mainAdapter(Context context, List<data> appleData){
        inflater=LayoutInflater.from(context);
        this.appleData=appleData;
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.row_type_1,parent,false);
        myViewHolder holder=new myViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(myViewHolder viewHolder, int position) {
        data current = appleData.get(position);
        viewHolder.title.setText(current.listTitle);
        viewHolder.subTitle.setText(current.listSubTitle);
        viewHolder.img.setImageResource(current.listImage);

        for(int i=position,j=1;i<getItemCount();i++,j++){
            switch (j){
                case 8:
                    viewHolder.linearLayout.setBackgroundColor(Color.parseColor("#289FA5"));
                    break;
                case 7:
                    viewHolder.linearLayout.setBackgroundColor(Color.parseColor("#E93165"));
                    break;
                case 6:
                    viewHolder.linearLayout.setBackgroundColor(Color.parseColor("#9FBE3C"));
                    break;
                case 5:
                    viewHolder.linearLayout.setBackgroundColor(Color.parseColor("#F8AC1B"));
                    break;
                case 4:
                    viewHolder.linearLayout.setBackgroundColor(Color.parseColor("#6B294F"));
                    break;
                case 3:
                    viewHolder.linearLayout.setBackgroundColor(Color.parseColor("#289FA5"));
                    break;
                case 2:
                    viewHolder.linearLayout.setBackgroundColor(Color.parseColor("#E93165"));
                    break;
                case 1:
                    viewHolder.linearLayout.setBackgroundColor(Color.parseColor("#9FBE3C"));
                    break;
                default:
                    viewHolder.linearLayout.setBackgroundColor(Color.parseColor("#ffffff"));
                    break;

            }
        }


    }

    @Override
    public int getItemCount() {
        return appleData.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        TextView subTitle;
        ImageView img;
        LinearLayout linearLayout;

                public myViewHolder(View itemView){
                super(itemView);
                title= (TextView) itemView.findViewById(R.id.tv_men);
                subTitle= (TextView) itemView.findViewById(R.id.tv_men_sub);
                img= (ImageView) itemView.findViewById(R.id.iv_icon_men);
                linearLayout   = (LinearLayout) itemView.findViewById(R.id.llayout1);

                }

    }

}
