package com.textview.persistenciadedatos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.textview.persistenciadedatos.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userDao: ContactDao

    private val db by lazy{
        Room.databaseBuilder(
            this,
            ContactDatabase::class.java,
            "contact_database"
        ).build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userDao = db.contactDao()

        showUsers()


        with(binding){
            btnAgregar.setOnClickListener{
                val name = edName.text.toString()
                val lastName = edLastName.text.toString()
                val gender = getGender(radioMujer)

                insertContact(name, lastName, gender)

                CleanEditText()

            }
        }

    }

    private fun insertContact(name: String, lastname: String, gender: String) {
        CoroutineScope(Dispatchers.IO).launch {
            var nextId  = userDao.getContacts().last().contactId + 2
            userDao.insert(Contact(nextId, name, lastname, gender))
        }
    }


    private fun showUsers() {
        CoroutineScope(Dispatchers.IO).launch {
            val recyclerView = findViewById<RecyclerView>(R.id.rv_list_item)
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.adapter = ListAdapter(userDao.getContacts())
        }
    }

    private fun CleanEditText(){
        with(binding){
            edName.text = null
            edLastName.text = null
        }

    }

    private fun getGender(view: View): String{
        if (view is RadioButton) {
            val checked = view.isChecked

            when (view.getId()) {
                R.id.radio_hombre ->
                    if (checked) {
                        return "H"
                    }
                R.id.radio_mujer ->
                    if (checked) {
                        return "M"
                    }
            }
        }
        return "H"
    }




}