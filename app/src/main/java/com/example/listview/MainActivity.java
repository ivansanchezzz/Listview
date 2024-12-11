package com.example.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lista;
    private TextView texto;
    private RadioButton radioButton_pulsado;

    public class Encapsulador {
        private int imagen;
        private String titulo;
        private String texto;
        private boolean dato1;

        public Encapsulador(int idImagen, String textoTitulo, String textoContenido, boolean favorito) {
            this.imagen = idImagen;
            this.titulo = textoTitulo;
            this.texto = textoContenido;
            this.dato1 = favorito;
        }

        public String get_textoTitulo() {
            return titulo;
        }

        public String get_textoContenido() {
            return texto;
        }

        public int get_idImagen() {
            return imagen;
        }

        public boolean get_checkBox1() {
            return dato1;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.listView);
        texto = findViewById(R.id.textFooter);

        ArrayList<Encapsulador> datos = new ArrayList<>();
        datos.add(new Encapsulador(R.drawable.stussy1, "FELT PATCH KNIT HOODIE", "\n" + "215€", false));
        datos.add(new Encapsulador(R.drawable.stussy2, "SHERPA REVERSIBLE JACKET", "\n" + "230€", false));
        datos.add(new Encapsulador(R.drawable.stussy3, "TRUCKER JACKET DENIM", "\n" + "200€", false));
        datos.add(new Encapsulador(R.drawable.stussy4, "WAXED BUILT BOMBER JACKET", "\n" + "\n" + "270€", false));
        datos.add(new Encapsulador(R.drawable.stussy5, "SHORT DOWN PUFFER", "\n" + "\n" + "330€", false));
        datos.add(new Encapsulador(R.drawable.stussy6, "WORK JACKET WOOL PLAID", "\n" + "\n" + "275€", false));
        datos.add(new Encapsulador(R.drawable.stussy7, "DOT STAMP HOODIE PIGMENT DYED", "\n" + "\n" + "145€", false));
        datos.add(new Encapsulador(R.drawable.stussy8, "SMOOTH INTERNATIONAL CREW PIGMENT", "\n" + "\n" + "135€", false));
        datos.add(new Encapsulador(R.drawable.stussy9, "FLEECE RAGLAN CREW", "\n" +    "\n" + "135€", false));
        datos.add(new Encapsulador(R.drawable.stussy10, "FLEECE RAGLAN HOODIE", "\n" + "\n" + "150€", false));

        lista.setAdapter(new Adaptador(this, R.layout.entrada, datos) {
            @Override
            public void onEntrada(Object entrada, View view) {
                if (entrada != null) {
                    TextView texto_superior_entrada = view.findViewById(R.id.texto_titulo);
                    TextView texto_inferior_entrada = view.findViewById(R.id.texto_datos);
                    ImageView imagen_entrada = view.findViewById(R.id.imagen);
                    RadioButton miRadio = view.findViewById(R.id.boton);

                    Encapsulador encapsulador = (Encapsulador) entrada;
                    texto_superior_entrada.setText(encapsulador.get_textoTitulo());
                    texto_inferior_entrada.setText(encapsulador.get_textoContenido());
                    imagen_entrada.setImageResource(encapsulador.get_idImagen());

                    miRadio.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (radioButton_pulsado != null) {
                                radioButton_pulsado.setChecked(false);
                            }
                            radioButton_pulsado = (RadioButton) v;
                            texto.setText("MARCADA UNA OPCIÓN");
                        }
                    });
                }
            }
        });
    }
}