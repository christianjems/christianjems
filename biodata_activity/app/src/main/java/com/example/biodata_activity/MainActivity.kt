package com.example.biodata_activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var editname: String = ""
    var editemail: String = ""
    var edittelp: String = ""
    var editalamat: String = ""
    var pilgend: String = ""
    var umur: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setDataSpinnerGender()

        btnSave.setOnClickListener { fungsiedit() }
    }

    private fun setDataSpinnerGender() {
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.jenis_kelamin, android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerGender.adapter = adapter
    }

    fun fungsiedit() {
        editname= edtName.text.toString()
        editemail = edtEmail.text.toString()
        edittelp = edtTelp.text.toString()
        editalamat = edtAddress.text.toString()
        pilgend = spinnerGender.selectedItem.toString()
        umur = Umur.text.toString()

        goToProfileActivity()
    }
    private fun goToProfileActivity() {
        val intent = Intent(this, ProfileActivity::class.java)
        val bundle = Bundle()
        bundle.putString("nama", editname)
        bundle.putString("gender", pilgend)
        bundle.putString("email", editname)
        bundle.putString("telp", edittelp)
        bundle.putString("alamat", editalamat)
        bundle.putString("Umur", umur)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}
