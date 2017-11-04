package com.chikeandroid.tutsplus_glide;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog;

import java.io.File;
import java.io.FileOutputStream;


/**
 * Created by Chike on 2/12/2017.
 */

public class SpacePhotoActivity extends AppCompatActivity {

    //dodatoizshera DIS

    LinearLayout activity_character;
    static int CODE_FOR_RESULT=981;

    public static final String EXTRA_SPACE_PHOTO = "SpacePhotoActivity.SPACE_PHOTO";

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_detail);

        /*getSupportActionBar().setDisplayShowTitleEnabled( true );
        getSupportActionBar().setTitle("Click on an image to share it");*/
        //getSupportActionBar()/* or getSupportActionBar() */.setTitle(Html.fromHtml("<font color=\"white\">" + getString(R.string.app_name) + "</font>"));
        /*Toast.makeText(this, "Click on image to share it!",
                Toast.LENGTH_SHORT).show();*/

        //DIS
        activity_character=(LinearLayout)findViewById(R.id.activity_character);

        mImageView = (ImageView) findViewById(R.id.image);
        SpacePhoto spacePhoto = getIntent().getParcelableExtra(EXTRA_SPACE_PHOTO);

        Glide.with(this)
                .load(spacePhoto.getUrl())
                .asBitmap()
                .error(R.drawable.ic_cloud_off_red)
                .listener(new RequestListener<String, Bitmap>() {

                    @Override
                    public boolean onException(Exception e, String model, Target<Bitmap> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Bitmap resource, String model, Target<Bitmap> target, boolean isFromMemoryCache, boolean isFirstResource) {

                        //onPalette(Palette.from(resource).generate());
                        mImageView.setImageBitmap(resource);

                        return false;
                    }

                    /*public void onPalette(Palette palette) {
                        if (null != palette) {
                            ViewGroup parent = (ViewGroup) mImageView.getParent().getParent();
                            parent.setBackgroundColor(palette.getDarkVibrantColor(Color.WHITE));
                        }
                    }*/
                })
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(mImageView);

    }

   /* private SimpleTarget target = new SimpleTarget<Bitmap>() {

        @Override
        public void onResourceReady(Bitmap bitmap, GlideAnimation glideAnimation) {

           onPalette(Palette.from(bitmap).generate());
           mImageView.setImageBitmap(bitmap);
        }

        public void onPalette(Palette palette) {
            if (null != palette) {
                ViewGroup parent = (ViewGroup) mImageView.getParent().getParent();
                parent.setBackgroundColor(palette.getDarkVibrantColor(Color.GRAY));
            }
        }
    };*/



    //create bitmap from view and returns it
    private Bitmap getBitmapFromView(View view) {
        //Define a bitmap with the same size as the view
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(),Bitmap.Config.ARGB_8888);
        //Bind a canvas to it
        Canvas canvas = new Canvas(returnedBitmap);
        //Get the view's background
        Drawable bgDrawable =view.getBackground();
        if (bgDrawable!=null) {
            //has background drawable, then draw it on the canvas
            bgDrawable.draw(canvas);
        }   else{
            //does not have background drawable, then draw white background on the canvas
            canvas.drawColor(Color.WHITE);
        }
        // draw the view on the canvas
        view.draw(canvas);
        //return the bitmap
        return returnedBitmap;
    }

    public void OnClickShare(View view){

        Bitmap bitmap =getBitmapFromView(activity_character);
        try {
            //File file = new File(this.getExternalCacheDir(),File.separator+ "logicchip.png");
            File file = new File(this.getExternalCacheDir(),"image.png");


            // File file = new File(this.getCacheDir(),File.separator+ "logicchip.png");
            FileOutputStream fOut = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);
            fOut.flush();
            fOut.close();
            file.setReadable(true, false);

            final Intent intent = new Intent(android.content.Intent.ACTION_SEND);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
            intent.setType("image/png");
            startActivity(Intent.createChooser(intent, "Share image via"));

        } catch (Exception e) {
            e.printStackTrace();
        }
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
