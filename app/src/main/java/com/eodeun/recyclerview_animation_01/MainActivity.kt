package com.eodeun.recyclerview_animation_01

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.eodeun.recyclerview_animation_01.Adapter.MyCustomAdapter
import com.eodeun.recyclerview_animation_01.Modal.Data
import com.eodeun.recyclerview_animation_01.Modal.Information
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.widget.StaggeredGridLayoutManager
import android.support.v7.widget.GridLayoutManager


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = MyCustomAdapter(this, Data().getData() as ArrayList<Information>)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item != null) {
            when (item.itemId) {
                R.id.LinearViewHorizontal -> {
                    val mLinearLayoutManagerHorizontal = LinearLayoutManager(this)
                    mLinearLayoutManagerHorizontal.orientation = LinearLayoutManager.HORIZONTAL
                    recycler_view.setLayoutManager(mLinearLayoutManagerHorizontal)
                }

                R.id.LinearViewVertical -> {
                    val mLinearLayoutManagerVertical = LinearLayoutManager(this)
                    mLinearLayoutManagerVertical.orientation = LinearLayoutManager.VERTICAL
                    recycler_view.setLayoutManager(mLinearLayoutManagerVertical)
                }
                R.id.gridView -> {
                    val mGridLayoutManager = GridLayoutManager(this, 3)
                    recycler_view.setLayoutManager(mGridLayoutManager)
                }
                R.id.staggeredViewHorizontal -> {
                    val mStaggeredHorizontalLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL)
                    recycler_view.setLayoutManager(mStaggeredHorizontalLayoutManager)
                }
                R.id.staggeredViewVertical -> {
                    val mStaggeredVerticalLayoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                    recycler_view.setLayoutManager(mStaggeredVerticalLayoutManager)
                }
            }
        }


        return super.onOptionsItemSelected(item)
    }
}
