package innoviz.niec.com.musicui;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import innoviz.niec.com.musicui.AppFragments.ListenNowFrag;

public class MainActivity extends FragmentActivity {
    private String[] drawerOptionList;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerOptionList=getResources().getStringArray(R.array.drawer_options);
        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        mDrawerList=(ListView)findViewById(R.id.drawer_list);

        //Setting the list addapter
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,drawerOptionList));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

    }

    private class DrawerItemClickListener implements  ListView.OnItemClickListener {




        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            selectItem(i);
        }

        private void selectItem(int i) {
            switch (i){
                case 0:ListenNowFrag listenNoewFrag= new ListenNowFrag();
                    FragmentManager fm=getSupportFragmentManager();
                    fm.beginTransaction().replace(R.id.content_frame,listenNoewFrag).commit();
                    mDrawerLayout.closeDrawer(mDrawerList);
                    break;

            }
        }
    }

}
