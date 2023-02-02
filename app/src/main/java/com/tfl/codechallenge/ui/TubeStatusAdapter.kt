package com.tfl.codechallenge.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tfl.codechallenge.R
import com.tfl.codechallenge.databinding.TubeLineItemBinding
import com.tfl.codechallenge.datamodels.CurrentStatus
import com.tfl.codechallenge.util.Constants.BAKERLOO
import com.tfl.codechallenge.util.Constants.CENTRAL
import com.tfl.codechallenge.util.Constants.CIRCLE
import com.tfl.codechallenge.util.Constants.DISTRICT
import com.tfl.codechallenge.util.Constants.DLR
import com.tfl.codechallenge.util.Constants.ELIZABETH
import com.tfl.codechallenge.util.Constants.HAMMERSMITH
import com.tfl.codechallenge.util.Constants.JUBILEE
import com.tfl.codechallenge.util.Constants.METROPOLITAN
import com.tfl.codechallenge.util.Constants.NORTHERN
import com.tfl.codechallenge.util.Constants.OVERGROUND
import com.tfl.codechallenge.util.Constants.PICCADILLY
import com.tfl.codechallenge.util.Constants.TFL_RAIL
import com.tfl.codechallenge.util.Constants.TRAM
import com.tfl.codechallenge.util.Constants.VICTORIA
import com.tfl.codechallenge.util.Constants.WATERLOO


class TubeStatusAdapter
    : ListAdapter<CurrentStatus, TubeStatusAdapter.TubeStatusViewHolder>
    (TubeStatusDiffUtil) {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TubeStatusViewHolder {
        context = parent.context
        return TubeStatusViewHolder(
            TubeLineItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }


    override fun onBindViewHolder(holder: TubeStatusViewHolder, position: Int) {
        val binding by holder::binding
        val lineItem = getItem(position)
        binding.apply {
            displayTubeLineColorCode(lineItem.id, binding.lineColorCode)
            lineName.text = lineItem.name
            lineStatus.text = lineItem.lineStatuses?.get(0)?.statusSeverityDescription
        }
    }

    private fun displayTubeLineColorCode(lineId: String?, colorBox: View) {
        when (lineId) {
            BAKERLOO -> colorBox.setBackgroundColor(context.getColor(R.color.bakerloo))
            CENTRAL -> colorBox.setBackgroundColor(context.getColor(R.color.central))
            CIRCLE -> colorBox.setBackgroundColor(context.getColor(R.color.circle))
            DISTRICT -> colorBox.setBackgroundColor(context.getColor(R.color.district))
            HAMMERSMITH -> colorBox.setBackgroundColor(context.getColor(R.color.hammersmith_City))
            JUBILEE -> colorBox.setBackgroundColor(context.getColor(R.color.jubilee))
            METROPOLITAN -> colorBox.setBackgroundColor(context.getColor(R.color.metropolitan))
            NORTHERN -> colorBox.setBackgroundColor(context.getColor(R.color.northern))
            PICCADILLY -> colorBox.setBackgroundColor(context.getColor(R.color.piccadilly))
            VICTORIA -> colorBox.setBackgroundColor(context.getColor(R.color.victoria))
            WATERLOO -> colorBox.setBackgroundColor(context.getColor(R.color.waterloo))
            OVERGROUND -> colorBox.setBackgroundColor(context.getColor(R.color.london_overground))
            TFL_RAIL -> colorBox.setBackgroundColor(context.getColor(R.color.tfl_rail))
            DLR -> colorBox.setBackgroundColor(context.getColor(R.color.dlr))
            TRAM -> colorBox.setBackgroundColor(context.getColor(R.color.tram))
            ELIZABETH -> colorBox.setBackgroundColor(context.getColor(R.color.elizabeth))
        }
    }

    inner class TubeStatusViewHolder(val binding: TubeLineItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    private object TubeStatusDiffUtil : DiffUtil.ItemCallback<CurrentStatus>() {
        override fun areItemsTheSame(oldItem: CurrentStatus, newItem: CurrentStatus): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CurrentStatus, newItem: CurrentStatus): Boolean {
            return oldItem == newItem
        }
    }

}