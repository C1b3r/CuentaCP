package arturoki.cuentacp;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity  {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


    }


    /*   @Override
       public boolean onCreateOptionsMenu(Menu menu) {
           // Inflate the menu; this adds items to the action bar if it is present.
           getMenuInflater().inflate(R.menu.menu_main4, menu);
           return true;
       }
   */
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }
        private Button musica;

        private Button boton;
        private Spinner lista;
        private EditText etd;
        private TextView resultadocp;
        private String[] paises={"Nivel 5-acceso a gyms, pociones y revivir","Nivel 8-razz berry ","Nivel 10-Super pociones","Nivel 12-Super ball",
                "Nivel 15-Hiperpociones","Nivel 20-ultraballs","Nivel 25-Max pocion","Nivel 30-Max revivir"};
        private ListView lv1;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            /*Aqui es donde pone en cada seccion el texto, voy a coger y dependiendo de cual sea
            * me haga un fragment de uno o de otro*/
            if (getArguments().getInt(ARG_SECTION_NUMBER)==1){
                View rootView = inflater.inflate(R.layout.fragment_pag1, container, false);
                boton= (Button)rootView.findViewById(R.id.button);
                etd=(EditText)rootView.findViewById(R.id.editText);
                resultadocp=(TextView)rootView.findViewById(R.id.textView3);
                lista = (Spinner)rootView.findViewById(R.id.spinner);
                boton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View vista){
                       try{
                           InputMethodManager keyboard = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                           keyboard.hideSoftInputFromWindow(etd.getWindowToken(), 0);}
                       catch (Exception e){}
                       // if(etd.length() == 0){Toast.makeText(getContext(),"Rellena el campo de CP",Toast.LENGTH_SHORT).show();}
                      //  Toast.makeText(getContext(),"asdasd",Toast.LENGTH_SHORT).show(); etd.equals("")
                        try {
                            double mincp = 0;
                            double maxcp = 0;
                            double mincpevl = 0;
                            double maxcpevl = 0;
                            String valor1 = etd.getText().toString();
                            Double nro1 = Double.parseDouble(etd.getText().toString());
                            Double resultado;
                            Double resultado2;
                            Double resultevol;
                            Double resultevol2;
                            String resu;
                            String resu2;
                            String resuev;
                            String resuev2;
                            String selec = lista.getSelectedItem().toString();

                            switch (selec) {
                                case "Bulbasaur":
                                    mincp = 1.53;
                                    maxcp = 1.58;
                                    mincpevl = 1.2;
                                    maxcpevl = 1.61;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;
                                    resultevol = resultado * mincpevl;
                                    resultevol2 = resultado2 * maxcpevl;

                                    resu = String.valueOf((int) Math.floor(resultado));
                                    resu2 = String.valueOf((int) Math.floor(resultado2));

                                    resuev = String.valueOf((int) Math.floor(resultevol));
                                    resuev2 = String.valueOf((int) Math.floor(resultevol2));

                                    resultadocp.setText("Tu " + selec + " evolucionará a Ivysaur con " + resu + " ó " + resu2 + " y a Venusaur con " + resuev + " ó " + resuev2);
                                    break;
                                case "Ivysaur":
                                    mincp = 1.2;
                                    maxcp = 1.61;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Venusaur con " + resu + " ó " + resu2);
                                    break;
                                case "Charmander":
                                    mincp = 1.64;
                                    maxcp = 1.7;
                                    mincpevl = 1.71;
                                    maxcpevl = 1.73;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;
                                    resultevol = resultado * mincpevl;
                                    resultevol2 = resultado2 * maxcpevl;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));

                                    resuev = String.valueOf((int) Math.floor(resultevol));
                                    resuev2 = String.valueOf((int) Math.floor(resultevol2));

                                    resultadocp.setText("Tu " + selec + " evolucionará a Charmeleon con " + resu + " ó " + resu2 + " y a Charizard con " + resuev + " ó " + resuev2);
                                    break;

                                case "Charmeleon":
                                    mincp = 1.71;
                                    maxcp = 1.73;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Charizard con " + resu + " ó " + resu2);
                                    break;

                                case "Squirtle":
                                    mincp = 1.63;
                                    maxcp = 1.66;
                                    mincpevl = 1.4;
                                    maxcpevl = 1.65;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;
                                    resultevol = resultado * mincpevl;
                                    resultevol2 = resultado2 * maxcpevl;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));

                                    resuev = String.valueOf((int) Math.floor(resultevol));
                                    resuev2 = String.valueOf((int) Math.floor(resultevol2));

                                    resultadocp.setText("Tu " + selec + " evolucionará a Wartortle con " + resu + " ó " + resu2 + " y a Blastoise con " + resuev + " ó " + resuev2);
                                    break;

                                case "Wartortle":
                                    mincp = 1.4;
                                    maxcp = 1.65;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Blastoise con " + resu + " ó " + resu2);
                                    break;

                                case "Caterpie":
                                    mincp = 1.04;
                                    maxcp = 1.08;
                                    mincpevl = 3.52;
                                    maxcpevl = 3.79;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;
                                    resultevol = resultado * mincpevl;
                                    resultevol2 = resultado2 * maxcpevl;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));

                                    resuev = String.valueOf((int) Math.floor(resultevol));
                                    resuev2 = String.valueOf((int) Math.floor(resultevol2));

                                    resultadocp.setText("Tu " + selec + " evolucionará a Metapod con " + resu + " ó " + resu2 + " y a Butterfree con " + resuev + " ó " + resuev2);
                                    break;

                                case "Metapod":
                                    mincp = 3.55;
                                    maxcp = 3.79;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Butterfree con " + resu + " ó " + resu2);
                                    break;

                                case "Weedle":
                                    mincp = 1.06;
                                    maxcp = 1.1;
                                    mincpevl = 3.3;
                                    maxcpevl = 3.42;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;
                                    resultevol = resultado * mincpevl;
                                    resultevol2 = resultado2 * maxcpevl;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));

                                    resuev = String.valueOf((int) Math.floor(resultevol));
                                    resuev2 = String.valueOf((int) Math.floor(resultevol2));

                                    resultadocp.setText("Tu " + selec + " evolucionará a Kakuna con " + resu + " ó " + resu2 + " y a Beedrill con " + resuev + " ó " + resuev2);
                                    break;

                                case "Kakuna":
                                    mincp = 3.33;
                                    maxcp = 3.42;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Beedrill con " + resu + " ó " + resu2);
                                    break;

                                case "Pidgey":
                                    mincp = 1.82;
                                    maxcp = 1.95;
                                    mincpevl = 1.73;
                                    maxcpevl = 1.78;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;
                                    resultevol = resultado * mincpevl;
                                    resultevol2 = resultado2 * maxcpevl;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));

                                    resuev = String.valueOf((int) Math.floor(resultevol));
                                    resuev2 = String.valueOf((int) Math.floor(resultevol2));

                                    resultadocp.setText("Tu " + selec + " evolucionará a Pidgeotto con " + resu + " ó " + resu2 + " y a Pidgeot con " + resuev + " ó " + resuev2);
                                    break;

                                case "Pidgeotto":
                                    mincp = 1.73;
                                    maxcp = 1.78;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Pidgeot con " + resu + " ó " + resu2);
                                    break;


                                case "Rattata":
                                    mincp = 2.61;
                                    maxcp = 2.73;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Raticate con " + resu + " ó " + resu2);
                                    break;

                                case "Spearow":
                                    mincp = 2.58;
                                    maxcp = 2.81;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Fearow con " + resu + " ó " + resu2);
                                    break;
                                case "Ekans":
                                    mincp = 2.22;
                                    maxcp = 2.33;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Arbok con " + resu + " ó " + resu2);
                                    break;
                                case "Pikachu":
                                    mincp = 2.33;
                                    maxcp = 2.38;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Raichu con " + resu + " ó " + resu2);
                                    break;
                                case "Sandshrew":
                                    mincp = 2.35;
                                    maxcp = 2.76;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Sandslash con " + resu + " ó " + resu2);
                                    break;
                                case "Nidoran-hembra":
                                    mincp = 1.62;
                                    maxcp = 1.66;
                                    mincpevl = 1.8;
                                    maxcpevl = 2.04;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;
                                    resultevol = resultado * mincpevl;
                                    resultevol2 = resultado2 * maxcpevl;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));

                                    resuev = String.valueOf((int) Math.floor(resultevol));
                                    resuev2 = String.valueOf((int) Math.floor(resultevol2));

                                    resultadocp.setText("Tu " + selec + " evolucionará a Nidorina con " + resu + " ó " + resu2 + " y a Nidoqueen con " + resuev + " ó " + resuev2);
                                    break;

                                case "Nidorina":
                                    mincp = 1.8;
                                    maxcp = 2.04;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Nidoqueen con " + resu + " ó " + resu2);
                                    break;

                                case "Nidoran-macho":
                                    mincp = 1.65;
                                    maxcp = 1.7;
                                    mincpevl = 1.64;
                                    maxcpevl = 1.86;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;
                                    resultevol = resultado * mincpevl;
                                    resultevol2 = resultado2 * maxcpevl;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));

                                    resuev = String.valueOf((int) Math.floor(resultevol));
                                    resuev2 = String.valueOf((int) Math.floor(resultevol2));

                                    resultadocp.setText("Tu " + selec + " evolucionará a Nidorino con " + resu + " ó " + resu2 + " y a Nidoking con " + resuev + " ó " + resuev2);
                                    break;

                                case "Nidorino":
                                    mincp = 1.64;
                                    maxcp = 1.86;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Nidoking con " + resu + " ó " + resu2);
                                    break;
                                case "Clefairy":
                                    mincp = 2.02;
                                    maxcp = 2.2;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Clefable con " + resu + " ó " + resu2);
                                    break;
                                case "Vulpix":
                                    mincp = 2.68;
                                    maxcp = 2.74;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Ninetales con " + resu + " ó " + resu2);
                                    break;
                                case "Jigglypuff":
                                    mincp = 2.41;
                                    maxcp = 2.47;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Wigglytuff con " + resu + " ó " + resu2);
                                    break;
                                case "Zubat":
                                    mincp = 2.9;
                                    maxcp = 3.33;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Golbat con " + resu + " ó " + resu2);
                                    break;

                                case "Oddish":
                                    mincp = 1.48;
                                    maxcp = 1.51;
                                    mincpevl = 1.48;
                                    maxcpevl = 1.53;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;
                                    resultevol = resultado * mincpevl;
                                    resultevol2 = resultado2 * maxcpevl;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));

                                    resuev = String.valueOf((int) Math.floor(resultevol));
                                    resuev2 = String.valueOf((int) Math.floor(resultevol2));

                                    resultadocp.setText("Tu " + selec + " evolucionará a Gloom con " + resu + " ó " + resu2 + " y a Vileplume con " + resuev + " ó " + resuev2);
                                    break;

                                case "Gloom":
                                    mincp = 1.48;
                                    maxcp = 1.53;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Vileplume con " + resu + " ó " + resu2);
                                    break;

                                case "Paras":
                                    mincp = 1.92;
                                    maxcp = 2.02;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Parasect con " + resu + " ó " + resu2);
                                    break;
                                case "Venonat":
                                    mincp = 1.85;
                                    maxcp = 1.9;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Venomoth con " + resu + " ó " + resu2);
                                    break;
                                case "Diglett":
                                    mincp = 2.68;
                                    maxcp = 2.77;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Dugtrio con " + resu + " ó " + resu2);
                                    break;
                                case "Meowth":
                                    mincp = 1.98;
                                    maxcp = 2.24;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Persian con " + resu + " ó " + resu2);
                                    break;

                                case "Psyduck":
                                    mincp = 2.22;
                                    maxcp = 2.29;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Golduck con " + resu + " ó " + resu2);
                                    break;
                                case "Mankey":
                                    mincp = 2.15;
                                    maxcp = 2.28;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Primeape con " + resu + " ó " + resu2);
                                    break;
                                case "Growlithe":
                                    mincp = 2.25;
                                    maxcp = 2.36;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Arcanine con " + resu + " ó " + resu2);
                                    break;

                                case "Poliwag":
                                    mincp = 1.72;
                                    maxcp = 1.89;
                                    mincpevl = 1.9;
                                    maxcpevl = 1.96;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;
                                    resultevol = resultado * mincpevl;
                                    resultevol2 = resultado2 * maxcpevl;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));

                                    resuev = String.valueOf((int) Math.floor(resultevol));
                                    resuev2 = String.valueOf((int) Math.floor(resultevol2));

                                    resultadocp.setText("Tu " + selec + " evolucionará a Poliwhirl con " + resu + " ó " + resu2 + " y a Poliwrath con " + resuev + " ó " + resuev2);
                                    break;

                                case "Poliwhirl":
                                    mincp = 1.9;
                                    maxcp = 1.96;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Poliwrath con " + resu + " ó " + resu2);
                                    break;

                                case "Abra":
                                    mincp = 1.36;
                                    maxcp = 2;
                                    mincpevl = 1.41;
                                    maxcpevl = 1.65;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;
                                    resultevol = resultado * mincpevl;
                                    resultevol2 = resultado2 * maxcpevl;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));

                                    resuev = String.valueOf((int) Math.floor(resultevol));
                                    resuev2 = String.valueOf((int) Math.floor(resultevol2));

                                    resultadocp.setText("Tu " + selec + " evolucionará a Kadabra con " + resu + " ó " + resu2 + " y a Alakazam con " + resuev + " ó " + resuev2);
                                    break;

                                case "Kadabra":
                                    mincp = 1.41;
                                    maxcp = 1.65;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Alakazam con " + resu + " ó " + resu2);
                                    break;
                                case "Machop":
                                    mincp = 1.62;
                                    maxcp = 1.67;
                                    mincpevl = 1.48;
                                    maxcpevl = 1.7;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;
                                    resultevol = resultado * mincpevl;
                                    resultevol2 = resultado2 * maxcpevl;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));

                                    resuev = String.valueOf((int) Math.floor(resultevol));
                                    resuev2 = String.valueOf((int) Math.floor(resultevol2));

                                    resultadocp.setText("Tu " + selec + " evolucionará a Machoke con " + resu + " ó " + resu2 + " y a Machamp con " + resuev + " ó " + resuev2);
                                    break;

                                case "Machoke":
                                    mincp = 1.48;
                                    maxcp = 1.7;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Machamp con " + resu + " ó " + resu2);
                                    break;

                                case "Bellsprout":
                                    mincp = 1.54;
                                    maxcp = 1.6;
                                    mincpevl = 1.47;
                                    maxcpevl = 1.52;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;
                                    resultevol = resultado * mincpevl;
                                    resultevol2 = resultado2 * maxcpevl;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));

                                    resuev = String.valueOf((int) Math.floor(resultevol));
                                    resuev2 = String.valueOf((int) Math.floor(resultevol2));

                                    resultadocp.setText("Tu " + selec + " evolucionará a Weepinbell con " + resu + " ó " + resu2 + " y a Victreebel con " + resuev + " ó " + resuev2);
                                    break;

                                case "Weepinbell":
                                    mincp = 1.47;
                                    maxcp = 1.52;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Victreebel con " + resu + " ó " + resu2);
                                    break;

                                case "Tentacool":
                                    mincp = 2.47;
                                    maxcp = 2.6;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Tentacruel con " + resu + " ó " + resu2);
                                    break;
                                case "Geodude":
                                    mincp = 1.71;
                                    maxcp = 1.76;
                                    mincpevl = 1.63;
                                    maxcpevl = 1.72;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;
                                    resultevol = resultado * mincpevl;
                                    resultevol2 = resultado2 * maxcpevl;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));

                                    resuev = String.valueOf((int) Math.floor(resultevol));
                                    resuev2 = String.valueOf((int) Math.floor(resultevol2));

                                    resultadocp.setText("Tu " + selec + " evolucionará a Graveler con " + resu + " ó " + resu2 + " y a Golem con " + resuev + " ó " + resuev2);
                                    break;

                                case "Graveler":
                                    mincp = 1.63;
                                    maxcp = 1.72;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Golem con " + resu + " ó " + resu2);
                                    break;

                                case "Ponyta":
                                    mincp = 1.47;
                                    maxcp = 1.6;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Rapidash con " + resu + " ó " + resu2);
                                    break;

                                case "Slowpoke":
                                    mincp = 2.19;
                                    maxcp = 2.21;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Slowbro con " + resu + " ó " + resu2);
                                    break;

                                case "Magnemite":
                                    mincp = 2.16;
                                    maxcp = 2.2;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Magneton con " + resu + " ó " + resu2);
                                    break;

                                case "Doduo":
                                    mincp = 2.11;
                                    maxcp = 2.24;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Dodrio con " + resu + " ó " + resu2);
                                    break;

                                case "Seel":
                                    mincp = 1.96;
                                    maxcp = 2.03;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Dewgong con " + resu + " ó " + resu2);
                                    break;

                                case "Grimer":
                                    mincp = 2.03;
                                    maxcp = 2.17;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Muk con " + resu + " ó " + resu2);
                                    break;
                                case "Shellder":
                                    mincp = 2.62;
                                    maxcp = 2.65;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Cloyster con " + resu + " ó " + resu2);
                                    break;

                                case "Gastly":
                                    mincp = 1.75;
                                    maxcp = 1.83;
                                    mincpevl = 1.53;
                                    maxcpevl = 1.8;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;
                                    resultevol = resultado * mincpevl;
                                    resultevol2 = resultado2 * maxcpevl;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));

                                    resuev = String.valueOf((int) Math.floor(resultevol));
                                    resuev2 = String.valueOf((int) Math.floor(resultevol2));

                                    resultadocp.setText("Tu " + selec + " evolucionará a Haunter con " + resu + " ó " + resu2 + " y a Gengar con " + resuev + " ó " + resuev2);
                                    break;

                                case "Haunter":
                                    mincp = 1.53;
                                    maxcp = 1.8;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Gengar con " + resu + " ó " + resu2);
                                    break;

                                case "Drowzee":
                                    mincp = 2.05;
                                    maxcp = 2.11;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Hypno con " + resu + " ó " + resu2);
                                    break;

                                case "Krabby":
                                    mincp = 2.35;
                                    maxcp = 2.4;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Kingler con " + resu + " ó " + resu2);
                                    break;

                                case "Voltorb":
                                    mincp = 2.01;
                                    maxcp = 2.03;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Electrode con " + resu + " ó " + resu2);
                                    break;
                                case "Exeggcute":
                                    mincp = 2.7;
                                    maxcp = 3.18;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Exeggutor con " + resu + " ó " + resu2);
                                    break;
                                case "Cubone":
                                    mincp = 1.65;
                                    maxcp = 1.67;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Marowak con " + resu + " ó " + resu2);
                                    break;
                                case "Koffing":
                                    mincp = 1.95;
                                    maxcp = 2.1;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Weezing con " + resu + " ó " + resu2);
                                    break;
                                case "Rhyhorn":
                                    mincp = 1.9;
                                    maxcp = 1.91;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Rhydon con " + resu + " ó " + resu2);
                                    break;
                                case "Horsea":
                                    mincp = 2.19;
                                    maxcp = 2.23;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Seadra con " + resu + " ó " + resu2);
                                    break;
                                case "Goldeen":
                                    mincp = 2.14;
                                    maxcp = 2.24;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Seaking con " + resu + " ó " + resu2);
                                    break;
                                case "Staryu":
                                    mincp = 2.35;
                                    maxcp = 2.44;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Starmie con " + resu + " ó " + resu2);
                                    break;

                                case "Magikarp":
                                    mincp = 10.1;
                                    maxcp = 11.96;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Gyarados con " + resu + " ó " + resu2);
                                    break;
                                case "Eevee":
                                    double minvap = 2.62;
                                    double maxvap = 2.67;
                                    double minjol = 2.01;
                                    double maxjol = 2.09;
                                    double minfl = 2.46;
                                    double maxfl = 2.64;
                                    String resuvap, resuvap2, resujol, resujol2, resufla, resufla2;
                /*vaporeon*/
                                    double resultadovap = nro1 * minvap;
                                    double resultadovap2 = nro1 * maxvap;

                /*jolteon*/
                                    double resultadojol = nro1 * minjol;
                                    double resultadojol2 = nro1 * maxjol;

                /*flareon*/
                                    double resultadofla = nro1 * minfl;
                                    double resultadofla2 = nro1 * maxfl;

                                    resuvap = String.valueOf((int) Math.floor(resultadovap));
                                    resuvap2 = String.valueOf((int) Math.floor(resultadovap2));

                                    resujol = String.valueOf((int) Math.floor(resultadojol));
                                    resujol2 = String.valueOf((int) Math.floor(resultadojol2));

                                    resufla = String.valueOf((int) Math.floor(resultadofla));
                                    resufla2 = String.valueOf((int) Math.floor(resultadofla2));


                                    resultadocp.setText("Tu " + selec + " evolucionará dependiendo de su nick, si es Sparky evolucionará a jolteon con " +
                                            resujol + " ó " + resujol2 + " ,si su nick es Pyro evolucionará a Flareon con  " + resufla + " ó " + resufla2 +
                                            " y si su nick es Rainer evolucionará a Vaporeon con " + resuvap + " ó " + resuvap2);
                                    break;

                                case "Omanyte":
                                    mincp = 1.99;
                                    maxcp = 2.12;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Omastar con " + resu + " ó " + resu2);
                                    break;
                                case "Kabuto":
                                    mincp = 1.97;
                                    maxcp = 2.37;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Kabutops con " + resu + " ó " + resu2);
                                    break;

                                case "Dratini":
                                    mincp = 1.8;
                                    maxcp = 1.85;
                                    mincpevl = 2.03;
                                    maxcpevl = 2.08;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;
                                    resultevol = resultado * mincpevl;
                                    resultevol2 = resultado2 * maxcpevl;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));

                                    resuev = String.valueOf((int) Math.floor(resultevol));
                                    resuev2 = String.valueOf((int) Math.floor(resultevol2));

                                    resultadocp.setText("Tu " + selec + " evolucionará a Dragonair con " + resu + " ó " + resu2 + " y a Dragonite con " + resuev + " ó " + resuev2);
                                    break;

                                case "Dragonair":
                                    mincp = 2.03;
                                    maxcp = 2.08;
                                    resultado = nro1 * mincp;
                                    resultado2 = nro1 * maxcp;

                                    resu = String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                                    resu2 = String.valueOf((int) Math.floor(resultado2));


                                    resultadocp.setText("Tu " + selec + " evolucionará a Dragonite con " + resu + " ó " + resu2);
                                    break;
                            }
                        }//try
                        catch (Exception e){/*despues de hacer el if seguia dandome error (creo que debería haber puesto un return
                        ahora que caigo para que no siguiera haciendo el resto, bueno lo meto en este try catch y listo
                        if(ed_text.isEmpty() || ed_text.length() == 0 || ed_text.equals("") || ed_text == null)*/
                            Toast.makeText(getContext(),"Rellena el campo de CP",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                /**/
                return rootView;
            }
            else if(getArguments().getInt(ARG_SECTION_NUMBER)==2){
                View rootView = inflater.inflate(R.layout.fragment_pag2, container, false);
                lv1 =(ListView)rootView.findViewById(R.id.listView);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1, paises);
                lv1.setAdapter(adapter);
                return rootView;
            }
            else{
                View rootView = inflater.inflate(R.layout.fragment_main4, container, false);
                musica= (Button)rootView.findViewById(R.id.button6);
                final MediaPlayer mp = MediaPlayer.create(getContext(), R.raw.simpsweet);

              /*  AudioManager amanager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);
                int maxVolume = amanager.getStreamMaxVolume(AudioManager.STREAM_ALARM);
                amanager.setStreamVolume(AudioManager.STREAM_ALARM, maxVolume, 10);
                mp.setAudioStreamType(AudioManager.STREAM_ALARM);*/
                musica.setOnClickListener(new View.OnClickListener(){

                    public void onClick(View v) {
                        if(!mp.isPlaying()) {
                            Toast.makeText(getContext(),"Sube el volumen :D",Toast.LENGTH_SHORT).show();
                            mp.setVolume(1.0f,1.0f);
                            mp.start();
                            musica.setText("Parar");

                        }
                        else{
                            musica.setText("Comprobar si es segura la app");
                            mp.pause();
                        }

                    }
                });
                return rootView;

            }
          /*  View rootView = inflater.inflate(R.layout.fragment_main4, container, false);*/
       /*     TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));*/

        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "CALCULAR";
                case 1:
                    return "INFO";
                case 2:
                    return "ACERCA DE";
            }
            return null;
        }
    }



    public void operar2(View view) {
//el contexto lo necesito esto solo funciona en este caso
        Toast.makeText(getBaseContext(),"asdasd",Toast.LENGTH_SHORT).show();
    }

 }



