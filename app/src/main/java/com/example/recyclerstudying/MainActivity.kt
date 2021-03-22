package com.example.recyclerstudying

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerstudying.adapter.DynamicAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val viewHolderDatas = listOf(
        ReviewRow.ViewHolderHeader(listOf()),
        ReviewRow.ViewHolderComments(listOf("Linha: ", "Linha: ", "Linha: ", "Linha: ")),
        ReviewRow.ViewHolderComments(listOf("Linha: ", "Linha: ", "Linha: ", "Linha: ", "Linha: ", "Linha: ", "Linha: ", "Linha: ", "Linha: ", "Linha: ")),
        ReviewRow.ViewHolderImageMovie(""),
        ReviewRow.ViewHolderComments(listOf("Linha: ", "Linha: ", "Linha: ", "Linha: ")),
        ReviewRow.ViewHolderImageMovie(""),
        ReviewRow.ViewHolderHeader(listOf()),
        ReviewRow.ViewHolderImageMovie(""),

        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val itemDecorator = DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL)
        itemDecorator.setDrawable(
            ContextCompat.getDrawable(
                this@MainActivity,
                R.drawable.recycler_view_divider
            )!!
        )

        main_recycler.apply {
            adapter = DynamicAdapter(viewHolderDatas)
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(itemDecorator)
        }
    }
}