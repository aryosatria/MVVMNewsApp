package com.aryosatria.mvvmnewsapp.repository

import com.aryosatria.mvvmnewsapp.database.ArticleDatabase
import com.aryosatria.mvvmnewsapp.model.Article
import com.aryosatria.mvvmnewsapp.network.RetrofitInstance

class NewsRepository(val db: ArticleDatabase) {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}