package adam.gardner.com.cheeseem

import android.annotation.SuppressLint
import android.content.ContentProvider
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.transition.Explode
import android.view.Menu
import android.view.MenuItem
import android.view.Window
import android.widget.AdapterView
import android.widget.GridView
import android.app.ActivityOptions




class MainActivity : AppCompatActivity() {

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fab = findViewById<FloatingActionButton>(R.id.fab)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        initGridView()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initGridView() {
        val gridView: GridView = this.findViewById(R.id.gridView)
        gridView.adapter = ImageAdapter(this)

        gridView.onItemClickListener =
                AdapterView.OnItemClickListener { parent, v, position, id ->
                    // Check if we're running on Android 5.0 or higher

                    val i = Intent(this@MainActivity, HeroDetailActivity::class.java)

                    val sharedView = gridView
                    val transitionName = getString(R.string.image_annimation)

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        val transitionActivityOptions = ActivityOptions.makeSceneTransitionAnimation(this@MainActivity, sharedView, transitionName)
                        startActivity(i, transitionActivityOptions.toBundle())
                    } else {
                        startActivity(Intent(this@MainActivity, HeroDetailActivity::class.java))
                    }
                }
    }
}
