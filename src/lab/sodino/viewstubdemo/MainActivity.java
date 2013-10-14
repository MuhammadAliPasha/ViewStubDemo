package lab.sodino.viewstubdemo;

import lab.sodino.viewstubdemo.R;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				if(v.getId() == R.id.btn){
					ViewStub viewStub = (ViewStub) findViewById(R.id.viewStub);
					if(viewStub != null){
						// inflate()֮��viewStub������parent��ɾ���ˣ���inflate���ص�vInflate��ȡ��
						View vInflate = viewStub.inflate();
						Log.d("ANDROID_LAB", "vInflate:" + vInflate);
						// viewStub��ɾ���ˣ���Ҫ��Button��λ�ù�ϵ���µ������ɵ�subViewStubLayout
						RelativeLayout.LayoutParams layParams = (LayoutParams) btn.getLayoutParams();
						layParams.addRule(RelativeLayout.BELOW, R.id.subViewStubLayout);
						btn.setLayoutParams(layParams);
					} else {
						Log.d("ANDROID_LAB", "vInflate is not null.");
					}
				}
			}
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
