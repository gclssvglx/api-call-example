package com.gclewis.space

class AstrosInSpaceRepository {
    private val astrosInSpaceService = AstrosInSpaceRetrofitInstance.astrosInSpaceService

    suspend fun getAstrosInSpace(): AstrosInSpace {
        return astrosInSpaceService.getAstrosInSpace()
    }
}
