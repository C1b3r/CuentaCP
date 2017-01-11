package arturoki.cuentacp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    private String[] paises={"Nivel 5-acceso a gyms, pociones y revivir","Nivel 8-razz berry ","Nivel 10-Super pociones","Nivel 12-Super ball",
            "Nivel 15-Hiperpociones","Nivel 20-ultraballs","Nivel 25-Max pocion","Nivel 30-Max revivir"};
    private ListView lv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        lv1 =(ListView)findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, paises);
        lv1.setAdapter(adapter);
    }

    public void acerca(View view) {
        Intent i = new Intent(this, Main2Activity.class );
        startActivity(i);
    }
    public void salir(View v) {
        finish();
    }
}
