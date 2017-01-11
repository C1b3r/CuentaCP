package arturoki.cuentacp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Spinner lista;
    private EditText etd;
    private TextView resultadocp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      /*  requestWindowFeature(Window.FEATURE_NO_TITLE);no es necesario si se ha tocado el styles.xml*/
        setContentView(R.layout.activity_main);
        etd=(EditText)findViewById(R.id.editText);
        resultadocp=(TextView)findViewById(R.id.textView3);

        lista = (Spinner) findViewById(R.id.spinner);
        String []opciones={"Bulbasaur","Ivysaur","Charmander","Charmeleon","Squirtle","Wartortle","Caterpie","Metapod","Weedle"
        ,"Kakuna","Pidgey","Pidgeotto","Rattata","Spearow","Ekans","Pikachu","Sandshrew","Nidoran-hembra","Nidorina","Nidoran-macho",
        "Nidorino","Clefairy","Vulpix","Jigglypuff","Zubat","Oddish","Gloom","Paras","Venonat","Diglett","Meowth","Psyduck","Mankey",
        "Growlithe","Poliwag","Poliwhirl","Abra","Kadabra","Machop","Machoke","Bellsprout","Weepinbell","Tentacool","Geodude","Graveler",
        "Ponyta","Slowpoke","Magnemite","Doduo","Seel","Grimer","Shellder","Gastly","Haunter","Drowzee","Krabby","Voltorb","Exeggcute",
         "Cubone","Koffing","Rhyhorn","Chansey","Horsea","Goldeen","Staryu","Magikarp","Eevee","Omanyte","Kabuto","Dratini","Dragonair"
        };
      /*  ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, opciones);*/
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, opciones);
        /*asi sale en modo lista http://www.edureka.co/blog/custom-spinner-in-android*/
        lista.setAdapter(adapter);
//metodo que vincula que cuando pulsemos
       /* lista.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override //al pulsarlo fisicamente, esto se genera solo
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {   //usamos el entero que nos da
                    case 1:

                        break;

                    case 2:

                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });*/
    }

    //Este método se ejecutará cuando se presione el botón
    public void operar(View view) {
        double mincp=0;
        double maxcp=0;
        double mincpevl=0;
        double maxcpevl=0;
        String valor1=etd.getText().toString();
        Double nro1= Double.parseDouble(etd.getText().toString());
        Double resultado;
        Double resultado2;
        Double resultevol;
        Double resultevol2;
        String resu;
        String resu2;
        String resuev;
        String resuev2;
        String selec=lista.getSelectedItem().toString();

        switch (selec){
            case "Bulbasaur":
                mincp=1.53;
                maxcp=1.58;
                mincpevl=1.2;
                maxcpevl=1.6;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;
                resultevol=resultado*mincpevl;
                resultevol2=resultado2*maxcpevl;

               /* String resu*/resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
               /* String resu2*/resu2=String.valueOf((int) Math.floor(resultado2));

               /* String resuev*/ resuev=String.valueOf((int) Math.floor(resultevol));
                /*String resuev2*/ resuev2=String.valueOf((int) Math.floor(resultevol2));

                resultadocp.setText("Tu "+ selec +" evolucionará a Ivysaur con "+resu + " ó "+resu2+ " y a Venusaur con "+resuev+" ó "+resuev2);
                break;
            case "Ivysaur":
                mincp=1.2;
                maxcp=1.6;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Venusaur con "+resu + " ó "+resu2);
                break;
            case "Charmander":
                mincp=1.64;
                maxcp=1.7;
                mincpevl=1.71;
                maxcpevl=1.79;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;
                resultevol=resultado*mincpevl;
                resultevol2=resultado2*maxcpevl;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                 resu2=String.valueOf((int) Math.floor(resultado2));

                 resuev=String.valueOf((int) Math.floor(resultevol));
                 resuev2=String.valueOf((int) Math.floor(resultevol2));

                resultadocp.setText("Tu "+ selec +" evolucionará a Charmeleon con "+resu + " ó "+resu2+ " y a Charizard con "+resuev+" ó "+resuev2);
                break;

            case "Charmeleon":
                mincp=1.64;
                maxcp=1.7;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Charizard con "+resu + " ó "+resu2);
                break;

            case "Squirtle":
                mincp=1.58;
                maxcp=2.1;
                mincpevl=1.4;
                maxcpevl=1.65;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;
                resultevol=resultado*mincpevl;
                resultevol2=resultado2*maxcpevl;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));

                resuev=String.valueOf((int) Math.floor(resultevol));
                resuev2=String.valueOf((int) Math.floor(resultevol2));

                resultadocp.setText("Tu "+ selec +" evolucionará a Wartortle con "+resu + " ó "+resu2+ " y a Blastoise con "+resuev+" ó "+resuev2);
                break;

            case "Wartortle":
                mincp=1.4;
                maxcp=1.65;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Blastoise con "+resu + " ó "+resu2);
                break;

            case "Caterpie":
                mincp=1.04;
                maxcp=1.08;
                mincpevl=3.55;
                maxcpevl=3.79;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;
                resultevol=resultado*mincpevl;
                resultevol2=resultado2*maxcpevl;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));

                resuev=String.valueOf((int) Math.floor(resultevol));
                resuev2=String.valueOf((int) Math.floor(resultevol2));

                resultadocp.setText("Tu "+ selec +" evolucionará a Metapod con "+resu + " ó "+resu2+ " y a Butterfree con "+resuev+" ó "+resuev2);
                break;

            case "Metapod":
                mincp=3.55;
                maxcp=3.79;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Butterfree con "+resu + " ó "+resu2);
                break;

            case "Weedle":
                mincp=1.06;
                maxcp=1.13;
                mincpevl=3.01;
                maxcpevl=3.42;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;
                resultevol=resultado*mincpevl;
                resultevol2=resultado2*maxcpevl;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));

                resuev=String.valueOf((int) Math.floor(resultevol));
                resuev2=String.valueOf((int) Math.floor(resultevol2));

                resultadocp.setText("Tu "+ selec +" evolucionará a Kakuna con "+resu + " ó "+resu2+ " y a Beedrill con "+resuev+" ó "+resuev2);
                break;

            case "Kakuna":
                mincp=3.01;
                maxcp=3.42;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Beedrill con "+resu + " ó "+resu2);
                break;

            case "Pidgey":
                mincp=1.71;
                maxcp=1.80;
                mincpevl=1.73;
                maxcpevl=3.42;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;
                resultevol=resultado*mincpevl;
                resultevol2=resultado2*maxcpevl;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));

                resuev=String.valueOf((int) Math.floor(resultevol));
                resuev2=String.valueOf((int) Math.floor(resultevol2));

                resultadocp.setText("Tu "+ selec +" evolucionará a Pidgeotto con "+resu + " ó "+resu2+ " y a Pidgeot con "+resuev+" ó "+resuev2);
                break;

            case "Pidgeotto":
                mincp=1.73;
                maxcp=1.80;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Pidgeot con "+resu + " ó "+resu2);
                break;


            case "Rattata":
                mincp=2.55;
                maxcp=2.73;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Raticate con "+resu + " ó "+resu2);
                break;

            case "Spearow":
                mincp=2.58;
                maxcp=2.81;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Fearow con "+resu + " ó "+resu2);
                break;
            case "Ekans":
                mincp=2.21;
                maxcp=2.27;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Arbok con "+resu + " ó "+resu2);
                break;
            case "Pikachu":
                mincp=2.33;
                maxcp=2.38;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Raichu con "+resu + " ó "+resu2);
                break;
            case "Sandshrew":
                mincp=2.30;
                maxcp=2.76;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Sandslash con "+resu + " ó "+resu2);
                break;
            case "Nidoran-hembra":
                mincp=1.63;
                maxcp=2.48;
                mincpevl=1.83;
                maxcpevl=2.48;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;
                resultevol=resultado*mincpevl;
                resultevol2=resultado2*maxcpevl;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));

                resuev=String.valueOf((int) Math.floor(resultevol));
                resuev2=String.valueOf((int) Math.floor(resultevol2));

                resultadocp.setText("Tu "+ selec +" evolucionará a Nidorina con "+resu + " ó "+resu2+ " y a Nidoqueen con "+resuev+" ó "+resuev2);
                break;

            case "Nidorina":
                mincp=1.83;
                maxcp=2.48;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Nidoqueen con "+resu + " ó "+resu2);
                break;

            case "Nidoran-macho":
                mincp=1.64;
                maxcp=1.7;
                mincpevl=1.64;
                maxcpevl=1.86;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;
                resultevol=resultado*mincpevl;
                resultevol2=resultado2*maxcpevl;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));

                resuev=String.valueOf((int) Math.floor(resultevol));
                resuev2=String.valueOf((int) Math.floor(resultevol2));

                resultadocp.setText("Tu "+ selec +" evolucionará a Nidorino con "+resu + " ó "+resu2+ " y a Nidoking con "+resuev+" ó "+resuev2);
                break;

            case "Nidorino":
                mincp=1.64;
                maxcp=1.86;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Nidoking con "+resu + " ó "+resu2);
                break;
            case "Clefairy":
                mincp=2.03;
                maxcp=2.14;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Clefable con "+resu + " ó "+resu2);
                break;
            case "Vulpix":
                mincp=2.74;
                maxcp=2.81;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Ninetales con "+resu + " ó "+resu2);
                break;
            case "Jigglypuff":
                mincp=2.41;
                maxcp=2.47;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Wigglytuff con "+resu + " ó "+resu2);
                break;
            case "Zubat":
                mincp=2.6;
                maxcp=3.67;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Golbat con "+resu + " ó "+resu2);
                break;

            case "Oddish":
                mincp=1.48;
                maxcp=1.51;
                mincpevl=1.48;
                maxcpevl=1.53;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;
                resultevol=resultado*mincpevl;
                resultevol2=resultado2*maxcpevl;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));

                resuev=String.valueOf((int) Math.floor(resultevol));
                resuev2=String.valueOf((int) Math.floor(resultevol2));

                resultadocp.setText("Tu "+ selec +" evolucionará a Gloom con "+resu + " ó "+resu2+ " y a Vileplume con "+resuev+" ó "+resuev2);
                break;

            case "Gloom":
                mincp=1.48;
                maxcp=1.53;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Vileplume con "+resu + " ó "+resu2);
                break;

            case "Paras":
                mincp=1.92;
                maxcp=2.02;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Parasect con "+resu + " ó "+resu2);
                break;
            case "Venonat":
                mincp=1.86;
                maxcp=1.9;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Venomoth con "+resu + " ó "+resu2);
                break;
            case "Diglett":
                mincp=2.68;
                maxcp=2.77;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Dugtrio con "+resu + " ó "+resu2);
                break;
            case "Meowth":
                mincp=1.98;
                maxcp=2.24;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Persian con "+resu + " ó "+resu2);
                break;

            case "Psyduck":
                mincp=2.22;
                maxcp=2.29;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Golduck con "+resu + " ó "+resu2);
                break;
            case "Mankey":
                mincp=2.17;
                maxcp=2.28;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Primeape con "+resu + " ó "+resu2);
                break;
            case "Growlithe":
                mincp=2.31;
                maxcp=2.36;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Arcanine con "+resu + " ó "+resu2);
                break;

            case "Poliwag":
                mincp=1.72;
                maxcp=1.77;
                mincpevl=1.9;
                maxcpevl=1.96;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;
                resultevol=resultado*mincpevl;
                resultevol2=resultado2*maxcpevl;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));

                resuev=String.valueOf((int) Math.floor(resultevol));
                resuev2=String.valueOf((int) Math.floor(resultevol2));

                resultadocp.setText("Tu "+ selec +" evolucionará a Poliwhirl con "+resu + " ó "+resu2+ " y a Poliwrath con "+resuev+" ó "+resuev2);
                break;

            case "Poliwhirl":
                mincp=1.9;
                maxcp=1.96;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Poliwrath con "+resu + " ó "+resu2);
                break;

            case "Abra":
                mincp=1.36;
                maxcp=1.95;
                mincpevl=1.4;
                maxcpevl=1.65;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;
                resultevol=resultado*mincpevl;
                resultevol2=resultado2*maxcpevl;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));

                resuev=String.valueOf((int) Math.floor(resultevol));
                resuev2=String.valueOf((int) Math.floor(resultevol2));

                resultadocp.setText("Tu "+ selec +" evolucionará a Kadabra con "+resu + " ó "+resu2+ " y a Alakazam con "+resuev+" ó "+resuev2);
                break;

            case "Kadabra":
                mincp=1.4;
                maxcp=1.65;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Alakazam con "+resu + " ó "+resu2);
                break;
            case "Machop":
                mincp=1.62;
                maxcp=1.67;
                mincpevl=1.48;
                maxcpevl=1.7;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;
                resultevol=resultado*mincpevl;
                resultevol2=resultado2*maxcpevl;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));

                resuev=String.valueOf((int) Math.floor(resultevol));
                resuev2=String.valueOf((int) Math.floor(resultevol2));

                resultadocp.setText("Tu "+ selec +" evolucionará a Machoke con "+resu + " ó "+resu2+ " y a Machamp con "+resuev+" ó "+resuev2);
                break;

            case "Machoke":
                mincp=1.48;
                maxcp=1.7;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Machamp con "+resu + " ó "+resu2);
                break;

            case "Bellsprout":
                mincp=1.54;
                maxcp=1.6;
                mincpevl=1.47;
                maxcpevl=1.49;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;
                resultevol=resultado*mincpevl;
                resultevol2=resultado2*maxcpevl;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));

                resuev=String.valueOf((int) Math.floor(resultevol));
                resuev2=String.valueOf((int) Math.floor(resultevol2));

                resultadocp.setText("Tu "+ selec +" evolucionará a Weepinbell con "+resu + " ó "+resu2+ " y a Victreebel con "+resuev+" ó "+resuev2);
                break;

            case "Weepinbell":
                mincp=1.47;
                maxcp=1.49;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Victreebel con "+resu + " ó "+resu2);
                break;

            case "Tentacool":
                mincp=2.47;
                maxcp=2.6;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Tentacruel con "+resu + " ó "+resu2);
                break;
            case "Geodude":
                mincp=1.73;
                maxcp=1.76;
                mincpevl=1.64;
                maxcpevl=1.72;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;
                resultevol=resultado*mincpevl;
                resultevol2=resultado2*maxcpevl;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));

                resuev=String.valueOf((int) Math.floor(resultevol));
                resuev2=String.valueOf((int) Math.floor(resultevol2));

                resultadocp.setText("Tu "+ selec +" evolucionará a Graveler con "+resu + " ó "+resu2+ " y a Golem con "+resuev+" ó "+resuev2);
                break;

            case "Graveler":
                mincp=1.64;
                maxcp=1.72;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Golem con "+resu + " ó "+resu2);
                break;

            case "Ponyta":
                mincp=1.46;
                maxcp=1.5;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Rapidash con "+resu + " ó "+resu2);
                break;

            case "Slowpoke":
                mincp=2.19;
                maxcp=2.21;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Slowbro con "+resu + " ó "+resu2);
                break;

            case "Magnemite":
                mincp=2.16;
                maxcp=2.18;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Magneton con "+resu + " ó "+resu2);
                break;

            case "Doduo":
                mincp=2.19;
                maxcp=2.30;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Dodrio con "+resu + " ó "+resu2);
                break;

            case "Seel":
                mincp=1.04;
                maxcp=1.96;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Dewgong con "+resu + " ó "+resu2);
                break;

            case "Grimer":
                mincp=2.01;
                maxcp=2.44;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Muk con "+resu + " ó "+resu2);
                break;
            case "Shellder":
                mincp=2.62;
                maxcp=2.65;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Cloyster con "+resu + " ó "+resu2);
                break;

            case "Gastly":
                mincp=1.75;
                maxcp=1.83;
                mincpevl=1.56;
                maxcpevl=1.8;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;
                resultevol=resultado*mincpevl;
                resultevol2=resultado2*maxcpevl;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));

                resuev=String.valueOf((int) Math.floor(resultevol));
                resuev2=String.valueOf((int) Math.floor(resultevol2));

                resultadocp.setText("Tu "+ selec +" evolucionará a Haunter con "+resu + " ó "+resu2+ " y a Gengar con "+resuev+" ó "+resuev2);
                break;

            case "Haunter":
                mincp=1.56;
                maxcp=1.8;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Gengar con "+resu + " ó "+resu2);
                break;

            case "Drowzee":
                mincp=2.06;
                maxcp=2.09;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Hypno con "+resu + " ó "+resu2);
                break;

            case "Krabby":
                mincp=2.32;
                maxcp=2.4;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Kingler con "+resu + " ó "+resu2);
                break;

            case "Voltorb":
                mincp=2.01;
                maxcp=2.02;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Electrode con "+resu + " ó "+resu2);
                break;
            case "Exeggcute":
                mincp=2.70;
                maxcp=3.18;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Exeggutor con "+resu + " ó "+resu2);
                break;
            case "Cubone":
                mincp=1.65;
                maxcp=1.67;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Marowak con "+resu + " ó "+resu2);
                break;
            case "Koffing":
                mincp=1.95;
                maxcp=2.025;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Weezing con "+resu + " ó "+resu2);
                break;
            case "Rhyhorn":
                mincp=1.9;
                maxcp=1.91;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Rhydon con "+resu + " ó "+resu2);
                break;
            case "Horsea":
                mincp=2.19;
                maxcp=2.23;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Seadra con "+resu + " ó "+resu2);
                break;
            case "Goldeen":
                mincp=2.14;
                maxcp=2.24;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Seaking con "+resu + " ó "+resu2);
                break;
            case "Staryu":
                mincp=2.35;
                maxcp=2.41;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Starmie con "+resu + " ó "+resu2);
                break;

            case "Magikarp":
                mincp=10.1;
                maxcp=11.8;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Gyarados con "+resu + " ó "+resu2);
                break;
            case "Eevee":
                double minvap=2.63;
                double maxvap=2.73;
                double minjol=2;
                double maxjol=2.1;
                double minfl=2.47;
                double maxfl=2.483;
                String resuvap, resuvap2, resujol,resujol2,resufla,resufla2;
                /*vaporeon*/
               double resultadovap= nro1*minvap;
                double resultadovap2= nro1*maxvap;

                /*jolteon*/
                double resultadojol= nro1*minjol;
                double resultadojol2= nro1*maxjol;

                /*flareon*/
                double resultadofla= nro1*minfl;
                double resultadofla2= nro1*maxfl;

                resuvap=String.valueOf((int) Math.floor(resultadovap));
                resuvap2=String.valueOf((int) Math.floor(resultadovap2));

                resujol=String.valueOf((int) Math.floor(resultadojol));
                resujol2=String.valueOf((int) Math.floor(resultadojol2));

                resufla=String.valueOf((int) Math.floor(resultadofla));
                resufla2=String.valueOf((int) Math.floor(resultadofla2));


                resultadocp.setText("Tu "+ selec +" evolucionará dependiendo de su nick, si es Sparky evolucionará a jolteon con " +
                        resujol + " ó "+resujol2+ " ,si su nick es Pyro evolucionará a Flareon con  "+resufla+" ó "+resufla2 +
               " y si su nick es Rainer evolucionará a Vaporeon con "+resuvap+" ó "+ resuvap2  );
                break;

            case "Omanyte":
                mincp=1.99;
                maxcp=2.12;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Omastar con "+resu + " ó "+resu2);
                break;
            case "Kabuto":
                mincp=1.97;
                maxcp=2.37;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Kabutops con "+resu + " ó "+resu2);
                break;

            case "Dratini":
                mincp=1.8;
                maxcp=1.85;
                mincpevl=2.03;
                maxcpevl=2.08;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;
                resultevol=resultado*mincpevl;
                resultevol2=resultado2*maxcpevl;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));

                resuev=String.valueOf((int) Math.floor(resultevol));
                resuev2=String.valueOf((int) Math.floor(resultevol2));

                resultadocp.setText("Tu "+ selec +" evolucionará a Dragonair con "+resu + " ó "+resu2+ " y a Dragonite con "+resuev+" ó "+resuev2);
                break;

            case "Dragonair":
                mincp=2.03;
                maxcp=2.08;
                resultado= nro1*mincp;
                resultado2= nro1*maxcp;

                resu=String.valueOf((int) Math.floor(resultado));/*lo convierto a int y lo redondeo hacia abajo*/
                resu2=String.valueOf((int) Math.floor(resultado2));


                resultadocp.setText("Tu "+ selec +" evolucionará a Dragonite con "+resu + " ó "+resu2);
                break;
        }
        /*if (selec.equals("sumar")) {
            int suma=nro1+nro2;
            String resu=String.valueOf(suma);
            tv3.setText(resu);
        } else
        if (selec.equals("restar")) {
            int resta=nro1-nro2;
            String resu=String.valueOf(resta);
            tv3.setText(resu);
        }
        else
        if (selec.equals("multiplicar")) {
            int multi=nro1*nro2;
            String resu=String.valueOf(multi);
            tv3.setText(resu);
        }
        else
        if (selec.equals("dividir")) {
            int divi=nro1/nro2;
            String resu=String.valueOf(divi);
            tv3.setText(resu);
        }*/
    }
    public void info(View view) {
        Intent i = new Intent(this, Main3Activity.class );
        startActivity(i);
    }
}
