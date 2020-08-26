package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CancellationSignal;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    TextView t;
    Button b;
    private ActionMode actionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b=(Button) findViewById(R.id.bottom);
         t =(TextView) findViewById(R.id.t3) ;
        e1=(EditText) findViewById(R.id.t1);
        e2=(EditText) findViewById(R.id.t2);

        // floating contexual menu
        registerForContextMenu(e1);
        registerForContextMenu(e2);

        // action mode contexual menu
        t.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(actionMode!=null){
                return false;
            }
                    actionMode=MainActivity.this.startActionMode(actionModeCallBack);
                            return true;
            }
        });


    }
     private ActionMode.Callback actionModeCallBack=new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.action_mode,menu);
            mode.setTitle("Choose ur option");
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()){
                case R.id.i6:
                    Toast.makeText(MainActivity.this,"share is selected ",Toast.LENGTH_SHORT).show();
                    mode.finish();
                    return true;
                case R.id.i7:
                    Toast.makeText(MainActivity.this,"delete is selected ",Toast.LENGTH_SHORT).show();
                    mode.finish();
                    return true;
                default:
                    return false;
            }
        }


        @Override
        public void onDestroyActionMode(ActionMode mode) {
           actionMode=null;


        }
    };

    // floating contexual menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        switch (v.getId()){
            case R.id.t1:
                getMenuInflater().inflate(R.menu.contextual_menu,menu);
                menu.setHeaderTitle("choose one");
                break;
            case R.id.t2:
                getMenuInflater().inflate(R.menu.contextual_menu2,menu);
                menu.setHeaderTitle("choose one");
                break;

        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.i1:
                Toast.makeText(this,"option1 selected",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.i2:
                Toast.makeText(this,"option2 selected",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.i3:
                Toast.makeText(this,"option1 selected",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.it4:
                Toast.makeText(this,"option2 selected",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.i5:
                Toast.makeText(this,"option3 selected",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }
// option menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.t5:
                Toast.makeText(this, "share item", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.it4:
                Toast.makeText(this, "call item", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.it1:
                Toast.makeText(this, "setting item", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.it2:
                Toast.makeText(this, "status item", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.t6:
                Toast.makeText(this, "sub1 item", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.t7:
                Toast.makeText(this, "sub2 item", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
// popup menu
    public void showPopup(View view) {
        PopupMenu pm=new PopupMenu(MainActivity.this,view);
        pm.getMenuInflater().inflate(R.menu.popup_menu,pm.getMenu());
        pm.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.i8:
                        Toast.makeText(MainActivity.this,"1 selected",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.i9:
                        Toast.makeText(MainActivity.this,"2 selected",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.i10:
                        Toast.makeText(MainActivity.this,"3 selected",Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.i11:
                        Toast.makeText(MainActivity.this,"4 selected",Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        return false;
                }

            }
        });
        pm.show();
    }
}
