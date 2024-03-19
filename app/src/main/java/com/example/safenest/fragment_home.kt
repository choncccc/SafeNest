import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.safenest.DatabaseHelper
import com.example.safenest.R

class fragment_home : Fragment() {
    private lateinit var homeNameTextView: TextView
    private lateinit var dbHelper: DatabaseHelper
    private var username: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            username = it.getString("username")
        }
        dbHelper = DatabaseHelper(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        homeNameTextView = view.findViewById(R.id.HomeName)
        val userName = dbHelper.getName(username ?: "")
        homeNameTextView.text = userName
        return view
    }
    companion object {
        fun newInstance(username: String?): fragment_home {
            val fragment = fragment_home()
            val args = Bundle().apply {
                putString("username", username)
            }
            fragment.arguments = args
            return fragment
        }
    }

}
