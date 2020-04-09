package com.univ_amu.food_scanner.ui;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;

import androidx.appcompat.widget.AppCompatTextView;

import com.univ_amu.food_scanner.R;

public class NutriscoreView extends AppCompatTextView {
    public NutriscoreView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // - modifier la taille du texte à 24sp (méthode setTextSize)
        setTextSize(24);
        //- modifier la gravité à Gravity.CENTER (méthode setGravity)
        setGravity(Gravity.CENTER );
        //- modifier la couleur du texte à Color.WHITE (méthode setTextColor)
        setTextColor(Color.WHITE);
    }

    public void setNutriscore(String nutriscore) {
        if (nutriscore == null) return;
        setBackgroundColor(getContext().getResources().getColor(colorId(nutriscore), null));

        // - afficher le nutriscore avec la méthode setText
        setText(nutriscore);
    }

    private int colorId(String nutriscore) {

        switch (nutriscore)
        {
            case "A":
                return R.color.nutriscore_A;

            case "B":
                return R.color.nutriscore_B;

            case "C":
                return R.color.nutriscore_C;

            case "D":
                return R.color.nutriscore_D;

            case "E":
                return R.color.nutriscore_E;

            default:
                return R.color.unknown_nutriscore;
        }
        //return android.R.color.black;
    }
}