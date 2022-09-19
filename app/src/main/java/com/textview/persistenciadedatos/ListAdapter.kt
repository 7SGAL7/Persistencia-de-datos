package com.textview.persistenciadedatos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.textview.persistenciadedatos.databinding.ListElementBinding
import kotlinx.coroutines.flow.Flow

class ListAdapter(val personList: List<Contact>): RecyclerView.Adapter<PersonHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PersonHolder(layoutInflater.inflate(R.layout.list_element, parent, false))
    }

    override fun getItemCount(): Int = personList.size


    override fun onBindViewHolder(holder: PersonHolder, position: Int) {

        holder.render(personList[position])
    }



}

