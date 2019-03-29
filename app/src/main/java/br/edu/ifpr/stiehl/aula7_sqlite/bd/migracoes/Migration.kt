//package br.edu.ifpr.stiehl.aula7_sqlite.bd.migracoes
//
//import androidx.room.migration.Migration
//import androidx.sqlite.db.SupportSQLiteDatabase
//
//const val VERSAO_BD = 3
//
//val MIGRATION_1_2 = object : Migration(1, 2) {
//    override fun migrate(database: SupportSQLiteDatabase) {
//        database.execSQL("ALTER TABLE tarefas ADD COLUMN num_cachorros INTEGER")
//    }
//}
//
//val MIGRATION_2_3 = object : Migration(2, 3) {
//    override fun migrate(database: SupportSQLiteDatabase) {
//        database.execSQL("ALTER TABLE pessoas ADD COLUMN status INTEGER")
//    }
//}
//
//val MIGRATIONS = arrayOf(MIGRATION_1_2, MIGRATION_2_3)