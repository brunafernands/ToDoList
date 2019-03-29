package br.edu.ifpr.stiehl.aula7_sqlite.bd.dao

import androidx.room.*
import br.edu.ifpr.stiehl.aula7_sqlite.entidades.Tarefa

@Dao
interface TarefaDao {
    @Query("SELECT * FROM tarefas")
    fun buscaTodas(): List<Tarefa>

    @Query("SELECT * FROM tarefas WHERE id = :id LIMIT 1")
    fun buscaTarefa(id: Int): Tarefa

    @Insert
    fun inserir(tarefa: Tarefa)

    @Delete
    fun apagar(tarefa: Tarefa)

    @Query("UPDATE tarefas SET status=1 WHERE id = :id")
    fun update(id: Int)
}