package br.com.heiderlopes.yugiohanimacao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements Animation.AnimationListener {
    private Animation animation1;
    private Animation animation2;
    private boolean isBackOfCardShowing = true;

    private ImageView ivCarta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animation1 = AnimationUtils.loadAnimation(this, R.anim.fechar);
        animation1.setAnimationListener(this);
        animation2 = AnimationUtils.loadAnimation(this, R.anim.abrir);
        animation2.setAnimationListener(this);
        ivCarta = (ImageView) findViewById(R.id.ivCarta);
    }

    public void virarCarta(View v) {
        v.setEnabled(false);
        ivCarta.clearAnimation();
        ivCarta.setAnimation(animation1);
        ivCarta.startAnimation(animation1);
    }


    @Override
    public void onAnimationEnd(Animation animation) {
        if (animation == animation1) {
            if (isBackOfCardShowing) {
                ivCarta.setImageResource(R.drawable.carta_frente);
            } else {
                ivCarta.setImageResource(R.drawable.carta_tras);
            }
            ivCarta.clearAnimation();
            ivCarta.setAnimation(animation2);
            ivCarta.startAnimation(animation2);
        } else {
            isBackOfCardShowing = !isBackOfCardShowing;
            ivCarta.setEnabled(true);
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
    }

    @Override
    public void onAnimationStart(Animation animation) {
    }
}
