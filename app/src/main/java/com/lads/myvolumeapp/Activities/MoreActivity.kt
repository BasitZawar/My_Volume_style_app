package com.lads.myvolumeapp.Activities

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.hmomeni.verticalslider.BuildConfig
import com.lads.myvolumeapp.databinding.ActivityMoreBinding


class MoreActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Build.VERSION.SDK_INT >= 21) {
            val window: Window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.setStatusBarColor(this.resources.getColor(com.lads.myvolumeapp.R.color.theme))
        }

        binding = ActivityMoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            layoutfeedBack.setOnClickListener {
                feedback()
            }
            layoutUpdate.setOnClickListener {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps")
                    )
                )
            }
            layoutShare.setOnClickListener {
                shareIt()
            }
            layoutPrivacy.setOnClickListener {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://ufappswing.blogspot.com/")
                    )
                )

            }
        }
    }

    //Feedback
    private fun feedback() {
        val feedbackEmail = Intent(Intent.ACTION_SEND)
        feedbackEmail.type = "text/email"
        feedbackEmail.putExtra(Intent.EXTRA_EMAIL, arrayOf("basitzawar@gmail.com"))
        feedbackEmail.putExtra(Intent.EXTRA_SUBJECT, "Feedback")
        startActivity(Intent.createChooser(feedbackEmail, "Send Feedback:"))
    }

    //ShareApp Link ....
    fun shareIt() {
        try {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name")
            var shareMessage = "\nLet me recommend you this application\n\n"
            val mBuildConfig: BuildConfig? = null
            shareMessage =
                """
            ${shareMessage}https://play.google.com/store/apps/details?id=com.lads.myvolumeapp}
            """.trimIndent()
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
            startActivity(Intent.createChooser(shareIntent, "choose one"))
        } catch (e: Exception) {
            //e.toString();
        }
    }
}