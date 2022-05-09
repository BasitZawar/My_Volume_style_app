package com.lads.myvolumeapp.Activities

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.TextView
import androidx.core.app.ActivityCompat.finishAffinity
import com.lads.myvolumeapp.R

class BackgroundDialog(private val context: Context) {
    fun alertDialogShow() {
        val dialog = Dialog(context)
        // setting content view to dialog
        dialog.setContentView(R.layout.exit_dialogue)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
        // getting reference of TextView

        val tv_label_no = dialog.findViewById<TextView>(R.id.tv_label_no)
        val tv_label_yes = dialog.findViewById<TextView>(R.id.tv_label_yes)

        tv_label_no.setOnClickListener {
            dialog.dismiss()
        }
        tv_label_yes.setOnClickListener {
            finishAffinity(context as Activity)
            dialog.dismiss()
        }
    }
}