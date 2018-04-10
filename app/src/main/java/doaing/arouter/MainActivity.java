package doaing.arouter;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.alibaba.android.arouter.launcher.ARouter;

import authority.AuthorityCentre;
import authority.AuthorityInfo;
import authority.MyBindView;
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyBindView.bindView(this);

        findViewById(R.id.registe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final AuthorityCentre authoritySingleton = AuthorityCentre.getInstance();
                authoritySingleton.putAuthorityItem(AuthorityInfo.LOGIN, true);

                authoritySingleton.putAuthorityItem(AuthorityInfo.ACTIVITY_VISIABLE_1, true);
               // authoritySingleton.putAuthorityItem(AuthorityInfo.ACTIVITY_VISIABLE_2, false);
                authoritySingleton.putAuthorityItem(AuthorityInfo.ACTIVITY_VISIABLE_3, false);


                authoritySingleton.putAuthorityItem(AuthorityInfo.VIEW_VISIABLE, true);
                authoritySingleton.putAuthorityItem(AuthorityInfo.EDIT_ENABLE, true);

            }
        });


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this,Main2Activity.class));


            }
        });
    }}






