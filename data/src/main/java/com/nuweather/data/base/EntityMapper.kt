package com.nuweather.data.base

import com.nuweather.domain.model.Model

interface EntityMapper<M : Model, ME : Entity> {
    fun mapToDomain(entity: ME): M

    fun mapToEntity(model: M): ME
}