package com.metcs.bookservice.domain.dto.response

data class PaginatedResponse<T>(
    var currentPage: Int,
    var elementCount: Int,
    var pageCount: Long,
    var data: T
)
