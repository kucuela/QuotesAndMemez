package com.chikeandroid.tutsplus_glide;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.gc.materialdesign.views.ButtonFloat;
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog;


/**
 * Created by Chike on 2/12/2017.
 */

public class SpaceGalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_space_gallery);



        /*getSupportActionBar().setDisplayShowTitleEnabled( true );
        getSupportActionBar().setTitle("Quotes & Memes");*/

        //getSupportActionBar()/* or getSupportActionBar() */.setTitle(Html.fromHtml("<font color=\"white\">" + getString(R.string.app_name) + "</font>"));

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 1);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_images);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(layoutManager);

        SpaceGalleryActivity.ImageGalleryAdapter adapter = new SpaceGalleryActivity.ImageGalleryAdapter(this, SpacePhoto.getSpacePhotos());
        recyclerView.setAdapter(adapter);



    }

    private class ImageGalleryAdapter extends RecyclerView.Adapter<ImageGalleryAdapter.MyViewHolder>  {

        @Override
        public ImageGalleryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);

            // Inflate the layout
            View photoView = inflater.inflate(R.layout.item_photo, parent, false);

            ImageGalleryAdapter.MyViewHolder viewHolder = new ImageGalleryAdapter.MyViewHolder(photoView);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ImageGalleryAdapter.MyViewHolder holder, int position) {

            SpacePhoto spacePhoto = mSpacePhotos[position];
            ImageView imageView = holder.mPhotoImageView;

            Glide.with(mContext)
                    .load(spacePhoto.getUrl())
                    .placeholder(R.drawable.ic_cloud_off_red)
                    .into(imageView);
        }

        @Override
        public int getItemCount() {
            return (mSpacePhotos.length);
        }

        public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            public ImageView mPhotoImageView;

            public MyViewHolder(View itemView) {

                super(itemView);
                mPhotoImageView = (ImageView) itemView.findViewById(R.id.iv_photo);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View view) {

                int position = getAdapterPosition();
                if(position != RecyclerView.NO_POSITION) {
                    SpacePhoto spacePhoto = mSpacePhotos[position];

                    Intent intent = new Intent(mContext, SpacePhotoActivity.class);
                    intent.putExtra(SpacePhotoActivity.EXTRA_SPACE_PHOTO, spacePhoto);
                    startActivity(intent);
                }
            }
        }

        private SpacePhoto[] mSpacePhotos;
        private Context mContext;

        public ImageGalleryAdapter(Context context, SpacePhoto[] spacePhotos) {
            mContext = context;
            mSpacePhotos = spacePhotos;
        }


    }

    public void dole(View V){

        RecyclerView sv = (RecyclerView) findViewById(R.id.rv_images);
        sv.scrollToPosition(sv.getAdapter().getItemCount() - 1);

        ButtonFloat button = (ButtonFloat) findViewById(R.id.buttonFloatt);
        button.setVisibility(View.GONE);

        ButtonFloat button1 = (ButtonFloat) findViewById(R.id.buttonFloattt);
        button1.setVisibility(View.VISIBLE);

        Toast.makeText(this, "Pali ste na dno liste.",
                Toast.LENGTH_SHORT).show();

    }

    public void gore(View V){

        RecyclerView sv = (RecyclerView) findViewById(R.id.rv_images);
        sv.scrollToPosition(sv.getAdapter().getItemCount() - 56);

        ButtonFloat button = (ButtonFloat) findViewById(R.id.buttonFloatt);
        button.setVisibility(View.VISIBLE);

        ButtonFloat button1 = (ButtonFloat) findViewById(R.id.buttonFloattt);
        button1.setVisibility(View.GONE);

        Toast.makeText(this, "Popeli ste se na vrh liste.",
                Toast.LENGTH_SHORT).show();


    }

    // Method(s) that manage Toolbar.

    // onCreateOptionsMenu method initialize the contents of the Activity's Toolbar.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /*// onOptionsItemSelected method is called whenever an item in the Toolbar is selected.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_create:
                finish();
                startActivity(getIntent());

            case R.id.action_update:
                Intent intent = new Intent(this, SecondActivity.class);
                startActivity(intent);

            case R.id.action_delete:
                Intent intent = new Intent(this, ThirdActivity.class);
                startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }*/

    // Overrides setTitle method to support older api levels
    @Override
    public void setTitle(CharSequence title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_create) {


            /*Intent intent1 = new Intent(this, MainActivity.class);
            startActivity(intent1);
            finish();*/

            /*Dialog dialog = new Dialog(this,"Poštovani korisnici", "Razvoj aplikacija je dug i zamoran proces i s vremena na vreme čovek mora popiti kafu," +
                    "pa bi bilo lepo sa Vaše strane da ukoliko možete pošaljete 1$ putem Paypal-a " +
                    "na rollbarbullbar@gmail.com.\n\nHvala što koristite naše aplikaciju.");
            dialog.show();*/

            new MaterialStyledDialog.Builder(this)
                    .setTitle("Poštovani korisnici")
                    .setDescription("Razvoj aplikacija je dug i zamoran posao i s vremena na vreme čovek mora popiti kafu ili pojesti pljeskavicu." +
                            "\n\nUkoliko ste u mogućnosti, pošaljite 1$ ili 2$ putem Paypal-a na rollbarbullbar@gmail.com i održite ovog sirotog developera u životu.\n\nHvala unapred.\n")
                    .setIcon(R.mipmap.kafa)
                    .withDialogAnimation(true)
                    //.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_launcher))
                    .show();





            return true;
        }

        if (id == R.id.action_create1) {


            /*Intent intent1 = new Intent(this, MainActivity.class);
            startActivity(intent1);
            finish();*/

            /*Dialog dialog = new Dialog(this,"Poštovani korisnici", "Razvoj aplikacija je dug i zamoran proces i s vremena na vreme čovek mora popiti kafu," +
                    "pa bi bilo lepo sa Vaše strane da ukoliko možete pošaljete 1$ putem Paypal-a " +
                    "na rollbarbullbar@gmail.com.\n\nHvala što koristite naše aplikaciju.");
            dialog.show();*/

            new MaterialStyledDialog.Builder(this)
                    .setTitle("Aplikacija Quotes & Memes")
                    .setDescription("Verzija 3.0 donosi: \n\n• Novi izgled koji prati Google-ov material design \n• Galeriju sa slikama Savića koje možete podeliti + dodatne slike\n• Ispravke sitnih bagova iz prethodnih verzija \n\nAko prilikom pokušaja da podelite sliku dobijete poruku poput *Cant attach empty file* proverite da li ste toj aplikaciji kojoj šaljete sliku dali storage permission (ovo je uglavnom karakteristično za neke Google aplikacije poput Gmail-a i Inbox-a). \n\nHvala što koristite našu aplikaciju!\n")
                    .setIcon(R.drawable.info)
                    .withDialogAnimation(true)
                    //.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_launcher))
                    .show();





            return true;
        }



        return super.onOptionsItemSelected(item);
    }




}
