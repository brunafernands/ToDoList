package br.edu.ifpr.stiehl.aula7_sqlite.entidades

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tarefas")
data class Tarefa(
    var titulo: String,
    var desc: String,
    var status: Boolean
) {
    @PrimaryKey(autoGenerate = true)

    var id: Int = 0

    override fun toString(): String {
        var feita:String
        if(status==true){
            feita = "Realizada"
        }else{
            feita = "Não realizada"
        }
        val statusTarefa = "$titulo $desc $feita"
        return statusTarefa}
}