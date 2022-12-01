package com.halilozcan.animearch.domain.mapper

interface AnimeBaseMapper<I, O> {
    fun map(input: I): O
}
