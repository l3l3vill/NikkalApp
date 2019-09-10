package com.digitalhouse.a0818moacn01_02.view.menuNavegacion.Favoritos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deezer.sdk.model.Artist;
import com.digitalhouse.a0818moacn01_02.R;
import com.digitalhouse.a0818moacn01_02.Utils.ResultListener;
import com.digitalhouse.a0818moacn01_02.controller.ArtistController;
import com.digitalhouse.a0818moacn01_02.controller.TracksController;
import com.digitalhouse.a0818moacn01_02.model.AlbumDeezer;
import com.digitalhouse.a0818moacn01_02.model.ArtistDeezer;
import com.digitalhouse.a0818moacn01_02.model.Favoritos;
import com.digitalhouse.a0818moacn01_02.model.TopChart;
import com.digitalhouse.a0818moacn01_02.model.Track;
import com.digitalhouse.a0818moacn01_02.view.MainActivity;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritoFragment extends Fragment { //implements AdaptadorFavoritos.AartistaFavoritodAdapterInterface {
   /* public static final String KEY_IMAGEN_ARTISTA_FAVORITO ="imagentArtistaFavorito";
    public static final String KEY_NOMBRE_ARTISTA_FAVORITO ="nombreArtistaFavorito";
    public static final String KEY_LISTA_ARTISTA_FAVORITO = "listaArtistaFavorito";*/


    private AdaptadorFavoritos adaptadorFavoritos;
    private Integer genreId;
    private View view;

    public FavoritoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_favorito, container, false);
        /*this.view = view;
        container = view.findViewById(R.id.rlayoutFavoritosContainer);*/

        //instancio adaptador
        adaptadorFavoritos = new AdaptadorFavoritos(new ArrayList<ArtistDeezer>());

        // buscamos la View
        RecyclerView recyclerView = view.findViewById(R.id.recyclerFavoritos);

        //DATOS instanciamos un controller
        ArtistController artistController = new ArtistController();
        artistController.getArtist(new ResultListener<List<ArtistDeezer>>() {
            @Override
            public void finish(List<ArtistDeezer> resultado) {
                adaptadorFavoritos.setArtistDeezers(resultado);
            }
        }, this.getContext(),genreId );


        //performance
        recyclerView.setHasFixedSize(true);

        //layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adaptadorFavoritos);


        return view;

    }

  /*  @Override
    public void cambiarDeActividad(ArtistDeezer artistDeezer) {
        //casteamos para decirle que es el contexto
        MainActivity mainActivity = (MainActivity) getActivity();
        Bundle bundle = new Bundle();
        bundle.putString();
    }*/
}