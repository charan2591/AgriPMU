package com.example.pmufirstapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.pmufirstapplication.databinding.FragmentMoreBinding
import com.example.pmufirstapplication.databinding.FragmentProfileBinding

class FragmentMore : BaseFragment() {

    private lateinit var binding : FragmentMoreBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMoreBinding.inflate(inflater, container, false)
        context ?: return binding.root

//        val adapter = PlantAdapter()
//        binding.plantList.adapter = adapter

        binding.linrAgriculture.setOnClickListener{
            binding.linrAgriculture.background =  (ContextCompat.getDrawable(context!!, R.drawable.bg_menu_card_selctd))
            binding.txtAgriculture.setTextColor(ContextCompat.getColor(context!!, R.color.white))
            normalLaytBackground(1)
        }

        binding.linrHorticulture.setOnClickListener{
            binding.linrHorticulture.background =  (ContextCompat.getDrawable(context!!, R.drawable.bg_menu_card_selctd))
            binding.txtHorticulture.setTextColor(ContextCompat.getColor(context!!, R.color.white))
            normalLaytBackground(2)

        }

        binding.linrSericulture.setOnClickListener{
            binding.linrSericulture.background =  (ContextCompat.getDrawable(context!!, R.drawable.bg_menu_card_selctd))
            binding.txtSericulture.setTextColor(ContextCompat.getColor(context!!, R.color.white))

            normalLaytBackground(3)
        }

        binding.linrAnimalHusbandry.setOnClickListener{
            binding.linrAnimalHusbandry.background =  (ContextCompat.getDrawable(context!!, R.drawable.bg_menu_card_selctd))
            binding.txtAnimalHusbandry.setTextColor(ContextCompat.getColor(context!!, R.color.white))

            normalLaytBackground(4)
        }

        binding.linrFisheries.setOnClickListener{
            binding.linrFisheries.background =  (ContextCompat.getDrawable(context!!, R.drawable.bg_menu_card_selctd))
            binding.txtFisheries.setTextColor(ContextCompat.getColor(context!!, R.color.white))

            normalLaytBackground(5)
        }

        binding.linrIrrigation.setOnClickListener{
            binding.linrIrrigation.background =  (ContextCompat.getDrawable(context!!, R.drawable.bg_menu_card_selctd))
            binding.txtIrrigation.setTextColor(ContextCompat.getColor(context!!, R.color.white))

            normalLaytBackground(6)
        }

        return binding.root
    }

    fun normalLaytBackground(num : Int)
    {
        val drawable = R.drawable.card_selector
        val color = R.color.colorTransparntBlack
        setIntent(MultiSelectorRadioActivity::class.java)

        if(num == 1)
        {
            binding.linrHorticulture.background =  (ContextCompat.getDrawable(context!!, drawable))
            binding.txtHorticulture.setTextColor(ContextCompat.getColor(context!!, color))
            binding.linrSericulture.background =  (ContextCompat.getDrawable(context!!, drawable))
            binding.txtSericulture.setTextColor(ContextCompat.getColor(context!!, color))
            binding.linrAnimalHusbandry.background =  (ContextCompat.getDrawable(context!!, drawable))
            binding.txtAnimalHusbandry.setTextColor(ContextCompat.getColor(context!!, color))
            binding.linrFisheries.background =  (ContextCompat.getDrawable(context!!, drawable))
            binding.txtFisheries.setTextColor(ContextCompat.getColor(context!!, color))
            binding.linrIrrigation.background =  (ContextCompat.getDrawable(context!!, drawable))
            binding.txtIrrigation.setTextColor(ContextCompat.getColor(context!!, color))
        }
        else if(num == 2)
        {
            binding.linrAgriculture.background =  (ContextCompat.getDrawable(context!!, drawable))
            binding.txtAgriculture.setTextColor(ContextCompat.getColor(context!!, color))
            binding.linrSericulture.background =  (ContextCompat.getDrawable(context!!, drawable))
            binding.txtSericulture.setTextColor(ContextCompat.getColor(context!!, color))
            binding.linrAnimalHusbandry.background =  (ContextCompat.getDrawable(context!!, drawable))
            binding.txtAnimalHusbandry.setTextColor(ContextCompat.getColor(context!!, color))
            binding.linrFisheries.background =  (ContextCompat.getDrawable(context!!, drawable))
            binding.txtFisheries.setTextColor(ContextCompat.getColor(context!!, color))
            binding.linrIrrigation.background =  (ContextCompat.getDrawable(context!!, drawable))
            binding.txtIrrigation.setTextColor(ContextCompat.getColor(context!!, color))
        }
        else if(num == 3)
        {
            binding.linrAgriculture.background =  (ContextCompat.getDrawable(context!!, drawable))
            binding.txtAgriculture.setTextColor(ContextCompat.getColor(context!!, color))
            binding.linrHorticulture.background =  (ContextCompat.getDrawable(context!!, drawable))
            binding.txtHorticulture.setTextColor(ContextCompat.getColor(context!!, color))
            binding.linrAnimalHusbandry.background =  (ContextCompat.getDrawable(context!!, drawable))
            binding.txtAnimalHusbandry.setTextColor(ContextCompat.getColor(context!!, color))
            binding.linrFisheries.background =  (ContextCompat.getDrawable(context!!, drawable))
            binding.txtFisheries.setTextColor(ContextCompat.getColor(context!!, color))
            binding.linrIrrigation.background =  (ContextCompat.getDrawable(context!!, drawable))
            binding.txtIrrigation.setTextColor(ContextCompat.getColor(context!!, color))
        }
        else if(num == 4)
        {
            binding.linrAgriculture.background =  (ContextCompat.getDrawable(context!!, drawable))
            binding.txtAgriculture.setTextColor(ContextCompat.getColor(context!!, color))
            binding.linrHorticulture.background =  (ContextCompat.getDrawable(context!!, drawable))
            binding.txtHorticulture.setTextColor(ContextCompat.getColor(context!!, color))
            binding.linrSericulture.background =  (ContextCompat.getDrawable(context!!, drawable))
            binding.txtSericulture.setTextColor(ContextCompat.getColor(context!!, color))
            binding.linrFisheries.background =  (ContextCompat.getDrawable(context!!, drawable))
            binding.txtFisheries.setTextColor(ContextCompat.getColor(context!!, color))
            binding.linrIrrigation.background =  (ContextCompat.getDrawable(context!!, drawable))
            binding.txtIrrigation.setTextColor(ContextCompat.getColor(context!!, color))
        }
        else if(num == 5)
        {
            binding.linrAgriculture.background =  (ContextCompat.getDrawable(context!!, drawable))
            binding.txtAgriculture.setTextColor(ContextCompat.getColor(context!!, color))
            binding.linrHorticulture.background =  (ContextCompat.getDrawable(context!!, drawable))
            binding.txtHorticulture.setTextColor(ContextCompat.getColor(context!!, color))
            binding.linrSericulture.background =  (ContextCompat.getDrawable(context!!, drawable))
            binding.txtSericulture.setTextColor(ContextCompat.getColor(context!!, color))
            binding.linrAnimalHusbandry.background =  (ContextCompat.getDrawable(context!!, drawable))
            binding.txtAnimalHusbandry.setTextColor(ContextCompat.getColor(context!!, color))
            binding.linrIrrigation.background =  (ContextCompat.getDrawable(context!!, drawable))
            binding.txtIrrigation.setTextColor(ContextCompat.getColor(context!!, color))
        }
        else
        {
            binding.linrAgriculture.background =  (ContextCompat.getDrawable(context!!, drawable))
            binding.txtAgriculture.setTextColor(ContextCompat.getColor(context!!, color))
            binding.linrHorticulture.background =  (ContextCompat.getDrawable(context!!, drawable))
            binding.txtHorticulture.setTextColor(ContextCompat.getColor(context!!, color))
            binding.linrSericulture.background =  (ContextCompat.getDrawable(context!!, drawable))
            binding.txtSericulture.setTextColor(ContextCompat.getColor(context!!, color))
            binding.linrAnimalHusbandry.background =  (ContextCompat.getDrawable(context!!, drawable))
            binding.txtAnimalHusbandry.setTextColor(ContextCompat.getColor(context!!, color))
            binding.linrFisheries.background =  (ContextCompat.getDrawable(context!!, drawable))
            binding.txtFisheries.setTextColor(ContextCompat.getColor(context!!, color))

        }

    }
}