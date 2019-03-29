package br.edu.ifpr.stiehl.aula7_sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.room.Room
import br.edu.ifpr.stiehl.aula7_sqlite.bd.AppDatabase
import br.edu.ifpr.stiehl.aula7_sqlite.bd.dao.TarefaDao
import br.edu.ifpr.stiehl.aula7_sqlite.entidades.Tarefa
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var db: AppDatabase
    lateinit var tarefaDAO: TarefaDao
    lateinit var adapter: ArrayAdapter<Tarefa>
    var atual: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "tarefa.db"
        )
            .allowMainThreadQueries()
            .build()
        tarefaDAO = db.TarefaDao()

        btSalvar.setOnClickListener {
            val titulo = txtTitulo.text.toString()
            val desc = txtDesc.text.toString()

            val tarefa = Tarefa(titulo, desc,false)

            tarefaDAO.inserir(tarefa)

            atualizaLista()
            limpaCampos()
        }

        btDeletar.setOnClickListener {
            val tarefa = tarefaDAO.buscaTarefa(atual)

            if(tarefa!=null){
                tarefaDAO.apagar(tarefa)

                atualizaLista()
                limpaCampos()
            }
        }


        atualizaLista()

        listTarefas.setOnItemClickListener { _, _, position, _ ->
            val tarefa = adapter.getItem(position)
            txtTitulo.setText(tarefa.titulo)
            txtDesc.setText(tarefa.desc)
            atual = tarefa.id
        }

        listTarefas.setOnItemLongClickListener { _, _, position, _ ->
            val tarefa = adapter.getItem(position)
            tarefaDAO.update(tarefa.id)
            atualizaLista()
            true
        }
    }

    fun atualizaLista() {
        val tarefas = tarefaDAO.buscaTodas()
        adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            tarefas
        )
        listTarefas.adapter = adapter
    }

    fun limpaCampos() {
        txtTitulo.setText("")
        txtDesc.setText("")
    }
}
