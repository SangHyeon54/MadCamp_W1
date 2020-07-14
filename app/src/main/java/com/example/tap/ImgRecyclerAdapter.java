package com.example.tap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ImgRecyclerAdapter extends RecyclerView.Adapter<ImgRecyclerAdapter.ViewHolder> {

    private final int img_num;

    private Integer[] mThumblds ={R.drawable.image1, R.drawable.image2,R.drawable.image3,
            R.drawable.image4,R.drawable.image5,R.drawable.image6,
            R.drawable.image7,R.drawable.image8,R.drawable.image9,
            R.drawable.image10,R.drawable.image11,R.drawable.image12,
            R.drawable.image13,R.drawable.image14,R.drawable.image15,
            R.drawable.image16,R.drawable.image17,R.drawable.image18,
            R.drawable.image19,R.drawable.image20,
    };

    ImgRecyclerAdapter(int img_num)
    {
        this.img_num = img_num;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.simple_image, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position)
    {
        //ViewHolder가 관리하는 View에 position에 해당하는 데이터 바인딩

        viewHolder.imageView.setImageResource(mThumblds[position]);
    }

    @Override
    public int getItemCount()
    {
        //Adapter가 관리하는 전체 데이터 개수 반환
        return 20;
    }



  /*  public ContactData getItem(int position){
        return myDataList.get(position);
    }*/

    public interface OnItemClickListner {
        void onItemClick(View v, int pos);
    }

    private OnItemClickListner imgRecyclerListener = null;

    public void setOnItemClickListner(OnItemClickListner listner) {
        this.imgRecyclerListener = listner;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        ViewHolder(View itemView)
        {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);


            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION)
                    {
                        // 리스너 객체의 메서드 호출
                        notifyItemChanged(pos) ;
                        if (imgRecyclerListener != null){
                            imgRecyclerListener.onItemClick(v,pos);
                        }

                    }
                }
            });
        }

    }

    public interface OnItemClickListener {
        void onItemCLick(View v, int position) ;
    }
/*
    //@Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                if(charString.isEmpty()) {
                    filteredList = myDataList;
                } else {
                    ArrayList<ContactData> filteringList = new ArrayList<>();
                    for(ContactData name : myDataList) {
                        if(name.getName().toLowerCase().contains(charString.toLowerCase())) {
                            filteringList.add(name);
                        }
                        else if(name.getNumber().toLowerCase().contains(charString.toLowerCase())) {
                            filteringList.add(name);
                        }
                        else if(name.getNumber_raw().toLowerCase().contains(charString.toLowerCase())) {
                            filteringList.add(name);
                        }
                    }
                    filteredList = filteringList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                filteredList = (ArrayList<ContactData>)results.values;
                notifyDataSetChanged();
            }
        };
    }*/

}

/*
public class ImgRecyclerAdapter extends RecyclerView.Adapter<ImgRecyclerAdapter.ImgViewHolder> {
    private Context context;
    private Integer[] mThumblds = {R.drawable.image1, R.drawable.image2, R.drawable.image3,
            R.drawable.image4, R.drawable.image5, R.drawable.image6,
            R.drawable.image7, R.drawable.image8, R.drawable.image9,
            R.drawable.image10, R.drawable.image11, R.drawable.image12,
            R.drawable.image13, R.drawable.image14, R.drawable.image15,
            R.drawable.image16, R.drawable.image17, R.drawable.image18,
            R.drawable.image19, R.drawable.image20,
    };

    public ImgRecyclerAdapter(Context context){//img_num 추가하기
        this.context=context;
        //img_num
    }
    @Override
    public ImgViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //전개자(Inflater)를 통해 얻은 참조 객체를 통해 뷰홀더 객체 생성
        View view = inflater.inflate(R.layout.simple_image, parent, false);
        ImgRecyclerAdapter.ImgViewHolder viewHolder = new ContactAdapter.ImgViewHolder(view);

        return ImgViewHolder;
       // View convertView = LayoutInflater.from(context).inflate(R.layout.simple_image, parent, false);
       // return new ImgViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(@NonNull ImgViewHolder holder, int position) {
        ImgViewHolder.imageView.setImageResource(mThumblds[position]);
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public interface OnItemClickListner {
        void onItemClick(View v, int pos);
    }

    private ContactAdapter.OnItemClickListner contactListener = null;

    public void setOnItemClickListner(ContactAdapter.OnItemClickListner listner) {
        this.contactListener = listner;
    }

    public class ImgViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        public ImgViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }
}
*/