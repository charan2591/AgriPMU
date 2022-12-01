package layout

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SearchView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pmufirstapplication.adapters.RecyclerSearchViewAdapter
import com.example.pmufirstapplication.databinding.FragmentSearchBinding
import com.example.pmufirstapplication.models.SearchModel
import com.example.pmufirstapplication.viewmodels.SearchViewModel
import com.example.pmufirstapplication.viewmodels.SearchViewModelFactory

class FragmentSearch : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    public final lateinit var adapter: RecyclerSearchViewAdapter
    private var viewManager = LinearLayoutManager(context)
    private lateinit var viewModel: SearchViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        context ?: return binding.root

         init()

        return binding.root
     }


    private fun init()
    {
        val application = requireNotNull(activity).application
        val factory = SearchViewModelFactory()
        viewModel = ViewModelProvider(this).get(SearchViewModel::class.java)

        addData()
        initialiseAdapter()

    }

    private fun setSearchView()
    {

        // To set the custom design of the search view
        val searchIcon =
            binding.searchView.findViewById<ImageView>(androidx.appcompat.R.id.search_mag_icon)
        searchIcon.setColorFilter(Color.WHITE)

        val cancelIcon =
            binding.searchView.findViewById<ImageView>(androidx.appcompat.R.id.search_close_btn)
        cancelIcon.setColorFilter(Color.WHITE)

        val textView = binding.searchView.findViewById<TextView>(androidx.appcompat.R.id.search_src_text)
        textView.setTextColor(Color.WHITE)
        // If you want to change the color of the cursor, change the 'colorAccent' in colors.xml


        binding.searchView.setOnQueryTextListener( object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                return  false

            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }

        })
    }

    private fun initialiseAdapter(){
        binding.recyclerSearch.layoutManager = viewManager
        observeData()

    }

    private fun observeData() {
        viewModel.list.observe(BottomBarActivity@this, Observer {
            Log.i("data",it.toString())
            adapter = RecyclerSearchViewAdapter(viewModel,it,context!!)
            binding.recyclerSearch.adapter = adapter
        })

        setSearchView()

    }

    private fun addData()
    {
            val model =  SearchModel("Hari","2 bag(s)","Rohtak"
                ,"1 day ago","Rs 1250")
            viewModel.add(model)
            val model1 =  SearchModel("Ramesh","1 bag(s)","Bhiwani"
                ,"2 days ago","Rs 1050")
            viewModel.add(model1)
            val model2 =  SearchModel("Gagan","2 bag(s)","Jind"
                ,"2 days ago","Rs 1500")
            viewModel.add(model2)
            val model3 =  SearchModel("Vishal","3 bag(s)","Karnal"
                ,"3 days ago","Rs 1000")
            viewModel.add(model3)

            val model4 =  SearchModel("Deepak","2 bag(s)","Panipat"
                ,"1 day ago","Rs 1250")
            viewModel.add(model4)
            val model5 =  SearchModel("Johnish","1 bag(s)","Ambala"
                ,"2 days ago","Rs 1280")
            viewModel.add(model5)
            val model6 =  SearchModel("Tarsem","2 bag(s)","Kaithal"
                ,"1 days ago","Rs 1100")
            viewModel.add(model6)
            val model7 =  SearchModel("Uday","1 bag(s)","Sonipat"
                ,"2 days ago","Rs 1300")
            viewModel.add(model7)

//            binding.recyclerSearch.adapter?.notifyDataSetChanged()
    }

}