package com.msf.bank.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.msf.bank.R
import com.msf.bank.model.Statement
import kotlinx.android.synthetic.main.statement_item.view.*

class StatementsAdapter(private val statements: List<Statement>) : RecyclerView.Adapter<StatementsAdapter.StatementViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatementViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.statement_item, parent, false)
        return StatementViewHolder(view)
    }

    override fun getItemCount(): Int = statements.size

    override fun onBindViewHolder(holder: StatementViewHolder, position: Int) {
        val statement = statements[position]
        holder.bind(statement)
    }

    inner class StatementViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        fun bind(mStatement: Statement){
            with(itemView){
                itemTitle.text = mStatement.title
                itemDate.text = mStatement.getFormattedDate()
                itemDescription.text = mStatement.desc
                itemValue.text = mStatement.getCurrencyValue()
            }
        }
    }
}