package com.example.kotlinbasicsinterviewpractice

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig

class TaskViewModel: ViewModel() {
    val pagingflow = Pager(PagingConfig(pageSize = 20)){
        TaskPagingSource()
    }.flow
}