import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import java.util.concurrent.Flow
import Word as Word1
import kotlin.collections.List as List

@Dao
interface WordDao {

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAlphabetizedWords():Flow<List<Word1>>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word1)

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()
}