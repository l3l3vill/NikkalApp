package com.digitalhouse.a0818moacn01_02.view.menuNavegacion.Favoritos;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.digitalhouse.a0818moacn01_02.R;
import com.digitalhouse.a0818moacn01_02.model.AlbumDeezer;
import com.digitalhouse.a0818moacn01_02.model.ArtistDeezer;
import com.digitalhouse.a0818moacn01_02.model.Favoritos;
import com.digitalhouse.a0818moacn01_02.model.Track;
import com.digitalhouse.a0818moacn01_02.model.Tracks;
import com.digitalhouse.a0818moacn01_02.view.adapter.AlbumAdapterRecyclerView;

import java.util.List;

public class AdaptadorFavoritos extends RecyclerView.Adapter {
    //atributos. no tomamos como Atributo una lista de favoritos ya que aún no manejamos base de datos donde almacenar el favorito del usuario
    private List<ArtistDeezer> artistDeezers;
    //private AartistaFavoritodAdapterInterface escuchador; COMENTADO MIENTRAS HAGO COMUNICACION ENTRE FRAGMENTS

    //CONSTRUCTOR


    public AdaptadorFavoritos(List<ArtistDeezer> artistDeezers){ //AartistaFavoritodAdapterInterface escuchador) {COMENTADO MIENTRAS HAGO COMUNICACION ENTRE FRAGMENTS
        this.artistDeezers = artistDeezers;
        //this.escuchador = escuchador;
    }

    //GETTER
    public List<ArtistDeezer> getArtistDeezers() {
        return artistDeezers;
    }

    //SETTER
    public void setArtistDeezers(List<ArtistDeezer> artistDeezers) {
        this.artistDeezers = artistDeezers;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //crea la celda en java
        Context context = viewGroup.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View viewCelda = layoutInflater.inflate(R.layout.cardview_celda_favorito,viewGroup,false);
        ViewHolderArtistaFavorito viewHolderAlbumFavoritos = new ViewHolderArtistaFavorito(viewCelda);
        return viewHolderAlbumFavoritos;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        //une la celda con la posicion. busca la posicion y carga a la view.
        ArtistDeezer artistDeezer = artistDeezers.get(i);
        AdaptadorFavoritos.ViewHolderArtistaFavorito viewHolderArtistaFavorito = (AdaptadorFavoritos.ViewHolderArtistaFavorito) viewHolder;
        viewHolderArtistaFavorito.cargarAlbumFavoritos(artistDeezer);

    }

    @Override
    public int getItemCount() {
        //cantidad de elementos
        return artistDeezers.size();
    }

    //CLASE ANÓNIMA----------TODAVIA NO USO PQ NO HE HECHO COMUNICACION ENTRE FRAGMENTS
    public interface AartistaFavoritodAdapterInterface {
        void cambiarDeActividad(ArtistDeezer artistDeezer);
    }


    //VIEWHOLDER
    private class ViewHolderArtistaFavorito extends RecyclerView.ViewHolder{

        //ATRIBUTOS
        private TextView textViewViewHolderFavoritosTitulo;
        private TextView textViewViewHolderFavoritosSubtitulo;
        private ImageView imageViewHolderFavoritos;

        //CONSTRUCTOR
        public ViewHolderArtistaFavorito(@NonNull View itemView) {
            super(itemView);
            textViewViewHolderFavoritosTitulo = itemView.findViewById(R.id.tvTituloEscuchadoRecientemente);
            textViewViewHolderFavoritosSubtitulo = itemView.findViewById(R.id.tvSubTituloEscuchadoRecientemente);
            imageViewHolderFavoritos = itemView.findViewById(R.id.ivEscuchadoRecientemente);
        }

        //MÉTODO
        public void cargarAlbumFavoritos (ArtistDeezer artistDeezer){
            textViewViewHolderFavoritosTitulo.setText(artistDeezer.getName());
            textViewViewHolderFavoritosSubtitulo.setText(artistDeezer.getTracklist());
            Glide.with(itemView.getContext()).load(artistDeezer.getPicture()).into(imageViewHolderFavoritos);
            //imageViewHolderFavoritos.setImageResource(favorito.getFavoritoImagen());
        }
    }
}
