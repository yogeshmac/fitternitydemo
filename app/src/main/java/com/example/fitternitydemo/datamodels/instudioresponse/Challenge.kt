package com.example.fitternitydemo.datamodels.instudioresponse

data class Challenge (
    val title: String,
    val description: String,
    val data: List<ChallengeDatum>,
    val campaign: ChallengeCampaign
)