package com.gclewis.search

data class SearchResult(
    val _id: String,
    val description: String,
    val document_type: String,
    val elasticsearch_type: String,
    val es_score: Double,
    val expanded_organisations: List<Organisation>,
    val format: String,
    val index: String,
    val link: String,
    val organisation_content_ids: List<String>,
    val organisations: List<Organisation>,
    val public_timestamp: String,
    val title: String,
    val topical_events: List<Any>,
    val world_locations: List<Any>
)
