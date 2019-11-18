package com.example.mvvmexam_kotlin.ui.quotes

import androidx.lifecycle.ViewModel
import com.example.mvvmexam_kotlin.data.Quote
import com.example.mvvmexam_kotlin.data.QuoteRepository

class QuotesViewModel (private val quoteRepository: QuoteRepository)
    :ViewModel(){

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuotes(quote: Quote) = quoteRepository.addQuote(quote)
}