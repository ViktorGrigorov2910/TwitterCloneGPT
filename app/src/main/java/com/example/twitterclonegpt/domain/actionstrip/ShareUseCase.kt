package com.example.twitterclonegpt.domain.actionstrip

import com.example.twitterclonegpt.domain.DataResult
import com.example.twitterclonegpt.domain.UseCase
import com.example.twitterclonegpt.domain.asDataResult
import javax.inject.Inject

class ShareUseCase @Inject constructor() : UseCase<Int, DataResult<Unit>> {

    //TODO: What is the share functionality? Share via message?
    override suspend fun execute(param: Int): DataResult<Unit> = asDataResult { Unit }

}