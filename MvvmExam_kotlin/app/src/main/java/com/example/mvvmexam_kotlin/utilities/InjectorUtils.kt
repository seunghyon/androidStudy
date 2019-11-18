package com.example.mvvmexam_kotlin.utilities

import com.example.mvvmexam_kotlin.data.FakeDatabase
import com.example.mvvmexam_kotlin.data.QuoteRepository
import com.example.mvvmexam_kotlin.ui.quotes.QuotesViewModelFactory

object InjectorUtils {
    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}