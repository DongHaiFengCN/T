package doaing.arouter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;

import authority.AuthorityInfo;
import authority.AuthorityShow;
import authority.ContentView;
import authority.Interceptor;
import authority.MyBindView;
import authority.ViewBindId;

@Interceptor(key = AuthorityInfo.LOGIN)
@Route(path = "/simple/simple1Activity")
public class Main2Activity extends AppCompatActivity implements AuthorityShow {

    @ViewBindId(id=R.id.ce1_bt,key = {AuthorityInfo.VIEW_VISIABLE,AuthorityInfo.EDIT_ENABLE})
    Button button1;

    Button button2;

    @ViewBindId(id=R.id.ce3_bt,key = {AuthorityInfo.EDIT_ENABLE})
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        MyBindView.bindView(this);

        final Intent intent = new Intent();
        button2 = findViewById(R.id.ce2_bt);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               startActivity(intent.setClass(Main2Activity.this,MainActivity1.class));
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(intent.setClass(Main2Activity.this,MainActivity2.class));

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(intent.setClass(Main2Activity.this,MainActivity3.class));

            }
        });



    }

    @Override
    public void show() {
        Toast.makeText(this,"没有权限访问！",Toast.LENGTH_SHORT).show();
    }
}
