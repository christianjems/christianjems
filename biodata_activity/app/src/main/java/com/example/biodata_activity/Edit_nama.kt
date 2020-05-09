package com.example.biodata_activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_nama.*
import kotlinx.android.synthetic.main.activity_profile.*

class Edit_nama : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_nama)
        val intentData = intent.extras
        val namaUser = intentData?.getString("nama")
        txtName.setText(namaUser)
        btn_simpan.setOnClickListener { saveData() }
        }

        private fun saveData(){
            val namaEdit = txtName.text.toString()
            if (!namaEdit.isEmpty()){

                val result = Intent()
                result.putExtra("nama", namaEdit)
                setResult(Activity.RESULT_OK, result)
            } else {
                setResult(Activity.RESULT_CANCELED)
            }
            finish()
        }


    }

