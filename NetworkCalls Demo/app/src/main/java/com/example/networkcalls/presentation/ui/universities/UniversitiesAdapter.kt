package com.example.networkcalls.presentation.ui.universities
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.networkcalls.presentation.ui.utils.BindableAdapter
import com.example.networkcalls.R
import com.example.networkcalls.presentation.ui.university.University
import kotlinx.android.synthetic.main.item_university.view.*

class UniversitiesAdapter : RecyclerView.Adapter<UniversitiesAdapter.UniversityHolder>(),
    BindableAdapter<University> {
    var universities = emptyList<University>()

    override fun setData(data: List<University>) {
        universities = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniversityHolder {
        val inflater = LayoutInflater.from(parent.context)
        return UniversityHolder(
            inflater.inflate(
                R.layout.item_university,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = universities.size

    override fun onBindViewHolder(holder: UniversityHolder, position: Int) {
        holder.bind(universities[position], position)
    }

    class UniversityHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(university: University, pos: Int) {

            (itemView as? LinearLayout)?.let {
                it.universityName.text = university.name
                it.universityWebsite.text = university.webPages.joinToString(", ")
            }
        }
    }
}