package br.com.fiap.gameviewapp.data.local.dao


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.fiap.gameviewapp.data.local.entity.ReviewEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ReviewDao {

    // Listar todas as reviews do banco de dados local
    @Query("SELECT * FROM reviews")
    fun getReceitas(): Flow<List<ReviewEntity>>

    // Cadastrar todas as reviews obtidas na API
    // no banco de dados local
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(receitas: List<ReviewEntity>)

    // Apagar todas as receitas do banco de dados local
    @Query("DELETE FROM reviews")
    suspend fun clear()

}