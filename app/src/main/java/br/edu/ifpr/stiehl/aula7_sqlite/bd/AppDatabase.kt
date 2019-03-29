package br.edu.ifpr.stiehl.aula7_sqlite.bd

import androidx.room.Database
import androidx.room.RoomDatabase
import br.edu.ifpr.stiehl.aula7_sqlite.bd.dao.TarefaDao
import br.edu.ifpr.stiehl.aula7_sqlite.entidades.Tarefa

@Database(entities = arrayOf(Tarefa::class), version = 3)
abstract class AppDatabase: RoomDatabase() {
    abstract fun TarefaDao(): TarefaDao
}