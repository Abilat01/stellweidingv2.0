package com.abilat01.stellweidingv20.ui.`object`

import android.view.View
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.abilat01.stellweidingv20.MainActivity
import com.abilat01.stellweidingv20.R
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem

class AppDrawer(val mainActivity: AppCompatActivity, val toolbar: androidx.appcompat.widget.Toolbar) {

    private lateinit var mDraver: Drawer
    private lateinit var mHeader: AccountHeader

    fun create(){
        createHeader()
        createDrawer()
    }

    private fun createDrawer() {
        mDraver = DrawerBuilder()
            .withActivity(mainActivity)
            .withToolbar(toolbar)
            .withActionBarDrawerToggle(true) //боковая кнопка
            .withSelectedItem(-1) //выбор меню
            .withAccountHeader(mHeader) //хеадер
            .addDrawerItems(
                PrimaryDrawerItem().withIdentifier(1)
                    .withIconTintingEnabled(true)
                    .withIcon(R.drawable.workout)
                    .withName("Разминка")
                    .withSelectable(false),
                PrimaryDrawerItem().withIdentifier(2)
                    .withIconTintingEnabled(true)
                    .withIcon(R.drawable.gym)
                    .withName("Программы")
                    .withSelectable(false),
                PrimaryDrawerItem().withIdentifier(3)
                    .withIconTintingEnabled(true)
                    .withIcon(R.drawable.gymtren)
                    .withName("Упражнения")
                    .withSelectable(false),
                PrimaryDrawerItem().withIdentifier(4)
                    .withIconTintingEnabled(true)
                    .withIcon(R.drawable.info)
                    .withName("Информация")
                    .withSelectable(false),
                PrimaryDrawerItem().withIdentifier(5)
                    .withIconTintingEnabled(true)
                    .withIcon(R.drawable.logout)
                    .withName("Выход")
                    .withSelectable(false)
            ).withOnDrawerItemClickListener(object : Drawer.OnDrawerItemClickListener{
                override fun onItemClick(
                    view: View?,
                    position: Int,
                    drawerItem: IDrawerItem<*>
                ): Boolean {
                    Toast.makeText(mainActivity.applicationContext, position.toString(), Toast.LENGTH_SHORT).show()
                    return false
                }
            })
            .build()
    }

    private fun createHeader() {
        mHeader = AccountHeaderBuilder()
            .withActivity(mainActivity)
            .withHeaderBackground(R.drawable.header)
            .addProfiles(
                ProfileDrawerItem().withName("Пацанская гиря")
            ).build()
    }
}