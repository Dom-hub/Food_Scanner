package com.univ_amu.food_scanner.ui;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.univ_amu.food_scanner.data.Food;
import com.univ_amu.food_scanner.data.Quantity;
import com.univ_amu.food_scanner.databinding.FoodItemBinding;
import com.univ_amu.food_scanner.databinding.QuantityItemBinding;

public class QuantityListAdapter extends ListAdapter<Quantity, QuantityListAdapter.ViewHolder> {

    QuantityListAdapter() {
        super(diffUtilCallback);
    }
    /*Création d'une vue à partir du layout précédent dans la méthode
     onCreateViewHolder.Pour cela, utiliser la méthode
     inflate de la classe FoodItemBinding créée automatiquement à partir du layout.
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int type) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        QuantityItemBinding binding =
                QuantityItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Quantity quantity = getItem(position);
        holder.bind(quantity);
    }

    /*-Modifiez le ViewHolder pour que son constructeur prenne en paramètre
    l'instance de la classe FoodItemBinding obtenue à la suite de la création
     de la vue à partir du layout au lieu de l'instance de TextView.
     Dans le constructeur de ViewHolder, passez au constructeur RecyclerView.ViewHolder
     la racine de la vue obtenue avec la méthode getRoot() de FoodItemBinding.

     -Modifiez l'implémentation de ViewHolder afin de conserver
     l'instance de FoodItemBinding passée au constructeur dans un
     attribut de classe nommé foodItemBinding.
     */
    public class ViewHolder extends RecyclerView.ViewHolder {

        private final QuantityItemBinding binding;

        //Ajoutez un attribut publique food de type Food à la classe ViewHolder.

        public Quantity quantity;

        /*Dans le constructeur de ViewHolder, assignez l'instance (this)
        du ViewHolder en cours de construction à la variable viewHolder
        du layout à l'aide de la méthode setViewHolder de la classe
        FoodItemBinding.
        Cette méthode a été générée automatiquement à partir de la
        définition des variables du layout.*/


        public ViewHolder(QuantityItemBinding binding) {
            super(binding.getRoot());
            binding.setViewHolder(this);
            this.binding = binding;
        }
        /* -Modifiez la méthode bind de la classe ViewHolder afin d'assigner
        à l'attribut food la référence de l'instance reçue par la méthode bind.
         -Appelez la méthode foodItemBinding.invalidateAll()
         pour demander la réexécution des bindings de la vue.
         */
        void bind(Quantity quantity) {
            this.quantity = quantity;
            this.binding.invalidateAll();
        }



    }

    private static final DiffUtil.ItemCallback<Quantity> diffUtilCallback =
            new DiffUtil.ItemCallback<Quantity>() {
                @Override
                public boolean areItemsTheSame(Quantity oldQuantity, Quantity newQuantity) {
                    return oldQuantity.name.equals(newQuantity.name);
                }
                @Override
                public boolean areContentsTheSame(Quantity oldQuantity, Quantity newQuantity) {
                    return this.areItemsTheSame(oldQuantity, newQuantity);
                }
            };

}

