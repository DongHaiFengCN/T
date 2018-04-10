package doaing.arouter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import authority.AuthorityInfo;
import authority.AuthorityShow;
import authority.Interceptor;
import authority.MyBindView;

@Interceptor(key = AuthorityInfo.ACTIVITY_VISIABLE_1)
public class MainActivity1 extends AppCompatActivity implements AuthorityShow {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        MyBindView.bindView(this);
    }

    @Override
    public void show() {
        Toast.makeText(this,"没有权限访问！",Toast.LENGTH_SHORT).show();
    }
}
