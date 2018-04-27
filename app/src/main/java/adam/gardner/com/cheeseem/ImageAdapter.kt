package adam.gardner.com.cheeseem

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView

class ImageAdapter(private val mContext: Context) : BaseAdapter() {

    private val thumbId = arrayOf(
            R.drawable.beast_master_icon, R.drawable.beast_master_icon,
            R.drawable.beast_master_icon, R.drawable.beast_master_icon,
            R.drawable.beast_master_icon, R.drawable.beast_master_icon,
            R.drawable.beast_master_icon, R.drawable.beast_master_icon,
            R.drawable.beast_master_icon, R.drawable.beast_master_icon,
            R.drawable.beast_master_icon, R.drawable.beast_master_icon,
            R.drawable.beast_master_icon, R.drawable.beast_master_icon,
            R.drawable.beast_master_icon, R.drawable.beast_master_icon,
            R.drawable.beast_master_icon, R.drawable.beast_master_icon,
            R.drawable.beast_master_icon, R.drawable.beast_master_icon,
            R.drawable.beast_master_icon, R.drawable.beast_master_icon)

    override fun getCount(): Int = thumbId.size

    override fun getItem(position: Int): Any? = null

    override fun getItemId(position: Int): Long = 0L

    // create a new ImageView for each item referenced by the Adapter
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val imageView: ImageView
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = ImageView(mContext)
            imageView.scaleType = ImageView.ScaleType.FIT_CENTER
            imageView.setPadding(10, 10,10, 10)
        } else {
            imageView = convertView as ImageView
        }

        imageView.setImageResource(thumbId[position])
        return imageView
    }
}