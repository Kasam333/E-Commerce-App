package com.example.craft.data

sealed class Category(val category: String) {

    object Duffel: Category("Duffels")
    object Luggage: Category("Luggages")
    object SchoolBags: Category("School Bags")
    object SlingBags: Category("Sling Bags")
    object Handbags: Category("Handbags")
}