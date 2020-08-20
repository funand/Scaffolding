package com.example.scaffoldiing.di

import com.example.scaffoldiing.rocketviewmodel.TeamViewmodel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val TeamModule = module {
    viewModel { TeamViewmodel() }
}