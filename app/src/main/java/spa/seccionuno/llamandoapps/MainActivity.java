package spa.seccionuno.llamandoapps;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String fileNameUno="android.jpg";
    String getFileNameDos="jellybean.png";
    String pathUno="/mnt/sdcard/" + fileNameUno;
    String pathDos="/mnt/sdcard/" + getFileNameDos;
    File fileUno= new File(pathUno);
    File fileDos=new File(pathDos);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick_IntentUno(View view){
        Intent i= new Intent(Intent.ACTION_VIEW );
        String query="-13,-72(Cusco el ombligo del mundo)";
        String encodeQuery= Uri.encode(query);
        i.setData(Uri.parse("geo:-13,-72?q=" + encodeQuery + "&z=4"));
        startActivity(i);
    }
    public void onClick_IntentDos(View view){
        Intent iDos=new Intent(Intent.ACTION_VIEW);
        iDos.setData(Uri.parse("http://play.google.com/store/apps/details?id=com.google.android.apps.maps"));
        startActivity(iDos);
    }
    public void onClick_IntentTres(View view){
        Intent iTres=new Intent(Intent.ACTION_SEND);
        iTres.setData(Uri.parse("mailto:"));
        String[] to={"cesarvallejos@gmail.com","johanyangales@gmail.com"};
        String[] cc={"yericoezeta@gmailk.com","soloparaapasionados@gmail.com"};

        iTres.putExtra(Intent.EXTRA_EMAIL,to);
        iTres.putExtra(Intent.EXTRA_CC,cc);
        iTres.putExtra(Intent.EXTRA_SUBJECT,"Video 1.9 de SoloParaApasionados...");
        iTres.putExtra(Intent.EXTRA_TEXT,"Te mando el video..");
        iTres.setType("message/rfc822");
        startActivity(Intent.createChooser(iTres,"Email"));
    }
    public void onClick_IntentCuatro(View view){
        Intent iCuatro=new Intent(Intent.ACTION_SEND);
        iCuatro.setType("text/plain");
        iCuatro.putExtra(Intent.EXTRA_SUBJECT, "Video 1.9 de SoloParaApasionados...");
        iCuatro.putExtra(Intent.EXTRA_TEXT, "Te mando el video..");
        startActivity(Intent.createChooser(iCuatro,"Apps que pueden responder a este Intent.."));
    }
    public void onClick_IntentCinco(View view){
        Uri uriToImage1=Uri.fromFile(fileUno);
        Intent iCinco=new Intent(Intent.ACTION_SEND);

        iCinco.setType("image/jpeg");
        String[] to={"cesarvallejos@gmail.com","johanyangales@gmail.com"};
        iCinco.putExtra(Intent.EXTRA_EMAIL,to);
        iCinco.putExtra(Intent.EXTRA_STREAM, uriToImage1);
        iCinco.putExtra(Intent.EXTRA_SUBJECT,"Video 1.9 de SoloParaApasionados...");
        iCinco.putExtra(Intent.EXTRA_TEXT,"Te mando el video..");
        startActivity(Intent.createChooser(iCinco, "Apps que pueden responder a este Intent.."));
    }
    public void onClick_IntentSeis(View view){
        Uri uriToImage1=Uri.fromFile(fileUno);
        Uri uriToImage2=Uri.fromFile(fileDos);

        ArrayList<Uri>urisToImages=new ArrayList<Uri>();
        urisToImages.add(uriToImage1);
        urisToImages.add(uriToImage2);

        Intent iSeis=new Intent(Intent.ACTION_SEND_MULTIPLE);

        iSeis.setType("message/rfc822");
        iSeis.putParcelableArrayListExtra(Intent.EXTRA_STREAM, urisToImages);
        iSeis.putExtra(Intent.EXTRA_SUBJECT, "Video 1.9 de SoloParaApasionados...");
        iSeis.putExtra(Intent.EXTRA_TEXT,"Te mando el video..");
        startActivity(Intent.createChooser(iSeis, "Apps que pueden responder a este Intent.."));
    }
    public void onClick_IntentSiete(View view){
        Intent iSiete=new Intent(Intent.ACTION_VIEW);
        Uri uriToImage1=Uri.fromFile(fileUno);

        iSiete.setDataAndType(uriToImage1,"image/*");
        startActivity(iSiete);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
