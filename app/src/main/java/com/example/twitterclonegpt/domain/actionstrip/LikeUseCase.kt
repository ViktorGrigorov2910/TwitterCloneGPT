package com.example.twitterclonegpt.domain.actionstrip

import com.example.twitterclonegpt.data.TrendingPostsRepositoryContract
import com.example.twitterclonegpt.domain.DataResult
import com.example.twitterclonegpt.domain.UseCase
import javax.inject.Inject

class LikeUseCase @Inject constructor(
    private val postsRepository: TrendingPostsRepositoryContract
) : UseCase<Int, DataResult<Unit>> {

    /**
     *  @param param is the [TrendingPost]'s Id
     * */
    override suspend fun execute(param: Int): DataResult<Unit> = postsRepository.likePost(param)

}