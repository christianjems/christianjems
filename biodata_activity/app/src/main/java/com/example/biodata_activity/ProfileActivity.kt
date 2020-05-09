package com.example.biodata_activity

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        ambilData()
        btnEditName.setOnClickListener {
            navigasiKeEditProfil()
        }

        }

    companion object {
        val REQUEST_CODE = 100
    }

    private fun navigasiKeEditProfil() {
        val intent = Intent(this, Edit_nama::class.java)
        val namaUser = txtName.text.toString()
        intent.putExtra("nama", namaUser)
        startActivityForResult(intent,REQUEST_CODE)
    }

    @SuppressLint("MissingSuperCall")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                val result = data?.getStringExtra("nama")
                txtName.text = result
            } else {
                Toast.makeText(this, "Edit failed", Toast.LENGTH_SHORT).show()

            }
        }
    }


    private fun ambilData() {
            val bundle = intent.extras
            val nama = bundle?.getString("nama")
            val gender = bundle?.getString("gender")
            val email = bundle?.getString("email")
            val telp = bundle?.getString("telp")
            val alamat = bundle?.getString("alamat")
            val Umur = bundle?.getString("Umur")

            txtName.text = nama
            txtGender.text = gender
            txtEmail.text = email
            txtTelp.text = telp
            txtAddress.text = alamat
            txtUmur.text = Umur

        }

    }