package com.eodeun.recyclerview_animation_01

import android.animation.ObjectAnimator
import android.animation.AnimatorSet
import android.support.v7.widget.RecyclerView



class AnimationUtil {

    fun animate(holder: RecyclerView.ViewHolder, goesDown: Boolean) {

        val animatorSet = AnimatorSet()

        val animatorTranslateY = ObjectAnimator.ofFloat(holder.itemView, "translationY", if (goesDown == true) 200f else -200f, 0f)
        animatorTranslateY.setDuration(1000)


        val animatorTranslateX = ObjectAnimator.ofFloat(holder.itemView, "translationX", -50f, 50f, -30f, 30f, -20f, 20f, -5f, 5f, 0f)
        animatorTranslateX.setDuration(1000)

        animatorSet.playTogether(animatorTranslateX, animatorTranslateY)

        //animatorSet.playTogether(animatorTranslateY);
        animatorSet.start()
    }
}