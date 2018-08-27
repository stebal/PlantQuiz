package com.stebal.plantquiz

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.media.Image
import android.os.AsyncTask
import android.os.Bundle
import android.provider.MediaStore
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var cameraButton: Button? = null
    private var photoGalleryButton: Button? = null
    private var imageTaken: ImageView? = null

    val OPEN_CAMERA_BUTTON_REQUEST_ID = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        /* Toast.makeText(this, "THE ONCREATE METHOD IS CALLED", Toast.LENGTH_SHORT).show()

        val myPlant: Plant = Plant(genus = "", species = "", cultivar = "", common = "", pictureName = "", description = "", difficulty = 0, id = 0 )

        myPlant.plantName = "" */

       /* var flower = Plant()
        var tree = Plant()

        var collectionOfPlants: ArrayList<Plant> = ArrayList()
        collectionOfPlants.add(flower)
        collectionOfPlants.add(tree) */

        cameraButton = findViewById(R.id.btnOpenCamera)
        photoGalleryButton = findViewById(R.id.btnOpenPhotoGallery)
        imageTaken = findViewById(R.id.imgTaken)

        cameraButton?.setOnClickListener(View.OnClickListener {

            Toast.makeText(this, "THE Camera Button is Clicked", Toast.LENGTH_SHORT).show()

            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent,OPEN_CAMERA_BUTTON_REQUEST_ID)
        })

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == OPEN_CAMERA_BUTTON_REQUEST_ID) {

            if (resultCode == Activity.RESULT_OK) {

                val imageData = data?.getExtras()?.get("data") as Bitmap
                imageTaken?.setImageBitmap(imageData)

            }
        }
    }

    fun button1IsClicked(buttonView: View) {

        Toast.makeText(this, "THE Button 1 is Clicked", Toast.LENGTH_SHORT).show()


    }

    fun button2IsClicked(buttonView: View) {

        Toast.makeText(this, "THE Button 2 is Clicked", Toast.LENGTH_SHORT).show()
    }

    fun button3IsClicked(buttonView: View) {

        Toast.makeText(this, "THE Button 3 is Clicked", Toast.LENGTH_SHORT).show()
    }

    fun button4IsClicked(buttonView: View) {

        Toast.makeText(this, "THE Button 4 is Clicked", Toast.LENGTH_SHORT).show()
    }

    inner class DownloadingPlantTask: AsyncTask<String, Int, List<Plant>>() {

        override fun doInBackground(vararg param: String?): List<Plant>? {
            // can access background thread. Not user interface.

            return null
        }

        override fun onPostExecute(result: List<Plant>?) {
            super.onPostExecute(result)

            // can access user interface thread. Not background thread
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
