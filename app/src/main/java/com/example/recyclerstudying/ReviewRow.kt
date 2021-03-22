package com.example.recyclerstudying

sealed class ReviewRow(val viewType: Int) {
    data class ViewHolderImageMovie(var genericData: String? = null) :
        ReviewRow(R.layout.image_review)

    data class ViewHolderComments(var genericData: List<String>) :
        ReviewRow(R.layout.comments_review)

    data class ViewHolderHeader(var genericData: List<String>) : ReviewRow(R.layout.header_review)
}
