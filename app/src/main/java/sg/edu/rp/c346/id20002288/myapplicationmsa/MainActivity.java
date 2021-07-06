package sg.edu.rp.c346.id20002288.myapplicationmsa;
//chengxile 20002288
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
Button btnnext,btnlink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
btnnext=findViewById(R.id.btnnext);
btnlink=findViewById(R.id.btnlink);

btnlink.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String url="https://github.com/xileq";
        Intent Enterurl= new Intent(Intent.ACTION_VIEW,Uri.parse(url));
        startActivity(Enterurl);
    }
});
btnnext.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent Gonext = new Intent(MainActivity.this,ItemListActivity.class);
        startActivity(Gonext);
    }
});
    }
}