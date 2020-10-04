package br.com.challenge.consultaremedios.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import br.com.challenge.consultaremedios.db.entity.CartItem

@Dao
interface CartDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(cart: CartItem)

    @Update
    suspend fun update(cart: CartItem)

    @Delete
    suspend fun delete(cart: CartItem)

    @Query("SELECT * FROM cart_items")
    fun getAll(): LiveData<List<CartItem>>

    @Query("SELECT SUM(quantity) FROM cart_items")
    fun cartItemsSum(): Int
}