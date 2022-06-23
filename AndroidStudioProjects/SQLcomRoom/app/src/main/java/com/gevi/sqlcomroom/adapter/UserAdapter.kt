package com.gevi.sqlcomroom.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gevi.sqlcomroom.data.Usuario
import com.gevi.sqlcomroom.databinding.CardlayoutBinding

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    var listUser = emptyList<Usuario>()

    class UserViewHolder (val binding: CardlayoutBinding ): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
    return UserViewHolder(CardlayoutBinding.inflate(LayoutInflater.from(parent.context), parent,
        false
    ))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = listUser[position]

        holder.binding.textId.text = user.id.toString()
        holder.binding.textNome.text = user.nome
        holder.binding.textSobrenome.text = user.sobrenome
        holder.binding.textIdade.text = user.idade.toString()
    }

    override fun getItemCount(): Int {
       return listUser.size
    }
    fun setlist (list: List<Usuario>){
        listUser = list
        notifyDataSetChanged()
    }
}