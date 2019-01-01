package com.ldt.cinematicket.ui.main.root;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ldt.cinematicket.R;
import com.ldt.cinematicket.model.Cinema;
import com.ldt.cinematicket.ui.main.MainActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CinemaAdapter extends RecyclerView.Adapter<CinemaAdapter.ItemHolder> {
    private List<Cinema> mData = new ArrayList<>();
    Context mContext;

    public CinemaAdapter(Context context) {
        this.mContext = context;
    }

    public void setData(List<Cinema> data) {
        mData.clear();
        if (data !=null) {
            mData.addAll(data);
        }
        notifyDataSetChanged();
    }

    public void addData(List<Cinema> data) {
        if(data!=null) {
            int posBefore = mData.size();
            mData.addAll(data);
            notifyItemRangeInserted(posBefore,data.size());
        }
    }


    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_cinema_tab, parent, false);

        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        holder.bind(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class ItemHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_name) TextView txtName;
        @BindView(R.id.txt_address) TextView txtAddress;
        @BindView(R.id.txt_hotline) TextView txtHotline;
        @BindView(R.id.img) ImageView image;
        @BindView(R.id.panel) View panel;

        public ItemHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

        @OnClick(R.id.panel)
        void clickPanel() {
//            if(mContext instanceof MainActivity)
//                ((MainActivity) mContext).presentFragment(MovieDetail.newInstance(mData.get(getAdapterPosition())));
            Toast.makeText(mContext, "abc", Toast.LENGTH_LONG).show();
        }

        public void bind(Cinema cinema) {

            txtName.setText(cinema.getName());

            if(mContext instanceof Activity) {
                LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            }


            String Address = cinema.getAddress();

            if (Address.length() >= 78) // Nhieu hon 78 ky tu thi nhung ky tu sau phai ghi bang ...
            {
                Address = Address.substring(0, Math.min(Address.length(), 78));
                Address += "...";
            }

            txtAddress.setText(Address);
            txtHotline.setText(cinema.getHotline());

            RequestOptions requestOptions = new RequestOptions().override(image.getWidth());
            Glide.with(mContext)
                    .load(cinema.getImageUrl())
                    .apply(requestOptions)
                    .into(image);
        }
    }
}
