package com.guptamansi.takeouts.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.guptamansi.takeouts.R
import com.guptamansi.takeouts.adapter.BasketAdapter
import com.guptamansi.takeouts.adapter.MenuAdapter
import com.guptamansi.takeouts.databinding.FragmentMenuBottomSheetBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MenuBottomSheetFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MenuBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentMenuBottomSheetBinding
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBottomSheetBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment

        val menuFoodName = listOf("Grilled Sandwich", "Veg Cheese Pizza", "Pancakes", "Veg Thaali", "Coconut Icecream", "Chocolate Sandesh", "Sugarcame Juice", "Kesar Rabdi", "Veg Dumplings", "Tomato Pizza", "Basil Pizza", "Noodle Bowl", "Fruit Platter", "Cupcakes", "Veg Sandwich", "Strawberry Shake")
        val menuItemPrice = listOf("$10", "$15", "$12", "$20", "$10", "$15", "$12", "$20", "$10", "$15", "$10", "$8", "$10", "$5", "$12", "$7")
        val menuImage = listOf(R.drawable.banner0, R.drawable.banner9, R.drawable.banner1, R.drawable.banner2, R.drawable.banner3, R.drawable.banner4, R.drawable.banner5, R.drawable.banner6, R.drawable.banner7, R.drawable.banner8, R.drawable.basilpizza, R.drawable.noodlebowl, R.drawable.fruitplatter, R.drawable.cupcakes, R.drawable.grilledsandwich, R.drawable.strawberryshake)
        val adapter = MenuAdapter(
            ArrayList(menuFoodName),
            ArrayList(menuItemPrice),
            ArrayList(menuImage)

        )
        binding.rVFragmentBottomSheet.layoutManager = LinearLayoutManager(requireContext())
        binding.rVFragmentBottomSheet.adapter = adapter

        binding.ibtnRewind.setOnClickListener{
            dismiss()
        }

        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MenuBottomSheetFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MenuBottomSheetFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}