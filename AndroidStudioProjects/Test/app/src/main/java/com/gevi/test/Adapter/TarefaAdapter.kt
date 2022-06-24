package com.gevi.test.Adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gevi.test.MainViewMode
import com.gevi.test.databinding.CardlayoutBinding
import com.gevi.test.model.Tarefa

class TarefaAdapter (
    val taskClickListener: TaskClickListener,
    val mainViewMode: MainViewMode,
    val context: Context
        ): RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder> () {

  private var  listTarefa = emptyList<Tarefa>()

class TarefaViewHolder (val binding: CardlayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarefaViewHolder {
       return TarefaViewHolder(CardlayoutBinding.inflate(LayoutInflater.from(parent.context)
           ,parent,false))
    }

    override fun onBindViewHolder(holder: TarefaViewHolder, position: Int) {
    val tarefa = listTarefa[position]
        holder.binding.textNome.text = tarefa.nome
        holder.binding.textDescricao.text = tarefa.descricao
        holder.binding.textResponsavel.text = tarefa.responsavel
        holder.binding.textData.text = tarefa.data
        holder.binding.textCategoria.text = tarefa.categoria.descricao

        holder.binding.switch1.isChecked = tarefa.status

        holder.itemView.setOnClickListener {
            taskClickListener.onTaskClickListener(tarefa)
        }
        holder.binding.switch1.setOnCheckedChangeListener { buttonView, ativo -> tarefa.status =
        ativo
         mainViewMode.uptoDate(tarefa)       }
        holder.binding.buttonDeletar.setOnClickListener {
            showAlertDialog(tarefa.id)

        }


    }



    override fun getItemCount(): Int {
      return listTarefa.size
    }
    fun setList (list: List<Tarefa>) {
        /*listTarefa = list.sortedBy { it.id }*/ //ordem das tarefas pelo id
        listTarefa = list.sortedByDescending { it.id }
        notifyDataSetChanged()


    }

    private fun showAlertDialog(id: Long){
        AlertDialog.Builder(context)
            .setTitle("Excluir Tarefa")
            .setMessage("Deseja excluir a tarefa")
            .setPositiveButton("Sim"){
                _,_ -> mainViewMode.deleteAssigment(id)
            }
            .setNegativeButton("Não"){
                _,_ ->
            }.show()

    }

}
