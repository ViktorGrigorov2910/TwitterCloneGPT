package com.example.twitterclonegpt.domain

interface UseCase<P, R> {
    suspend fun execute(param: P): R
}