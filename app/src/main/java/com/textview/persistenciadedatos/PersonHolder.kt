package com.textview.persistenciadedatos


import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.textview.persistenciadedatos.databinding.ListElementBinding




class PersonHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ListElementBinding.bind(view)

/*
    val personId = view.findViewById<TextView>(R.id.tv_id)
    val personName = view.findViewById<TextView>(R.id.tv_name)
    val personLastName = view.findViewById<TextView>(R.id.tv_lastname)
    val personGender = view.findViewById<TextView>(R.id.tv_gender)
    val background = view.findViewById<LinearLayout>(R.id.ia_content)
    val img = view.findViewById<ImageView>(R.id.iv_icon)
    */


    fun render(person: Contact) {
        with(binding){
            tvName.text = person.firstName
            tvLastname.text = person.lastName
            tvGender.text = person.gender
            tvId.text = person.contactId.toString()

            binding.iaContent.background
            if (person.gender == "M"){
                iaContent.setBackgroundResource(R.color.pink_list)
                ivIcon.setImageResource(R.drawable.ic_woman_fill0_wght400_grad0_opsz48)
            }

            btnDelete.setOnClickListener{
                tvName.text = "Test"
            }
        }

        itemView.setOnClickListener{
            Toast.makeText(
                binding.tvId.context,
                person.firstName,
                Toast.LENGTH_SHORT
            )


        }
    }


}




