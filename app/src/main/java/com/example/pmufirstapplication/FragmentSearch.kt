package layout

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pmufirstapplication.BottomBarActivity
import com.example.pmufirstapplication.adapters.RecyclerAdapter
import com.example.pmufirstapplication.adapters.RecyclerSearchViewAdapter
import com.example.pmufirstapplication.databinding.FragmentMoreBinding
import com.example.pmufirstapplication.databinding.FragmentSearchBinding
import com.example.pmufirstapplication.models.MainModel
import com.example.pmufirstapplication.models.SearchModel
import com.example.pmufirstapplication.viewmodels.SearchViewModel
import com.example.pmufirstapplication.viewmodels.SearchViewModelFactory

class FragmentSearch : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private var viewManager = LinearLayoutManager(context)
    private lateinit var viewModel: SearchViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        context ?: return binding.root

        return binding.root

        init()
     }


    private fun init()
    {
        val application = requireNotNull(activity).application
        val factory = SearchViewModelFactory()
        viewModel = ViewModelProvider(this).get(SearchViewModel::class.java)

        initialiseAdapter()
        addData()
    }

    private fun initialiseAdapter(){
        binding.recyclerSearch.layoutManager = viewManager
        observeData()
    }

    private fun observeData() {
        viewModel.list.observe(BottomBarActivity@this, Observer {
            Log.i("data",it.toString())
            binding.recyclerSearch.adapter = RecyclerSearchViewAdapter(viewModel,it,context!!)
        })

    }

    fun addData()
    {

            var model =  SearchModel("Hari","2 bag(s)","Rohtak"
                ,"1 day ago","Rs 1250")
            viewModel.add(model)
            var model1 =  SearchModel("Ramesh","1 bag(s)","Bhiwani"
                ,"2 days ago","Rs 1050")
            viewModel.add(model1)
            var model2 =  SearchModel("Gagan","2 bag(s)","Jind"
                ,"2 days ago","Rs 1500")
            viewModel.add(model2)
            var model3 =  SearchModel("Vishal","3 bag(s)","Karnal"
                ,"3 days ago","Rs 1000")
            viewModel.add(model3)
            binding.recyclerSearch.adapter?.notifyDataSetChanged()
    }

}