package com.example.kotlinbasicsinterviewpractice

import androidx.paging.PagingSource
import androidx.paging.PagingState

class TaskPagingSource: PagingSource<Int, TaskItem>() {
    override fun getRefreshKey(state: PagingState<Int, TaskItem>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TaskItem> {
       val currentpage = params.key?:0
        val data = (currentpage until currentpage+ params.loadSize).map {
            TaskItem(id=it, title = "task item ${it}")
        }
        return LoadResult.Page(data = data,
            prevKey = if(currentpage == 0) null else currentpage - params.loadSize,
            nextKey = if(data.isEmpty()) null else currentpage + params.loadSize)
    }
}