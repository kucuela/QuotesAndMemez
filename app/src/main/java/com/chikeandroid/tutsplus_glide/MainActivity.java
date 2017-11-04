package com.chikeandroid.tutsplus_glide;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;



import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.gc.materialdesign.views.ButtonFlat;
import com.gc.materialdesign.views.ButtonFloat;
import com.gc.materialdesign.widgets.Dialog;
import com.github.javiersantos.materialstyleddialogs.MaterialStyledDialog;
import com.github.javiersantos.materialstyleddialogs.enums.Style;



public class MainActivity extends AppCompatActivity {

    private static boolean firstRun = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        //ANIMACIJE UVODNOG TEKSTA

        final TextView txt2 = (TextView) findViewById(R.id.cardview_title);
        txt2.setText("Cunnilingus");
        txt2.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),android.R.anim.slide_in_left));

        final TextView txt21 = (TextView) findViewById(R.id.cardview_desc);
        txt21.setText("Zapamtićeš sinoćnu veče porijeklo ti jebem upamtićeš srbina iz republike srpske mira nije sama i repa bez korena komećeš ti pičku lizat lizat ćeš ti moj kurac !");
        txt21.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),android.R.anim.slide_in_left));


        final TextView txt2122 = (TextView) findViewById(R.id.cardview_title1);
        txt2122.setText("Disciplina");
        txt2122.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),android.R.anim.slide_in_left));

        final TextView txt212 = (TextView) findViewById(R.id.cardview_desc1);
        txt212.setText("Ja sam ti disciplinovan !");
        txt212.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),android.R.anim.slide_in_left));


        final TextView txt21222 = (TextView) findViewById(R.id.cardview_title2);
        txt21222.setText("Kuća");
        txt21222.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),android.R.anim.slide_in_left));

        final TextView txt212222 = (TextView) findViewById(R.id.cardview_desc2);
        txt212222.setText("Ovo je srpska kuća neće mi on ovde klanjati nije ovo džamija jebo majku svoju bradatu !");
        txt212222.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),android.R.anim.slide_in_left));

        final TextView txt21222a = (TextView) findViewById(R.id.cardview_title3);
        txt21222a.setText("Higijena");
        txt21222a.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),android.R.anim.slide_in_left));

        final TextView txt2122221 = (TextView) findViewById(R.id.cardview_desc3);
        txt2122221.setText("Što ovo malo ne očistite reću ja Branku ovaj mali Takilo neće ništa da čisti ne može to tako bre u ugovoru stoji da će se higijena održavati ako neće Takilo da čisti dovešću ja ženu za 20 ojra a ako neće ni to kapija !");
        txt2122221.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),android.R.anim.slide_in_left));

        final TextView txt21222as = (TextView) findViewById(R.id.cardview_title21);
        txt21222as.setText("Zatvor");
        txt21222as.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),android.R.anim.slide_in_left));

        final TextView txt2122221y = (TextView) findViewById(R.id.cardview_desc21);
        txt2122221y.setText("Ja sam ti se zatvora naležo, pički najebo i života naživeo !");
        txt2122221y.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),android.R.anim.slide_in_left));






        //getSupportActionBar()/* or getSupportActionBar() */.setTitle(Html.fromHtml("<font color=\"white\">" + getString(R.string.app_name) + "</font>"));

        /*getSupportActionBar().setDisplayShowTitleEnabled( true );
        getSupportActionBar().setTitle("Quotes");



*/

        /*getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setIcon(R.mipmap.belo);*/


        ButtonFloat buttonFloat = (ButtonFloat) findViewById(R.id.buttonFloat);
        buttonFloat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galleryIntent = new Intent(MainActivity.this, SpaceGalleryActivity.class);
                startActivity(galleryIntent);
            }
        });





    }



    public void onRestart (){

        super.onRestart();
        Intent i = new Intent(MainActivity.this,MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
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
                    .setDescription("Verzija 3.0 donosi: \n\n• Novi izgled koji prati Google-ov material design \n• Galeriju sa slikama Savića koje možete podeliti + dodatne slike\n• Ispravke sitnih bagova iz prethodnih verzija \n\nAko prilikom pokušaja da podelite sliku dobijete poruku poput *Cant attach empty file* proverite da li ste toj aplikaciji kojoj šaljete sliku dali storage permission (ovo je uglavnom karakteristično za neke Google aplikacije poput Gmail-a i Inbox-a). \n\nHvala što koristite našu aplikaciju!\n\n")
                    .setIcon(R.drawable.info)
                    .withDialogAnimation(true)


                    //.setIcon(ContextCompat.getDrawable(this, R.drawable.ic_launcher))
                    .show();





            return true;
        }



        return super.onOptionsItemSelected(item);
    }

    //KLIK METODE ZA SHARE KARTICA SA CITATIMA

    // Called when btnOpen is clicked
    public void neunosimo (View view) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, "NEUNOSIMO POZZ?");
        startActivity(intent);


    }

    public void disciplinovan (View view) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, "OVO JE NJEMAČKA KVALITETA! \nNIJE TO ONO SRANJE ŠTO " +
                "KINEZI PRAVE! \nALO BRE! \nNJEMAČKA KVALITETA! \nNIKAD MI SE NIKO NIJE ŽALIO NA ROBU!");
        startActivity(intent);
    }

    public void razguli (View view) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, "VISIO BI TI MENI NA BANDERI!");
        startActivity(intent);
    }

    public void kapija (View view) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, "OVO JE SRPSKA KUĆA!ALO! \nNEĆE MI ON OVDE KLANJATI! " +
                "\nNIJE OVO DŽAMIJA! \nJEBO MAJKU SVOJU BRADATU! \nSRPSKA KUĆA,BRE!");
        startActivity(intent);
    }

    public void sc (View view) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, "ŠTO OVO MALO NE OČISTITE? \nREĆU JA BRANKU! \nOVAJ MALI TAKILO " +
                "NEĆE NIŠTA DA ČISTI! \nILI NEK PLATI ŽENU 20 OJRA! \nILI KAPIJA!");
        startActivity(intent);
    }

    public void hey (View view) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, "ZAPAMTIĆEŠ SINOĆNU VEČE \nPORIJEKLO TI JEBEM \nZAPAMTIĆEŠ SRBINA" +
                " \nIZ REPUBLIKE SPRSKE! \nMIRA NIJE SAMA \nNI REPA BEZ KORENA \nKOME ĆEŠ TI PIČKU LIZAT? \nLIZAT ĆEŠ TI MOJ KURAC!!!");
        startActivity(intent);
    }



    public void zatvor (View view) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, "MIRO,IMAL PIVE?");
        startActivity(intent);
    }



    public void zapamtices (View view) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, "K  A  P  I  J  A !");
        startActivity(intent);
    }

    public void alo (View view) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, "ALO! \n\nA\nL\nO \n\nA L O !");
        startActivity(intent);
    }

    public void branko (View view) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, "ŠTO MI SE BRANKO NE JAVLJA?");
        startActivity(intent);
    }

    public void jasam (View view) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, "JA SAM TI SE \nZATVORA NALEŽO \nPIČKI NAJEBO \nI ŽIVOTA NAŽIVEO!");
        startActivity(intent);
    }

    public void zakljucaj (View view) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, "JA SAM TI DISCIPLINOVAN!");
        startActivity(intent);
    }

    public void nared (View view) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, ":GROK: \nDOĆEŠ I TI NARED!");
        startActivity(intent);
    }

    public void komsinica (View view) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, ":GROK: \nMORAM IZJEBATI OVU KOMŠINICU!");
        startActivity(intent);
    }

    public void sinoc (View view) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, ":GROK: \nJOJ ŠTO SAM SINOĆ JEBO JEDNU! \nUH UH! \nKAKO SAM JE ODRO!");
        startActivity(intent);
    }

    public void masina (View view) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, ":GROK: \nMOGU JEBATI SATIMA KO MAŠINA \n:GROK: \n:GROK: \nOSAM SATI BEZ PAUZE!");
        startActivity(intent);
    }

    public void muslimanke (View view) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, ":GROK: \nJOJ ŠTO VOLIM DA JEBEM MUSLIMANKE \nTAKO IM SE SVETIM!");
        startActivity(intent);
    }

    public void krmece (View view) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, ":GROK: \nIMA PIČKU KO KRMEĆE OKO!");
        startActivity(intent);
    }

    public void hrvati (View view) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, "BRANKO MANI SE HRVATA!");
        startActivity(intent);
    }

    public void imela (View view) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, "MUŠTERIJE MI ŠALJU IMELA \nNA KUPUJEM PRODAJEM!\nIMELA!");
        startActivity(intent);
    }

    public void musterija (View view) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, "KAD ODE MUŠTERIJA MOŠ JE JEBAT!");
        startActivity(intent);
    }

    public void vrat (View view) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, "PRESKOČIM OGRADU \nI U LETU GA ZGRABIM \nZUBIMA ZA VRAT!");
        startActivity(intent);
    }

    public void fruska (View view) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, "STAVIM GA U KOLA \nODVEDEM NA FRUŠKU GORU \nVEŽEM GA ZA DRVO \nI NE PUŠTAM DOK NE VRATI PARE!");
        startActivity(intent);
    }

    public void pastete (View view) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, "MINIRAO SAM CELO DVORIŠTE PAŠTETAMA! \nSVUDA SU NAGAZNE MINE! \nALI NISU STRAŠNE \nSAMO TI STOPALO OTKINU!");
        startActivity(intent);
    }

    public void brat (View view) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(android.content.Intent.EXTRA_TEXT, "JA SAM BRE ROĐENOM BRATU \nUVEO ZABRANU 10 GODINA \nDA MI OVDE DOLAZI!");
        startActivity(intent);
    }




}
